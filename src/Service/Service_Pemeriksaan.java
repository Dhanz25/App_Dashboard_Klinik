
package Service;

import Model.Model_Pemeriksaan;
import java.util.List;

public interface Service_Pemeriksaan {
    void tambahPemeriksaan(Model_Pemeriksaan mod_periksa);
    void perbaruiPemeriksaan(Model_Pemeriksaan mod_periksa);
    void hapusPemeriksaan(Model_Pemeriksaan mod_periksa);
    List<Model_Pemeriksaan> ambilPemeriksaan();
    List<Model_Pemeriksaan> ambilPemeriksaanTanpaResep();
}
