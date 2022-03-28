/*
 * Context.java By: Andrew Erickson
 *
 * Last Modified: 2/24/22
 *
 * This class is for handling all the data objects the application will need.
 * It also deals with all SQLite interactions.
 * Passing out and taking in User, Dish, and Transaction objects.
 *
 * Requesting object(s) that are not in the database will return Null or an empty ArrayList.
 * TODO add get/set for cart
 */

package SQLite_db;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import application.dataObjects.Cart;
import application.dataObjects.Coupon;
import application.dataObjects.Customer;
import application.dataObjects.Manager;
import application.dataObjects.Menu;
import application.dataObjects.Payment;
import application.dataObjects.User;
import application.dataObjects.foodItem;

public class Context {
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

	//Adds/updates a User to the database.
	public void setUser(User u) {
		//search to see if user is in database
		String stmt = "SELECT * FROM User WHERE Email = " + u.getEmail();
		ResultSet r = getData(stmt);

		try {
			if(r.getFetchSize() == 0) {//if result set is of size zero
				//add new record
				String updateStmt = "INSERT INTO User (Role,UserName,Password,Email) VALUES (-1,"+u.getName()+","+u.getPassword()+","+u.getEmail()+")";
				setData(updateStmt);
			} else {
				//update record
				String updateStmt = "UPDATE User SET UserName = " + u.getName() + " , Email = " + u.getEmail() + " , Password = " + u.getPassword()
									+ " WHERE Email = " + u.getEmail();
				setData(updateStmt);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return;
	}

	//Adds/updates a Customer to the database.
	public void setCustomer(Customer u) {
		//search to see if user is in database
		String stmt = "SELECT * FROM User WHERE Email = " + u.getEmail();
		ResultSet r = getData(stmt);

		try {
			if(r.getFetchSize() == 0) {//if result set is of size zero
				//add new record
				String updateStmt = "INSERT INTO User (Role,UserName,Password,Email,CardNum,CCV,EXPDate) "+
									"VALUES (0,"+u.getName()+","+u.getPassword()+","+u.getEmail()+")";
				setData(updateStmt);
			} else {
				//update record
				String updateStmt = "UPDATE User SET UserName = " + u.getName() + " , Email = " + u.getEmail() + " , Password = " + u.getPassword()
									+ " WHERE Email = " + u.getEmail();
				setData(updateStmt);
			}
			//update users payment info
			setPaymentInfo(u);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return;
	}

	//Adds/updates a Manager to the database.
	public void setManager(Manager u) {
		//search to see if user is in database
		String stmt = "SELECT * FROM User WHERE Email = " + u.getEmail();
		ResultSet r = getData(stmt);

		try {
			if(r.getFetchSize() == 0) {//if result set is of size zero
				//add new record
				String updateStmt = "INSERT INTO User (Role,UserName,Password,Email) VALUES (1,"+u.getName()+","+u.getPassword()+","+u.getEmail()+")";
				setData(updateStmt);
			} else {
				//update record
				String updateStmt = "UPDATE User SET UserName = " + u.getName() + " , Email = " + u.getEmail() + " , Password = " + u.getPassword()
									+ " WHERE Email = " + u.getEmail();
				setData(updateStmt);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return;
	}

	//Updates payment info for a user. ASSUMING user has already been entered into database
	public void setPaymentInfo(Customer u) {
		//update user's CardNum, CCV, and EXPDate
		//search to see if user is in database
		String stmt = "SELECT * FROM User WHERE Email = " + u.getEmail();
		ResultSet r = getData(stmt);
		try {
			if(r.getFetchSize() == 0) {//if result set is of size zero
				//user needs to be entered into database first
				System.err.println("Error: Attempted update to payment info of non-exsistent user.\n\t" + u.toString());
				return;
			} else {
				//update record
				String updateStmt = "UPDATE User SET CardNum = " + u.getCard().getCardNumber() + " , CCV = " + u.getCard().getCcv() + " , EXPDate = " + u.getCard().getExpDate()
									+ " WHERE Email = " + u.getEmail();
				setData(updateStmt);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return;
	}

	//Adds/updates a food item to the database
	public void setFoodItem(Menu m, foodItem f) {
		//search to see if FoodItem is in database
		String foodStmt = "SELECT * FROM Food_Item WHERE Dish_Name = " + f.getFoodName();
		ResultSet food = getData(foodStmt);
		try {
			if(food.getFetchSize() == 0) {
				//food does not exist add it to database
				//get menu ID
				String menuStmt = "SELECT ID FROM Menu WHERE Name = " + m.menuName;
				ResultSet menu = getData(menuStmt);
				menu.next();
				int ID = menu.getInt("ID");
				//add new food item to database
				String insertStmt = "INSERT INTO Food_item (Dish_Name,Price,Ingreadents,Menu_ID) VALUES ("+f.getFoodName()+","+f.getPrice()+","+f.getIngredients()+","+ID+")";
				setData(insertStmt);
			} else if(food.getFetchSize() == 1) {
				//only one item. update it
				String updateStmt = "UPDATE Food_Item SET Dish_Name = "+f.getFoodName()+" , Price = " + f.getPrice()+" , Ingreadents = " + f.getIngredients()
									+ " WHERE Dish_Name = " + f.getFoodName();
				setData(updateStmt);
			} else {
				//if more than one food item is returned then name is too general
				System.err.println("Error: More than one food item returned in search. Food name may be too general.\n\t"+f.toString());
				return;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//if so update record
		//if not then add new record
	}

	//Adds/updates a food item to the database
	public void addCoupon(Coupon c, User u) {
		//add new Coupon record
		//String insertStmt = "INSERT INTO Coupons (Amount,User_ID) Values (5.0,"+u.getID()+")";
		//setData(insertStmt);
	}

	//Deletes a coupon from the database
	public void removeCoupon(Coupon c, User u) {
		//delete coupon record
		//String delStmt = "DELETE FROM Coupons WHERE ID = "+c.getID();
		//setData(delStmt);
	}

	//Returns a new user obj from the database, searched by email.
	public User getUser(String email, String password) {
		//search database for user by email
		String stmt = "SELECT * FROM User WHERE Email = " + email + " AND Password = " + password;
		ResultSet r = getData(stmt);
		User u = null;
		try {
			if(r.getFetchSize() == 0) {//if result set is of size zero
				return null;//user does not exist
			}
			//add in data
			r.next();//move to first data point
			u = new User(r.getString("UserName"), r.getString("Email"), r.getString("Password"));//make new user obj
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return u;
	}

	//Returns a new user obj from the database, searched by email.
	public User getCustomer(String email, String password) {
		Customer u = null;
		try {
			//search database for user by email
			String stmtCust = "SELECT * FROM User WHERE Role = 0 AND Email = " + email + " AND Password = " + password;
			ResultSet cust = getData(stmtCust);

			if(cust.getFetchSize() == 0) {//if result set is of size zero
				return null;//user does not exist
			}
			//add in data
			cust.next();//move to first data point
			u = new Customer(cust.getString("UserName"), cust.getString("Email"), cust.getString("Password"));//make new customer obj

			//set customer's payment info and coupons
			u.setCard(getPaymentInfo(u));
			u.setCoupon(getCoupons(u));

			//get the coustomer's cart
			String orderStmt = "SELECT * FROM Order WHERE User_ID = " + cust.getInt("ID");
			ResultSet orderR = getData(orderStmt);
			ArrayList<Cart> pastCarts = new ArrayList<>();
			//for each order
			while(orderR.next()) {
				Cart c = new Cart();
				//search Transaction table for the foods in order
				String transactionsStmt = "SELECT * FROM Transaction WHERE Order_ID = " + orderR.getString("ID");
				ResultSet transactions = getData(transactionsStmt);
				//for each transaction
				while(transactions.next()) {
					//get the food item associated with the transaction
					String foodStmt = "SELECT * FROM Food_Item WHERE ID = " + transactions.getString("Dish_ID");
					ResultSet foods = getData(foodStmt);
					foods.next();
					//convert to foodItem
					foodItem f = new foodItem(foods.getString("Dish_Name"),foods.getString("Ingreadents"), foods.getDouble("Price"));
					//add it to the cart
					c.addFood(f);
				}
				//add cart to pastCarts
				pastCarts.add(c);
			}
			u.setCart(pastCarts);
			u.pastOrders = pastCarts.size();

		} catch(SQLException e) {
			e.printStackTrace();
		}
		return u;
	}

	//Returns a new user obj from the database, searched by email.
	public User getManager(String email, String password) {
		//search database for user by email
		String stmt = "SELECT * FROM User WHERE Role = 1 AND Email = " + email + " AND Password = " + password;
		ResultSet r = getData(stmt);
		Manager u = null;
		try {
			if(r.getFetchSize() == 0) {//if result set is of size zero
				return null;//user does not exist
			}
			//add in data
			r.next();//move to first data point
			u = new Manager(r.getString("UserName"), r.getString("Email"), r.getString("Password"));//make new user obj
			u.menu = getMenu("Breakfast");		//TODO manuly getting menu, if more menus are added change this to a search and add menu[] arg
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return u;
	}


	//Returns a new menu obj from the database, searched by name.
	public Menu getMenu(String menuName) {
		//search database for menu by name
		String menuStmt = "SELECT * FROM Menu WHERE Name = " + menuName;
		ResultSet m = getData(menuStmt);
		Menu menu = null;
		try {
			m.next();
			int menuID = m.getInt("ID");
			menu = new Menu(m.getString("Name"));

			//get each food item with that menuID
			String foodStmt = "SELECT * FROM Food_Item WHERE Menu_ID = " + menuID;
			ResultSet foods = getData(foodStmt);
			while(foods.next()) {
				foodItem f = new foodItem(foods.getString("Dish_Name"), foods.getString("Ingreadents"), foods.getDouble("Price"));
				menu.addFoodItem(f);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}

		//with menu id search for all related foodItems
		return menu;
	}

	//Returns a new food item obj from the database, searched by name.
	public foodItem getFoodItem(String name) {
		//search database for foodItem by name
		String foodStmt = "SELECT * FROM Food_Item WHERE Dish_Name = " + name;
		ResultSet foods = getData(foodStmt);
		foodItem f = null;
		try {
			foods.next();
			//convert to foodItem
			f = new foodItem(foods.getString("Dish_Name"),foods.getString("Ingreadents"), foods.getDouble("Price"));
		} catch (SQLException e) {//add in data
			e.printStackTrace();
		}
		return f;
	}

	//gets any coupon(s) that a user may have.
	public ArrayList<Coupon> getCoupons(User u) {
		//search database for userID by email
		String userStmt = "SELECT ID FROM User WHERE Email = " + u.getEmail();
		ResultSet user = getData(userStmt);
		ArrayList<Coupon> c = new ArrayList<>();
		try {
			user.next();
			int ID = user.getInt("ID");
			String couponStmt = "SELECT * FROM Coupons WHERE User_ID = " + ID;
			ResultSet coupons = getData(couponStmt);
			while(coupons.next()) {
				Coupon cou = new Coupon();
				cou.haveCoupon = true;
				c.add(cou);
			}
		} catch (SQLException e) {//add in data
			e.printStackTrace();
		}

		return c;
	}

	//Returns a payment info obj, searched by user.
	public Payment getPaymentInfo(User u) {
		//search database for userID by email
		String userStmt = "SELECT ID FROM User WHERE Email = " + u.getEmail();
		ResultSet user = getData(userStmt);
		Payment p = null;
		try {
			user.next();
			p = new Payment(user.getInt("CardNum"), user.getInt("CCV"), user.getInt("EXPDate"));
		} catch (SQLException e) {//add in data
			e.printStackTrace();
		}
		return p;
	}

	private void setData(String stmt) {
		try {
			PreparedStatement pstmt = conn.prepareStatement(stmt);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.err.print("ERROR: SQL Statement failed\\nQuerry: "+stmt+"\n\nFull Trace:\\n"+e.getMessage());
		}
		return;
	}

	private ResultSet getData(String stmt) {
		ResultSet r;
		try {
			PreparedStatement pstmt = conn.prepareStatement(stmt);
			r = pstmt.executeQuery();
		} catch (SQLException e) {
			System.err.print("ERROR: SQL Statement failed\\nQuerry: "+stmt+"\n\nFull Trace:\\n"+e.getMessage());
			return null;
		}
		return r;
	}

}
