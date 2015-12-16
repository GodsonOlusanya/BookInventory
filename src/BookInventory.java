import java.sql.*;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author it
 */

/**
 *
 * 
 */
public class BookInventory {

    	Connection con;
	Statement st;
	ResultSet rs;
        PreparedStatement pst = null;


	public BookInventory () 
        {
		connect();

	}
	public void connect()
        {

	try
        {
		String driver = "sun.jdbc.odbc.JdbcOdbcDriver";
		Class.forName(driver);

		String dbase ="jdbc:odbc:bookDatabase";
		con =DriverManager.getConnection(dbase);
		st = con.createStatement();
		String sql ="select * from bookDetails";
		rs = st.executeQuery(sql);
		//displays everything in the database

		while (rs.isAfterLast())
                {
			String fname = rs.getString("firstName");
			String lname = rs.getString("lastName");
			String book = rs.getString("bookName");
			System.out.println(fname + " " + lname+ " " + book);


		}


	} 
        catch(Exception ex)
        {

	}

	}

	public static void main (String[] agrs)
        {
		new BookInventory();
                new InterfaceDesign();

	}
}
