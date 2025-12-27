
package Model;

public class Model_Resep {
    
    private int id_resep;
    private Model_Pemeriksaan id_pemeriksaan;
    private String nama_pasien;
    private Model_Obat id_obat;
    private int jumlah;
    private String aturan_pakai;

    public String getNama_pasien() {
        return nama_pasien;
    }

    public void setNama_pasien(String nama_pasien) {
        this.nama_pasien = nama_pasien;
    }

    public int getId_resep() {
        return id_resep;
    }

    public void setId_resep(int id_resep) {
        this.id_resep = id_resep;
    }

    public Model_Pemeriksaan getId_pemeriksaan() {
        return id_pemeriksaan;
    }

    public void setId_pemeriksaan(Model_Pemeriksaan id_pemeriksaan) {
        this.id_pemeriksaan = id_pemeriksaan;
    }

    public Model_Obat getId_obat() {
        return id_obat;
    }

    public void setId_obat(Model_Obat id_obat) {
        this.id_obat = id_obat;
    }

    public int getJumlah() {
        return jumlah;
    }

    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }

    public String getAturan_pakai() {
        return aturan_pakai;
    }

    public void setAturan_pakai(String aturan_pakai) {
        this.aturan_pakai = aturan_pakai;
    }
}
