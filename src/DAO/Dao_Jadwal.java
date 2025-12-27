
package DAO;

import Config.Koneksi;
import Config.UserSession;
import Model.Model_Dokter;
import Model.Model_Jadwal;
import Model.Model_Pasien;
import Service.Service_Jadwal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Logger;
import java.util.logging.Level;
import java.util.List;
import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.Date;

public class Dao_Jadwal implements Service_Jadwal{
    
    private Connection cn;
    
    public Dao_Jadwal(){
        cn = Koneksi.getConnection();
    }

 @Override
public void tambahData(Model_Jadwal mod) {
    PreparedStatement st = null;

    String sql =
        "INSERT INTO jadwal_pemeriksaan " +
        "(no_urut, id_pasien, id_dokter, tanggal) " +
        "VALUES (?,?,?,?)";

    try {
        int idDokter;
        if (UserSession.level == 2) { // DOKTER
            idDokter = UserSession.idDokter;
        } else { // ADMIN
            idDokter = mod.getId_d().getId_dokter();
        }

        int noUrut = getNoUrutByTanggal(mod.getTanggal(), idDokter);

        st = cn.prepareStatement(sql);

        st.setInt(1, noUrut);
        st.setInt(2, mod.getId_p().getId_pasien());
        st.setInt(3, idDokter);
        st.setTimestamp(4, new java.sql.Timestamp(
            mod.getTanggal().getTime()
        ));

        st.executeUpdate();

    } catch (SQLException e) {
        Logger.getLogger(Dao_Jadwal.class.getName())
              .log(Level.SEVERE, null, e);
    } finally {
        try {
            if (st != null) st.close();
        } catch (SQLException e) {
            Logger.getLogger(Dao_Jadwal.class.getName())
                  .log(Level.SEVERE, null, e);
        }
    }
}
@Override
public void perbaruiData(Model_Jadwal mod_jadwal) {
    String sql =
        "UPDATE jadwal_pemeriksaan " +
        "SET no_urut=?, id_pasien=?, tanggal=?, id_dokter=? " +
        "WHERE id_jadwal=?";

    try (PreparedStatement st = cn.prepareStatement(sql)) {

        st.setInt(1, mod_jadwal.getNo_urut());
        st.setInt(2, mod_jadwal.getId_p().getId_pasien());
        st.setDate(3, new java.sql.Date(mod_jadwal.getTanggal().getTime()));

        
        if (UserSession.level == 2) {
            st.setInt(4, UserSession.idDokter);
        } else {
            st.setInt(4, mod_jadwal.getId_d().getId_dokter());
        }

        st.setInt(5, mod_jadwal.getId_jadwal());

        st.executeUpdate();

    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Perbarui Data Gagal");
        Logger.getLogger(Dao_Jadwal.class.getName())
              .log(Level.SEVERE, null, ex);
    }
}
  @Override
    public List<Model_Jadwal> getData() {
    List<Model_Jadwal> list = new ArrayList<>();

    String sql =
        "SELECT j.id_jadwal, j.no_urut, j.tanggal, " +
        "p.id_pasien, p.nama_pasien, " +
        "d.id_dokter, d.nama_dokter " +
        "FROM jadwal_pemeriksaan j " +
        "JOIN pasien p ON j.id_pasien = p.id_pasien " +
        "JOIN dokter d ON j.id_dokter = d.id_dokter ";

    
    if (UserSession.level == 2) {
        sql += "WHERE j.id_dokter = ? ";
    }

    try (PreparedStatement st = cn.prepareStatement(sql)) {

        if (UserSession.level == 2) {
            st.setInt(1, UserSession.idDokter);
        }

        try (ResultSet rs = st.executeQuery()) {

            while (rs.next()) {

                Model_Pasien pasien = new Model_Pasien();
                pasien.setId_pasien(rs.getInt("id_pasien"));
                pasien.setNama_pasien(rs.getString("nama_pasien"));

                Model_Dokter dokter = new Model_Dokter();
                dokter.setId_dokter(rs.getInt("id_dokter"));
                dokter.setNama_dokter(rs.getString("nama_dokter"));

                Model_Jadwal jadwal = new Model_Jadwal();
                jadwal.setId_jadwal(rs.getInt("id_jadwal"));
                jadwal.setNo_urut(rs.getInt("no_urut"));
                jadwal.setTanggal(rs.getDate("tanggal"));

                jadwal.setId_p(pasien);
                jadwal.setId_d(dokter);

                list.add(jadwal);
            }
        }

    } catch (SQLException ex) {
        Logger.getLogger(Dao_Jadwal.class.getName())
              .log(Level.SEVERE, null, ex);
    }

    return list;
}
   @Override
    public List<Model_Jadwal> ambilDataTampil() {

    List<Model_Jadwal> list = new ArrayList<>();

    String sql =
        "SELECT j.id_jadwal, j.no_urut, " +
        "p.id_pasien, p.nama_pasien, " +
        "j.tanggal, " +
        "d.id_dokter, d.nama_dokter " +
        "FROM jadwal_pemeriksaan j " +
        "JOIN pasien p ON j.id_pasien = p.id_pasien " +
        "JOIN dokter d ON j.id_dokter = d.id_dokter ";

    if (UserSession.level == 2) {
        sql += "WHERE j.id_dokter = ? ";
    }

    sql += "ORDER BY j.no_urut";

    try (PreparedStatement st = cn.prepareStatement(sql)) {

        if (UserSession.level == 2) {
            st.setInt(1, UserSession.idDokter);
        }

        try (ResultSet rs = st.executeQuery()) {

            while (rs.next()) {

                Model_Pasien pasien = new Model_Pasien();
                pasien.setId_pasien(rs.getInt("id_pasien"));
                pasien.setNama_pasien(rs.getString("nama_pasien"));

                Model_Dokter dokter = new Model_Dokter();
                dokter.setId_dokter(rs.getInt("id_dokter"));
                dokter.setNama_dokter(rs.getString("nama_dokter"));

                Model_Jadwal m = new Model_Jadwal();
                m.setId_jadwal(rs.getInt("id_jadwal"));
                m.setNo_urut(rs.getInt("no_urut"));
                m.setTanggal(rs.getDate("tanggal"));

                m.setId_p(pasien);
                m.setId_d(dokter);

                list.add(m);
            }
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }

    return list;
}

 public void hapusData(int idJadwal) {
    try {
        String sql1 = "DELETE FROM pemeriksaan WHERE id_jadwal=?";
        PreparedStatement ps1 = cn.prepareStatement(sql1);
        ps1.setInt(1, idJadwal);
        ps1.executeUpdate();

        String sql2 = "DELETE FROM jadwal_pemeriksaan WHERE id_jadwal=?";
        PreparedStatement ps2 = cn.prepareStatement(sql2);
        ps2.setInt(1, idJadwal);
        ps2.executeUpdate();

    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, e.getMessage());
    }
}

