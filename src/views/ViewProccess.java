/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import java.awt.Component;
import java.awt.event.KeyEvent;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Ignatius
 */
public class ViewProccess {

    /**
     * fungsi untuk memanggil form
     * @param desktopPane
     * @param internalFrame 
     */
    public void callForm(JDesktopPane desktopPane, JInternalFrame internalFrame) {
        internalFrame.show();
        desktopPane.add(internalFrame);
    }

    /**
     * fungsi untuk menampilkan data pada tabel dengan parameter sesuai regionview dan regioncontroller
     * @param table
     * @param header
     * @param datas 
     */
    public void viewTable(JTable table, String[] header, List<Object[]> datas) {
        DefaultTableModel dtm = new DefaultTableModel(header, 0);
        datas.forEach((data) -> {
            dtm.addRow(data);
        });
        table.setModel(dtm);
    }

    /**
     * fungsi untuk membuat combobox terisi secara otomatis sesuai parameter
     * @param comboBox
     * @param header 
     */
    public void loadSearchComboBox(JComboBox comboBox, String[] header) {
        comboBox.removeAllItems();
        for (String string : header) {
            comboBox.addItem(string);
        }
    }

    /**
     * fungsi untuk membuat combobox terisi secara otomatis sesuai parameter misal di country
     * @param comboBox
     * @param datas
     * @param index 
     */
    public void loadDetails(JComboBox comboBox, List<Object[]> datas, int index) {
        datas.forEach((data) -> {
            comboBox.addItem(data[index]);
        });
    }

    /**
     * fungsi untuk mengambil nilai kategori yang ada dicombobox
     * @param categories
     * @param comboBox
     * @return nilai dari categori berdasarkan index dipilih di combobox
     */
    public String getCategory(String[] categories, JComboBox comboBox) {
        return categories[comboBox.getSelectedIndex()];
    }

    /**
     * 
     * @param evt
     * @return memproses kode setelah dillakukan enter
     */
    public boolean keyPressed(KeyEvent evt) {
        return evt.getKeyCode() == KeyEvent.VK_ENTER;
    }

    /**
     * 
     * @param component
     * @return konfiramasi perintah drop
     */
    public boolean dropConfirm(Component component) {
        return JOptionPane.showConfirmDialog(component, "Are you sure to drop data?", "Attention",
                JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION;
    }

    /**
     * show informasi
     * @param component
     * @param message 
     */
    public void showInformation(Component component, String message) {
        JOptionPane.showMessageDialog(component, message, "Notification",
                JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * 
     * @param action
     * @param flag
     * @return message berdasarkan masing-masing action
     */
    public String getMessage(String action, boolean flag) {
        if (flag) {
            return "Success to " + action + " data...";
        }
        return "Failed to " + action + " data...";
    }

    /**
     * perintah dropdata
     * @param component
     * @param flag 
     */
    public void dropData(Component component, boolean flag) {
        this.showInformation(component, this.getMessage("drop", flag));
    }

    /**
     * 
     * @param isSave
     * @return aksi dengan kodisi apakah data akan dirubah atau disimpan
     */
    public String getAction(boolean isSave) {
        if (isSave) {
            return "save";
        }
        return "edit";
    }

    /**
     * show informasi setelah dilakukan save data
     * @param component
     * @param flag
     * @param isSave 
     */
    public void saveData(Component component, boolean flag, boolean isSave) {
        this.showInformation(component, this.getMessage(this.getAction(isSave), flag));
    }

    public void loadData(Component component, JTable table, String[] header, List<Object[]> datas) {
        if (datas!=null) {
            this.viewTable(table, header, datas);
        } else {
            this.showInformation(component, this.getMessage("load", false));
        }
    }    
    
    public String getIdfromComboBox(List<Object[]> datas, int index){
        return datas.get(index)[0].toString();
    }
}
