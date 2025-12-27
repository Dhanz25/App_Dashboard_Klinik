
package TableModel;

import Model.Model_Obat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

public class Tablemod_Obat extends AbstractTableModel {
    
    private List<Model_Obat> list = new ArrayList<>();
    
    public void tambahData(Model_Obat mod_obt) {
        list.add(mod_obt);
        fireTableRowsInserted(list.size() - 1, list.size() -1);
    }
    
    public void perbaruiData(int row, Model_Obat mod_obt) {
        list.add(row, mod_obt);
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
    
    public void setData(List<Model_Obat> list){
        clear();
        this.list.addAll(list);
        fireTableDataChanged();
    }
    
    public void setData(int index,Model_Obat mod_obt) {
        list.set(index, mod_obt);
        fireTableRowsUpdated(index, index);
    }
    
    public Model_Obat getData(int index) {
        return list.get(index);
    }
    
    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
       return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
             case 0: return list.get(rowIndex).getId_obat();
             case 1: return list.get(rowIndex).getNama_obat();
             case 2: return list.get(rowIndex).getSatuan();
             case 3: return list.get(rowIndex).getHarga();
             case 4: return list.get(rowIndex).getStok();
             
             default: return null;
        }
       
    }
    
    public String getColumnName(int column) {
        switch (column) {
            case 0: return "Id Obat";
            case 1: return "Nama Obat";
            case 2: return "Satuan";
            case 3: return "Harga";
            case 4: return "Stok";
            
            default: return null;
        }
    }   
}