    public int getNoUrutByTanggal(Date tanggal, int idDokter) {
    int noUrut = 1;

    String sql =
        "SELECT COALESCE(MAX(no_urut), 0) + 1 AS next_no " +
        "FROM jadwal_pemeriksaan " +
        "WHERE DATE(tanggal) = ? AND id_dokter = ?";

    try (PreparedStatement ps = cn.prepareStatement(sql)) {
        ps.setDate(1, new java.sql.Date(tanggal.getTime()));
        ps.setInt(2, idDokter);

        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            noUrut = rs.getInt("next_no");
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }

    return noUrut;
}
    public List<Model_Jadwal> getJadwalDokterHariIni(int idDokter) {
    List<Model_Jadwal> list = new ArrayList<>();

    String sql =
        "SELECT j.id_jadwal, j.no_urut, j.tanggal, p.nama_pasien " +
        "FROM jadwal_pemeriksaan j " +
        "JOIN pasien p ON j.id_pasien = p.id_pasien " +
        "WHERE j.id_dokter = ? AND DATE(j.tanggal) = CURDATE() " +
        "ORDER BY j.no_urut";

    try (PreparedStatement st = cn.prepareStatement(sql)) {
        st.setInt(1, idDokter);
        ResultSet rs = st.executeQuery();

        while (rs.next()) {
            Model_Jadwal j = new Model_Jadwal();
            j.setId_jadwal(rs.getInt("id_jadwal"));
            j.setNo_urut(rs.getInt("no_urut"));
            j.setTanggal(rs.getTimestamp("tanggal"));

            Model_Pasien p = new Model_Pasien();
            p.setNama_pasien(rs.getString("nama_pasien"));
            j.setId_p(p);

            list.add(j);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return list;
}

    @Override
    public List<Model_Jadwal> ambilJadwalBelumPeriksa() {
        List<Model_Jadwal> list = new ArrayList<>();

    String sql =
        "SELECT j.id_jadwal, j.no_urut, ps.nama_pasien " +
        "FROM jadwal_pemeriksaan j " +
        "JOIN pasien ps ON ps.id_pasien = j.id_pasien " +
        "WHERE NOT EXISTS ( " +
        "   SELECT 1 FROM pemeriksaan p " +
        "   WHERE p.id_jadwal = j.id_jadwal " +
        ")";

    if (UserSession.level == 2) {
        sql += " AND j.id_dokter = ?";
    }

    sql += " ORDER BY j.no_urut";

    try (PreparedStatement st = cn.prepareStatement(sql)) {

        if (UserSession.level == 2) {
            st.setInt(1, UserSession.idDokter);
        }

        ResultSet rs = st.executeQuery();

        while (rs.next()) {
            Model_Jadwal j = new Model_Jadwal();
            j.setId_jadwal(rs.getInt("id_jadwal"));
            j.setNo_urut(rs.getInt("no_urut"));

            Model_Pasien p = new Model_Pasien();
            p.setNama_pasien(rs.getString("nama_pasien"));
            j.setId_p(p);

            list.add(j);
        }

    } catch (Exception e) {
        e.printStackTrace();
    }

    return list;
    }
}