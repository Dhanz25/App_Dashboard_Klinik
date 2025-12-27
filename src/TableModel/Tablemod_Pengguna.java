
package TableModel;

import Model.Model_Pengguna;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

public class Tablemod_Pengguna extends AbstractTableModel {
    
    private List<Model_Pengguna> list = new ArrayList<>();
    
    public void tambahData(Model_Pengguna mod_peng) {
        list.add(mod_peng);
        fireTableRowsInserted(list.size() - 1, list.size() -1);
        JOptionPane.showMessageDialog(null, "Data Berhasil ditambahkan");
    }
    
    public void perbaruiData(int row, Model_Pengguna mod_peng) {
        list.add(row, mod_peng);
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
    
    public void setData(List<Model_Pengguna> list){
        clear();
        this.list.addAll(list);
        fireTableDataChanged();
    }
    
    public void setData(int index,Model_Pengguna mod_peng) {
        list.set(index, mod_peng);
        fireTableRowsUpdated(index, index);
    }
    
    public Model_Pengguna getData(int index) {
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
    
    private final String[] columnNames ={"Id", "Username", "Password", "Level", "Nama"};

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Model_Pengguna p = list.get(rowIndex);
        switch (columnIndex) {
             case 0: return list.get(rowIndex).getId_pengguna();
             case 1: return list.get(rowIndex).getUsername();
             case 2: return list.get(rowIndex).getPassword();
             case 3:
    if (p.getLevel() == 1) {
        return "Admin";
    } else if (p.getLevel() == 2) {
        return "Dokter";
    } else {
        return "-";
    }
             case 4:
    return list.get(rowIndex).getId_dokter() != null
           ? list.get(rowIndex).getId_dokter().getNama_dokter()
           : "";
             
             default: return null;
        }
    }
    
    public String getColumnName(int column) {
        if(column == 0){
            return "    "+columnNames[column];
        }else{
            return columnNames[column];
        }
    }
}
