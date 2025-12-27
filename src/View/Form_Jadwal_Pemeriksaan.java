
package View;

import Config.Koneksi;
import Config.UserSession;
import DAO.Dao_Dokter;
import DAO.Dao_Jadwal;
import DAO.Dao_Pasien;
import Model.Model_Dokter;
import Model.Model_Jadwal;
import Model.Model_Pasien;
import Service.Service_Dokter;
import Service.Service_Jadwal;
import Service.Service_Pasien;
import TableModel.Tabelmod_Jadwal;
import java.awt.Color;
import java.io.InputStream;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.RowFilter;
import javax.swing.SpinnerDateModel;
import javax.swing.Timer;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

public class Form_Jadwal_Pemeriksaan extends javax.swing.JPanel {

    private Service_Jadwal servis = new Dao_Jadwal();
    private Tabelmod_Jadwal tblModel = new Tabelmod_Jadwal();
    private TableRowSorter<TableModel> sorter;
    private final int COL_NAMA = 1;
    private Service_Pasien servicePasien = new Dao_Pasien();
    private Service_Dokter serviceDokter = new Dao_Dokter();
    private Timer timer;

    private void loadDataJadwal() {
        Dao_Dokter dao = new Dao_Dokter();
        List<Model_Dokter> list = dao.getDokterPraktikHariIni();

        String hariIni = getHariIni();

        CmbIdDokter.removeAllItems();

        for (Model_Dokter d : list) {
            if (isDokterPraktikHariIni(d.getJadwal(), hariIni)) {
                CmbIdDokter.addItem(d);
            }
        }
    }
    private String getHariIni() {
        DayOfWeek hari = LocalDate.now().getDayOfWeek();
        switch (hari) {
            case MONDAY: return "Senin";
            case TUESDAY: return "Selasa";
            case WEDNESDAY: return "Rabu";
            case THURSDAY: return "Kamis";
            case FRIDAY: return "Jumat";
            case SATURDAY: return "Sabtu";
            case SUNDAY: return "Minggu";
            default: return "";
        }
    }
    private boolean isDokterPraktikHariIni(String jadwal, String hariIni) {
    
        if (jadwal.equalsIgnoreCase(hariIni)) return true;

        if (jadwal.contains("-")) {
            String[] split = jadwal.split("-");
            int hariAwal = hariKeAngka(split[0]);
            int hariAkhir = hariKeAngka(split[1]);
            int hariSekarang = hariKeAngka(hariIni);

            return hariSekarang >= hariAwal && hariSekarang <= hariAkhir;
        }

        return false;
    }
    private int hariKeAngka(String hari) {
        switch (hari.trim()) {
            case "Senin": return 1;
            case "Selasa": return 2;
            case "Rabu": return 3;
            case "Kamis": return 4;
            case "Jumat": return 5;
            case "Sabtu": return 6;
            case "Minggu": return 7;
            default: return 0;
        }
    }
    private enum ModeForm {
        TAMBAH, EDIT
    }
    private ModeForm modeForm = ModeForm.TAMBAH;
    private boolean isUpdatingForm = false;
    private int selectedIdJadwal = 0;

