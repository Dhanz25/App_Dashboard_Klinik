
package Model;

import java.util.Date;

public class Model_Pemeriksaan {
    
    private int id_pemeriksaan;
    private int no_urut;
    private String nama_pasien;
    private Model_Jadwal id_jadwal;
    private String keluhan;
    private String diagnosa;
    private String tindakan;
    private Date tanggal;

    public String getNama_pasien() {
        return nama_pasien;
    }

    public void setNama_pasien(String nama_pasien) {
        this.nama_pasien = nama_pasien;
    }

    public int getId_pemeriksaan() {
        return id_pemeriksaan;
    }

    public void setId_pemeriksaan(int id_pemeriksaan) {
        this.id_pemeriksaan = id_pemeriksaan;
    }
    
    public int getNo_urut() {
        return no_urut;
    }

    public void setNo_urut(int no_urut) {
        this.no_urut = no_urut;
    }

    public Model_Jadwal getId_jadwal() {
        return id_jadwal;
    }

    public void setId_jadwal(Model_Jadwal id_jadwal) {
        this.id_jadwal = id_jadwal;
    }

    public String getKeluhan() {
        return keluhan;
    }

    public void setKeluhan(String keluhan) {
        this.keluhan = keluhan;
    }

    public String getDiagnosa() {
        return diagnosa;
    }

    public void setDiagnosa(String diagnosa) {
        this.diagnosa = diagnosa;
    }

    public String getTindakan() {
        return tindakan;
    }

    public void setTindakan(String tindakan) {
        this.tindakan = tindakan;
    }

    public Date getTanggal() {
        return tanggal;
    }

    public void setTanggal(Date tanggal) {
        this.tanggal = tanggal;
    }
    @Override
    public String toString() {
        return "[" + no_urut + "] " + nama_pasien;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Model_Pemeriksaan)) return false;
        Model_Pemeriksaan other = (Model_Pemeriksaan) o;
        return this.id_pemeriksaan == other.id_pemeriksaan;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(id_pemeriksaan);
    }
}
