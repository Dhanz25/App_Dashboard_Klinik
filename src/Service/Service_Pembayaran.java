
package Service;

import Model.Model_Pembayaran;
import java.math.BigDecimal;
import java.util.List;

public interface Service_Pembayaran {
    void tambahPembayaran(Model_Pembayaran mod_bayar);
    void perbaruiPembayaran(Model_Pembayaran mod_bayar);
    void updateStatusPembayaran(int idPembayaran, String status);
    void hapusPembayaran(Model_Pembayaran mod_bayar);  
    List<Model_Pembayaran> ambilPembayaran();
    BigDecimal hitungTotalBayar(int idPemeriksaan);
}