    public Form_Jadwal_Pemeriksaan() {
        
        initComponents();
        if (UserSession.level == 2) {
        btnTambah.setVisible(false);
        btnEdit.setVisible(false);
        btnHapus.setVisible(false);
    }

    servis = new Dao_Jadwal();

    tblModel = new Tabelmod_Jadwal();
    tblJadwalPemeriksaan.setModel(tblModel);

    sorter = new TableRowSorter<>(tblModel);
    tblJadwalPemeriksaan.setRowSorter(sorter);

    loadData();
    loadPasien();
    loadDokter();
    loadDataJadwal();

    int[] hiddenCols = {2, 5};
    for (int col : hiddenCols) {
        tblJadwalPemeriksaan.getColumnModel().getColumn(col).setMinWidth(0);
        tblJadwalPemeriksaan.getColumnModel().getColumn(col).setMaxWidth(0);
    }
    }
 private void loadPasien() {
    CmbIdpasien.removeAllItems();
    Service_Pasien servis = new Dao_Pasien();

    for (Model_Pasien p : servis.getData()) {
        CmbIdpasien.addItem(p);
    }
}

private void loadDokter() {
    CmbIdDokter.removeAllItems();
    Service_Dokter servis = new Dao_Dokter();

    for (Model_Dokter d : servis.getData()) {
        CmbIdDokter.addItem(d);
    }
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        DataJadwalPemeriksaan = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblJadwalPemeriksaan = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        btnTambah = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        txtCari = new javax.swing.JTextField();
        btnBatal = new javax.swing.JButton();
        btnPrint = new javax.swing.JButton();
        TambahJadwal = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        btnKembali = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtIdJadwal = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtNoUrut = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        CmbIdpasien = new javax.swing.JComboBox<>();
        CmbIdDokter = new javax.swing.JComboBox<>();
        JsTanggal = new javax.swing.JSpinner();
        btnSimpan = new javax.swing.JButton();

        setLayout(new java.awt.CardLayout());

        mainPanel.setLayout(new java.awt.CardLayout());

        tblJadwalPemeriksaan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Id jadwal", "No Urut", "Id Pasien", "Tanggal", "Id_Dokter"
            }
        ));
        tblJadwalPemeriksaan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblJadwalPemeriksaanMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblJadwalPemeriksaan);

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        jLabel1.setText("Data Jadwal Pemeriksaaan");

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

        javax.swing.GroupLayout DataJadwalPemeriksaanLayout = new javax.swing.GroupLayout(DataJadwalPemeriksaan);
        DataJadwalPemeriksaan.setLayout(DataJadwalPemeriksaanLayout);
        DataJadwalPemeriksaanLayout.setHorizontalGroup(
            DataJadwalPemeriksaanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DataJadwalPemeriksaanLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(DataJadwalPemeriksaanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 647, Short.MAX_VALUE)
                    .addGroup(DataJadwalPemeriksaanLayout.createSequentialGroup()
                        .addComponent(btnTambah, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnPrint, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtCari, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(DataJadwalPemeriksaanLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnBatal, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        DataJadwalPemeriksaanLayout.setVerticalGroup(
            DataJadwalPemeriksaanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DataJadwalPemeriksaanLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(DataJadwalPemeriksaanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnBatal)
                    .addComponent(jLabel1))
                .addGap(30, 30, 30)
                .addGroup(DataJadwalPemeriksaanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(DataJadwalPemeriksaanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btnEdit, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnHapus, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtCari, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnTambah, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnPrint, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 317, Short.MAX_VALUE)
                .addContainerGap())
        );

        mainPanel.add(DataJadwalPemeriksaan, "card2");

        TambahJadwal.setBackground(new java.awt.Color(255, 255, 255));
        TambahJadwal.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                TambahJadwalComponentShown(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        jLabel2.setText("Tambah Jadwal Pemeriksaan");

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
        jLabel3.setText("ID Jadwal");

        txtIdJadwal.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        txtIdJadwal.setEnabled(false);

        jLabel4.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel4.setText("No Urut");

        txtNoUrut.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));

        jLabel5.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel5.setText("Nama Pasien ");

        jLabel6.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel6.setText("Tanggal ");

        jLabel7.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel7.setText("Nama Dokter");

        CmbIdpasien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CmbIdpasienActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtIdJadwal)
                    .addComponent(txtNoUrut)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(CmbIdpasien, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CmbIdDokter, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JsTanggal, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addGap(1, 1, 1)
                .addComponent(txtIdJadwal, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNoUrut, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CmbIdpasien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addComponent(jLabel6)
                .addGap(13, 13, 13)
                .addComponent(JsTanggal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CmbIdDokter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
        );

        btnSimpan.setBackground(javax.swing.UIManager.getDefaults().getColor("textHighlight"));
        btnSimpan.setText("Simpan");
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout TambahJadwalLayout = new javax.swing.GroupLayout(TambahJadwal);
        TambahJadwal.setLayout(TambahJadwalLayout);
        TambahJadwalLayout.setHorizontalGroup(
            TambahJadwalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TambahJadwalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(TambahJadwalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(TambahJadwalLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 220, Short.MAX_VALUE)
                        .addComponent(btnKembali, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27))
                    .addGroup(TambahJadwalLayout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
            .addGroup(TambahJadwalLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(btnSimpan)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        TambahJadwalLayout.setVerticalGroup(
            TambahJadwalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TambahJadwalLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(TambahJadwalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(btnKembali, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSimpan, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        mainPanel.add(TambahJadwal, "card2");

        add(mainPanel, "card2");
    }// </editor-fold>//GEN-END:initComponents

    private void btnTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahActionPerformed
       mainPanel.removeAll();
       mainPanel.add(TambahJadwal);
       mainPanel.revalidate();
       mainPanel.repaint();
    }//GEN-LAST:event_btnTambahActionPerformed

    private void btnKembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKembaliActionPerformed
        resetForm();

    mainPanel.removeAll();
    mainPanel.add(DataJadwalPemeriksaan);
    mainPanel.revalidate();
    mainPanel.repaint();

    if (tblJadwalPemeriksaan.getSelectedRow() != -1) {
        btnEdit.setVisible(true);
        btnHapus.setVisible(true);
        btnBatal.setVisible(true);
    }
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

    private void tblJadwalPemeriksaanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblJadwalPemeriksaanMouseClicked
        
         int row = tblJadwalPemeriksaan.getSelectedRow();
    if (row == -1) return;

    row = tblJadwalPemeriksaan.convertRowIndexToModel(row);

    isUpdatingForm = true; 

    try {
        int idJadwal = Integer.parseInt(
            tblModel.getValueAt(row, 0).toString()
        );

        int idPasien = Integer.parseInt(
            tblModel.getValueAt(row, 2).toString()
        );

        int idDokter = Integer.parseInt(
            tblModel.getValueAt(row, 5).toString()
        );

        txtNoUrut.setText(
            tblModel.getValueAt(row, 1).toString()
        );

        if (!(JsTanggal.getModel() instanceof SpinnerDateModel)) {
            SpinnerDateModel dateModel =
                new SpinnerDateModel(new Date(), null, null, Calendar.MINUTE);
            JsTanggal.setModel(dateModel);

            JSpinner.DateEditor editor =
                new JSpinner.DateEditor(JsTanggal, "yyyy-MM-dd HH:mm");
            JsTanggal.setEditor(editor);
        }

        Object objTanggal = tblModel.getValueAt(row, 4);
        Date tanggal = null;

        if (objTanggal instanceof java.sql.Timestamp) {
            tanggal = new Date(((java.sql.Timestamp) objTanggal).getTime());
        } else if (objTanggal instanceof java.util.Date) {
            tanggal = (Date) objTanggal;
        } else if (objTanggal != null) {
            try {
                SimpleDateFormat sdf =
                    new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                tanggal = sdf.parse(objTanggal.toString());
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

        if (tanggal != null) {
            JsTanggal.setValue(tanggal); 
        }

        for (int i = 0; i < CmbIdpasien.getItemCount(); i++) {
            Model_Pasien p = (Model_Pasien) CmbIdpasien.getItemAt(i);
            if (p.getId_pasien() == idPasien) {
                CmbIdpasien.setSelectedIndex(i);
                break;
            }
        }

        for (int i = 0; i < CmbIdDokter.getItemCount(); i++) {
            Model_Dokter d = (Model_Dokter) CmbIdDokter.getItemAt(i);
            if (d.getId_dokter() == idDokter) {
                CmbIdDokter.setSelectedIndex(i);
                break;
            }
        }

        if (UserSession.level == 2) {
            btnEdit.setVisible(false);
            btnHapus.setVisible(false);
            btnBatal.setVisible(true);
            return;
        }
        
        btnHapus.setVisible(true);
        btnEdit.setVisible(true);
        btnBatal.setVisible(true);
        btnTambah.setEnabled(false);

    } finally {
        isUpdatingForm = false; 
    }
    }//GEN-LAST:event_tblJadwalPemeriksaanMouseClicked

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
    int rowView = tblJadwalPemeriksaan.getSelectedRow();
    if (rowView == -1) {
        JOptionPane.showMessageDialog(this, "Pilih data terlebih dahulu");
        return;
    }

    int row = tblJadwalPemeriksaan.convertRowIndexToModel(rowView);

    selectedIdJadwal = Integer.parseInt(
        tblModel.getValueAt(row, 0).toString()
    );

    modeForm = ModeForm.EDIT;
    isUpdatingForm = true;

    mainPanel.removeAll();
    mainPanel.add(TambahJadwal);
    mainPanel.revalidate();
    mainPanel.repaint();

    dataTabel(row);
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

    if (keyword.trim().isEmpty()) {
        sorter.setRowFilter(null);
        return;
    }

    String escaped = java.util.regex.Pattern.quote(keyword);
    sorter.setRowFilter(RowFilter.regexFilter("(?i).*" + escaped + ".*", 3));
    }//GEN-LAST:event_txtCariKeyReleased

    private void CmbIdpasienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CmbIdpasienActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CmbIdpasienActionPerformed

    private void TambahJadwalComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_TambahJadwalComponentShown
        if (JsTanggal == null || txtNoUrut == null) {
        System.out.println("Komponen TambahJadwal belum siap");
        return;
    }

    txtNoUrut.setEnabled(false);

    if (!(JsTanggal.getModel() instanceof SpinnerDateModel)) {
        SpinnerDateModel dateModel =
            new SpinnerDateModel(new Date(), null, null, Calendar.MINUTE);
        JsTanggal.setModel(dateModel);

        JSpinner.DateEditor editor =
            new JSpinner.DateEditor(JsTanggal, "yyyy-MM-dd HH:mm");
        JsTanggal.setEditor(editor);

        JFormattedTextField tf = editor.getTextField();
        tf.setEditable(false);
        tf.setBackground(Color.LIGHT_GRAY);
    }

    if (modeForm == ModeForm.TAMBAH) {

        JsTanggal.addChangeListener(e -> {
            if (modeForm == ModeForm.EDIT || isUpdatingForm) return;
            updateNoUrut();
        });

        if (timer == null) {
            timer = new Timer(1000, e -> {
                if (modeForm == ModeForm.EDIT || isUpdatingForm) return;
                JsTanggal.setValue(new Date());
                updateNoUrut();
            });
            timer.start();
        }

        updateNoUrut();
    }

    if (modeForm == ModeForm.EDIT) {
        if (timer != null) {
            timer.stop();
        }
    }
    }//GEN-LAST:event_TambahJadwalComponentShown

    private void btnPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrintActionPerformed
        try {
            InputStream reportStream =
            getClass().getResourceAsStream("/Report/Report_Jadwal.jasper");

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
    private javax.swing.JComboBox<Model_Dokter> CmbIdDokter;
    private javax.swing.JComboBox<Model_Pasien> CmbIdpasien;
    private javax.swing.JPanel DataJadwalPemeriksaan;
    private javax.swing.JSpinner JsTanggal;
    private javax.swing.JPanel TambahJadwal;
    private javax.swing.JButton btnBatal;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnKembali;
    private javax.swing.JButton btnPrint;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JButton btnTambah;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JTable tblJadwalPemeriksaan;
    private javax.swing.JTextField txtCari;
    private javax.swing.JTextField txtIdJadwal;
    private javax.swing.JTextField txtNoUrut;
    // End of variables declaration//GEN-END:variables

    private void dataTabel(int row) {

     Tabelmod_Jadwal model =
        (Tabelmod_Jadwal) tblJadwalPemeriksaan.getModel();

    Model_Jadwal m = model.getData().get(row);

    jLabel2.setText("Perbarui Data Jadwal");

    txtIdJadwal.setText(String.valueOf(m.getId_jadwal()));
    txtNoUrut.setText(String.valueOf(m.getNo_urut()));
    txtNoUrut.setEnabled(false);

    if (m.getTanggal() != null) {
        JsTanggal.setValue(new Date(m.getTanggal().getTime()));
    }

    for (int i = 0; i < CmbIdpasien.getItemCount(); i++) {
        Model_Pasien p = (Model_Pasien) CmbIdpasien.getItemAt(i);
        if (p.getId_pasien() == m.getId_p().getId_pasien()) {
            CmbIdpasien.setSelectedIndex(i);
            break;
        }
    }
    for (int i = 0; i < CmbIdDokter.getItemCount(); i++) {
        Model_Dokter d = (Model_Dokter) CmbIdDokter.getItemAt(i);
        if (d.getId_dokter() == m.getId_d().getId_dokter()) {
            CmbIdDokter.setSelectedIndex(i);
            break;
        }
    }

    aktif();

    btnTambah.setEnabled(false);
    btnEdit.setVisible(false);
    btnHapus.setVisible(true);
    btnBatal.setVisible(true);
    btnSimpan.setText("Perbarui");

    isUpdatingForm = false;
}
private void setComboPasien(int idPasien) {
    for (int i = 0; i < CmbIdpasien.getItemCount(); i++) {
    Model_Pasien p = (Model_Pasien) CmbIdpasien.getItemAt(i);
    if (p.getId_pasien() == idPasien) {
        CmbIdpasien.setSelectedIndex(i);
        break;
        }
    }
}
private void setComboDokter(int idDokter) {
    for (int i = 0; i < CmbIdDokter.getItemCount(); i++) {
    Model_Dokter d = (Model_Dokter) CmbIdDokter.getItemAt(i);
    if (d.getId_dokter() == idDokter) {
        CmbIdDokter.setSelectedIndex(i);
        break;
        }
    }
}
private void aktif(){
    txtNoUrut.setEnabled(true);
    JsTanggal.setEnabled(true);
    CmbIdpasien.setEnabled(true);
    CmbIdDokter.setEnabled(true);
}    
private void loadData() {
    btnHapus.setVisible(false);
    btnEdit.setVisible(false);
    btnBatal.setVisible(false);
    List<Model_Jadwal> data = servis.ambilDataTampil();
    tblModel.setData(data);
}
private void hapusData() {

    int row = tblJadwalPemeriksaan.getSelectedRow();

    if (row == -1) {
        JOptionPane.showMessageDialog(
            this,
            "Pilih dahulu record yang akan dihapus"
        );
        return;
    }
    int modelRow = tblJadwalPemeriksaan.convertRowIndexToModel(row);

    Model_Jadwal data = tblModel.getData().get(modelRow);

    int idJadwal = data.getId_jadwal();

    int konfirmasi = JOptionPane.showConfirmDialog(
        this,
        "Yakin Data Akan Dihapus?",
        "Konfirmasi",
        JOptionPane.OK_CANCEL_OPTION
    );

    if (konfirmasi == JOptionPane.OK_OPTION) {
        servis.hapusData(idJadwal);  
        loadData();
        resetForm();
    }
}
    private void resetForm() {
        modeForm = ModeForm.TAMBAH;
    selectedIdJadwal = 0;
    isUpdatingForm = false;

    txtNoUrut.setText("");
    JsTanggal.setValue(new java.util.Date());

    CmbIdpasien.setSelectedIndex(-1);
    if (UserSession.level != 2) {
        CmbIdDokter.setSelectedIndex(-1);
    }

    btnSimpan.setText("Simpan");
    btnTambah.setEnabled(true);

    btnHapus.setVisible(false);
    btnBatal.setVisible(false);
    }
    
    private void tampilPanel(){
        mainPanel.removeAll();
        mainPanel.add(new Form_Jadwal_Pemeriksaan());
        mainPanel.repaint();
        mainPanel.revalidate();
    }

    private void simpanData() {

    if (!validasiInput()) return;

    Model_Jadwal mod = new Model_Jadwal();
   
    Model_Pasien p = (Model_Pasien) CmbIdpasien.getSelectedItem();
    Model_Dokter d = (Model_Dokter) CmbIdDokter.getSelectedItem();

    mod.setId_p(p);  
    mod.setId_d(d);  
    Date tanggal = (Date) JsTanggal.getValue();
    mod.setTanggal(tanggal);

    servis.tambahData(mod);

    JOptionPane.showMessageDialog(
        this,
        "Data Jadwal berhasil ditambahkan"
    );

    resetForm();
    loadData();
    tampilPanel();
}
 private void perbaruiData() {

    int row = tblJadwalPemeriksaan.getSelectedRow();
    if (row == -1) {
        JOptionPane.showMessageDialog(this, "Pilih data yang akan diperbarui");
        return;
    }

    Model_Jadwal view = tblModel.getData(
            tblJadwalPemeriksaan.convertRowIndexToModel(row)
        );

    Model_Jadwal mod = new Model_Jadwal();

    mod.setId_jadwal(view.getId_jadwal());
    mod.setNo_urut(Integer.parseInt(txtNoUrut.getText()));

    Model_Pasien p = (Model_Pasien) CmbIdpasien.getSelectedItem();
    Model_Dokter d = (Model_Dokter) CmbIdDokter.getSelectedItem();

    mod.setId_p(p);   
    mod.setId_d(d);   
    Date tgl = (Date) JsTanggal.getValue();
    mod.setTanggal(tgl);

    servis.perbaruiData(mod);

    JOptionPane.showMessageDialog(this, "Data berhasil diperbarui");

    loadData();
    resetForm();
    tampilPanel();
}
   private boolean validasiInput() {

    if (txtNoUrut.getText().trim().isEmpty()) {
        JOptionPane.showMessageDialog(this, "No Urut tidak boleh kosong");
        txtNoUrut.requestFocus();
        return false;
    }

    if (CmbIdpasien.getSelectedIndex() == -1) {
        JOptionPane.showMessageDialog(this, "Id Pasien harus dipilih");
        CmbIdpasien.requestFocus();
        return false;
    }

    if (CmbIdDokter.getSelectedIndex() == -1) {
        JOptionPane.showMessageDialog(this, "Id Dokter harus dipilih");
        CmbIdDokter.requestFocus();
        return false;
    }

    if (JsTanggal.getValue() == null) {
        JOptionPane.showMessageDialog(this, "Tanggal harus diisi");
        JsTanggal.requestFocus();
        return false;
    }

    return true;
    }

    private void updateNoUrut() {
        if (JsTanggal == null || txtNoUrut == null) return;

    Date tgl = (Date) JsTanggal.getValue();
    int idDokter;

    if (UserSession.level == 2) {
        idDokter = UserSession.idDokter;
    } else {
        idDokter = CmbIdDokter.getSelectedItem() != null
            ? ((Model_Dokter) CmbIdDokter.getSelectedItem()).getId_dokter()
            : 0;
    }

    if (idDokter == 0) {
        txtNoUrut.setText("");
        return;
    }

    Dao_Jadwal dao = new Dao_Jadwal();
    txtNoUrut.setText(String.valueOf(
        dao.getNoUrutByTanggal(tgl, idDokter)
    ));
    }
}
