
package TableModel;

import Model.Model_Pembayaran;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

public class tablemod_pembayaran extends AbstractTableModel {
    
    private List<Model_Pembayaran> list = new ArrayList<>();
    
    public void tambahData(Model_Pembayaran mod_byr) {
        list.add(mod_byr);
        fireTableRowsInserted(list.size() - 1, list.size() -1);
        JOptionPane.showMessageDialog(null, "Data Berhasil ditambahkan");
    }
    
    public void perbaruiData(int row, Model_Pembayaran mod_byr) {
        list.add(row, mod_byr);
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
    
    public void setData(List<Model_Pembayaran> list){
        clear();
        this.list.addAll(list);
        fireTableDataChanged();
    }
    
    public void setData(int index,Model_Pembayaran mod_byr) {
        list.set(index, mod_byr);
        fireTableRowsUpdated(index, index);
    }
    
    public Model_Pembayaran getData(int index) {
        return list.get(index);
    }
    @Override
    public int getRowCount() {
        return list.size();
    }
    @Override
    public int getColumnCount() {
       return 7;
    }
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Model_Pembayaran m = list.get(rowIndex);
        switch (columnIndex) {
            case 0: return m.getId_pembayaran();
            case 1: return m.getNama_pasien();
            case 2: return m.getNama_obat();
            case 3: return m.getJumlah();
            case 4: return m.getTotal_bayar();
            case 5: return m.getTgl_pembayaran();
            case 6: return m.getStatus();
            
            default: return null;
        }
    }
    public String getColumnName(int column) {
        switch (column) {
            case 0: return "Id Pembayaran";
            case 1: return "Nama Pasien";
            case 2: return "Nama Obat";
            case 3: return "Jumlah";
            case 4: return "Total Bayar";
            case 5: return "Tanggal Pembayaran";
            case 6: return "Status";
             
            default: return null;
        }
    }
}