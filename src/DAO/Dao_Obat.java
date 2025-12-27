
package DAO;

import Config.Koneksi;
import DAO.Dao_Dokter;
import DAO.Dao_Dokter;
import Model.Model_Dokter;
import Model.Model_Obat;
import Service.Service_Obat;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Dao_Obat implements Service_Obat{
    
    private Connection cn;
    
    public Dao_Obat(){
        cn = Koneksi.getConnection();        
    }
    @Override
    public void TambahObat(Model_Obat mobat) {
       PreparedStatement st = null;
        String sql = "INSERT INTO obat(Nama_obat, Satuan, Harga, Stok) VALUES (?,?,?,?)";
        try{
            st = cn.prepareStatement(sql);
            
            st.setString(1, mobat.getNama_obat());
            st.setString(2, mobat.getSatuan());
            st.setBigDecimal(3, mobat.getHarga());
            st.setInt(4, mobat.getStok());
            
            st.executeUpdate();
        }catch(SQLException ex){
            Logger.getLogger(Dao_Obat.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if(st!=null){
                try{
                    st.close();
                }catch(SQLException ex){
                    Logger.getLogger(Dao_Obat.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

    }
    @Override
    public void PerbaruiObat(Model_Obat mobat) {
       PreparedStatement st = null;
    String sql = "UPDATE Obat SET Nama_Obat=?, Satuan=?, Harga=?, Stok=? WHERE Id_Obat=?";
    
    try {
        st = cn.prepareStatement(sql);
        
        st.setString(1, mobat.getNama_obat());
        st.setString(2, mobat.getSatuan());
        st.setBigDecimal(3, mobat.getHarga());
        st.setInt(4, mobat.getStok());
        st.setInt(5, mobat.getId_obat());  // ← ID dokter wajib dipasang di parameter ke-5
        
        st.executeUpdate();
        
    } catch(SQLException ex) {
        JOptionPane.showMessageDialog(null, "Perbarui Data Gagal");
        Logger.getLogger(Dao_Obat.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
        if (st != null) {
            try {
                st.close();
            } catch(SQLException ex) {
                Logger.getLogger(Dao_Obat.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    }
    @Override
    public void HapusObat(Model_Obat mobat) {
        PreparedStatement st = null;
    String sql = "DELETE FROM obat WHERE id_obat=?";

    try {
        st = cn.prepareStatement(sql);
        st.setInt(1, mobat.getId_obat());
        st.executeUpdate();
    } catch (SQLException ex) {
        Logger.getLogger(Dao_Obat.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
        try {
            if (st != null) st.close();
        } catch (SQLException ex) {
            Logger.getLogger(Dao_Obat.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    }
    @Override
    public List<Model_Obat> getData() {
          PreparedStatement st = null;
        List list = new ArrayList();
        ResultSet rs = null;
        String sql = "SELECT * FROM obat";
        try{
            st = cn.prepareStatement(sql);
            rs = st.executeQuery();
            while(rs.next()){
                Model_Obat mobat = new Model_Obat();
                
                mobat.setId_obat(rs.getInt("Id_Obat"));
                mobat.setNama_obat(rs.getString("Nama_Obat"));
                mobat.setSatuan(rs.getString("satuan"));
                mobat.setHarga(rs.getBigDecimal("Harga"));
                mobat.setStok(rs.getInt("Stok"));
                
                list.add(mobat);
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
    public void kurangiStok(int idObat, int jumlah) {
    String sql =
        "UPDATE obat SET stok = stok - ? WHERE id_obat = ?";

    try (PreparedStatement ps = cn.prepareStatement(sql)) {
        ps.setInt(1, jumlah);
        ps.setInt(2, idObat);
        ps.executeUpdate();
    } catch (Exception e) {
        e.printStackTrace();
    }
}

    public int getStok(int idObat) {
    String sql = "SELECT stok FROM obat WHERE id_obat = ?";
    try (PreparedStatement ps = cn.prepareStatement(sql)) {
        ps.setInt(1, idObat);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            return rs.getInt("stok");
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return 0;
}
public void tambahStok(int idObat, int jumlah) {
    String sql = "UPDATE obat SET stok = stok + ? WHERE id_obat = ?";
    try (PreparedStatement ps = cn.prepareStatement(sql)) {
        ps.setInt(1, jumlah);
        ps.setInt(2, idObat);
        ps.executeUpdate();
    } catch (Exception e) {
        e.printStackTrace();
    }
}
}
