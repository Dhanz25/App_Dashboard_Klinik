
package Service;

import Model.Model_Jadwal;
import java.util.List;

public interface Service_Jadwal {
    void tambahData (Model_Jadwal mod_jadwal);
    void perbaruiData (Model_Jadwal mod_jadwal);
    void hapusData(int idJadwal);
    List<Model_Jadwal> getData();
    List<Model_Jadwal> ambilDataTampil();
    List<Model_Jadwal> ambilJadwalBelumPeriksa();
}
