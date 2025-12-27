
package View;

import Config.Koneksi;
import DAO.Dao_Pemeriksaan;
import DAO.Dao_Pembayaran;
import Model.Model_Pembayaran;
import Service.Service_Pemeriksaan;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.RowFilter;
import javax.swing.SpinnerDateModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import Service.Service_Pembayaran;
import TableModel.tablemod_pembayaran;
import java.io.InputStream;
import java.sql.Connection;
import java.util.HashMap;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

public class Form_Pembayaran extends javax.swing.JPanel {

    private Service_Pemeriksaan servisJadwal = new Dao_Pemeriksaan();
    private Service_Pembayaran servis = new Dao_Pembayaran();
    private tablemod_pembayaran tblModel = new tablemod_pembayaran();
    private TableRowSorter<TableModel> sorter;
    private final int COL_NAMA = 1;
    
    public Form_Pembayaran() {
    initComponents();
    loadStatus();

    SpinnerDateModel dateModel =
        new SpinnerDateModel(new java.util.Date(), null, null, Calendar.DAY_OF_MONTH);
    spntanggal.setModel(dateModel);

    JSpinner.DateEditor dateEditor =
        new JSpinner.DateEditor(spntanggal, "yyyy-MM-dd");
    spntanggal.setEditor(dateEditor);

    tblPembayaran.setModel(tblModel);
    sorter = new TableRowSorter<>(tblPembayaran.getModel());
    tblPembayaran.setRowSorter(sorter);

    loadData();
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        mainPanel = new javax.swing.JPanel();
        dataPembayaran = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPembayaran = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        btnTambah = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        txtCari = new javax.swing.JTextField();
        btnBatal = new javax.swing.JButton();
        btnPrint = new javax.swing.JButton();
        tambahPembayaran = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        btnKembali = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtIdPembayaran = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtTotalbayar = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        spntanggal = new javax.swing.JSpinner();
        cmbstatus = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        txtJumlah = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtObat = new javax.swing.JTextField();
        txtPasien = new javax.swing.JTextField();
        btnSimpan = new javax.swing.JButton();

        setLayout(new java.awt.CardLayout());

        mainPanel.setLayout(new java.awt.CardLayout());

        tblPembayaran.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID Pembayaran", "ID Pemeriksaan", "Total bayar", "Tanggal Pembayaran", "Status"
            }
        ));
        tblPembayaran.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPembayaranMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblPembayaran);

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        jLabel1.setText("Data Pembayaran");

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

        javax.swing.GroupLayout dataPembayaranLayout = new javax.swing.GroupLayout(dataPembayaran);
        dataPembayaran.setLayout(dataPembayaranLayout);
        dataPembayaranLayout.setHorizontalGroup(
            dataPembayaranLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dataPembayaranLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(dataPembayaranLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 647, Short.MAX_VALUE)
                    .addGroup(dataPembayaranLayout.createSequentialGroup()
                        .addComponent(btnTambah, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnPrint, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtCari, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(dataPembayaranLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnBatal, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        dataPembayaranLayout.setVerticalGroup(
            dataPembayaranLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dataPembayaranLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(dataPembayaranLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnBatal)
                    .addComponent(jLabel1))
                .addGap(30, 30, 30)
                .addGroup(dataPembayaranLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(dataPembayaranLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btnEdit, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnHapus, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtCari, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnTambah, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnPrint, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 330, Short.MAX_VALUE)
                .addContainerGap())
        );

        mainPanel.add(dataPembayaran, "card2");

        tambahPembayaran.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        jLabel2.setText("Tambah Data Pembayaran");

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
        jLabel3.setText("ID Pembayaran");

        txtIdPembayaran.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        txtIdPembayaran.setEnabled(false);
        txtIdPembayaran.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdPembayaranActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel4.setText("Nama Pasien");

        jLabel5.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel5.setText("Total Bayar");

        jLabel7.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel7.setText("Tanggal Pembayaran");

        txtTotalbayar.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));

        jLabel9.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel9.setText("Status");

        jLabel6.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel6.setText("Nama Obat");

        txtJumlah.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));

        jLabel8.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel8.setText("Jumlah");

        txtObat.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));

        txtPasien.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtPasien)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtIdPembayaran)
                            .addComponent(txtTotalbayar)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel4)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addGap(268, 268, 268)
                                        .addComponent(jLabel8)))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtObat, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(63, 63, 63)
                                .addComponent(txtJumlah)))
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(spntanggal, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(155, 155, 155)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(144, 144, 144))
                            .addComponent(cmbstatus, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(104, 104, 104))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addGap(1, 1, 1)
                .addComponent(txtIdPembayaran, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPasien, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtJumlah, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtObat, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTotalbayar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(spntanggal, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbstatus, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        btnSimpan.setBackground(javax.swing.UIManager.getDefaults().getColor("textHighlight"));
        btnSimpan.setText("Simpan");
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout tambahPembayaranLayout = new javax.swing.GroupLayout(tambahPembayaran);
        tambahPembayaran.setLayout(tambahPembayaranLayout);
        tambahPembayaranLayout.setHorizontalGroup(
            tambahPembayaranLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tambahPembayaranLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(tambahPembayaranLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tambahPembayaranLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnKembali, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27))
                    .addGroup(tambahPembayaranLayout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(tambahPembayaranLayout.createSequentialGroup()
                        .addComponent(btnSimpan)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        tambahPembayaranLayout.setVerticalGroup(
            tambahPembayaranLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tambahPembayaranLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(tambahPembayaranLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(btnKembali, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSimpan, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        mainPanel.add(tambahPembayaran, "card2");

        add(mainPanel, "card2");
    }// </editor-fold>//GEN-END:initComponents

    private void btnTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahActionPerformed
        mainPanel.removeAll();
        mainPanel.repaint();
        mainPanel.revalidate();
        
        mainPanel.add(tambahPembayaran);
        mainPanel.repaint();
        mainPanel.revalidate();
    }//GEN-LAST:event_btnTambahActionPerformed

    private void btnKembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKembaliActionPerformed
        mainPanel.removeAll();
        mainPanel.add(dataPembayaran);
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

    private void tblPembayaranMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPembayaranMouseClicked
        btnHapus.setVisible(false);
        btnEdit.setVisible(true);
        btnBatal.setVisible(true);
        btnTambah.setEnabled(false);    
    }//GEN-LAST:event_tblPembayaranMouseClicked

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        int row = tblPembayaran.getSelectedRow();
    
    if (row == -1) {
        JOptionPane.showMessageDialog(this, 
            "Pilih baris data dahulu!", 
            "Peringatan", 
            JOptionPane.WARNING_MESSAGE);
        return;
    }
    dataTabel();

    mainPanel.removeAll();
    mainPanel.add(tambahPembayaran);
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

    private void txtIdPembayaranActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdPembayaranActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdPembayaranActionPerformed

    private void btnPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrintActionPerformed
        try {
            InputStream reportStream =
            getClass().getResourceAsStream("/Report/Report_Pembayaran.jasper");

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
    private javax.swing.JComboBox<String> cmbstatus;
    private javax.swing.JPanel dataPembayaran;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JSpinner spntanggal;
    private javax.swing.JPanel tambahPembayaran;
    private javax.swing.JTable tblPembayaran;
    private javax.swing.JTextField txtCari;
    private javax.swing.JTextField txtIdPembayaran;
    private javax.swing.JTextField txtJumlah;
    private javax.swing.JTextField txtObat;
    private javax.swing.JTextField txtPasien;
    private javax.swing.JTextField txtTotalbayar;
    // End of variables declaration//GEN-END:variables

    private void dataTabel() {
     int row = tblPembayaran.getSelectedRow();
    if (row == -1) return;

    dataPembayaran.setVisible(false);
    tambahPembayaran.setVisible(true);

    jLabel2.setText("Perbarui Status Pembayaran");

    txtIdPembayaran.setText(
        tblPembayaran.getValueAt(row, 0).toString()
    );

    txtPasien.setText(
        tblPembayaran.getValueAt(row, 1).toString()
    );

    txtObat.setText(
        tblPembayaran.getValueAt(row, 2).toString()
    );

    txtJumlah.setText(
        tblPembayaran.getValueAt(row, 3).toString()
    );

    txtTotalbayar.setText(
        tblPembayaran.getValueAt(row, 4).toString()
    );

    cmbstatus.setSelectedItem(
        tblPembayaran.getValueAt(row, 6).toString()
    );

    try {
        Date tgl = new SimpleDateFormat("yyyy-MM-dd")
            .parse(tblPembayaran.getValueAt(row, 5).toString());
        spntanggal.setValue(tgl);
    } catch (Exception e) {
        e.printStackTrace();
    }

    aktif();

    btnSimpan.setText("Perbarui Status");
    btnKembali.setVisible(true);
    }
    private void aktif(){
        txtIdPembayaran.setEnabled(false);
        txtPasien.setEnabled(false);
        txtObat.setEnabled(false);
        txtJumlah.setEnabled(false);
        txtTotalbayar.setEnabled(false);
        spntanggal.setEnabled(false);

        cmbstatus.setEnabled(true);
    }
    
    private void loadData() {
        btnHapus.setVisible(false);
        btnEdit.setVisible(false);
        btnTambah.setVisible(false);
        btnBatal.setVisible(false);
        List<Model_Pembayaran> list=servis.ambilPembayaran();
        tblModel.setData(list);
    }
    private void hapusData(){
        int index = tblPembayaran.getSelectedRow();
        if(index!=-1){
            Model_Pembayaran pm = tblModel.getData(tblPembayaran.convertRowIndexToModel(index));
            if(JOptionPane.showConfirmDialog(null, "Yakin Data Akan Dihapus", "Konfirmasi", 
                    JOptionPane.OK_CANCEL_OPTION)==JOptionPane.OK_OPTION){
                servis.hapusPembayaran(pm);
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
        txtIdPembayaran.setText("");
        txtTotalbayar.setText("");
        cmbstatus.setSelectedItem(null);
        spntanggal.setValue(new java.util.Date());
        btnTambah.requestFocus();
    }
    private void tampilPanel(){
        mainPanel.removeAll();
        mainPanel.add(new Form_Pembayaran());
        mainPanel.repaint();
        mainPanel.revalidate();
    }
    private void simpanData() {
    }
    private void perbaruiData() {
        int row = tblPembayaran.getSelectedRow();
    if (row == -1) {
        JOptionPane.showMessageDialog(this, "Pilih data terlebih dahulu!");
        return;
    }

    int idPembayaran = Integer.parseInt(txtIdPembayaran.getText());
    String status = cmbstatus.getSelectedItem().toString();

    servis.updateStatusPembayaran(idPembayaran, status);

    JOptionPane.showMessageDialog(null, "Status berhasil diperbarui");

    loadData();
    resetForm();
    tampilPanel();
    }
    private void loadStatus() {
        cmbstatus.removeAllItems();
        cmbstatus.addItem("-- PILIH STATUS --");
        cmbstatus.addItem("BELUM LUNAS");
        cmbstatus.addItem("LUNAS");
    }
}
//    private boolean validasiInput() {
//        if(txtTotalbayar.getText().trim().isEmpty()){
//            JOptionPane.showMessageDialog(this, "Total Bayar tidak boleh kosong");
//            txtTotalbayar.requestFocus();
//            return false;
//        }
//        if (spntanggal.getValue() == null) {
//            JOptionPane.showMessageDialog(this, "Tanggal harus dipilih");
//            return false;
//        }
//        if (cmbstatus.getSelectedIndex() == 0) {
//            JOptionPane.showMessageDialog(this,
//                "Status pembayaran harus dipilih");
//            cmbstatus.requestFocus();
//            return false;
//        }
//        return true;
//    }
    
//    private void loadComboJadwal() {
//        if (cmbpemeriksaan == null) {
//            System.out.println("cmbjadwal NULL - cek Design View");
//            return;
//        }
//
//        cmbpemeriksaan.removeAllItems();
//
//        Dao_Pemeriksaan dao = new Dao_Pemeriksaan();
//        List<Model_Pemeriksaan> list = dao.ambilPemeriksaan();
//
//        cmbpemeriksaan.removeAllItems();
//
//        for (Model_Pemeriksaan p : list) {
//            cmbpemeriksaan.addItem(p);
//        }
//    }
    
//    private void hitungTotalBayar() {
//        Model_Pemeriksaan p =
//            (Model_Pemeriksaan) cmbpemeriksaan.getSelectedItem();
//
//        if (p == null) return;
//
//        BigDecimal total =
//            servis.hitungTotalBayar(p.getId_pemeriksaan());
//
//        txtTotalbayar.setText(total.toString());
//    }

