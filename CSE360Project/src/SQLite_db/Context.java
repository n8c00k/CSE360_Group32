/*
 * Context.java By: Andrew Erickson
 * 
 * Last Modified: 2/24/22
 * 
 * This class is for handling all the data objects the application will need.
 * It also deals with all SQLite interactions.
 * Passing out and taking in User, Dish, and Transaction objects.
 * 
 * Requesting object(s) that are not in the database will throw an EntryNotFoundException
 */

package SQLite_db;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Context {
	/*
	 * NOTES
	 * menu and fooditem need a name field
	 * user needs a payment var
	 */
	
	//connection obj that all sqlite interactions are handled through
	private Connection conn = null;
	
	public Context() {
		try {
			Class.forName("org.sqlite.JDBC");//for some reason this makes it able to find the database
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
	/* REMOVE WHEN DATA CALSSES ARE ADDED
	//Adds/updates a user to the database.
	public void setUser(User u) {
		//search to see if user is in database
		//if so update record
		//if not then add new record
	}
	
	//Adds/updates payment info for a user.
	public void setPaymentInfo(User u) {
		//update user's CardNum, CCV, and EXPDate
	}
	
	//Adds/updates a food item to the database
	public void setFoodItem(Menu m, FoodItem f) {
		//search to see if FoodItem is in database
		//if so update record
		//if not then add new record
	}
	
	//Adds/updates a food item to the database
	public void addCoupon(Coupon c, User u) {
		//add new Coupon record
	}
	
	//Deletes a coupon from the database
	public void removeCoupon(Coupon c, User u) {
		//delete coupon record
	}
	
	//Returns a new user obj from the database, searched by email. 
	public User getUser(String email) {
		//search database for user by email
		User u = new User();//make new user obj
		//add in data
	}
	
	//Returns a new menu obj from the database, searched by name.
	public Menu getMenu(String menuName) {
		//search database for menu by name
		//with menu id search for all related foodItems
	}
	
	//Returns a new food item obj from the database, searched by name.
	public FoodItem getFoodItem(String name) {
		//search database for foodItem by name
		FoodItem f = new FoodItem();
		//add in data
	}
	
	//Returns a payment info obj, searched by user.
	public Payment getPaymentInfo(User u) {
		//search database for user by email
		payment p = new Payment();
		//add data
	}*/
	
	private void setData(String stmt) throws Exception {
		try {
			PreparedStatement pstmt = conn.prepareStatement(stmt);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			throw new Exception("ERROR: SQL Statement failed\nQuerry: "+stmt+"\n\nFull Trace:\n"+e.getMessage());
		}
		return;
	}
	
	private ResultSet getData(String stmt) throws Exception {
		ResultSet r;
		try {
			PreparedStatement pstmt = conn.prepareStatement(stmt);
			r = pstmt.executeQuery();
		} catch (SQLException e) {
			throw new Exception("ERROR: SQL Statement failed\nQuerry: "+stmt+"\n\nFull Trace:\n"+e.getMessage());
		}
		return r;
	}

}
