
import javax.swing.*;
import java.awt.*;
import javax.swing.JTable;
import net.proteanit.sql.DbUtils;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *This class holds the Graphic User Interface of the Application 
 *
 * @author Abraham, Godson, Haritha
 */

public class InterfaceDesign extends DatabaseConnection 
{
    JFrame f;
    JLabel fNameLabel;
    JLabel lNameLabel;
    JLabel bookLabel;
    JLabel idLabel;
    JTextField fNameTxt;
    JTextField lNameTxt;
    JTextField bookTxt;
    JTextField idTxt;
    JButton btnDelete;
    JButton btnSave ;
    JButton btnUpdate;
    JButton btnRefresh;
    JTable table;
    JScrollPane scrollPane;
    

    /**
     *constructor of the class InterfaceDesign
     */
    public InterfaceDesign ()
    {
        frame();
        updateTable();
          
    }

    /**
     *This Method links the Table to the Database
     */
    public void updateTable()
    {
        try
        {
            String sql = "SELECT * FROM BOOKDETAILS WHERE FIRSTNAME  (bookID, firstName, lastName, bookName) values (?, ?, ?)"; 
                            
            pst = con.prepareStatement(sql);
            table.setModel(DbUtils.resultSetToTableModel(rs));
    
        }
        catch(Exception e) 
        { 
            System.out.println("ERROR Connecting to Dbase");    
        }
    }

    /**
     *Creates various buttons, table and frame for the Graphic User Interface
     */
    public void frame()
    {
        
        f = new JFrame();
        f.setVisible(true);
        f.setSize(1000,600);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setTitle("Digital Book Record System");
        fNameLabel = new JLabel("First Name");
        fNameLabel.setLocation(500, 500);
        idLabel =new JLabel("Book ID");
        lNameLabel = new JLabel("Last Name");
        bookLabel = new JLabel("Book");
        btnDelete = new JButton("DELETE");
        btnSave = new JButton("SUBMIT");
        btnUpdate = new JButton("UPDATE");
        btnRefresh = new JButton("REFRESH");
        fNameTxt = new JTextField(10);
        idTxt  = new JTextField(4);
        lNameTxt = new JTextField(10);
        bookTxt = new JTextField(10);
   
        scrollPane = new javax.swing.JScrollPane();

        /**
         * Creation of a table
         */
        table = new javax.swing.JTable();
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        table.setVisible(true);
        table.setSize(800,500);
        scrollPane.setViewportView(table);
                
        //Adding Label and TextField on Frame
        //Adding all textfield and labels onto panel
        JPanel p = new JPanel();
        p.setOpaque(true);
        p.setBackground(Color.orange);
        p.setSize(1000,600);
        p.add(idLabel);
        p.add(idTxt);
        p.add(fNameLabel);
        p.add(fNameTxt);
        p.add(lNameLabel);
        p.add(lNameTxt);
        p.add(bookLabel);
        p.add(bookTxt);
        p.add(btnDelete);
        p.add(btnSave);
        p.add(btnUpdate);
        p.add(table);
        p.add(btnRefresh);

        //Adding panel onto frame
        f.add(p);
        
      
                
       
        try 
        {
           //the pointer to the first field in the Dbase
           rs.next();
           /**
            * Connects to a particular field in Database 
            */
           
           
           idTxt.setText(rs.getString("bookID"));
           fNameTxt.setText(rs.getString("firstName"));
           lNameTxt.setText(rs.getString("lastName"));
           bookTxt.setText(rs.getString("bookName"));
           btnSave.setText("SAVE");
           btnDelete.setText("DELETE");
           btnUpdate.setText("UPDATE");
           btnRefresh.setText("REFRESH");
           
        }
        catch(Exception ex)
        {
           System.out.println("ERROR SQL");
        }          
      
    }
   
}

    

