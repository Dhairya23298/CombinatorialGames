import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.Vector;

/**
 * Created by dhairyathakkar on 25-03-2017.
 */
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.*;
public class viPanel2 extends JPanel{
    public JTable table;
    public viPanel2(){
        Vector<String> columnNames = new Vector<String>();
        columnNames.addElement("Player");
        columnNames.addElement("Operation");

        Vector<String> row = new Vector<String>();
        row.addElement("Player");
        row.addElement("Operation");

        Vector<Vector<String>> rowData = new Vector<Vector<String>>();
        rowData.addElement(row);

        table=new JTable(rowData,columnNames);
        add(table);
    }
    public void addrow(String s1,String s2){
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.addRow(new Object[]{s1, s2});
        validate();
    }
}
