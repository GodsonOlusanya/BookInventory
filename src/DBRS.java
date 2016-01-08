/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Description:<br>
 * A Digital Book Record System which helps to keep track of the
 * available books in a personal book collection. <br><br>
 * <p>
 * The System possesses a database with which it is available to
 * maintain a record that can receive added books and books can
 * be deleted from.
 *
 * @author Abraham, Godson, Haritha
 */
public class DBRS 
{

    /**
     *
     * @param agrs This is the main method for running the  DatabaseConnection, 
     * InterfaceDesign, and ButtonConnection  classes
     */
        public static void main (String[] agrs)
        {
		new DatabaseConnection();
                new InterfaceDesign();
                new ButtonConnection();
                

	}
    
}
