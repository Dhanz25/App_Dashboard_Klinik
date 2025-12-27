
package DAO;

import Config.Koneksi;
import Model.Model_Jadwal;
import Model.Model_Pembayaran;
import Model.Model_Pemeriksaan;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import Service.Service_Pembayaran;
import java.math.BigDecimal;

public class Dao_Pembayaran implements Service_Pembayaran {
    private Connection cn;
    public Dao_Pembayaran(){
        cn = Koneksi.getConnection();
    }
    @Override
    public void tambahPembayaran(Model_Pembayaran mod_bayar) {
    PreparedStatement st = null;
    String sql = "INSERT INTO pembayaran (id_pemeriksaan, total_bayar, tgl_pembayaran, status) VALUES (?,?,?,?)";

    try {
        BigDecimal totalBayar = hitungTotalBayar(
            mod_bayar.getId_pemeriksaan().getId_pemeriksaan()
        );

        st = cn.prepareStatement(sql);

        st.setInt(1, mod_bayar.getId_pemeriksaan().getId_pemeriksaan());
        st.setBigDecimal(2, totalBayar); 
        st.setDate(3, new java.sql.Date(System.currentTimeMillis()));
        st.setString(4, mod_bayar.getStatus());
        st.executeUpdate();
    } catch (SQLException ex) {
        ex.printStackTrace();
        JOptionPane.showMessageDialog(null, "Simpan data GAGAL");
    } finally {
        try {
            if (st != null) st.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
    @Override
    public void updateStatusPembayaran(int idPembayaran, String status) {
        String sql = "UPDATE pembayaran SET status=? WHERE id_pembayaran=?";

    try (PreparedStatement st = cn.prepareStatement(sql)) {

        st.setString(1, status);
        st.setInt(2, idPembayaran);

        st.executeUpdate();

    } catch (SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Gagal memperbarui status");
    }
    }
    @Override
    public void perbaruiPembayaran(Model_Pembayaran mod_bayar) {
    String sql =
        "UPDATE pembayaran SET status=? WHERE id_pembayaran=?";

    try (PreparedStatement st = cn.prepareStatement(sql)) {

        st.setString(1, mod_bayar.getStatus());
        st.setInt(2, mod_bayar.getId_pembayaran());

        st.executeUpdate();

    } catch (Exception e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Gagal update status");
    }
        
}
    @Override
    public void hapusPembayaran(Model_Pembayaran mod_bayar) {
        PreparedStatement st = null;
        String sql = "DELETE FROM pembayaran WHERE id_pembayaran=?";
        try{
            st = cn.prepareStatement(sql);
            
            st.setInt(1, mod_bayar.getId_pembayaran());
            
            st.executeUpdate();
        }catch(SQLException ex){
            java.util.logging.Logger.getLogger(Dao_Pembayaran.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if(st!=null){
                try{
                    st.close();
                }catch(SQLException ex){
                    java.util.logging.Logger.getLogger(Dao_Pembayaran.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    @Override
    public List<Model_Pembayaran> ambilPembayaran() {
        List<Model_Pembayaran> list = new ArrayList<>();

    try {
        String sql =
            "SELECT p.id_pembayaran, " +
            "       ps.nama_pasien, " +
            "       ob.nama_obat, " +
            "       ro.jumlah, " +
            "       p.total_bayar, " +
            "       p.tgl_pembayaran, " +
            "       p.status " +
            "FROM pembayaran p " +
            "JOIN pemeriksaan pr ON p.id_pemeriksaan = pr.id_pemeriksaan " +
            "JOIN jadwal_pemeriksaan jp ON pr.id_jadwal = jp.id_jadwal " +
            "JOIN pasien ps ON jp.id_pasien = ps.id_pasien " +
            "JOIN resep_obat ro ON pr.id_pemeriksaan = ro.id_pemeriksaan " +
            "JOIN obat ob ON ro.id_obat = ob.id_obat";

        PreparedStatement st = cn.prepareStatement(sql);
        ResultSet rs = st.executeQuery();

        while (rs.next()) {
            Model_Pembayaran m = new Model_Pembayaran();
            m.setId_pembayaran(rs.getInt("id_pembayaran"));
            m.setNama_pasien(rs.getString("nama_pasien"));
            m.setNama_obat(rs.getString("nama_obat"));
            m.setJumlah(rs.getInt("jumlah"));
            m.setTotal_bayar(rs.getBigDecimal("total_bayar"));
            m.setTgl_pembayaran(rs.getDate("tgl_pembayaran"));
            m.setStatus(rs.getString("status"));

            list.add(m);
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return list;
    }
    private static final BigDecimal BIAYA_LAYANAN = new BigDecimal("30000");

    
    public BigDecimal hitungTotalObat(int idPemeriksaan) {
    BigDecimal total = BigDecimal.ZERO;

    String sql =
        "SELECT SUM(o.harga * r.jumlah) AS total_obat " +
        "FROM resep_obat r " +
        "JOIN obat o ON r.id_obat = o.id_obat " +
        "WHERE r.id_pemeriksaan = ?";

    try (PreparedStatement ps = cn.prepareStatement(sql)) {
        ps.setInt(1, idPemeriksaan);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            total = rs.getBigDecimal("total_obat");
            if (total == null) total = BigDecimal.ZERO;
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return total;
}
    public BigDecimal hitungTotalBayar(int idPemeriksaan) {
        BigDecimal totalObat = hitungTotalObat(idPemeriksaan);
        return totalObat.add(BIAYA_LAYANAN);
    }
}
