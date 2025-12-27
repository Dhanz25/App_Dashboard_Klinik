
package Main;

import Model.Model_Login;
import View.Menu_Setting;
import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Menu_Utama extends javax.swing.JFrame {
    private Model_Login modelLogin;
    private boolean isAdmin() {
        return modelLogin != null && modelLogin.getLevel() == 1;
    }

    private boolean isDokter() {
        return modelLogin != null && modelLogin.getLevel() == 2;
    }
private ArrayList<Menu_Item> allMenu = new ArrayList<>();
    public Menu_Utama(Model_Login modelLogin) {
        initComponents();
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.modelLogin = modelLogin;
        tampilkanUser();
        execute(modelLogin);  
        setAppIcon();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pn_navbar = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnSetting = new javax.swing.JButton();
        pn_sidebar = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        pn_menu = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        lblIcon = new javax.swing.JLabel();
        lblUser = new javax.swing.JLabel();
        lblLevel = new javax.swing.JLabel();
        pn_content = new javax.swing.JPanel();
        pn_utama = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        pn_navbar.setBackground(new java.awt.Color(39, 157, 135));
        pn_navbar.setPreferredSize(new java.awt.Dimension(100, 60));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/logo_.png"))); // NOI18N

        btnSetting.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/setting.png"))); // NOI18N
        btnSetting.setContentAreaFilled(false);
        btnSetting.setMaximumSize(new java.awt.Dimension(24, 24));
        btnSetting.setMinimumSize(new java.awt.Dimension(24, 24));
        btnSetting.setPreferredSize(new java.awt.Dimension(24, 24));
        btnSetting.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSettingActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pn_navbarLayout = new javax.swing.GroupLayout(pn_navbar);
        pn_navbar.setLayout(pn_navbarLayout);
        pn_navbarLayout.setHorizontalGroup(
            pn_navbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_navbarLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 420, Short.MAX_VALUE)
                .addComponent(btnSetting, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pn_navbarLayout.setVerticalGroup(
            pn_navbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pn_navbarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnSetting, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(pn_navbar, java.awt.BorderLayout.PAGE_START);

        pn_sidebar.setBackground(new java.awt.Color(204, 204, 204));
        pn_sidebar.setPreferredSize(new java.awt.Dimension(200, 318));

        jScrollPane1.setBorder(null);

        pn_menu.setBackground(new java.awt.Color(255, 255, 255));
        pn_menu.setLayout(new javax.swing.BoxLayout(pn_menu, javax.swing.BoxLayout.Y_AXIS));
        jScrollPane1.setViewportView(pn_menu);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        lblIcon.setMaximumSize(new java.awt.Dimension(64, 64));
        lblIcon.setMinimumSize(new java.awt.Dimension(64, 64));
        lblIcon.setPreferredSize(new java.awt.Dimension(64, 64));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(lblIcon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(62, 62, 62))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblIcon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        lblUser.setBackground(new java.awt.Color(255, 255, 255));
        lblUser.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        lblUser.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblUser.setText("Nama");

        lblLevel.setBackground(new java.awt.Color(255, 255, 255));
        lblLevel.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        lblLevel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblLevel.setText("Level");

        javax.swing.GroupLayout pn_sidebarLayout = new javax.swing.GroupLayout(pn_sidebar);
        pn_sidebar.setLayout(pn_sidebarLayout);
        pn_sidebarLayout.setHorizontalGroup(
            pn_sidebarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_sidebarLayout.createSequentialGroup()
                .addGroup(pn_sidebarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblLevel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pn_sidebarLayout.setVerticalGroup(
            pn_sidebarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pn_sidebarLayout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblUser, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblLevel, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE))
        );

        getContentPane().add(pn_sidebar, java.awt.BorderLayout.LINE_START);

        pn_utama.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout pn_contentLayout = new javax.swing.GroupLayout(pn_content);
        pn_content.setLayout(pn_contentLayout);
        pn_contentLayout.setHorizontalGroup(
            pn_contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pn_utama, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 413, Short.MAX_VALUE)
        );
        pn_contentLayout.setVerticalGroup(
            pn_contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pn_utama, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        getContentPane().add(pn_content, java.awt.BorderLayout.CENTER);

        setSize(new java.awt.Dimension(631, 445));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
       pn_utama.setLayout(new BorderLayout());
       pn_utama.add(new content_bg("/Image/bg_1.png"));
       pn_utama.repaint();
       pn_utama.revalidate();
    }//GEN-LAST:event_formWindowOpened

    private void btnSettingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSettingActionPerformed
         Frame parent =
        (Frame) SwingUtilities.getWindowAncestor(btnSetting);

        Menu_Setting menu = new Menu_Setting(parent, false); // NON-MODAL

        Point p = btnSetting.getLocationOnScreen();
        int x = p.x + btnSetting.getWidth() - menu.getPreferredSize().width;
        int y = p.y + btnSetting.getHeight();

        menu.pack();
        menu.setLocation(x, y);
        menu.setVisible(true);
    }//GEN-LAST:event_btnSettingActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Model_Login modelLogin = null;
                new Menu_Utama(modelLogin).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSetting;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblIcon;
    private javax.swing.JLabel lblLevel;
    private javax.swing.JLabel lblUser;
    private javax.swing.JPanel pn_content;
    private javax.swing.JPanel pn_menu;
    private javax.swing.JPanel pn_navbar;
    private javax.swing.JPanel pn_sidebar;
    private javax.swing.JPanel pn_utama;
    // End of variables declaration//GEN-END:variables
    
    
    private void execute(Model_Login modelLogin) {
        ImageIcon iconMaster  =  new ImageIcon(getClass().getResource("/Image/home.png"));
        ImageIcon iconDataMaster  =  new ImageIcon(getClass().getResource("/Image/note.png"));
        ImageIcon iconPeriksa  =  new ImageIcon(getClass().getResource("/Image/medical-records.png"));
        ImageIcon iconPembayaran  =  new ImageIcon(getClass().getResource("/Image/wallet.png"));
        ImageIcon iconLaporan  =  new ImageIcon(getClass().getResource("/Image/report.png"));
        ImageIcon iconLogout  =  new ImageIcon(getClass().getResource("/Image/logout.png"));
        ImageIcon iconMenu  =  new ImageIcon(getClass().getResource("/Image/menu_item.png"));
        
        Menu_Item masData1 = new Menu_Item(null, true, iconMenu, "Data Dokter", null);
            masData1.setAction(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setMenuAktif(masData1);
                pn_utama.removeAll();
                pn_utama.add(new View.Form_Dokter());
                pn_utama.repaint();
                pn_utama.revalidate();
            }
        });
        Menu_Item masData2 = new Menu_Item(null, true, iconMenu, "Data Pasien", null);
            masData2.setAction(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setMenuAktif(masData2);
                pn_utama.removeAll();
                pn_utama.add(new View.Form_Pasien());
                pn_utama.repaint();
                pn_utama.revalidate();
            }
        });
        Menu_Item masData3 = new Menu_Item(null, true, iconMenu, "Data Obat", null);
        masData3.setAction(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setMenuAktif(masData3);
                pn_utama.removeAll();
                pn_utama.add(new View.Form_Obat());
                pn_utama.repaint();
                pn_utama.revalidate();
            }
        });
        Menu_Item masData4 = new Menu_Item(null, true, iconMenu, "Data Pengguna", null);
        masData4.setAction(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setMenuAktif(masData4);
                pn_utama.removeAll();
                pn_utama.add(new View.Form_Pengguna());
                pn_utama.repaint();
                pn_utama.revalidate();
            }
        });
        
        Menu_Item masPeriksa1 = new Menu_Item(null, true, iconMenu, "Jadwal", null);
        masPeriksa1.setAction(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setMenuAktif(masPeriksa1);
                pn_utama.removeAll();
                pn_utama.add(new View.Form_Jadwal_Pemeriksaan());
                pn_utama.repaint();
                pn_utama.revalidate();
            }
        });
        
        Menu_Item masPeriksa2 = new Menu_Item(null, true, iconMenu, "Pemeriksaan", null);
        masPeriksa2.setAction(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setMenuAktif(masPeriksa2);
                pn_utama.removeAll();
                pn_utama.add(new View.Form_Pemeriksaan());
                pn_utama.repaint();
                pn_utama.revalidate();
            }
        });
        Menu_Item masPeriksa3 = new Menu_Item(null, true, iconMenu, "Resep Obat", null);
        masPeriksa3.setAction(new ActionListener() {
             @Override
            public void actionPerformed(ActionEvent e) {
                setMenuAktif(masPeriksa3);
                pn_utama.removeAll();
                pn_utama.add(new View.Form_ResepObat());
                pn_utama.repaint();
                pn_utama.revalidate();
            }
        });  
        Menu_Item menuMaster = new Menu_Item(iconMaster,false, null, "Dashboard", null);
        menuMaster.setAction(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                setMenuAktif(menuMaster);
                pn_utama.removeAll();
                pn_utama.add(new content_bg("/Image/bg_1.png"));
                pn_utama.repaint();
                pn_utama.revalidate();
            }
        });
                
        Menu_Item menuDataMaster  =  new Menu_Item(iconDataMaster,false,null,"Data Master",null, masData1,masData2, masData3, masData4);
        Menu_Item menuPemeriksaan  =  new Menu_Item(iconPeriksa,false,null,"Periksa",null, masPeriksa1,masPeriksa2,masPeriksa3);
        
        Menu_Item menuPembayaran = new Menu_Item(iconPembayaran, false, null, "Data Pembayaran", null);
        menuPembayaran.setAction(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                setMenuAktif(menuPembayaran);
                pn_utama.removeAll();
                pn_utama.add(new View.Form_Pembayaran());
                pn_utama.repaint();
                pn_utama.revalidate();
            }
        });
        
        Menu_Item laporan = new Menu_Item(null, true, iconMenu,"Data Pasien",null);
        Menu_Item laporan2 = new Menu_Item(null, true, iconMenu,"Data Resep",null);
        Menu_Item laporan3 = new Menu_Item(null, true, iconMenu, "Laporan",null);
        Menu_Item laporan4 = new Menu_Item(null, true, iconMenu, "Laporan",null);
        Menu_Item laporan5 = new Menu_Item(null, true, iconMenu, "Laporan",null);
        
