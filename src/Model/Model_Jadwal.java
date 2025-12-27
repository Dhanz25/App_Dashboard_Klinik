
package Model;
import java.util.Date;

public class Model_Jadwal {
   private int id_jadwal;
    private int no_urut;
    private Date tanggal;
    private Model_Pasien id_p;  
    private Model_Dokter id_d;

    public int getId_jadwal() { 
        return id_jadwal; }
    public void setId_jadwal(int id_jadwal) { 
        this.id_jadwal = id_jadwal; }

    public int getNo_urut() { 
        return no_urut; }
    public void setNo_urut(int no_urut) { 
        this.no_urut = no_urut; }

    public Date getTanggal() { 
        return tanggal; }
    public void setTanggal(Date tanggal) {
        this.tanggal = tanggal; }

    public Model_Pasien getId_p() {
        return id_p;
    }

    public void setId_p(Model_Pasien id_p) {
        this.id_p = id_p;
    }

    public Model_Dokter getId_d() {
        return id_d;
    }

    public void setId_d(Model_Dokter id_d) {
        this.id_d = id_d;
    }
   @Override
    public String toString() {
        return "[" + no_urut + "] " + id_p.getNama_pasien();
    }
}
    





