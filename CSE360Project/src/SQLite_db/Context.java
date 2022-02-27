/*
 * Context.java By: Andrew Erickson
 * 
 * Last Modified: 2/24/22
 * 
 * This class is holding all the global vars the application will need.
 * It also deals with all SQLite interactions.
 * Passing out and taking in User, Dish, and Transaction objects.
 */

package SQLite_db;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Context {
	
	//connection obj that all sqlite interactions are handled through
	private Connection conn = null;
	
	public Context() {
		try {
			Class.forName("org.sqlite.JDBC");//for some reason this makes it able to fin d the database
			//get file path for workspace
			File dbfile=new File(".");//dot is relative to current directory
			//Drive Manager parameters
			//It is made for many data bases so we need to tell it what we are using and where the DB file is
            String url = "jdbc:sqlite:"+dbfile.getAbsolutePath()+"\\src\\SQLite_db\\Data.db";
            // create a connection to the database
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException e) {
        	 System.out.println(e.getMessage());
		}
	}

}
