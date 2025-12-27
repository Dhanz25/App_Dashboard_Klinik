
package TableModel;

import Model.Model_Jadwal;
import Model.Model_Pemeriksaan;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

public class Tablemod_Pemeriksaan extends AbstractTableModel {
    
    private List<Model_Pemeriksaan> list = new ArrayList<>();
    
    public void tambahData(Model_Pemeriksaan mod_prk) {
        list.add(mod_prk);
        fireTableRowsInserted(list.size() - 1, list.size() -1);
    }
    
    public void perbaruiData(int row, Model_Pemeriksaan mod_prk) {
        list.add(row, mod_prk);
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
    
    public void setData(List<Model_Pemeriksaan> list){
        clear();
        this.list.addAll(list);
        fireTableDataChanged();
    }
    
    public void setData(int index,Model_Pemeriksaan mod_prk) {
        list.set(index, mod_prk);
        fireTableRowsUpdated(index, index);
    }
    
    public Model_Pemeriksaan getData(int index) {
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
             case 0: return list.get(rowIndex).getId_pemeriksaan();
             case 1:
            Model_Jadwal j = list.get(rowIndex).getId_jadwal();
            return "[" + j.getNo_urut() + "] "
            + j.getId_p().getNama_pasien();

             case 2: return list.get(rowIndex).getKeluhan();
             case 3: return list.get(rowIndex).getDiagnosa();
             case 4: return list.get(rowIndex).getTindakan();
             case 5:
                Date tgl = list.get(rowIndex).getTanggal();
                return new SimpleDateFormat("yyyy-MM-dd HH:mm").format(tgl);

             
             default: return null;
        }
    }
    
    public String getColumnName(int column) {
        switch (column) {
            case 0: return "Id Pemeriksaan";
            case 1: return "No Urut / Nama Pasien";
            case 2: return "Keluhan";
            case 3: return "Diagnosa";
            case 4: return "Tindakan";
            case 5: return "Tanggal";
            
             
            default: return null;
        }
    }
}
