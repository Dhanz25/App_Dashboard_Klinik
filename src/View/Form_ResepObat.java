
package View;

import Config.Koneksi;
import Config.UserSession;
import DAO.Dao_Dokter;
import DAO.Dao_Obat;
import DAO.Dao_Pemeriksaan;
import DAO.Dao_Pembayaran;
import DAO.Dao_Resepobat;
import Model.Model_Dokter;
import Model.Model_Jadwal;
import Model.Model_Obat;
import Model.Model_Pembayaran;
import Model.Model_Pemeriksaan;
import Model.Model_Resep;
import Service.Service_Dokter;
import Service.Service_Pemeriksaan;
import Service.Service_Resep;
import TableModel.Tablemod_Pemeriksaan;
import java.awt.CardLayout;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.RowFilter;
import javax.swing.SpinnerDateModel;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import TableModel.tablemod_resep;
import java.awt.event.ItemEvent;
import java.io.InputStream;
import java.sql.Connection;
import java.util.HashMap;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

public class Form_ResepObat extends javax.swing.JPanel {

    private Service_Pemeriksaan servisJadwal = new Dao_Pemeriksaan();
    private Service_Resep servis = new Dao_Resepobat();
    private tablemod_resep tblModel = new tablemod_resep();
    private TableRowSorter<TableModel> sorter;
    private final int COL_NAMA = 1;
    private int selectedIdPemeriksaan;
    private boolean isEditMode = false;
    
    public Form_ResepObat() {
        initComponents();
        txtKeluhan.setEditable(false);
        txtKeluhan.setLineWrap(true);
        txtKeluhan.setWrapStyleWord(true);
        loadComboJadwal();
        loadComboPasien();
        cekHakAkses();
        initListener();
        
        cmbpemeriksaan.addActionListener(e -> {
    Model_Pemeriksaan p =
        (Model_Pemeriksaan) cmbpemeriksaan.getSelectedItem();

    if (p != null) {
        txtKeluhan.setText(p.getKeluhan());
    }
});

        loadComboObat();

        tblResepobat.setModel(tblModel);
        sorter = new TableRowSorter<>(tblResepobat.getModel());
        tblResepobat.setRowSorter(sorter);
        loadData();
    }
    
    public void setDataResep(Model_Resep r) {

    txtIdResep.setText(String.valueOf(r.getId_resep()));

    loadComboJadwal();

    for (int i = 0; i < cmbpemeriksaan.getItemCount(); i++) {
        Model_Pemeriksaan p = cmbpemeriksaan.getItemAt(i);

        if (p.getId_pemeriksaan() ==
            r.getId_pemeriksaan().getId_pemeriksaan()) {

            cmbpemeriksaan.setSelectedIndex(i);

            txtKeluhan.setText(p.getKeluhan());
            break;
        }
    }

    txtJumlah.setText(String.valueOf(r.getJumlah()));
    txtAturanpakai.setText(r.getAturan_pakai());
}

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        mainPanel = new javax.swing.JPanel();
        dataResepobat = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblResepobat = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        btnTambah = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        txtCari = new javax.swing.JTextField();
        btnBatal = new javax.swing.JButton();
        btnPrint = new javax.swing.JButton();
        tambahResepobat = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        btnKembali = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtIdResep = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        cmbpemeriksaan = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        cmbobat = new javax.swing.JComboBox<>();
        txtJumlah = new javax.swing.JTextField();
        txtAturanpakai = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtKeluhan = new javax.swing.JTextArea();
        jLabel6 = new javax.swing.JLabel();
        btnSimpan = new javax.swing.JButton();

        setLayout(new java.awt.CardLayout());

        mainPanel.setLayout(new java.awt.CardLayout());

