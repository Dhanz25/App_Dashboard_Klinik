
package DAO;

import Config.Koneksi;
import DAO.Dao_Obat;
import Model.Model_Obat;
import Model.Model_Pembayaran;
import Model.Model_Pemeriksaan;
import Model.Model_Resep;
import Service.Service_Resep;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import javax.swing.JOptionPane;

public class Dao_Resepobat implements Service_Resep {
    private Connection cn;
    public Dao_Resepobat(){
        cn = Koneksi.getConnection();
    }
     private void updatePembayaran(int idPemeriksaan, BigDecimal nominal) throws SQLException {

        String cek = "SELECT id_pembayaran FROM pembayaran WHERE id_pemeriksaan=?";
        PreparedStatement psCek = cn.prepareStatement(cek);
        psCek.setInt(1, idPemeriksaan);
        ResultSet rs = psCek.executeQuery();

        if (rs.next()) {
            String up =
                "UPDATE pembayaran SET total_bayar = total_bayar + ? WHERE id_pemeriksaan=?";
            PreparedStatement psUp = cn.prepareStatement(up);
            psUp.setBigDecimal(1, nominal);
            psUp.setInt(2, idPemeriksaan);
            psUp.executeUpdate();
        } else {
            String ins =
                "INSERT INTO pembayaran (id_pemeriksaan, total_bayar, tgl_pembayaran, status) " +
                "VALUES (?, ?, CURDATE(), 'BELUM LUNAS')";
            PreparedStatement psIns = cn.prepareStatement(ins);
            psIns.setInt(1, idPemeriksaan);
            psIns.setBigDecimal(2, nominal);
            psIns.executeUpdate();
        }
    }
    @Override
    public void tambahResep(Model_Resep mod_resep) {
        String sql =
            "INSERT INTO resep_obat (id_pemeriksaan, id_obat, jumlah, aturan_pakai) " +
            "VALUES (?,?,?,?)";

        try {
            cn.setAutoCommit(false);

            if (mod_resep.getId_obat().getStok() < mod_resep.getJumlah()) {
                JOptionPane.showMessageDialog(null, "Stok obat tidak mencukupi!");
                return;
            }

            PreparedStatement st = cn.prepareStatement(sql);
            st.setInt(1, mod_resep.getId_pemeriksaan().getId_pemeriksaan());
            st.setInt(2, mod_resep.getId_obat().getId_obat());
            st.setInt(3, mod_resep.getJumlah());
            st.setString(4, mod_resep.getAturan_pakai());
            st.executeUpdate();

            Dao_Obat daoObat = new Dao_Obat();
            daoObat.kurangiStok(
                mod_resep.getId_obat().getId_obat(),
                mod_resep.getJumlah()
            );

            BigDecimal subtotal =
                mod_resep.getId_obat().getHarga()
                .multiply(new BigDecimal(mod_resep.getJumlah()));

            updatePembayaran(
                mod_resep.getId_pemeriksaan().getId_pemeriksaan(),
                subtotal
            );

            cn.commit();

        } catch (Exception e) {
            try { cn.rollback(); } catch (Exception ex) {}
            JOptionPane.showMessageDialog(null, "Simpan data GAGAL");
            e.printStackTrace();
        } finally {
            try { cn.setAutoCommit(true); } catch (Exception e) {}
        }
    }

