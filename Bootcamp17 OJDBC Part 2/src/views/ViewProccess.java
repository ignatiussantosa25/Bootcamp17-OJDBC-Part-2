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

    public void callForm(JDesktopPane desktopPane, JInternalFrame internalFrame) {
        internalFrame.show();
        desktopPane.add(internalFrame);
    }

    public void viewTable(JTable table, String[] header, List<Object[]> datas) {
        DefaultTableModel dtm = new DefaultTableModel(header, 0);
        datas.forEach((data) -> {
            dtm.addRow(data);
        });
        table.setModel(dtm);
    }

    public void loadSearchComboBox(JComboBox comboBox, String[] header) {
        comboBox.removeAllItems();
        for (String string : header) {
            comboBox.addItem(string);
        }
    }

    public void loadDetails(JComboBox comboBox, List<Object[]> datas, int index) {
        datas.forEach((data) -> {
            comboBox.addItem(data[index]);
        });
    }

    public String getCategory(String[] categories, JComboBox comboBox) {
        return categories[comboBox.getSelectedIndex()];
    }

    public boolean keyPressed(KeyEvent evt) {
        return evt.getKeyCode() == KeyEvent.VK_ENTER;
    }

    public boolean dropConfirm(Component component) {
        return JOptionPane.showConfirmDialog(component, "Are you sure to drop data?", "Attention",
                JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION;
    }

    public void showInformation(Component component, String message) {
        JOptionPane.showMessageDialog(component, message, "Notification",
                JOptionPane.INFORMATION_MESSAGE);
    }

    public String getMessage(String action, boolean flag) {
        if (flag) {
            return "Success to " + action + " data...";
        }
        return "Failed to " + action + " data...";
    }

    public void dropData(Component component, boolean flag) {
        this.showInformation(component, this.getMessage("drop", flag));
    }

    public String getAction(boolean isSave) {
        if (isSave) {
            return "save";
        }
        return "edit";
    }

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
