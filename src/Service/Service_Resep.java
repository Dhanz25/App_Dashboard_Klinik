
package Service;

import Model.Model_Resep;
import java.util.List;

public interface Service_Resep {
    void tambahResep(Model_Resep mod_resep);
    void perbaruiResep(Model_Resep mod_resep);
    void hapusResep(Model_Resep mod_resep);
    List<Model_Resep> ambilResep();
}
