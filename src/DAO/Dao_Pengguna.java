
package DAO;

import Config.Koneksi;
import Model.Model_Dokter;
import Model.Model_Pengguna;
import Service.Service_Pengguna;
import TableModel.Tablemod_Pengguna;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Dao_Pengguna implements Service_Pengguna{
    
    private Connection cn;
    
    public Dao_Pengguna(){
        cn = Koneksi.getConnection();
    }

    @Override
    public void tambahData(Model_Pengguna mod_peng) {
        PreparedStatement st = null;
        String sql = "INSERT INTO login_pengguna (username, password, level, id_dokter) " +
"VALUES (?, ?, '2', ?)";
        try{
            st = cn.prepareStatement(sql);
            
            st.setString(1, mod_peng.getUsername());
st.setString(2, Encrypt.getmd5java(mod_peng.getPassword()));
            st.setInt(3, mod_peng.getId_dokter().getId_dokter());
            
            st.executeUpdate();
        }catch(SQLException ex){
            Logger.getLogger(Dao_Pengguna.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if(st!=null){
                try{
                    st.close();
                }catch(SQLException ex){
                    Logger.getLogger(Dao_Pengguna.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    @Override
    public void editData(Model_Pengguna mod_peng) {
        PreparedStatement st = null;
    String sql = "UPDATE login_pengguna "
               + "SET username=?, password=? "
               + "WHERE id_pengguna=?";

    try {
        st = cn.prepareStatement(sql);
        st.setString(1, mod_peng.getUsername());
        st.setString(2, Encrypt.getmd5java(mod_peng.getPassword()));
        st.setInt(3, mod_peng.getId_pengguna());

        st.executeUpdate();
    } catch (SQLException ex) {
        Logger.getLogger(Dao_Pengguna.class.getName())
              .log(Level.SEVERE, null, ex);
    } finally {
        try {
            if (st != null) st.close();
        } catch (SQLException ex) {}
    }
    }
    @Override
    public void hapusData(Model_Pengguna mod_peng) {
        PreparedStatement st = null;
        String sql = "DELETE FROM login_pengguna WHERE id_pengguna=?";
        try{
            st = cn.prepareStatement(sql);
            
            st.setInt(1, mod_peng.getId_pengguna());
            
            st.executeUpdate();
        }catch(SQLException ex){
            java.util.logging.Logger.getLogger(Dao_Pengguna.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if(st!=null){
                try{
                    st.close();
                }catch(SQLException ex){
                    java.util.logging.Logger.getLogger(Dao_Pengguna.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    @Override
    public List<Model_Pengguna> getData() {
        PreparedStatement st = null;
        List list = new ArrayList();
        ResultSet rs = null;
        String sql =
            "SELECT lp.id_pengguna, lp.username, lp.password, lp.level, d.nama_dokter " +
            "FROM login_pengguna lp " +
            "LEFT JOIN dokter d ON lp.id_dokter = d.id_dokter";
        try{
            st = cn.prepareStatement(sql);
            rs = st.executeQuery();
             while (rs.next()) {
            Model_Pengguna mod = new Model_Pengguna();

            mod.setId_pengguna(rs.getInt("id_pengguna"));
            mod.setUsername(rs.getString("username"));
            mod.setPassword(rs.getString("password"));
            mod.setLevel(rs.getInt("level")); 

            Model_Dokter dokter = new Model_Dokter();
            dokter.setNama_dokter(rs.getString("nama_dokter"));
            mod.setId_dokter(dokter);

            list.add(mod);
        }
            return list;
        }catch(SQLException ex){
            java.util.logging.Logger.getLogger(Dao_Pengguna.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }finally{
            if(st!=null){
                try{
                    st.close();
                }catch(SQLException ex){
                    java.util.logging.Logger.getLogger(Dao_Pengguna.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(rs!=null){
                try{
                    rs.close();
                }catch(SQLException ex){
                    java.util.logging.Logger.getLogger(Dao_Pengguna.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
}
