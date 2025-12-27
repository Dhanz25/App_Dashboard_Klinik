
package Service;

import Model.Model_Pengguna;
import java.util.List;

public interface Service_Pengguna {
    void tambahData(Model_Pengguna mod_dok);
    void editData(Model_Pengguna mod_dok);
    void hapusData(Model_Pengguna mod_dok);
    List<Model_Pengguna> getData();
}