        tblResepobat.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID Resep", "ID Pemeriksaan", "Keluhan", "ID Obat", "Jumlah", "Aturan Pakai"
            }
        ));
        tblResepobat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblResepobatMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblResepobat);

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        jLabel1.setText("Data Resep Obat");

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

        javax.swing.GroupLayout dataResepobatLayout = new javax.swing.GroupLayout(dataResepobat);
        dataResepobat.setLayout(dataResepobatLayout);
        dataResepobatLayout.setHorizontalGroup(
            dataResepobatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dataResepobatLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(dataResepobatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 647, Short.MAX_VALUE)
                    .addGroup(dataResepobatLayout.createSequentialGroup()
                        .addComponent(btnTambah, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnPrint, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtCari, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(dataResepobatLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnBatal, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        dataResepobatLayout.setVerticalGroup(
            dataResepobatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dataResepobatLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(dataResepobatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnBatal)
                    .addComponent(jLabel1))
                .addGap(30, 30, 30)
                .addGroup(dataResepobatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(dataResepobatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btnEdit, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnHapus, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtCari, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnTambah, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnPrint, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 665, Short.MAX_VALUE)
                .addContainerGap())
        );

        mainPanel.add(dataResepobat, "card2");

        tambahResepobat.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        jLabel2.setText("Tambah Data Resep Obat");

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
        jLabel3.setText("ID Resep");

        txtIdResep.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        txtIdResep.setEnabled(false);
        txtIdResep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdResepActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel4.setText("Nama Pasien");

        jLabel5.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel5.setText("Nama Obat");

        jLabel7.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel7.setText("Jumlah");

        jLabel9.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel9.setText("Aturan Pakai");

        txtKeluhan.setColumns(20);
        txtKeluhan.setRows(5);
        jScrollPane2.setViewportView(txtKeluhan);

        jLabel6.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel6.setText("Keluhan :");

        btnSimpan.setBackground(javax.swing.UIManager.getDefaults().getColor("textHighlight"));
        btnSimpan.setText("Simpan");
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtJumlah, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtIdResep)
                    .addComponent(txtAturanpakai, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(cmbpemeriksaan, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 361, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel7)
                            .addComponent(jLabel9)
                            .addComponent(cmbobat, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4)
                            .addComponent(btnSimpan))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addGap(1, 1, 1)
                .addComponent(txtIdResep, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addGap(4, 4, 4)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cmbpemeriksaan, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                        .addComponent(jLabel6)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbobat, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addGap(4, 4, 4)
                .addComponent(txtJumlah, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtAturanpakai, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSimpan, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout tambahResepobatLayout = new javax.swing.GroupLayout(tambahResepobat);
        tambahResepobat.setLayout(tambahResepobatLayout);
        tambahResepobatLayout.setHorizontalGroup(
            tambahResepobatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tambahResepobatLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(tambahResepobatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tambahResepobatLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnKembali, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27))
                    .addGroup(tambahResepobatLayout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        tambahResepobatLayout.setVerticalGroup(
            tambahResepobatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tambahResepobatLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(tambahResepobatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(btnKembali, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        mainPanel.add(tambahResepobat, "card2");

        add(mainPanel, "card2");
    }// </editor-fold>//GEN-END:initComponents

    private void btnTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahActionPerformed
        mainPanel.removeAll();
        mainPanel.repaint();
        mainPanel.revalidate();
        
        mainPanel.add(tambahResepobat);
        mainPanel.repaint();
        mainPanel.revalidate();
    }//GEN-LAST:event_btnTambahActionPerformed

    private void btnKembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKembaliActionPerformed
        mainPanel.removeAll();
        mainPanel.add(dataResepobat);
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

    private void tblResepobatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblResepobatMouseClicked
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
    }//GEN-LAST:event_tblResepobatMouseClicked

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        int row = tblResepobat.getSelectedRow();
    
    if (row == -1) {
        JOptionPane.showMessageDialog(this, 
            "Pilih baris data dahulu!", 
            "Peringatan", 
            JOptionPane.WARNING_MESSAGE);
        return;
    }
    dataTabel();

    mainPanel.removeAll();
    mainPanel.add(tambahResepobat);
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

    if (keyword.matches(".*\\d.*")) { 
        JOptionPane.showMessageDialog(null,
            "Pencarian hanya boleh berdasarkan NAMA (huruf saja).",
            "Input Tidak Valid",
            JOptionPane.WARNING_MESSAGE);
        txtCari.setText(keyword.replaceAll("\\d", ""));
        return; 
    }
    if (keyword.trim().isEmpty()) {
        sorter.setRowFilter(null);
        return;
    }
    String escaped = java.util.regex.Pattern.quote(keyword);
    sorter.setRowFilter(RowFilter.regexFilter("(?i).*" + escaped + ".*", 1));
    }//GEN-LAST:event_txtCariKeyReleased

    private void txtIdResepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdResepActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdResepActionPerformed

    private void btnPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrintActionPerformed
        try {
            InputStream reportStream =
            getClass().getResourceAsStream("/Report/Report_Resep.jasper");

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
    private javax.swing.JComboBox<Model_Obat> cmbobat;
    private javax.swing.JComboBox<Model_Pemeriksaan> cmbpemeriksaan;
    private javax.swing.JPanel dataResepobat;
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
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JPanel tambahResepobat;
    private javax.swing.JTable tblResepobat;
    private javax.swing.JTextField txtAturanpakai;
    private javax.swing.JTextField txtCari;
    private javax.swing.JTextField txtIdResep;
    private javax.swing.JTextField txtJumlah;
    private javax.swing.JTextArea txtKeluhan;
    // End of variables declaration//GEN-END:variables

    private void dataTabel() {
    int row = tblResepobat.getSelectedRow();
    if (row == -1) {
        JOptionPane.showMessageDialog(this, "Tidak ada data yang dipilih!");
        return;
    }

    dataResepobat.setVisible(false);
    tambahResepobat.setVisible(true);
    jLabel2.setText("Perbarui Data Resep");

    txtIdResep.setEditable(false);

    int modelRow = tblResepobat.convertRowIndexToModel(row);
    Model_Resep r = tblModel.getData(modelRow);

    selectedIdPemeriksaan = r.getId_pemeriksaan().getId_pemeriksaan();
    isEditMode = true;

    txtIdResep.setText(String.valueOf(r.getId_resep()));

    cmbpemeriksaan.setEnabled(false);

    for (int i = 0; i < cmbpemeriksaan.getItemCount(); i++) {
        Model_Pemeriksaan p = cmbpemeriksaan.getItemAt(i);
        if (p.getId_pemeriksaan() == selectedIdPemeriksaan) {
            cmbpemeriksaan.setSelectedIndex(i);
            txtKeluhan.setText(p.getKeluhan());
            break;
        }
    }

    int idObat = r.getId_obat().getId_obat();
    for (int i = 0; i < cmbobat.getItemCount(); i++) {
        Model_Obat o = cmbobat.getItemAt(i);
        if (o.getId_obat() == idObat) {
            cmbobat.setSelectedIndex(i);
            break;
        }
    }

    txtJumlah.setText(String.valueOf(r.getJumlah()));
    txtAturanpakai.setText(r.getAturan_pakai());

    aktif();
    btnSimpan.setText("Perbarui");
    btnKembali.setVisible(true);
}

    private void aktif(){
        txtIdResep.setEnabled(false);

    if (!isEditMode) {
        cmbpemeriksaan.setEnabled(true);
    } else {
        cmbpemeriksaan.setEnabled(false);
    }

    cmbobat.setEnabled(true);
    txtJumlah.setEnabled(true);
    txtAturanpakai.setEnabled(true);
    }
    private void loadData() {
        btnHapus.setVisible(false);
        btnEdit.setVisible(false);
        btnBatal.setVisible(false);
        List<Model_Resep> list=servis.ambilResep();
        tblModel.setData(list);
    }
    private void hapusData(){
        int index = tblResepobat.getSelectedRow();
        if(index!=-1){
            Model_Resep rp = tblModel.getData(tblResepobat.convertRowIndexToModel(index));
            if(JOptionPane.showConfirmDialog(null, "Yakin Data Akan Dihapus", "Konfirmasi", 
                    JOptionPane.OK_CANCEL_OPTION)==JOptionPane.OK_OPTION){
                servis.hapusResep(rp);
                tblModel.hapusData(index);
                loadData();
                loadComboPasien();
                resetForm();
                tampilPanel();
            }
        }else{
            JOptionPane.showMessageDialog(null, "Pilih dahulu record yang akan dihapus");
        }
    }
    private void resetForm() {
        isEditMode = false;

    txtIdResep.setText("");
    txtKeluhan.setText("");
    txtJumlah.setText("");
    txtAturanpakai.setText("");

    cmbpemeriksaan.setSelectedIndex(-1);
    cmbpemeriksaan.setEnabled(true);

    cmbobat.setSelectedIndex(-1);

    btnSimpan.setText("Simpan");
    }
    private void tampilPanel(){
        mainPanel.removeAll();
        mainPanel.add(new Form_ResepObat());
        mainPanel.repaint();
        mainPanel.revalidate();
    }
    private void simpanData() {
        Model_Resep rsp = new Model_Resep();

        Model_Pemeriksaan periksa = (Model_Pemeriksaan) cmbpemeriksaan.getSelectedItem();
        Model_Obat obt = (Model_Obat) cmbobat.getSelectedItem();

        rsp.setId_pemeriksaan(periksa);
        rsp.setId_obat(obt);
        rsp.setJumlah(Integer.parseInt(txtJumlah.getText()));
        rsp.setAturan_pakai(txtAturanpakai.getText());

        servis.tambahResep(rsp);
        JOptionPane.showMessageDialog(null, "Data Berhasil ditambahkan");

        resetForm();
        loadData();
        loadComboPasien();
        tampilPanel();
    }
    private void perbaruiData() {
        int index = tblResepobat.getSelectedRow();
    if (index == -1) {
        JOptionPane.showMessageDialog(this, "Pilih data yang akan diperbarui!");
        return;
    }
    if (!validasiInput()) return;

    Model_Resep rsp = new Model_Resep();
    rsp.setId_resep(Integer.parseInt(txtIdResep.getText()));

    Model_Pemeriksaan p = new Model_Pemeriksaan();
    p.setId_pemeriksaan(selectedIdPemeriksaan);
    rsp.setId_pemeriksaan(p);

    rsp.setId_obat((Model_Obat) cmbobat.getSelectedItem());

    rsp.setJumlah(Integer.parseInt(txtJumlah.getText()));
    rsp.setAturan_pakai(txtAturanpakai.getText());

    servis.perbaruiResep(rsp);
    loadData();

    JOptionPane.showMessageDialog(this, "Data berhasil diperbarui");
    resetForm();
    tampilPanel();
    }
    private boolean validasiInput() {
        if(txtJumlah.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(this, "Jumlah tidak boleh kosong");
            txtJumlah.requestFocus();
            return false;
        }
        if(txtAturanpakai.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(this, "Aturan pakai tidak boleh kosong");
            txtAturanpakai.requestFocus();
            return false;
        }
        return true;
    }
    private void loadComboJadwal() {
        if (cmbpemeriksaan == null) {
            System.out.println("cmbjadwal NULL - cek Design View");
            return;
        }
        cmbpemeriksaan.removeAllItems();

        Dao_Pemeriksaan dao = new Dao_Pemeriksaan();
        List<Model_Pemeriksaan> list = dao.ambilPemeriksaan();
        cmbpemeriksaan.removeAllItems();

        for (Model_Pemeriksaan p : list) {
            cmbpemeriksaan.addItem(p);
        }
    }
    private void loadComboObat() {
        if (cmbobat == null) {
        System.out.println("cmbobat NULL - cek Design View");
        return;
    }
    cmbobat.removeAllItems();

    Dao_Obat obt = new Dao_Obat();
    List<Model_Obat> list = obt.getData();
    cmbobat.removeAllItems();

    for (Model_Obat o : list) {
        cmbobat.addItem(o);
    }
    }

    private void loadComboPasien() {
        cmbpemeriksaan.removeAllItems();

    Service_Pemeriksaan service = new Dao_Pemeriksaan();

    for (Model_Pemeriksaan p : service.ambilPemeriksaanTanpaResep()) {
        cmbpemeriksaan.addItem(p);
    }
    if (cmbpemeriksaan.getItemCount() > 0) {
    cmbpemeriksaan.setSelectedIndex(0);
}

    }

    private void initListener() {
        cmbpemeriksaan.addActionListener(e -> {
    Model_Pemeriksaan p =
        (Model_Pemeriksaan) cmbpemeriksaan.getSelectedItem();

    if (p != null) {
        txtKeluhan.setText(p.getKeluhan());
    }
});
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
