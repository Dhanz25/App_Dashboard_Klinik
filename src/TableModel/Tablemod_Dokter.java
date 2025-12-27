
package TableModel;

import Model.Model_Dokter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

public class Tablemod_Dokter extends AbstractTableModel {
    private List<Model_Dokter> list = new ArrayList<>();
    
    public void tambahData(Model_Dokter mod_dok) {
        list.add(mod_dok);
        fireTableRowsInserted(list.size() - 1, list.size() -1);
    }
    
    public void perbaruiData(int row, Model_Dokter mod_dok) {
        list.add(row, mod_dok);
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
    
    public void setData(List<Model_Dokter> list){
        clear();
        this.list.addAll(list);
        fireTableDataChanged();
    }
    
    public void setData(int index,Model_Dokter mod_dok) {
        list.set(index, mod_dok);
        fireTableRowsUpdated(index, index);
    }
    
    public Model_Dokter getData(int index) {
        return list.get(index);
    }
    
    @Override
    public int getRowCount() {
        return list.size();
    }

    private final String[] columnNames ={"Id", "Nama", "Spesialis", "No Telphone", "Jadwal"};
    @Override
    public int getColumnCount() {
       return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0: return list.get(rowIndex).getId_dokter();
            case 1: return list.get(rowIndex).getNama_dokter();
            case 2: return list.get(rowIndex).getSpesialis();
            case 3: return list.get(rowIndex).getNo_telp();
            case 4: return list.get(rowIndex).getJadwal();
            default: return null;
        }
    }
    @Override
    public String getColumnName(int column) {
        if(column == 0){
            return "    "+columnNames[column];
        }else{
            return columnNames[column];
        }
    }
}
