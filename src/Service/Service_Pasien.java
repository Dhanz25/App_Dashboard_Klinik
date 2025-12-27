
package Service;

import Model.Model_Pasien;
import java.util.List;

public interface Service_Pasien {
    void tambahData(Model_Pasien mod_pas);
    void editData(Model_Pasien mod_pas);
    void hapusData(Model_Pasien mod_pas);
    List<Model_Pasien> getData();
}
