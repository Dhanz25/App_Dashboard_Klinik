
package DAO;

import Main.Menu_Utama;
import Config.Koneksi;
import Config.UserSession;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import Model.Model_Login;
import Service.Service_Login;
import View.Form_Login;
import java.sql.Connection;

public class Dao_Login implements Service_Login{
    private Connection cn; 
    public Dao_Login() { 
        cn = Koneksi.getConnection(); 
    } 
    @Override 
    public void prosesLogin( Model_Login mod_login) {
        PreparedStatement st = null;
    ResultSet rs = null;

    String sql = "SELECT id_pengguna, username, password, level, id_dokter "
               + "FROM login_pengguna "
               + "WHERE username=?";

    try {
        st = cn.prepareStatement(sql);
        st.setString(1, mod_login.getUsername().trim());
        rs = st.executeQuery();

        if (!rs.next()) {
            JOptionPane.showMessageDialog(
                null,
                "Username Tidak Ada!",
                "Login gagal",
                JOptionPane.ERROR_MESSAGE
            );
            return;
        }

        String passwordDB = rs.getString("password");
        String passwordInput = Encrypt.getmd5java(
            mod_login.getPassword().trim()
        );

        if (!passwordDB.equals(passwordInput)) {
            JOptionPane.showMessageDialog(
                null,
                "Password salah!",
                "Login gagal",
                JOptionPane.ERROR_MESSAGE
            );
            return;
        }

        int idPengguna = rs.getInt("id_pengguna");
        String username = rs.getString("username");
        int level = rs.getInt("level");

        int idDokterDB = rs.getInt("id_dokter");
        Integer idDokter = rs.wasNull() ? null : idDokterDB;

        UserSession.idPengguna = idPengguna;
        UserSession.username  = username;
        UserSession.level     = level;
        UserSession.idDokter  = idDokter;

        Model_Login model = new Model_Login();
        model.setId_pengguna(idPengguna);
        model.setUsername(username);
        model.setLevel(level);

        new Menu_Utama(model).setVisible(true);

        if (Form_Login.instance != null) {
            Form_Login.instance.dispose();
        }

    } catch (SQLException ex) {
        Logger.getLogger(Dao_Login.class.getName())
              .log(Level.SEVERE, null, ex);
    } finally {
        try {
            if (rs != null) rs.close();
            if (st != null) st.close();
        } catch (SQLException ex) {
            Logger.getLogger(Dao_Login.class.getName())
                  .log(Level.SEVERE, null, ex);
        }
    }
    }
}
