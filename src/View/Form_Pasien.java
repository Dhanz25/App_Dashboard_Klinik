
package View;

import Config.Koneksi;
import DAO.Dao_Pasien;
import Model.Model_Pasien;
import Service.Service_Pasien;
import TableModel.Tablemod_Pasien;
import java.io.InputStream;
import java.sql.Connection;
import java.text.SimpleDateFormat;
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

public class Form_Pasien extends javax.swing.JPanel {

    private Service_Pasien servis = new Dao_Pasien();
    private Tablemod_Pasien tblModel = new Tablemod_Pasien();
    private TableRowSorter<TableModel> sorter;
    private final int COL_NAMA = 1;
    
    public Form_Pasien() {
        initComponents();
        SpinnerDateModel dateModel =
        new SpinnerDateModel(new java.util.Date(), null, null, java.util.Calendar.DAY_OF_MONTH);
    spntanggal.setModel(dateModel);

    JSpinner.DateEditor dateEditor =
        new JSpinner.DateEditor(spntanggal, "yyyy-MM-dd");
    spntanggal.setEditor(dateEditor);

    tblPasien.setModel(tblModel);
    sorter = new TableRowSorter<>(tblPasien.getModel());
    tblPasien.setRowSorter(sorter);

    loadData();
        
        tblPasien.setModel(tblModel);
        sorter = new TableRowSorter<>(tblPasien.getModel());
        tblPasien.setRowSorter(sorter);
        
        loadData();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        mainPanel = new javax.swing.JPanel();
        dataPasien = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPasien = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        btnTambah = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        txtCari = new javax.swing.JTextField();
        btnBatal = new javax.swing.JButton();
        btnPrint = new javax.swing.JButton();
        tambahPasien = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        btnKembali = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtIdPasien = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtNamaPasien = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtAlamat = new javax.swing.JTextField();
        txtNoTelp = new javax.swing.JTextField();
        rblakilaki = new javax.swing.JRadioButton();
        rbperempuan = new javax.swing.JRadioButton();
        spntanggal = new javax.swing.JSpinner();
        btnSimpan = new javax.swing.JButton();

        setLayout(new java.awt.CardLayout());

        mainPanel.setLayout(new java.awt.CardLayout());

        tblPasien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Nama", "Jenis Kelamin", "Tanggal Lahir", "Alamat", "No Telp"
            }
        ));
        tblPasien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPasienMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblPasien);

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        jLabel1.setText("Data Pasien");

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

        javax.swing.GroupLayout dataPasienLayout = new javax.swing.GroupLayout(dataPasien);
        dataPasien.setLayout(dataPasienLayout);
        dataPasienLayout.setHorizontalGroup(
            dataPasienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dataPasienLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(dataPasienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 647, Short.MAX_VALUE)
                    .addGroup(dataPasienLayout.createSequentialGroup()
                        .addComponent(btnTambah, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnPrint, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtCari, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(dataPasienLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnBatal, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        dataPasienLayout.setVerticalGroup(
            dataPasienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dataPasienLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(dataPasienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnBatal)
                    .addComponent(jLabel1))
                .addGap(30, 30, 30)
                .addGroup(dataPasienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnEdit, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnHapus, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dataPasienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btnPrint, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtCari, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnTambah, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 469, Short.MAX_VALUE)
                .addContainerGap())
        );

        mainPanel.add(dataPasien, "card2");

        tambahPasien.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        jLabel2.setText("Tambah Data Pasien");

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
        jLabel3.setText("ID");

        txtIdPasien.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        txtIdPasien.setEnabled(false);
        txtIdPasien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdPasienActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel4.setText("Nama");

        txtNamaPasien.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));

        jLabel5.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel5.setText("Jenis Kelamin");

        jLabel6.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel6.setText("Tanggal Lahir");

        jLabel7.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel7.setText("Alamat");

        jLabel8.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel8.setText("No Telp.");

        txtAlamat.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));

        txtNoTelp.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));

        buttonGroup1.add(rblakilaki);
        rblakilaki.setText("Laki-Laki");
        rblakilaki.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rblakilakiActionPerformed(evt);
            }
        });

        buttonGroup1.add(rbperempuan);
        rbperempuan.setText("Perempuan");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtNoTelp)
                    .addComponent(txtIdPasien, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNamaPasien, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtAlamat, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(spntanggal, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(rblakilaki)
                                .addGap(18, 18, 18)
                                .addComponent(rbperempuan)))
                        .addGap(0, 435, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addGap(1, 1, 1)
                .addComponent(txtIdPasien, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNamaPasien, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addGap(1, 1, 1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rblakilaki)
                    .addComponent(rbperempuan))
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addGap(15, 15, 15)
                .addComponent(spntanggal, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtAlamat, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNoTelp, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnSimpan.setBackground(javax.swing.UIManager.getDefaults().getColor("textHighlight"));
        btnSimpan.setText("Simpan");
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout tambahPasienLayout = new javax.swing.GroupLayout(tambahPasien);
        tambahPasien.setLayout(tambahPasienLayout);
        tambahPasienLayout.setHorizontalGroup(
            tambahPasienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tambahPasienLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(tambahPasienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tambahPasienLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 318, Short.MAX_VALUE)
                        .addComponent(btnKembali, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27))
                    .addGroup(tambahPasienLayout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(tambahPasienLayout.createSequentialGroup()
                        .addComponent(btnSimpan)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        tambahPasienLayout.setVerticalGroup(
            tambahPasienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tambahPasienLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(tambahPasienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(btnKembali, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(btnSimpan, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
        );

        mainPanel.add(tambahPasien, "card2");

        add(mainPanel, "card2");
    }// </editor-fold>//GEN-END:initComponents

    private void btnTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahActionPerformed
        mainPanel.removeAll();
        mainPanel.repaint();
        mainPanel.revalidate();
        
        mainPanel.add(tambahPasien);
        mainPanel.repaint();
        mainPanel.revalidate();
    }//GEN-LAST:event_btnTambahActionPerformed

    private void btnKembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKembaliActionPerformed
        mainPanel.removeAll();
        mainPanel.add(dataPasien);
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

    private void tblPasienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPasienMouseClicked
        btnHapus.setVisible(true);
        btnEdit.setVisible(true);
        btnBatal.setVisible(true);
        btnTambah.setEnabled(false);
    }//GEN-LAST:event_tblPasienMouseClicked

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        int row = tblPasien.getSelectedRow();
    
    if (row == -1) {
        JOptionPane.showMessageDialog(this, 
            "Pilih baris data dahulu!", 
            "Peringatan", 
            JOptionPane.WARNING_MESSAGE);
        return;
    }
    dataTabel();

    mainPanel.removeAll();
    mainPanel.add(tambahPasien);
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
    if (keyword.matches(".*\\d.*")) { // mengecek apakah ada angka
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

    private void txtIdPasienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdPasienActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdPasienActionPerformed

    private void rblakilakiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rblakilakiActionPerformed
        
    }//GEN-LAST:event_rblakilakiActionPerformed

    private void btnPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrintActionPerformed
        try {
        InputStream reportStream =
                getClass().getResourceAsStream("/Report/Report_Pasien.jasper");

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
    private javax.swing.JPanel dataPasien;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JRadioButton rblakilaki;
    private javax.swing.JRadioButton rbperempuan;
    private javax.swing.JSpinner spntanggal;
    private javax.swing.JPanel tambahPasien;
    private javax.swing.JTable tblPasien;
    private javax.swing.JTextField txtAlamat;
    private javax.swing.JTextField txtCari;
    private javax.swing.JTextField txtIdPasien;
    private javax.swing.JTextField txtNamaPasien;
    private javax.swing.JTextField txtNoTelp;
    // End of variables declaration//GEN-END:variables

    private void dataTabel(){
         int row = tblPasien.getSelectedRow();
    
    if (row == -1) {
        JOptionPane.showMessageDialog(this, "Tidak ada data yang dipilih!");
        return;
    }

    dataPasien.setVisible(false);
    tambahPasien.setVisible(true);

    jLabel2.setText("Perbarui Data Pasien");

    txtIdPasien.setEnabled(false);

    txtIdPasien.setText(tblPasien.getValueAt(row, 0).toString());
    txtNamaPasien.setText(tblPasien.getValueAt(row, 1).toString());
    txtAlamat.setText(tblPasien.getValueAt(row, 4).toString());
    txtNoTelp.setText(tblPasien.getValueAt(row, 5).toString());
    
    String jk = tblPasien.getValueAt(row, 2).toString();

    if (jk.equalsIgnoreCase("L")) {
        rblakilaki.setSelected(true);
    } else if (jk.equalsIgnoreCase("P")) {
        rbperempuan.setSelected(true);
    }

    try {
        String tgl = tblPasien.getValueAt(row, 3).toString();
        Date date = new SimpleDateFormat("yyyy-MM-dd").parse(tgl);
        spntanggal.setValue(date);
    } catch (Exception e) {
        e.printStackTrace();
    }
        aktif();
        btnSimpan.setText("Perbarui");
        btnKembali.setVisible(true);
    }
    
    private void aktif(){
        txtNamaPasien.setEnabled(true);
        rblakilaki.setEnabled(true);
        rbperempuan.setEnabled(true);
        txtNoTelp.setEnabled(true);
    }
    
    private void loadData() {
        btnHapus.setVisible(false);
        btnEdit.setVisible(false);
        btnBatal.setVisible(false);
        List<Model_Pasien> list=servis.getData();
        tblModel.setData(list);
    }
    private void hapusData(){
        int index = tblPasien.getSelectedRow();
        if(index!=-1){
            Model_Pasien ps = tblModel.getData(tblPasien.convertRowIndexToModel(index));
            if(JOptionPane.showConfirmDialog(null, "Yakin Data Akan Dihapus", "Konfirmasi", 
                    JOptionPane.OK_CANCEL_OPTION)==JOptionPane.OK_OPTION){
                servis.hapusData(ps);
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
        txtIdPasien.setText("");
        txtNamaPasien.setText("");
        txtAlamat.setText("");
        txtNoTelp.setText("");
        buttonGroup1.clearSelection();
        spntanggal.setValue(new java.util.Date());
        btnTambah.requestFocus();
    }
    private void tampilPanel(){
        mainPanel.removeAll();
        mainPanel.add(new Form_Pasien());
        mainPanel.repaint();
        mainPanel.revalidate();
    }
    private void simpanData() {
    if (validasiInput()) {

        String jenisKelamin;
        if (rblakilaki.isSelected()) {
            jenisKelamin = "L";
        } else if (rbperempuan.isSelected()) {
            jenisKelamin = "P";
        } else {
            JOptionPane.showMessageDialog(this,
                    "Pilih jenis kelamin terlebih dahulu!");
            return;
        }

        Model_Pasien pas = new Model_Pasien();
        pas.setNama_pasien(txtNamaPasien.getText());
        pas.setJenis_kelamin(jenisKelamin);
        pas.setAlamat(txtAlamat.getText());
        pas.setNo_telp(txtNoTelp.getText());
        
        Date tanggal = (Date) spntanggal.getValue();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String tanggalLahir = sdf.format(tanggal);

        pas.setTanggal_lahir(tanggalLahir);


        servis.tambahData(pas);
        tblModel.tambahData(pas);

        JOptionPane.showMessageDialog(null, "Data Berhasil ditambahkan");

        resetForm();
        loadData();
        tampilPanel();
    }
    }
    private void perbaruiData() {
    int index = tblPasien.getSelectedRow();
    if (index != -1) {

        if (validasiInput()) {

            int id_pasien = Integer.parseInt(txtIdPasien.getText());
            String nama_Pasien = txtNamaPasien.getText();
            String alamat = txtAlamat.getText();
            String no_telp = txtNoTelp.getText();

            String jenis_kelamin;
            if (rblakilaki.isSelected()) {
                jenis_kelamin = "L";
            } else if (rbperempuan.isSelected()) {
                jenis_kelamin = "P";
            } else {
                JOptionPane.showMessageDialog(this,
                        "Pilih jenis kelamin terlebih dahulu!");
                return;
            }

            Model_Pasien ps = new Model_Pasien();
            ps.setId_pasien(id_pasien);
            ps.setNama_pasien(nama_Pasien);
            ps.setJenis_kelamin(jenis_kelamin);
            ps.setAlamat(alamat);
            ps.setNo_telp(no_telp);
            
            Date tanggal = (Date) spntanggal.getValue();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String tanggalLahir = sdf.format(tanggal);

            ps.setTanggal_lahir(tanggalLahir);

            
            servis.editData(ps);
            tblModel.perbaruiData(index, ps);

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
        if(txtNamaPasien.getText().trim().isEmpty()){
        JOptionPane.showMessageDialog(this, "Nama Pasien tidak boleh kosong");
        txtNamaPasien.requestFocus();
        return false;
    }
        if(txtAlamat.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(this, "Alamat tidak boleh kosong");
            txtAlamat.requestFocus();
            return false;
        }
        if(txtNoTelp.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(this, "Jadwal Praktik tidak boleh kosong");
            txtNoTelp.requestFocus();
            return false;
        }
        if (!rblakilaki.isSelected() && !rbperempuan.isSelected()) {
        JOptionPane.showMessageDialog(this,
            "Jenis kelamin harus dipilih");
        return false;
        }
        if (!rblakilaki.isSelected() && !rbperempuan.isSelected()) {
        JOptionPane.showMessageDialog(this,
            "Jenis kelamin harus dipilih");
        return false;
        }
        if (spntanggal.getValue() == null) {
        JOptionPane.showMessageDialog(this,
            "Tanggal lahir harus dipilih");
        return false;
        }
    return true;
    }
}