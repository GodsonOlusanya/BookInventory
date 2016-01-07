
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import net.proteanit.sql.DbUtils;
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

    /**
     *
     * @param evt
     */
    public void btnSaveActionPerformed(java.awt.event.ActionEvent evt) 
    {                                         
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

    /**
     *
     * @param evt
     */
    public void btnUpdateActionPerformed(java.awt.event.ActionEvent evt)
    {     
        
        // TODO add your handling code here:
       try{ 
           String sql = "UPDATE BOOKDETAILS SET FIRSTNAME = '"+fNameTxt.getText()+"',LASTNAME = '"+lNameTxt.getText()+"', BOOKNAME = '"+bookTxt.getText()+"' WHERE BOOKID = "+idTxt.getText(); 
        JOptionPane.showMessageDialog(null, "File Has been Updated");
       } 
       catch(Exception ex){}
//Read more at http://1bestcsharp.blogspot.com/2015/03/java-mysql-insert-update-delete-data-from-mysql-database-using-java.html#jqdqWe6PLof4iGqf.99 
            
        
    }

//Declaration of Frames, Label and Textfield

    /**
     *
     * @param evt
     */
    
    public void btnDeleteActionPerformed(java.awt.event.ActionEvent evt)
    {                                         
        // TODO add your handling code here:
        try{ String sql = "DElETE * FROM BOOKDETAILS WHERE FIRSTNAME =? "; 
                            
              pst = con.prepareStatement(sql);       
              pst.setString(1,fNameTxt.getText());      
              pst.execute();
           
                   JOptionPane.showMessageDialog(null, "File Has been deleted");
        }catch(SQLException | HeadlessException b){
            
        }
    }
    
///Selecting using the mouse

    /**
     *
     * @param evt
     */
     public void tableMouseClicked(java.awt.event.MouseEvent evt) {                                    
        // TODO add your handling code here:
        try{
            
        
     int row =table.getSelectedRow();
     String clickTable = table.getModel().getValueAt(row,0).toString();
     String sql = "SELECT * FROM FIRSTNAME WHERE BOOKID ='"+clickTable+"'";
     pst = con.prepareStatement(sql);
     pst.executeQuery();
     if(rs.next())
     {
         String add1 =rs.getString("firstName");
         fNameTxt.setText(add1);
         String add2 =rs.getString("lastName");
         lNameTxt.setText(add2);
         String add3 =rs.getString("bookName");
         bookTxt.setText(add3);
         
     }
         
     
        
    }
        catch(Exception e)
        {
            
        }
      
     }
    
     
    
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
    JTable table;
    JScrollPane scrollPane;
    
    
    //constructor of the class gui

    /**
     *
     */
    public InterfaceDesign (){
        frame();
        initComponents();
        updateTable();
        
    //Initialization of GUI Frame, Labels and Textfield    
    }

    /**
     *
     */
    public void updateTable(){
   try{
    
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
     *
     */
    public void frame(){
        
        f = new JFrame();
        f.setVisible(true);
        f.setSize(1000,600);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        fNameLabel = new JLabel("First Name");
        fNameLabel.setLocation(500, 500);
        idLabel =new JLabel("Book ID");
        lNameLabel = new JLabel("Last Name");
        bookLabel = new JLabel("Book");
        btnDelete = new JButton("DELETE");
        btnSave = new JButton("SUBMIT");
        btnUpdate = new JButton("UPDATE");
        fNameTxt = new JTextField(10);
        idTxt  = new JTextField(4);
        lNameTxt = new JTextField(10);
        bookTxt = new JTextField(10);
   
        
//SetSize and location for buttons
    //btnSave.setLocation(280,350);
    //SetSize and location for buttons
    //btnSave.setLocation(280,400);
//Creation of a ScrollPane
scrollPane = new javax.swing.JScrollPane();

//Creation of a table

table = new javax.swing.JTable();

/*
table.setModel(new javax.swing.table.DefaultTableModel(
    new Object [][] {
        {null, null, null, null,500},
        {null, null, null, null,null},
        {null, null, null, null,null},
        {null, null, null, null,null}
    },
    new String [] {
        "Title 1", "Title 2", "Title 3", "Title 4"
    }
        
));
*/
table.setSize(800,500);
scrollPane.setViewportView(table);
        
        
        
        ///Adding Label and TextField on Frame
        //Adding all textfield and labels onto panel
        JPanel p = new JPanel();
        p.setOpaque(true);
        p.setBackground(Color.red);
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
           
           idTxt.setText(rs.getString("bookID"));
           fNameTxt.setText(rs.getString("firstName"));
           lNameTxt.setText(rs.getString("lastName"));
           bookTxt.setText(rs.getString("bookName"));
           //btnSave.setActionCommand(rs.getString"Insert into Table1(Fname,Lname,Age)");
           btnSave.setText("SAVE");
           btnDelete.setText("DELETE");
           btnUpdate.setText("UPDATE");
           
           
       }catch(Exception ex){
           System.out.println("ERROR SQL");
       }

                    

            
      
    }

    /**
     *
     */
    public void initComponents(){
       
   table.addMouseListener(new java.awt.event.MouseListener (){
       
   
       @Override
       
       public void mouseClicked(java.awt.event.MouseEvent e){
       tableMouseClicked(e);
   }

       @Override
       public void mousePressed(MouseEvent e) {
          // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
       }

       @Override
       public void mouseReleased(MouseEvent e) {
           //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
       }

       @Override
       public void mouseEntered(MouseEvent e) {
          // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
       }

       @Override
       public void mouseExited(MouseEvent e) {
           //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
 }
   });
   
      btnSave.addActionListener(new java.awt.event.ActionListener() {
    
    @Override
    public void actionPerformed(java.awt.event.ActionEvent evt) {
           btnSaveActionPerformed(evt);
    }
});  
      btnUpdate.addActionListener(new java.awt.event.ActionListener() {
    
    @Override
    public void actionPerformed(java.awt.event.ActionEvent evt) {
           btnUpdateActionPerformed(evt);
    }
});
      
      btnDelete.addActionListener(new java.awt.event.ActionListener() {
    
    @Override
    public void actionPerformed(java.awt.event.ActionEvent evt) {
           btnDeleteActionPerformed(evt);
    }
}); 
    
    }
}

    

