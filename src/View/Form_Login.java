
package View;

import DAO.Dao_Login;
import Model.Model_Login;
import Service.Service_Login;
import java.awt.Toolkit;
import javax.swing.JOptionPane;

public class Form_Login extends javax.swing.JFrame {
    int xx, xy;
    private Service_Login servis = new Dao_Login();
    public boolean tutup = false;
    public static Form_Login instance;
    
    public Form_Login() {
        initComponents();
        setLocationRelativeTo(null); 
        instance = this;
        btnMasuk.requestFocus();
        setAppIcon();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();
        jLabel2 = new javax.swing.JLabel();
        btnMasuk = new javax.swing.JButton();
        btnClose = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        txtUsername = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                formMouseDragged(evt);
            }
        });
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(39, 157, 135));
        jLabel1.setText("KLINIK EL UNTU");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(66, 66, -1, -1));

        jPanel2.setBackground(new java.awt.Color(38, 113, 118));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/user-lock.png"))); // NOI18N
        jLabel4.setToolTipText("");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 5, 22, 33));

        txtPassword.setText("password");
        txtPassword.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtPasswordFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtPasswordFocusLost(evt);
            }
        });
        jPanel2.add(txtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(44, 0, 154, 44));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(66, 319, 198, 44));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/logo_eluntu.png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(99, 110, 132, 132));

        btnMasuk.setBackground(new java.awt.Color(39, 157, 135));
        btnMasuk.setText("LOGIN");
        btnMasuk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMasukActionPerformed(evt);
            }
        });
        jPanel1.add(btnMasuk, new org.netbeans.lib.awtextra.AbsoluteConstraints(66, 396, 198, 44));

        btnClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/close.png"))); // NOI18N
        btnClose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCloseMouseClicked(evt);
            }
        });
        jPanel1.add(btnClose, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 11, 33, 33));

        jPanel4.setBackground(new java.awt.Color(38, 113, 118));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtUsername.setText("username");
        txtUsername.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtUsernameFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtUsernameFocusLost(evt);
            }
        });
        jPanel4.add(txtUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(44, 0, 154, 44));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/user (1).png"))); // NOI18N
        jPanel4.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 15, -1, -1));

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(66, 264, 198, 44));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/rs_gigi (2).png"))); // NOI18N
        jLabel3.setIconTextGap(2);
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(363, 110, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 704, 484));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        xx = evt.getX();
        xy = evt.getY();
    }//GEN-LAST:event_formMousePressed

    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
        int x  = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xx, y - xy);
    }//GEN-LAST:event_formMouseDragged

    private void btnCloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCloseMouseClicked
        dispose();
        System.exit(0);
    }//GEN-LAST:event_btnCloseMouseClicked

    private void txtUsernameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtUsernameFocusGained
        String User = txtUsername.getText();
        if(User.equals("username")){
            txtUsername.setText("");
        }
    }//GEN-LAST:event_txtUsernameFocusGained

    private void txtUsernameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtUsernameFocusLost
        String User = txtUsername.getText();
        if(User.equals("")||User.equals("username")){
            txtUsername.setText("username");
        }
    }//GEN-LAST:event_txtUsernameFocusLost

    private void btnMasukActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMasukActionPerformed
        prosesLogin();
    }//GEN-LAST:event_btnMasukActionPerformed

    private void txtPasswordFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPasswordFocusGained
        String Pass = txtPassword.getText();
        if(Pass.equals("password")){
            txtPassword.setText("");
        }
    }//GEN-LAST:event_txtPasswordFocusGained

    private void txtPasswordFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPasswordFocusLost
        String Pass = txtPassword.getText();
        if(Pass.equals("")||Pass.equals("password")){
            txtPassword.setText("password");
        }
    }//GEN-LAST:event_txtPasswordFocusLost

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Form_Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Form_Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Form_Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Form_Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Form_Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnClose;
    private javax.swing.JButton btnMasuk;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables

    private void prosesLogin() {
         String user = txtUsername.getText().trim();
    String password = txtPassword.getText().trim();

    Model_Login mod_log = new Model_Login();

    mod_log.setUsername(user);
    mod_log.setPassword(password);

    servis.prosesLogin(mod_log);

    if (tutup) {
        dispose();
    }
    }
    private boolean validasiInput() {
        boolean valid=false;
        if(txtUsername.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(null, "Username tidak boleh kosong");
        }else if(txtPassword.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(null, "Password tidak boleh kosong");
        }else{
            valid = true;
        }
        return valid;
    }
    
    public void cekTutup() {
        Model_Login mod_log = new Model_Login();
        servis.prosesLogin(mod_log);
    }

    private void setAppIcon() {
        setIconImage(
        Toolkit.getDefaultToolkit().getImage(
            getClass().getResource("/Image/logoo.png")
        )
    );
    }
}
