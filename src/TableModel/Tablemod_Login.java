
package TableModel;

import Model.Model_Login;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

public class Tablemod_Login extends AbstractTableModel {
    
    private List<Model_Login> list = new ArrayList<>();
    
    public void tambahData(Model_Login mod_log) {
        list.add(mod_log);
        fireTableRowsInserted(list.size() - 1, list.size() -1);
        JOptionPane.showMessageDialog(null, "Data Berhasil ditambahkan");
    }
    
    public void perbaruiData(int row, Model_Login mod_log) {
        list.add(row, mod_log);
        fireTableDataChanged();
        JOptionPane.showMessageDialog(null, "Data Berhasil diperbarui");
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
    
    public void setData(List<Model_Login> list){
        clear();
        this.list.addAll(list);
        fireTableDataChanged();
    }
    
    public void setData(int index,Model_Login mod_log) {
        list.set(index, mod_log);
        fireTableRowsUpdated(index, index);
    }
    
    public Model_Login getData(int index) {
        return list.get(index);
    }
    
    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
       return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
             case 0: return list.get(rowIndex).getId_pengguna();
             case 1: return list.get(rowIndex).getUsername();
             case 2: return list.get(rowIndex).getPassword();
             
             default: return null;
        }
       
    }
    
    public String getColumnName(int column) {
        switch (column) {
            case 0: return "Id Pengguna";
            case 1: return "Username";
            case 2: return "Password";
             
            default: return null;
        }
    }
}
