package TableModel;

import Model.Model_Jadwal;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

public class Tabelmod_Jadwal extends AbstractTableModel {

    private List<Model_Jadwal> data = new ArrayList<>();

    private final String[] columnNames = {
        "ID Jadwal",  
        "No Urut",    
        "Id Pasien",
        "Nama Pasien",
        "Tanggal",    
        "Id Dokter",
        "Nama Dokter" 
    };
    public void setData(List<Model_Jadwal> data) {
        this.data = data;
        fireTableDataChanged();
    }

    public List<Model_Jadwal> getData() {
        return data;
    }
    
    public Model_Jadwal getData(int row) {
    return data.get(row);
}

    @Override
    public int getRowCount() {
        return data == null ? 0 : data.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {

        Model_Jadwal j = data.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return j.getId_jadwal();
            case 1:
                return j.getNo_urut();
            case 2:
                return j.getId_p().getId_pasien();  
            case 3:
                return j.getId_p().getNama_pasien();
            case 4:
                return j.getTanggal();
            case 5:
                return j.getId_d().getId_dokter();  
            case 6:
                return j.getId_d().getNama_dokter();
            default:
                return null;
        }
    }
}



