import java.sql.*;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Abraham, Godson, Haritta
 */
public class DatabaseConnection 
{
    
    Connection con;
    Statement st;
    ResultSet rs;
    PreparedStatement pst;

    /**
     * This constructor Initialises the Method connect  
     */
    public DatabaseConnection () 
    {
	connect();

    }

    /**
     *This Method is connects the Access Database to Java Interface through ODBC Driver
     */
    public void connect()
    {

	try
        {
            /**
             * The String driver contains the ODBC driver for connection
             */
		String driver = "sun.jdbc.odbc.JdbcOdbcDriver";
		Class.forName(driver);

		String dbase ="jdbc:odbc:bookDatabase";
		con =DriverManager.getConnection(dbase);
		st = con.createStatement();
		String sql ="select * from bookDetails";
		rs = st.executeQuery(sql);


		while (rs.isAfterLast())
                {
                        String id = rs.getString("bookID");
			String fname  = rs.getString("firstName");
			String lname  = rs.getString("lastName");
			String book   = rs.getString("bookName");
		}
	} 
        catch(Exception ex)
        {
         
	}

    }

    
}
