/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import java.awt.event.KeyEvent;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Ignatius
 */
public class ViewProccess {

    public void callForm(JDesktopPane desktopPane, JInternalFrame internalFrame){
        internalFrame.show();
        desktopPane.add(internalFrame);
    }
    
    public void viewTable(JTable table, String[] header, List<Object[]> datas) {
        DefaultTableModel dtm = new DefaultTableModel(header, 0);
        datas.forEach((data) -> {dtm.addRow(data);});
        table.setModel(dtm);
    }
    
    public void loadSearchComboBox(JComboBox comboBox, String[] header){
        for (String string : header) {
            comboBox.addItem(string);
        }
    }    
    
    public void loadDetails(JComboBox comboBox, List<Object[]> datas, int index){
        datas.forEach((data) -> {comboBox.addItem(data[index]);});
    }
    
    public String getCategory(String[] categories, JComboBox comboBox){
        return categories[comboBox.getSelectedIndex()];
    }
    
    public boolean keyPressed(KeyEvent evt){
        return evt.getKeyCode()==KeyEvent.VK_ENTER;
    }
    
}
