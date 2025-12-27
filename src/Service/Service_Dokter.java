
package Service;

import Model.Model_Dokter;
import java.util.List;

public interface Service_Dokter {
    void tambahData(Model_Dokter mod_dok);
    void editData(Model_Dokter mod_dok);
    void hapusData(Model_Dokter mod_dok);
    
    List<Model_Dokter> getData();
    List<Model_Dokter> getDokterPraktikHariIni();
    
}
