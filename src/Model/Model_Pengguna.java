
package Model;

public class Model_Pengguna {
    
    private int id_pengguna;
    private String username;
    private String password;
    private int level;
    private Model_Dokter id_dokter;

    public int getId_pengguna() {
        return id_pengguna;
    }

    public void setId_pengguna(int id_pengguna) {
        this.id_pengguna = id_pengguna;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public Model_Dokter getId_dokter() {
        return id_dokter;
    }

    public void setId_dokter(Model_Dokter id_dokter) {
        this.id_dokter = id_dokter;
    }
}
