/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Ignatius
 */
public class ViewProccess {

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
    
    
//    public void loadDetailComboBox(JComboBox comboBox, )
//    
//    public String saveData(String ){
//        
//    }
}
