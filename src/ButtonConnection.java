
import java.awt.HeadlessException;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Abraham, Godson, Haritha
 */
public class ButtonConnection extends InterfaceDesign
{
     /**
     *This is a Constructor that Initialises button functionalities 
     */
    public ButtonConnection()
    {
        initComponents();
    }
  
    /**
     *
     * @param evt indicates that the Save to the database action has occurred
     */
    public void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) 
    {                                         
        // TODO add your handling code here:
        try
        { 
            String sql = "SELECT * FROM BOOKDETAILS"; 
                            
             pst = con.prepareStatement(sql);
             rs = pst.executeQuery();
             table.setModel(DbUtils.resultSetToTableModel(rs));
             
             JOptionPane.showMessageDialog(null, "Database has been Refreshed");
        
        }
        catch(SQLException | HeadlessException b)
        {
            
        }
    }
    
    
    /**
     *
     * @param evt indicates that the Save to the database action has occurred
     */
    public void btnSaveActionPerformed(java.awt.event.ActionEvent evt) 
    {                                         
        // TODO add your handling code here:
        try
        { 
            String sql = "INSERT INTO BOOKDETAILS (firstName, lastName, bookName) values (?, ?, ?)"; 
                            
              pst = con.prepareStatement(sql);
              pst.setString(1,fNameTxt.getText());
              pst.setString(2,lNameTxt.getText());
              pst.setString(3,bookTxt.getText());       
              pst.execute();
           
             JOptionPane.showMessageDialog(null, "Saved");
        
        }
        catch(SQLException | HeadlessException b)
        {
            JOptionPane.showMessageDialog(null, "ERROR SAVING DATA");
        }
     
    }
 
    /**
     *
     * @param evt indicates that the Update to the database action has occurred
     */
    public void btnUpdateActionPerformed(java.awt.event.ActionEvent evt)
    {     
        
        // TODO add your handling code here:
       try
       { 
           String sql = "UPDATE BOOKDETAILS SET FIRSTNAME = '"+fNameTxt.getText()+"',LASTNAME = '"+lNameTxt.getText()+"', BOOKNAME = '"+bookTxt.getText()+"' WHERE BOOKID = "+idTxt.getText(); 
            pst = con.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null, "File Has been Updated");
       } 
       catch(Exception ex)
       {
           JOptionPane.showMessageDialog(null, "ERROR UPDATING");
       }
        
    }

    /**
     *
     * @param evt indicates that the Update made to the database action has occurred
     */
    public void btnDeleteActionPerformed(java.awt.event.ActionEvent evt)
    {                                         
        // TODO add your handling code here:
        try{ String sql = "DElETE * FROM BOOKDETAILS WHERE FIRSTNAME =? "; 
                            
              pst = con.prepareStatement(sql);       
              pst.setString(1,fNameTxt.getText());      
              pst.execute();
           
              JOptionPane.showMessageDialog(null, "File Has been deleted");
        }
        catch(SQLException | HeadlessException b)
        {
            JOptionPane.showMessageDialog(null, "ERROR DELETING");
        }
    } 

    /**
     * Initialise components for actions such btnSaveActionPerform, btnDeleteActionPerform and 
     * btnUpdateActionPerform  to be performed
     */
    public void initComponents()
    {
      btnRefresh.addActionListener(new java.awt.event.ActionListener() 
      {
    
        @Override
        public void actionPerformed(java.awt.event.ActionEvent evt) 
        {
           btnRefreshActionPerformed(evt);
        }
      });   
   
      btnSave.addActionListener(new java.awt.event.ActionListener() 
      {
    
        @Override
        public void actionPerformed(java.awt.event.ActionEvent evt) 
        {
           btnSaveActionPerformed(evt);
        }
      });  
      btnUpdate.addActionListener(new java.awt.event.ActionListener() 
      {
    
        @Override
        public void actionPerformed(java.awt.event.ActionEvent evt) 
        {
           btnUpdateActionPerformed(evt);
        }
      });
      
      btnDelete.addActionListener(new java.awt.event.ActionListener() 
      {
    
        @Override
        public void actionPerformed(java.awt.event.ActionEvent evt) 
        {
           btnDeleteActionPerformed(evt);
        }
      }); 
    
    } 

}