//        Menu_Item menuReport  =  new Menu_Item(iconLaporan,false,null,"Laporan", null, laporan, laporan2, laporan3, laporan4, laporan4, laporan5);
         
        
        if (modelLogin == null) return;

        if (isAdmin()) {
            addMenu(menuMaster,menuDataMaster,menuPemeriksaan,menuPembayaran);
        }

        if (isDokter()) {
            addMenu(menuMaster, menuPemeriksaan);
        }
        
    }
    
    private void addMenu(Menu_Item... menu) {
    for (Menu_Item m : menu) {
        pn_menu.add(m);
        allMenu.add(m);

        for (Menu_Item sub : m.getSubMenu()) {
            addMenu(sub);
        }
    }
    pn_menu.revalidate();
}

     private void resetMenuAktif() {
    for (Menu_Item m : allMenu) {
        m.setActive(false);
    }
}

    private void setMenuAktif(Menu_Item aktif) {
    resetMenuAktif();
    aktif.setActive(true);
}

    private void tampilkanUser() {
        if (modelLogin == null) return;

        lblUser.setText(modelLogin.getUsername());

        ImageIcon icon;
        String levelTeks;

        if (modelLogin.getLevel() == 1) {
            levelTeks = "Administrator";
            icon = new ImageIcon(getClass().getResource("/Image/Administrator.png"));
        } else {
            levelTeks = "Dokter";
            icon = new ImageIcon(getClass().getResource("/Image/Dokter.png"));
        }

        lblLevel.setText(levelTeks);
        lblIcon.setIcon(icon);
    }
    private void setAppIcon() {
        setIconImage(
        Toolkit.getDefaultToolkit().getImage(
            getClass().getResource("/Image/logoo.png")
        )
    );
    }
}
