
package Model;

import java.math.BigDecimal;
import java.util.Date;

public class Model_Pembayaran {
    
    private int id_pembayaran;
    private Model_Pemeriksaan id_pemeriksaan;
    private String nama_pasien;
    private String nama_obat;
    private int jumlah;
    private BigDecimal total_bayar;
    private BigDecimal biaya_dokter;
    private Date tgl_pembayaran;
    private String status;

    public BigDecimal getBiaya_dokter() {
        return biaya_dokter;
    }

    public void setBiaya_dokter(BigDecimal biaya_dokter) {
        this.biaya_dokter = biaya_dokter;
    }

    public String getNama_pasien() {
        return nama_pasien;
    }

    public void setNama_pasien(String nama_pasien) {
        this.nama_pasien = nama_pasien;
    }

    public String getNama_obat() {
        return nama_obat;
    }

    public void setNama_obat(String nama_obat) {
        this.nama_obat = nama_obat;
    }

    public int getJumlah() {
        return jumlah;
    }

    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }

    public int getId_pembayaran() {
        return id_pembayaran;
    }

    public void setId_pembayaran(int id_pembayaran) {
        this.id_pembayaran = id_pembayaran;
    }

    public Model_Pemeriksaan getId_pemeriksaan() {
        return id_pemeriksaan;
    }

    public void setId_pemeriksaan(Model_Pemeriksaan id_pemeriksaan) {
        this.id_pemeriksaan = id_pemeriksaan;
    }

    public BigDecimal getTotal_bayar() {
        return total_bayar;
    }

    public void setTotal_bayar(BigDecimal total_bayar) {
        this.total_bayar = total_bayar;
    }

    public Date getTgl_pembayaran() {
        return tgl_pembayaran;
    }

    public void setTgl_pembayaran(Date tgl_pembayaran) {
        this.tgl_pembayaran = tgl_pembayaran;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
