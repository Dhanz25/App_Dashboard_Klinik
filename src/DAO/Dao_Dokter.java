
package DAO;

import Config.Koneksi;
import Model.Model_Dokter;
import Service.Service_Dokter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.logging.Logger;
import java.util.logging.Level;
import java.util.List;
import javax.swing.JOptionPane;
import java.util.ArrayList;

public class Dao_Dokter implements Service_Dokter{
    
    private Connection cn;
    
    public Dao_Dokter(){
        cn = Koneksi.getConnection();
    }

    @Override
    public void tambahData(Model_Dokter mod_dok) {
        PreparedStatement st = null;
        String sql = "INSERT INTO dokter (nama_dokter, spesialis, no_telp, jadwal_praktik) VALUES (?,?,?,?)";
        try{
            st = cn.prepareStatement(sql);
            
            st.setString(1, mod_dok.getNama_dokter());
            st.setString(2, mod_dok.getSpesialis());
            st.setString(3, mod_dok.getNo_telp());
            st.setString(4, mod_dok.getJadwal());
            
            st.executeUpdate();
        }catch(SQLException ex){
            Logger.getLogger(Dao_Dokter.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if(st!=null){
                try{
                    st.close();
                }catch(SQLException ex){
                    Logger.getLogger(Dao_Dokter.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @Override
    public void editData(Model_Dokter mod_dok) {
        PreparedStatement st = null;
    String sql = "UPDATE dokter SET nama_dokter=?, spesialis=?, no_telp=?, jadwal_praktik=? WHERE id_dokter=?";
    
    try {
        st = cn.prepareStatement(sql);
        
        st.setString(1, mod_dok.getNama_dokter());
        st.setString(2, mod_dok.getSpesialis());
        st.setString(3, mod_dok.getNo_telp());
        st.setString(4, mod_dok.getJadwal());
        st.setInt(5, mod_dok.getId_dokter());  
        
        st.executeUpdate();
        
    } catch(SQLException ex) {
        JOptionPane.showMessageDialog(null, "Perbarui Data Gagal");
        Logger.getLogger(Dao_Dokter.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
        if (st != null) {
            try {
                st.close();
            } catch(SQLException ex) {
                Logger.getLogger(Dao_Dokter.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    }

    @Override
    public void hapusData(Model_Dokter mod_dok) {
        PreparedStatement st = null;
        String sql = "DELETE FROM dokter WHERE id_dokter=?";
        try{
            st = cn.prepareStatement(sql);
            
            st.setInt(1, mod_dok.getId_dokter());
            
            st.executeUpdate();
        }catch(SQLException ex){
            java.util.logging.Logger.getLogger(Dao_Dokter.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if(st!=null){
                try{
                    st.close();
                }catch(SQLException ex){
                    java.util.logging.Logger.getLogger(Dao_Dokter.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @Override
    public List<Model_Dokter> getData() {
        PreparedStatement st = null;
        List list = new ArrayList();
        ResultSet rs = null;
        String sql = "SELECT * FROM dokter";
        try{
            st = cn.prepareStatement(sql);
            rs = st.executeQuery();
            while(rs.next()){
                Model_Dokter mod_dok = new Model_Dokter();
                
                mod_dok.setId_dokter(rs.getInt("id_dokter"));
                mod_dok.setNama_dokter(rs.getString("nama_dokter"));
                mod_dok.setSpesialis(rs.getString("spesialis"));
                mod_dok.setNo_telp(rs.getString("no_telp"));
                mod_dok.setJadwal(rs.getString("jadwal_praktik"));
                
                list.add(mod_dok);
            }
            return list;
        }catch(SQLException ex){
            java.util.logging.Logger.getLogger(Dao_Dokter.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }finally{
            if(st!=null){
                try{
                    st.close();
                }catch(SQLException ex){
                    java.util.logging.Logger.getLogger(Dao_Dokter.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(rs!=null){
                try{
                    rs.close();
                }catch(SQLException ex){
                    java.util.logging.Logger.getLogger(Dao_Dokter.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @Override
    public List<Model_Dokter> getDokterPraktikHariIni() {
         List<Model_Dokter> list = new ArrayList<>();

    String sql = "SELECT id_dokter, nama_dokter, jadwal_praktik FROM dokter";

    try (PreparedStatement ps = cn.prepareStatement(sql);
         ResultSet rs = ps.executeQuery()) {

        while (rs.next()) {
            Model_Dokter d = new Model_Dokter();
            d.setId_dokter(rs.getInt("id_dokter"));
            d.setNama_dokter(rs.getString("nama_dokter"));
            d.setJadwal(rs.getString("jadwal_praktik"));
            list.add(d);
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return list;
    }
}