    @Override
    public void perbaruiResep(Model_Resep mod_resep) {
        String sql =
            "UPDATE resep_obat SET id_pemeriksaan=?, id_obat=?, jumlah=?, aturan_pakai=? " +
            "WHERE id_resep=?";

        try {
            cn.setAutoCommit(false);

            int jumlahLama = getJumlahLama(mod_resep.getId_resep());
            int jumlahBaru = mod_resep.getJumlah();
            int selisih = jumlahBaru - jumlahLama;

            // VALIDASI STOK JIKA BERTAMBAH
            if (selisih > 0 && mod_resep.getId_obat().getStok() < selisih) {
                JOptionPane.showMessageDialog(null, "Stok obat tidak mencukupi!");
                return;
            }

            PreparedStatement st = cn.prepareStatement(sql);
            st.setInt(1, mod_resep.getId_pemeriksaan().getId_pemeriksaan());
            st.setInt(2, mod_resep.getId_obat().getId_obat());
            st.setInt(3, jumlahBaru);
            st.setString(4, mod_resep.getAturan_pakai());
            st.setInt(5, mod_resep.getId_resep());
            st.executeUpdate();

            Dao_Obat daoObat = new Dao_Obat();
            if (selisih > 0) {
                daoObat.kurangiStok(mod_resep.getId_obat().getId_obat(), selisih);
            } else if (selisih < 0) {
                daoObat.tambahStok(mod_resep.getId_obat().getId_obat(), Math.abs(selisih));
            }

            BigDecimal selisihTotal =
                mod_resep.getId_obat().getHarga()
                .multiply(new BigDecimal(selisih));

            if (selisih != 0) {
                updatePembayaran(
                    mod_resep.getId_pemeriksaan().getId_pemeriksaan(),
                    selisihTotal
                );
            }
            cn.commit();
        } catch (Exception e) {
            try { cn.rollback(); } catch (Exception ex) {}
            JOptionPane.showMessageDialog(null, "Perbarui data GAGAL");
            e.printStackTrace();
        } finally {
            try { cn.setAutoCommit(true); } catch (Exception e) {}
        }
    }
    @Override
    public void hapusResep(Model_Resep mod_resep) {
    String sqlGet =
        "SELECT id_obat, jumlah FROM resep_obat WHERE id_resep = ?";
    String sqlDelete =
        "DELETE FROM resep_obat WHERE id_resep = ?";

    try {
        PreparedStatement ps = cn.prepareStatement(sqlGet);
        ps.setInt(1, mod_resep.getId_resep());
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            int idObat = rs.getInt("id_obat");
            int jumlah = rs.getInt("jumlah");

            Dao_Obat daoObat = new Dao_Obat();
            daoObat.tambahStok(idObat, jumlah);
        }
        PreparedStatement st = cn.prepareStatement(sqlDelete);
        st.setInt(1, mod_resep.getId_resep());
        st.executeUpdate();

        JOptionPane.showMessageDialog(null, "Resep berhasil dihapus");

    } catch (Exception e) {
        e.printStackTrace();
    }
}
    @Override
   public List<Model_Resep> ambilResep() {
    List<Model_Resep> list = new ArrayList<>();

    try {
        String sql =
            "SELECT r.id_resep, r.id_pemeriksaan, r.id_obat, " +
    "ps.nama_pasien, p.keluhan, o.nama_obat, " +
    "r.jumlah, r.aturan_pakai " +
    "FROM resep_obat r " +
    "JOIN pemeriksaan p ON p.id_pemeriksaan = r.id_pemeriksaan " +
    "JOIN jadwal_pemeriksaan jp ON jp.id_jadwal = p.id_jadwal " +
    "JOIN pasien ps ON ps.id_pasien = jp.id_pasien " +
    "JOIN obat o ON o.id_obat = r.id_obat";

        PreparedStatement st = cn.prepareStatement(sql);
        ResultSet rs = st.executeQuery();

       while (rs.next()) {
    Model_Resep m = new Model_Resep();
    m.setId_resep(rs.getInt("id_resep"));

    Model_Pemeriksaan p = new Model_Pemeriksaan();
    p.setId_pemeriksaan(rs.getInt("id_pemeriksaan"));
    p.setNama_pasien(rs.getString("nama_pasien"));
    p.setKeluhan(rs.getString("keluhan")); // 🔥 TAMBAHAN
    m.setId_pemeriksaan(p);

    Model_Obat o = new Model_Obat();
    o.setId_obat(rs.getInt("id_obat"));
    o.setNama_obat(rs.getString("nama_obat"));
    m.setId_obat(o);

    m.setJumlah(rs.getInt("jumlah"));
    m.setAturan_pakai(rs.getString("aturan_pakai"));

    list.add(m);
}
    } catch (Exception e) {
        e.printStackTrace();
    }
    return list;
}   
    public int getJumlahLama(int idResep) {
     int jumlah = 0;
        String sql = "SELECT jumlah FROM resep_obat WHERE id_resep=?";

        try (PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setInt(1, idResep);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                jumlah = rs.getInt("jumlah");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jumlah;
        }
}
