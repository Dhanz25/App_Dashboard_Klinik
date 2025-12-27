
package TableModel;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import Model.Model_Pasien;
import javax.swing.JOptionPane;

public class Tablemod_Pasien extends AbstractTableModel {
    
    private List<Model_Pasien> list = new ArrayList<>();
    
    public void tambahData(Model_Pasien mod_pas) {
        list.add(mod_pas);
        fireTableRowsInserted(list.size() - 1, list.size() -1);
        
    }
    
    public void perbaruiData(int row, Model_Pasien mod_pas) {
        list.add(row, mod_pas);
        fireTableDataChanged();
        
    }
    
    public void hapusData(int index) {
        list.remove(index);
        fireTableRowsDeleted(index, index);
        JOptionPane.showMessageDialog(null, "Data Berhasil dihapus");
    }
    
    public void clear() {
        list.clear();
        fireTableDataChanged();
    }
    
    public void setData(List<Model_Pasien> list){
        clear();
        this.list.addAll(list);
        fireTableDataChanged();
    }
    
    public void setData(int index,Model_Pasien mod_pas) {
        list.set(index, mod_pas);
        fireTableRowsUpdated(index, index);
    }
    
    public Model_Pasien getData(int index) {
        return list.get(index);
    }
    
    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
       return 6;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
             case 0: return list.get(rowIndex).getId_pasien();
             case 1: return list.get(rowIndex).getNama_pasien();
             case 2: return list.get(rowIndex).getJenis_kelamin();
             case 3: return list.get(rowIndex).getTanggal_lahir();
             case 4: return list.get(rowIndex).getAlamat();
             case 5: return list.get(rowIndex).getNo_telp();
             
             default: return null;
        }
    }
    
    public String getColumnName(int column) {
        switch (column) {
            case 0: return "Id Pasien";
            case 1: return "Nama Pasien";
            case 2: return "Jenis Kelamin";
            case 3: return "Tanggal lahir";
            case 4: return "Alamat";
            case 5: return "No Telp";
            
             
            default: return null;
        }
    }
}
