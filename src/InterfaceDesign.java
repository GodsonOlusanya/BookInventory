
import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author it
 */

//This class is to design the gui of the Application
//extends db makes make gui a subclass (so we can access all the instances variable
//from from class ab ie ResultSet(rs))





public class InterfaceDesign extends BookInventory {
    
      
    //Declaration of Frames, Label and Textfield
    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
        try{ String sql = "SELECT * FROM BOOKDETAILS WHERE FIRSTNAME  (firstName, lastName, bookName) values (?, ?, ?)"; 
                            
              pst = con.prepareStatement(sql);
      
                          
              pst.setString(1,fNameTxt.getText());
              pst.setString(2,lNameTxt.getText());
              pst.setString(3,bookTxt.getText());
                    
              pst.execute();
           
                   JOptionPane.showMessageDialog(null, "Next Data");
        }catch(SQLException | HeadlessException b){
            
        }
    } 
    
    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
        try{ String sql = "INSERT INTO BOOKDETAILS (firstName, lastName, bookName) values (?, ?, ?)"; 
                            
              pst = con.prepareStatement(sql);
      
                          
              pst.setString(1,fNameTxt.getText());
              pst.setString(2,lNameTxt.getText());
              pst.setString(3,bookTxt.getText());
                    
              pst.execute();
           
                   JOptionPane.showMessageDialog(null, "Saved");
        }catch(SQLException | HeadlessException b){
            
        }
    } 
    
    JFrame f;
    JLabel fNameLabel;
    JLabel lNameLabel;
    JLabel bookLabel;
    JTextField fNameTxt;
    JTextField lNameTxt;
    JTextField bookTxt;
    JButton btnBack;
    JButton btnSave ;
    //JTable table;
    
    
    
    //constructor of the class gui
    public InterfaceDesign (){
        frame();
        initComponents();
    //Initialization of GUI Frame, Labels and Textfield    
    }
    
    public void frame(){
        f = new JFrame();
        f.setVisible(true);
        f.setSize(600,400);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        fNameLabel = new JLabel("First Name");
        lNameLabel = new JLabel("Last Name");
        bookLabel = new JLabel("Book");
        btnBack = new JButton("BACK");
        btnSave = new JButton("SUBMIT");
        fNameTxt = new JTextField(10);
        lNameTxt = new JTextField(10);
        bookTxt = new JTextField(10);
        
        
        ///Adding Label and TextField on Frame
        //Adding all textfield and labels onto panel
        JPanel p = new JPanel();
        p.add(fNameLabel);
        p.add(fNameTxt);
        p.add(lNameLabel);
        p.add(lNameTxt);
        p.add(bookLabel);
        p.add(bookTxt);
        p.add(btnBack);
        p.add(btnSave);
        //p.add(table);

        //Adding panel onto frame
        f.add(p);
        
  
        
        
       //Display record from Dbase
       
       try {
           //the pointer to the first field in the Dbase
           rs.next();
           //connects to a particular field in dbase 
           //string name should be the same as in the Dbase
           // u can also use
           //String namef  = rs.getString("Fname");
           //t.setText(namef);
           
           
           fNameTxt.setText(rs.getString("firstName"));
           lNameTxt.setText(rs.getString("lastName"));
           bookTxt.setText(rs.getString("bookName"));
           //btnSave.setActionCommand(rs.getString"Insert into Table1(Fname,Lname,Age)");
           btnSave.setText("Main Save");
           btnBack.setText("Back");
           
           
       }catch(Exception ex){
           System.out.println("ERROR SQL");
       }

                    

            
      
    }
   public void initComponents(){
      btnSave.addActionListener(new java.awt.event.ActionListener() {
    
    @Override
    public void actionPerformed(java.awt.event.ActionEvent evt) {
           btnSaveActionPerformed(evt);
    }
});  
      
      btnBack.addActionListener(new java.awt.event.ActionListener() {
    
    @Override
    public void actionPerformed(java.awt.event.ActionEvent evt) {
           btnBackActionPerformed(evt);
    }
}); 
      
    }
}

    

