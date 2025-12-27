
package DAO;

import Config.Koneksi;
import Config.UserSession;
import Model.Model_Jadwal;
import Model.Model_Pasien;
import Model.Model_Pemeriksaan;
import Service.Service_Pemeriksaan;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Dao_Pemeriksaan implements Service_Pemeriksaan {
    private Connection cn;
    public Dao_Pemeriksaan(){
        cn = Koneksi.getConnection();
    }

    @Override
    public void tambahPemeriksaan(Model_Pemeriksaan mod_periksa) {
    PreparedStatement st = null;

    String sql =
        "INSERT INTO pemeriksaan " +
        "(id_jadwal, keluhan, diagnosa, tindakan, tanggal) " +
        "VALUES (?,?,?,?,?)";

    try {
        st = cn.prepareStatement(sql);

        st.setInt(1, mod_periksa.getId_jadwal().getId_jadwal());
        st.setString(2, mod_periksa.getKeluhan());
        st.setString(3, mod_periksa.getDiagnosa());
        st.setString(4, mod_periksa.getTindakan());
        st.setTimestamp(5, new java.sql.Timestamp(
        mod_periksa.getTanggal().getTime()
        ));
        st.executeUpdate();
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Simpan data pemeriksaan GAGAL");
        Logger.getLogger(Dao_Pemeriksaan.class.getName())
              .log(Level.SEVERE, null, ex);
    } finally {
        try {
            if (st != null) st.close();
        } catch (SQLException ex) {
            Logger.getLogger(Dao_Pemeriksaan.class.getName())
                  .log(Level.SEVERE, null, ex);
        }
    }
}
    @Override
    public void perbaruiPemeriksaan(Model_Pemeriksaan mod_periksa) {
    String sql =
        "UPDATE pemeriksaan " +
        "SET id_jadwal=?, keluhan=?, diagnosa=?, tindakan=?, tanggal=? " +
        "WHERE id_pemeriksaan=?";

    try (PreparedStatement st = cn.prepareStatement(sql)) {

        st.setInt(1, mod_periksa.getId_jadwal().getId_jadwal());
        st.setString(2, mod_periksa.getKeluhan());
        st.setString(3, mod_periksa.getDiagnosa());
        st.setString(4, mod_periksa.getTindakan());
        st.setTimestamp(5,
        new java.sql.Timestamp(
        mod_periksa.getTanggal().getTime()
        )
        );
        st.setInt(6, mod_periksa.getId_pemeriksaan());

        st.executeUpdate();

    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Perbarui data pemeriksaan GAGAL");
        Logger.getLogger(Dao_Pemeriksaan.class.getName())
              .log(Level.SEVERE, null, ex);
    }
}
    @Override
    public void hapusPemeriksaan(Model_Pemeriksaan mod_periksa) {
        PreparedStatement st = null;
        String sql = "DELETE FROM pemeriksaan WHERE id_pemeriksaan=?";
        try{
            st = cn.prepareStatement(sql);
            
            st.setInt(1, mod_periksa.getId_pemeriksaan());
            
            st.executeUpdate();
        }catch(SQLException ex){
            java.util.logging.Logger.getLogger(Dao_Pemeriksaan.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if(st!=null){
                try{
                    st.close();
                }catch(SQLException ex){
                    java.util.logging.Logger.getLogger(Dao_Pemeriksaan.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    public List<Model_Pemeriksaan> ambilPemeriksaan() {
    List<Model_Pemeriksaan> list = new ArrayList<>();
    String sql =
        "SELECT p.id_pemeriksaan, p.id_jadwal, j.no_urut, " +
        "ps.id_pasien, ps.nama_pasien, " +
        "p.keluhan, p.diagnosa, p.tindakan, p.tanggal " +
        "FROM pemeriksaan p " +
        "JOIN jadwal_pemeriksaan j ON p.id_jadwal = j.id_jadwal " +
        "JOIN pasien ps ON j.id_pasien = ps.id_pasien ";

    if (UserSession.level == 2) {
        sql += "WHERE j.id_dokter = ? ";
    }

    try (PreparedStatement st = cn.prepareStatement(sql)) {

        if (UserSession.level == 2) {
            st.setInt(1, UserSession.idDokter);
        }

        ResultSet rs = st.executeQuery();

        while (rs.next()) {

            Model_Pasien pasien = new Model_Pasien();
            pasien.setId_pasien(rs.getInt("id_pasien"));
            pasien.setNama_pasien(rs.getString("nama_pasien"));

            Model_Jadwal jadwal = new Model_Jadwal();
            jadwal.setId_jadwal(rs.getInt("id_jadwal"));
            jadwal.setNo_urut(rs.getInt("no_urut"));
            jadwal.setId_p(pasien); // ⬅️ INI KUNCI

            Model_Pemeriksaan m = new Model_Pemeriksaan();
            m.setId_pemeriksaan(rs.getInt("id_pemeriksaan"));
            m.setId_jadwal(jadwal);
            m.setNo_urut(jadwal.getNo_urut());
            m.setNama_pasien(pasien.getNama_pasien());
            m.setKeluhan(rs.getString("keluhan"));
            m.setDiagnosa(rs.getString("diagnosa"));
            m.setTindakan(rs.getString("tindakan"));
            m.setTanggal(rs.getTimestamp("tanggal"));

            list.add(m);
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }

    return list;
}
    @Override
    public List<Model_Pemeriksaan> ambilPemeriksaanTanpaResep() {
         List<Model_Pemeriksaan> list = new ArrayList<>();

    String sql =
    "SELECT p.id_pemeriksaan, jp.no_urut, ps.nama_pasien, p.keluhan " +
    "FROM pemeriksaan p " +
    "JOIN jadwal_pemeriksaan jp ON jp.id_jadwal = p.id_jadwal " +
    "JOIN pasien ps ON ps.id_pasien = jp.id_pasien " +
    "WHERE NOT EXISTS ( " +
    "   SELECT 1 FROM resep_obat r " +
    "   WHERE r.id_pemeriksaan = p.id_pemeriksaan " +
    ") " +
    "ORDER BY jp.no_urut";

    try (PreparedStatement st = cn.prepareStatement(sql);
         ResultSet rs = st.executeQuery()) {

        while (rs.next()) {
            Model_Pemeriksaan m = new Model_Pemeriksaan();

            m.setId_pemeriksaan(rs.getInt("id_pemeriksaan"));
            m.setNo_urut(rs.getInt("no_urut"));
            m.setNama_pasien(rs.getString("nama_pasien"));
            m.setKeluhan(rs.getString("keluhan")); // 🔥 INI KUNCI

            list.add(m);
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return list;
    }
}
