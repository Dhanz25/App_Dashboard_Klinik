
package View;

import java.awt.AWTEvent;
import java.awt.Component;
import java.awt.Desktop;
import java.awt.Toolkit;
import java.awt.event.AWTEventListener;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.net.URL;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;


public class About extends java.awt.Dialog {
    private AWTEventListener outsideClickListener;
    public About(java.awt.Frame parent, boolean modal){
        super(parent, modal);
        setUndecorated(true);
        setModal(false);          
        setAlwaysOnTop(false);    
        initComponents();
        jEditorPane1.setOpaque(false);
        jEditorPane1.setEditable(false);
        jEditorPane1.setBorder(null);
        jScrollPane1.setBorder(null);
        jScrollPane1.setViewportBorder(null);
        jScrollPane1.getViewport().setOpaque(false);
        
        jEditorPane1.setContentType("text/html");
        jEditorPane1.setEditable(false); 

        jEditorPane1.addHyperlinkListener(e -> {
         if (e.getEventType() == javax.swing.event.HyperlinkEvent.EventType.ACTIVATED) {
        try {
            URL pdf = getClass().getResource("/ManualBook/ManualBook.pdf");
            Desktop.getDesktop().open(new File(pdf.toURI()));
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Gagal membuka Manual Book");
        }
    }
    });
        setLocationRelativeTo(parent);
        outsideClickListener = new AWTEventListener() {
    @Override
    public void eventDispatched(AWTEvent event) {

        if (!(event instanceof MouseEvent)) return;

        MouseEvent me = (MouseEvent) event;

        if (me.getID() != MouseEvent.MOUSE_PRESSED) return;

        Component c = me.getComponent();

        if (c == null) return;

        if (!SwingUtilities.isDescendingFrom(c, About.this)) {
            dispose();
        }
    }
};

Toolkit.getDefaultToolkit().addAWTEventListener(
    outsideClickListener,
    AWTEvent.MOUSE_EVENT_MASK
);

addWindowListener(new WindowAdapter() {
    @Override
    public void windowClosed(WindowEvent e) {
        Toolkit.getDefaultToolkit()
               .removeAWTEventListener(outsideClickListener);
    }
});
}
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jEditorPane1 = new javax.swing.JEditorPane();

        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jEditorPane1.setEditable(false);
        jEditorPane1.setBackground(new java.awt.Color(204, 204, 204));
        jEditorPane1.setBorder(null);
        jEditorPane1.setContentType("text/html"); // NOI18N
        jEditorPane1.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jEditorPane1.setText("<html>\n<body style=\"font-family: Sans-Serif; font-size: 12px;\">\n\n<!-- FOTO / LOGO -->\n<div style=\"text-align: center; margin-bottom: 15px;\">\n    <img src=\"file:src/Image/logoo.png\" width=\"120\">\n</div>\n\n<!-- DESKRIPSI -->\n<div style=\"text-align: justify;\">\nAplikasi Klinik ini dikembangkan untuk membantu pengelolaan data klinik secara terkomputerisasi,\nmeliputi data pasien, dokter, pemeriksaan, dan layanan medis.\nSistem ini bertujuan meningkatkan efisiensi administrasi dan kualitas pelayanan kesehatan\nagar proses administrasi dan pelayanan menjadi lebih cepat dan akurat.\n</div>\n\n<div style=\"margin-top:20px; font-weight:bold;\">\nTeam Pengembang:\n</div>\n<div style=\"text-align:center; margin-top:15px; margin-bottom:20px; border-radius:50%\">\n    <img src=\"file:src/Team/Faizz.jpeg\" width=\"100\"><br>\n    <b>24SA21A045</b><br>\n    <b>Faizurrohim Ramadhani</b><br>\n    Ketua Kelompok\n</div>\n\n<!-- ANGGOTA -->\n<table width=\"100%\" cellpadding=\"12\">\n    <tr>\n        <td align=\"center\">\n            <img src=\"file:src/Team/Adit.jpg\" width=\"100\"><br>\n            <b>24SA21A069</b><br>\n            <b>Aditya Saputra Darmawan</b><br>\n            Anggota 1\n        </td>\n        <td align=\"center\">\n            <img src=\"file:src/Team/Abi.jpeg\" width=\"100\"><br>\n            <b>24SA21A073</b><br>\n            <b>Abi Rizki Hidayat</b><br>\n            Anggota 2\n        </td>\n        <td align=\"center\">\n            <img src=\"file:src/Team/Bathin.jpg\" width=\"100\"><br>\n             <b>24SA21A044</b><br>\n             <b>Bathin Daffa Ramadhan</b><br>\n            Anggota 3\n        </td>\n    </tr>\n    <tr>\n        <td align=\"center\">\n            <img src=\"file:src/Team/Arif.jpg\" width=\"100\"><br>\n             <b>24SA21A076</b><br>\n             <b>Arif Setiabudi</b><br>\n            Anggota 4\n        </td>\n        <td align=\"center\">\n            <img src=\"file:src/Team/Damar.jpg\" width=\"100\"><br>\n             <b>24SA21A078</b><br>\n             <b>Damar Praba Arga R</b><br>\n            Anggota 5\n        </td>\n        <td align=\"center\">\n            <img src=\"file:src/Team/Anggerr.jpg\" width=\"100\"><br>\n             <b>24SA21A070</b><br>\n             <b>Angger Dwi Laksana</b><br>\n            Anggota 6\n        </td>\n    </tr>\n</table>\n\n<div style=\"margin-top:10px; font-weight:bold; \">\n    <a href=\"manual/ManualBook.pdf\" style=\"text-decoration:none; color:#25727a;\">\n        📘 Manual Book\n    </a>\n</div>\n\n</body>\n</html>\n");
        jEditorPane1.setCaretColor(new java.awt.Color(204, 204, 204));
        jEditorPane1.setDisabledTextColor(new java.awt.Color(204, 204, 204));
        jEditorPane1.setOpaque(false);
        jScrollPane1.setViewportView(jEditorPane1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 776, Short.MAX_VALUE)
                .addGap(68, 68, 68))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 889, Short.MAX_VALUE)
                .addGap(65, 65, 65))
        );

        add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void closeDialog(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_closeDialog
        setVisible(false);
        dispose();
    }//GEN-LAST:event_closeDialog

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                About dialog = new About(new java.awt.Frame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JEditorPane jEditorPane1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

}
