
package Service;

import Model.Model_Obat;
import java.util.List;

public interface Service_Obat {
    void TambahObat (Model_Obat mobat);
    void PerbaruiObat (Model_Obat mobat);
    void HapusObat (Model_Obat mobat);
    List<Model_Obat> getData();
}
