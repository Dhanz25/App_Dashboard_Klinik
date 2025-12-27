
package View;

import Config.Koneksi;
import Config.UserSession;
import DAO.Dao_Jadwal;
import DAO.Dao_Pemeriksaan;
import Model.Model_Jadwal;
import Model.Model_Pemeriksaan;
import Service.Service_Jadwal;
import Service.Service_Pemeriksaan;
import TableModel.Tablemod_Pemeriksaan;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.RowFilter;
import javax.swing.SpinnerDateModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

public class Form_Pemeriksaan extends javax.swing.JPanel {

    private Service_Pemeriksaan servisJadwal = new Dao_Pemeriksaan();
    private Service_Pemeriksaan servis = new Dao_Pemeriksaan();
    private Tablemod_Pemeriksaan tblModel = new Tablemod_Pemeriksaan();
    private TableRowSorter<TableModel> sorter;
    private final int COL_NAMA = 1;
    
    public Form_Pemeriksaan() {
    initComponents();
    loadComboJadwal();
    cekHakAkses();

    SpinnerDateModel model =
    new SpinnerDateModel(new Date(), null, null, Calendar.MINUTE);
    spntanggal.setModel(model);

    JSpinner.DateEditor dateEditor =
        new JSpinner.DateEditor(spntanggal, "yyyy-MM-dd");
    spntanggal.setEditor(dateEditor);
    
    javax.swing.JFormattedTextField tf =
    dateEditor.getTextField();
    tf.setEditable(false);
    tf.setBackground(java.awt.Color.LIGHT_GRAY);

    new javax.swing.Timer(1000, e -> {
    spntanggal.setValue(new Date());
    }).start();
    
    tblPemeriksaan.setModel(tblModel);
    sorter = new TableRowSorter<>(tblPemeriksaan.getModel());
    tblPemeriksaan.setRowSorter(sorter);

    loadData();
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        mainPanel = new javax.swing.JPanel();
        dataPemeriksaan = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPemeriksaan = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        btnTambah = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        txtCari = new javax.swing.JTextField();
        btnBatal = new javax.swing.JButton();
        btnPrint = new javax.swing.JButton();
        tambahPemeriksaan = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        btnKembali = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtIdPemeriksaan = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtKeluhan = new javax.swing.JTextField();
        cmbjadwal = new javax.swing.JComboBox<>();
        txtDiagnosa = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtTindakan = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        spntanggal = new javax.swing.JSpinner();
        btnSimpan = new javax.swing.JButton();

        setLayout(new java.awt.CardLayout());

        mainPanel.setLayout(new java.awt.CardLayout());

        tblPemeriksaan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID Pemeriksaan", "ID Jadwal", "Keluhan", "Diagnosa", "Tindakan", "Tanggal"
            }
        ));
        tblPemeriksaan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPemeriksaanMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblPemeriksaan);

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        jLabel1.setText("Data Pemeriksaan");

        btnTambah.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/tambah.png"))); // NOI18N
        btnTambah.setContentAreaFilled(false);
        btnTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahActionPerformed(evt);
            }
        });

        btnEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/edit.png"))); // NOI18N
        btnEdit.setContentAreaFilled(false);
        btnEdit.setMaximumSize(new java.awt.Dimension(79, 25));
        btnEdit.setMinimumSize(new java.awt.Dimension(79, 25));
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnHapus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/hapus.png"))); // NOI18N
        btnHapus.setContentAreaFilled(false);
        btnHapus.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnHapus.setMaximumSize(new java.awt.Dimension(79, 25));
        btnHapus.setMinimumSize(new java.awt.Dimension(79, 25));
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });

        txtCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCariActionPerformed(evt);
            }
        });
        txtCari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCariKeyReleased(evt);
            }
        });

        btnBatal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/close.png"))); // NOI18N
        btnBatal.setContentAreaFilled(false);
        btnBatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBatalActionPerformed(evt);
            }
        });

        btnPrint.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/print.png"))); // NOI18N
        btnPrint.setContentAreaFilled(false);
        btnPrint.setMaximumSize(new java.awt.Dimension(32, 32));
        btnPrint.setMinimumSize(new java.awt.Dimension(32, 32));
        btnPrint.setPreferredSize(new java.awt.Dimension(32, 32));
        btnPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrintActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout dataPemeriksaanLayout = new javax.swing.GroupLayout(dataPemeriksaan);
        dataPemeriksaan.setLayout(dataPemeriksaanLayout);
        dataPemeriksaanLayout.setHorizontalGroup(
            dataPemeriksaanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dataPemeriksaanLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(dataPemeriksaanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 647, Short.MAX_VALUE)
                    .addGroup(dataPemeriksaanLayout.createSequentialGroup()
                        .addComponent(btnTambah, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnPrint, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtCari, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(dataPemeriksaanLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnBatal, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        dataPemeriksaanLayout.setVerticalGroup(
            dataPemeriksaanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dataPemeriksaanLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(dataPemeriksaanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnBatal)
                    .addComponent(jLabel1))
                .addGap(30, 30, 30)
                .addGroup(dataPemeriksaanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(dataPemeriksaanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btnEdit, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnHapus, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtCari, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnTambah, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnPrint, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 665, Short.MAX_VALUE)
                .addContainerGap())
        );

        mainPanel.add(dataPemeriksaan, "card2");

        tambahPemeriksaan.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        jLabel2.setText("Tambah Data Pemeriksaan");

        btnKembali.setBackground(javax.swing.UIManager.getDefaults().getColor("close_button"));
        btnKembali.setText("Kembali");
        btnKembali.setMaximumSize(new java.awt.Dimension(79, 25));
        btnKembali.setMinimumSize(new java.awt.Dimension(79, 25));
        btnKembali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKembaliActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel3.setText("ID Pemeriksaan");

        txtIdPemeriksaan.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        txtIdPemeriksaan.setEnabled(false);
        txtIdPemeriksaan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdPemeriksaanActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel4.setText("Nama Pasien");

        jLabel5.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel5.setText("Keluhan");

        jLabel7.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel7.setText("DIagnosa");

        txtKeluhan.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));

        txtDiagnosa.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));

        jLabel9.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel9.setText("Tindakan");

        txtTindakan.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));

        jLabel6.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel6.setText("Tanggal");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtIdPemeriksaan)
                    .addComponent(txtKeluhan)
                    .addComponent(txtDiagnosa)
                    .addComponent(txtTindakan, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmbjadwal, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel7)
                            .addComponent(jLabel9)
                            .addComponent(jLabel6)
                            .addComponent(spntanggal, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addGap(1, 1, 1)
                .addComponent(txtIdPemeriksaan, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addGap(4, 4, 4)
                .addComponent(cmbjadwal, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtKeluhan, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtDiagnosa, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTindakan, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(spntanggal, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        btnSimpan.setBackground(javax.swing.UIManager.getDefaults().getColor("textHighlight"));
        btnSimpan.setText("Simpan");
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout tambahPemeriksaanLayout = new javax.swing.GroupLayout(tambahPemeriksaan);
        tambahPemeriksaan.setLayout(tambahPemeriksaanLayout);
        tambahPemeriksaanLayout.setHorizontalGroup(
            tambahPemeriksaanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tambahPemeriksaanLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(tambahPemeriksaanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tambahPemeriksaanLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 249, Short.MAX_VALUE)
                        .addComponent(btnKembali, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27))
                    .addGroup(tambahPemeriksaanLayout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(tambahPemeriksaanLayout.createSequentialGroup()
                        .addComponent(btnSimpan)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        tambahPemeriksaanLayout.setVerticalGroup(
            tambahPemeriksaanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tambahPemeriksaanLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(tambahPemeriksaanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(btnKembali, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSimpan, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        mainPanel.add(tambahPemeriksaan, "card2");

        add(mainPanel, "card2");
    }// </editor-fold>//GEN-END:initComponents

    private void btnTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahActionPerformed
        mainPanel.removeAll();
        mainPanel.repaint();
        mainPanel.revalidate();
        
        mainPanel.add(tambahPemeriksaan);
        mainPanel.repaint();
        mainPanel.revalidate();
    }//GEN-LAST:event_btnTambahActionPerformed

    private void btnKembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKembaliActionPerformed
        mainPanel.removeAll();
        mainPanel.add(dataPemeriksaan);
        mainPanel.repaint();
        mainPanel.revalidate();
    }//GEN-LAST:event_btnKembaliActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        hapusData();
    }//GEN-LAST:event_btnHapusActionPerformed

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        if(btnSimpan.getText().equals("Simpan")){
            simpanData();
        }else{
            perbaruiData();
        }
    }//GEN-LAST:event_btnSimpanActionPerformed

    private void tblPemeriksaanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPemeriksaanMouseClicked
        if (UserSession.level == 1) {
            btnEdit.setVisible(false);
            btnHapus.setVisible(false);
            btnBatal.setVisible(true);
            return;
        }
        btnHapus.setVisible(true);
        btnEdit.setVisible(true);
        btnBatal.setVisible(true);
        btnTambah.setEnabled(false);    
    }//GEN-LAST:event_tblPemeriksaanMouseClicked

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        int row = tblPemeriksaan.getSelectedRow();
    
    if (row == -1) {
        JOptionPane.showMessageDialog(this, 
            "Pilih baris data dahulu!", 
            "Peringatan", 
            JOptionPane.WARNING_MESSAGE);
        return;
    }
    dataTabel();

    mainPanel.removeAll();
    mainPanel.add(tambahPemeriksaan);
    mainPanel.repaint();
    mainPanel.revalidate();
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnBatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBatalActionPerformed
        tampilPanel();
        loadData();
    }//GEN-LAST:event_btnBatalActionPerformed

    private void txtCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCariActionPerformed
        
    }//GEN-LAST:event_txtCariActionPerformed

    private void txtCariKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCariKeyReleased
       String keyword = txtCari.getText();

    // VALIDASI: Jika mengandung angka → tampilkan pesan
    if (keyword.matches(".*\\d.*")) { 
        JOptionPane.showMessageDialog(null,
            "Pencarian hanya boleh berdasarkan NAMA (huruf saja).",
            "Input Tidak Valid",
            JOptionPane.WARNING_MESSAGE);
        txtCari.setText(keyword.replaceAll("\\d", ""));
        return;
    }
    // --- lanjut filter jika valid ---
    if (keyword.trim().isEmpty()) {
        sorter.setRowFilter(null);
        return;
    }
    String escaped = java.util.regex.Pattern.quote(keyword);
    sorter.setRowFilter(RowFilter.regexFilter("(?i).*" + escaped + ".*", 1));
    }//GEN-LAST:event_txtCariKeyReleased

    private void txtIdPemeriksaanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdPemeriksaanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdPemeriksaanActionPerformed

    private void btnPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrintActionPerformed
        try {
            InputStream reportStream =
            getClass().getResourceAsStream("/Report/Report_Pemeriksaan.jasper");

            HashMap<String, Object> parameter = new HashMap<>();

            Connection cn = Koneksi.getConnection();

            JasperPrint jp = JasperFillManager.fillReport(
                reportStream,
                parameter,
                cn
            );

            JasperViewer.viewReport(jp, false);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(
                this,
                "Gagal mencetak laporan!\n" + e.getMessage(),
                "Error",
                JOptionPane.ERROR_MESSAGE
            );
        }
    }//GEN-LAST:event_btnPrintActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBatal;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnKembali;
    private javax.swing.JButton btnPrint;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JButton btnTambah;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<Model_Jadwal> cmbjadwal;
    private javax.swing.JPanel dataPemeriksaan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JSpinner spntanggal;
    private javax.swing.JPanel tambahPemeriksaan;
    private javax.swing.JTable tblPemeriksaan;
    private javax.swing.JTextField txtCari;
    private javax.swing.JTextField txtDiagnosa;
    private javax.swing.JTextField txtIdPemeriksaan;
    private javax.swing.JTextField txtKeluhan;
    private javax.swing.JTextField txtTindakan;
    // End of variables declaration//GEN-END:variables

    private void dataTabel() {
    int row = tblPemeriksaan.getSelectedRow();
    if (row == -1) return;

    dataPemeriksaan.setVisible(false);
    tambahPemeriksaan.setVisible(true);
    jLabel2.setText("Perbarui Data Pemeriksaan");

    txtIdPemeriksaan.setEnabled(false);

    int modelRow = tblPemeriksaan.convertRowIndexToModel(row);
    Model_Pemeriksaan pm = tblModel.getData(modelRow);

    txtIdPemeriksaan.setText(
        String.valueOf(pm.getId_pemeriksaan())
    );

    loadComboJadwal();

    Model_Jadwal jadwalPemeriksaan = pm.getId_jadwal();
    boolean ketemu = false;

    for (int i = 0; i < cmbjadwal.getItemCount(); i++) {
        Model_Jadwal j = cmbjadwal.getItemAt(i);
        if (j.getId_jadwal() == jadwalPemeriksaan.getId_jadwal()) {
            cmbjadwal.setSelectedIndex(i);
            ketemu = true;
            break;
        }
    }

    if (!ketemu) {
        cmbjadwal.addItem(jadwalPemeriksaan);
        cmbjadwal.setSelectedItem(jadwalPemeriksaan);
    }

    txtKeluhan.setText(pm.getKeluhan());
    txtDiagnosa.setText(pm.getDiagnosa());
    txtTindakan.setText(pm.getTindakan());
    spntanggal.setValue(pm.getTanggal());

    aktif();
    btnSimpan.setText("Perbarui");
    btnKembali.setVisible(true);
}



    private void aktif(){
        txtIdPemeriksaan.setEnabled(false);
        txtKeluhan.setEnabled(true);
        txtDiagnosa.setEnabled(true);
        txtTindakan.setEnabled(true);
    }
    private void loadData() {
        btnHapus.setVisible(false);
        btnEdit.setVisible(false);
        btnBatal.setVisible(false);
        List<Model_Pemeriksaan> list=servis.ambilPemeriksaan();
        tblModel.setData(list);
    }
    private void hapusData(){
        int index = tblPemeriksaan.getSelectedRow();
        if(index!=-1){
            Model_Pemeriksaan pm = tblModel.getData(tblPemeriksaan.convertRowIndexToModel(index));
            if(JOptionPane.showConfirmDialog(null, "Yakin Data Akan Dihapus", "Konfirmasi", 
                    JOptionPane.OK_CANCEL_OPTION)==JOptionPane.OK_OPTION){
                servis.hapusPemeriksaan(pm);
                tblModel.hapusData(index);
                loadData();
                resetForm();
                tampilPanel();
            }
        }else{
            JOptionPane.showMessageDialog(null, "Pilih dahulu record yang akan dihapus");
        }
    }
    private void resetForm() {
        txtIdPemeriksaan.setText("");
        txtKeluhan.setText("");
        txtDiagnosa.setText("");
        txtTindakan.setText("");
        spntanggal.setValue(new java.util.Date());
        btnTambah.requestFocus();
    }
    private void tampilPanel(){
        mainPanel.removeAll();
        mainPanel.add(new Form_Pemeriksaan());
        mainPanel.repaint();
        mainPanel.revalidate();
    }
    private void simpanData() {
        Model_Pemeriksaan prk = new Model_Pemeriksaan();

        Model_Jadwal jadwal = (Model_Jadwal) cmbjadwal.getSelectedItem();
        prk.setId_jadwal(jadwal);
        prk.setKeluhan(txtKeluhan.getText());
        prk.setDiagnosa(txtDiagnosa.getText());
        prk.setTindakan(txtTindakan.getText());
        prk.setTanggal((Date) spntanggal.getValue());

        servis.tambahPemeriksaan(prk);
        JOptionPane.showMessageDialog(null, "Data Berhasil ditambahkan");

        resetForm();
        loadData();
        tampilPanel();
    }
    private void perbaruiData() {
    int index = tblPemeriksaan.getSelectedRow();
    if (index != -1) {

        if (validasiInput()) {

            Model_Pemeriksaan pr = new Model_Pemeriksaan();
            
            pr.setId_pemeriksaan(
                Integer.parseInt(txtIdPemeriksaan.getText())
            );

            Model_Jadwal j = (Model_Jadwal) cmbjadwal.getSelectedItem();
            pr.setId_jadwal(j);
            pr.setKeluhan(txtKeluhan.getText());
            pr.setDiagnosa(txtDiagnosa.getText());
            pr.setTindakan(txtTindakan.getText());
            pr.setTanggal((Date) spntanggal.getValue());
            
            servis.perbaruiPemeriksaan(pr);
            tblModel.perbaruiData(index, pr);

            JOptionPane.showMessageDialog(null, "Data Berhasil diperbarui");
            loadData();
            resetForm();
            tampilPanel();
        }
    } else {
        JOptionPane.showMessageDialog(this, "Pilih data yang akan diperbarui!");
    }
    }
    private boolean validasiInput() {
    if(txtKeluhan.getText().trim().isEmpty()){
        JOptionPane.showMessageDialog(this, "Keluhan tidak boleh kosong");
        txtKeluhan.requestFocus();
        return false;
    }
    if(txtDiagnosa.getText().trim().isEmpty()){
        JOptionPane.showMessageDialog(this, "Diagnosa tidak boleh kosong");
        txtDiagnosa.requestFocus();
        return false;
    }
    if(txtTindakan.getText().trim().isEmpty()){
        JOptionPane.showMessageDialog(this, "Tindakan tidak boleh kosong");
        txtTindakan.requestFocus();
        return false;
    }
    if (spntanggal.getValue() == null) {
    JOptionPane.showMessageDialog(this, "Tanggal harus dipilih");
    return false;
    }
    return true;
    }
    
   private void loadComboJadwal() {
    cmbjadwal.removeAllItems();

    Service_Jadwal servis = new Dao_Jadwal();

    for (Model_Jadwal j : servis.ambilJadwalBelumPeriksa()) {
        cmbjadwal.addItem(j);
    }
}

    private void cekHakAkses() {
        if (UserSession.level == 1) {
            btnTambah.setVisible(false);
            btnEdit.setVisible(false);
            btnHapus.setVisible(false);
        } else { 
            btnTambah.setVisible(true);
            btnEdit.setVisible(true);
            btnHapus.setVisible(true);
        }
    }

}
