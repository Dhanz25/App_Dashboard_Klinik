
package TableModel;

import Model.Model_Resep;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

public class tablemod_resep extends AbstractTableModel {
    
    private List<Model_Resep> list = new ArrayList<>();
    
    public void tambahData(Model_Resep mod_rsp) {
        list.add(mod_rsp);
        fireTableRowsInserted(list.size() - 1, list.size() -1);
    }
    
    public void perbaruiData(int row, Model_Resep mod_rsp) {
        list.add(row, mod_rsp);
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
    
    public void setData(List<Model_Resep> list){
        clear();
        this.list.addAll(list);
        fireTableDataChanged();
    }
    
    public void setData(int index,Model_Resep mod_rsp) {
        list.set(index, mod_rsp);
        fireTableRowsUpdated(index, index);
    }
    public Model_Resep getData(int index) {
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
    public Object getValueAt(int row, int col) {
        Model_Resep r = list.get(row);
        switch (col) {
            case 0: return r.getId_resep();
            case 1 : return r.getId_pemeriksaan().getNama_pasien();
            case 2 : return r.getId_pemeriksaan().getKeluhan();
            case 3: return r.getId_obat().getNama_obat();
            case 4: return r.getJumlah();
            case 5: return r.getAturan_pakai();
            default: return null;
        }
    }
    public String getColumnName(int column) {
        switch (column) {
            case 0: return "Id Resep";
            case 1: return "Nama Pasien";
            case 2: return "Keluhan";
            case 3: return "Nama obat";
            case 4: return "Jumlah";
            case 5: return "Aturan Pakai";
            
            default: return null;
        }
    }
}
