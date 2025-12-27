
package DAO;

import Config.Koneksi;
import Model.Model_Dokter;
import Model.Model_Pasien;
import Service.Service_Pasien;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Dao_Pasien implements Service_Pasien {
    private Connection cn;
    public Dao_Pasien(){
        cn = Koneksi.getConnection();
    }
    @Override
    public void tambahData(Model_Pasien mod_pas) {
        PreparedStatement st = null;
        String sql = "INSERT INTO pasien (nama_pasien, jenis_kelamin, tanggal_lahir, alamat, no_telp) VALUES (?,?,?,?,?)";
        try{
            st = cn.prepareStatement(sql);
            
            st.setString(1, mod_pas.getNama_pasien());
            st.setString(2, mod_pas.getJenis_kelamin());
            st.setString(3, mod_pas.getTanggal_lahir());
            st.setString(4, mod_pas.getAlamat());
            st.setString(5, mod_pas.getNo_telp());
            
            st.executeUpdate();
        }catch(SQLException ex){
            Logger.getLogger(Dao_Pasien.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if(st!=null){
                try{
                    st.close();
                }catch(SQLException ex){
                    Logger.getLogger(Dao_Pasien.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    @Override
    public void editData(Model_Pasien mod_pas) {
        PreparedStatement st = null;
    String sql = "UPDATE pasien SET nama_pasien=?, jenis_kelamin=?, tanggal_lahir=?, alamat=?, no_telp=? WHERE id_pasien=?";
    
    try {
        st = cn.prepareStatement(sql);
        
        st.setString(1, mod_pas.getNama_pasien());
        st.setString(2, mod_pas.getJenis_kelamin());
        st.setString(3, mod_pas.getTanggal_lahir());
        st.setString(4, mod_pas.getAlamat());
        st.setString(5, mod_pas.getNo_telp());
        st.setInt(6, mod_pas.getId_pasien());  // ← ID dokter wajib dipasang di parameter ke-5
        
        st.executeUpdate();
        
    } catch(SQLException ex) {
        JOptionPane.showMessageDialog(null, "Perbarui Data Gagal");
        Logger.getLogger(Dao_Pasien.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
        if (st != null) {
            try {
                st.close();
            } catch(SQLException ex) {
                Logger.getLogger(Dao_Pasien.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    }
    @Override
    public void hapusData(Model_Pasien mod_pas) {
        PreparedStatement st = null;
        String sql = "DELETE FROM pasien WHERE id_pasien=?";
        try{
            st = cn.prepareStatement(sql);
            
            st.setInt(1, mod_pas.getId_pasien());
            
            st.executeUpdate();
        }catch(SQLException ex){
            java.util.logging.Logger.getLogger(Dao_Pasien.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if(st!=null){
                try{
                    st.close();
                }catch(SQLException ex){
                    java.util.logging.Logger.getLogger(Dao_Pasien.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    @Override
    public List<Model_Pasien> getData() {
        PreparedStatement st = null;
        List list = new ArrayList();
        ResultSet rs = null;
        String sql = "SELECT * FROM pasien";
        try{
            st = cn.prepareStatement(sql);
            rs = st.executeQuery();
            while(rs.next()){
                Model_Pasien mod_pas = new Model_Pasien();
                
                mod_pas.setId_pasien(rs.getInt("id_pasien"));
                mod_pas.setNama_pasien(rs.getString("nama_pasien"));
                mod_pas.setJenis_kelamin(rs.getString("jenis_kelamin"));
                mod_pas.setTanggal_lahir(rs.getString("tanggal_lahir"));
                mod_pas.setAlamat(rs.getString("Alamat"));
                mod_pas.setNo_telp(rs.getString("No_telp"));
                
                list.add(mod_pas);
            }
            return list;
        }catch(SQLException ex){
            java.util.logging.Logger.getLogger(Dao_Pasien.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }finally{
            if(st!=null){
                try{
                    st.close();
                }catch(SQLException ex){
                    java.util.logging.Logger.getLogger(Dao_Pasien.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(rs!=null){
                try{
                    rs.close();
                }catch(SQLException ex){
                    java.util.logging.Logger.getLogger(Dao_Pasien.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
}
