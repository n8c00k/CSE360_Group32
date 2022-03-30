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
 * 
 * TODO final testing, major issues should be gone
 */

package SQLite_db;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import application.dataObjects.*;

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
		String stmt = "SELECT * FROM User WHERE ID = " + u.getUserId() + ";";
		ResultSet r = getData(stmt);

		try {
			if(r.next() == false) {//if result set is of size zero
				//add new record
				String updateStmt = "INSERT INTO User (Role,UserName,Password,Email) VALUES (-1,'"+u.getName()+"','"+u.getPassword()+"','"+u.getEmail()+"');";
				setData(updateStmt);
				//since it's a new record they don't have an ID field.
				//get it and add it to the obj
				ResultSet newUser = getData("SELECT ID FROM User WHERE Email = '" + u.getEmail() + "';");
				newUser.next();
				u.setUserId(newUser.getInt("ID"));
			} else {
				//update record
				String updateStmt = "UPDATE User SET UserName = '" + u.getName() + "' , Email = '" + u.getEmail() + "' , Password = '" + u.getPassword()
									+ "' WHERE ID = " + u.getUserId() + ";";
				setData(updateStmt);
			}
		} catch (SQLException e) {
			System.err.println("Error in setUser");
			e.printStackTrace();
		}
		return;
	}

	//Adds/updates a Customer to the database.
	public void setCustomer(Customer u) {
		/*//uncomment if we are checking for null data
		if(u.getName() == "" || u.getEmail() == "" || u.getPassword() == "") {
			//Customer has bad data throw error
			throw new InputMismatchException("Null Data not allowed\n" + u.toString());
		}*/
		//search to see if user is in database
		String stmt = "SELECT * FROM User WHERE ID = " + u.getUserId() + ";";
		ResultSet r = getData(stmt);

		try {
			if(r.next() == false) {//if result set is of size zero
				//add new record
				String updateStmt = "INSERT INTO User (Role,UserName,Password,Email) "+
									"VALUES (0,'"+u.getName()+"','"+u.getPassword()+"','"+u.getEmail()+"');";
				setData(updateStmt);
				//since it's a new record they don't have an ID field.
				//get it and add it to the obj
				ResultSet newUser = getData("SELECT ID FROM User WHERE Email = '" + u.getEmail() + "';");
				newUser.next();
				u.setUserId(newUser.getInt("ID"));
			} else {
				//update record
				String updateStmt = "UPDATE User SET UserName = '" + u.getName() + "' , Email = '" + u.getEmail() + "' , Password = '" + u.getPassword()
									+ "' WHERE ID = " + u.getUserId() + ";";
				setData(updateStmt);
			}
			//update users payment info
			setPaymentInfo(u);
		} catch (SQLException e) {
			System.err.println("Error in setCustomer");
			e.printStackTrace();
		}
		return;
	}

	//Adds/updates a Manager to the database.
	public void setManager(Manager u) {
		//search to see if user is in database
		String stmt = "SELECT * FROM User WHERE ID = " + u.getUserId() + ";";
		ResultSet r = getData(stmt);

		try {
			if(r.next() == false) {//if result set is of size zero
				//add new record
				String updateStmt = "INSERT INTO User (Role,UserName,Password,Email) VALUES (1,'"+u.getName()+"','"+u.getPassword()+"','"+u.getEmail()+"');";
				setData(updateStmt);
				//since it's a new record they don't have an ID field.
				//get it and add it to the obj
				ResultSet newUser = getData("SELECT ID FROM User WHERE Email = '" + u.getEmail() + "';");
				newUser.next();
				u.setUserId(newUser.getInt("ID"));
			} else {
				//update record
				String updateStmt = "UPDATE User SET UserName = '" + u.getName() + "' , Email = '" + u.getEmail() + "' , Password = '" + u.getPassword()
									+ "' WHERE ID = " + u.getUserId() + ";";
				setData(updateStmt);
			}
		} catch (SQLException e) {
			System.err.println("Error in setManager");
			e.printStackTrace();
		}
		return;
	}

	//Updates payment info for a user. ASSUMING user has already been entered into database
	public void setPaymentInfo(Customer u) {
		//update user's CardNum, CCV, and EXPDate
		//search to see if user is in database
		String stmt = "SELECT * FROM User WHERE ID = " + u.getUserId() + ";";
		ResultSet r = getData(stmt);
		try {
			if(r.next() == false) {//if result set is of size zero
				//user needs to be entered into database first
				System.err.println("Error: Attempted update to payment info of non-exsistent user.\n\t" + u.toString());
				return;
			} else if(u.getCard() != null) {
				//update record if card is available
				String updateStmt = "UPDATE User SET CardNum = " + u.getCard().getCardNumber() + " , CCV = " + u.getCard().getCcv() + " , EXPDate = " + u.getCard().getExpDate()
									+ " WHERE ID = " + u.getUserId() + ";";
				setData(updateStmt);
			}
		} catch (SQLException e) {
			System.err.println("Error in setPaymentInfo");
			e.printStackTrace();
		}
		return;
	}
	
	//Adds Cart to the database
	public void addCart(Customer u, Cart c) {
		//insert the main cart into database
		String ordersStmt = "INSERT INTO 'Order' (User_ID,Price) VALUES (" + u.getUserId() + "," + c.totalPrice + ");";
		setData(ordersStmt);
		try {
			//get ID from new order TODO this search is not unique. make it unique so we don't get collisions. add hidden time field?
			ResultSet order = getData("SELECT ID FROM 'Order' WHERE User_ID = " + u.getUserId() + " AND Price = " + c.totalPrice + ";");
			order.next();
			int orderID = order.getInt("ID");
			//for each food item in cart
			for(int i = 0; i < c.foods.size(); i++) {
				//add the transaction to the data basse
				String transStmt = "INSERT INTO 'Transaction' (Order_ID,Dish_ID,Quantity) VALUES (" + orderID + "," + c.foods.get(i).getUserId() + "," + c.quantity.get(i) + ");";
				setData(transStmt);
			}
		}  catch (SQLException e) {
			System.err.println("Error in addCart");
			e.printStackTrace();
		}
		return;
	}

	//Adds/updates a food item to the database
	public void setFoodItem(Menu m, foodItem f) {
		//search to see if FoodItem is in database
		String foodStmt = "SELECT * FROM Food_Item WHERE ID = " + f.getUserId() + ";";
		ResultSet food = getData(foodStmt);
		try {
			if(food.next() == false) {
				//food does not exist add it to database
				//add new food item to database
				String insertStmt = "INSERT INTO Food_item (Dish_Name,Price,Ingreadents,Menu_ID) VALUES ('"+f.getFoodName()+"',"+f.getPrice()+",'"+f.getIngredients()+"',"+m.getUserId()+");";
				setData(insertStmt);
				ResultSet NF = getData("SELECT ID FROM Food_Item WHERE Dish_Name = '" + f.getFoodName() + "';");
				NF.next();
				f.setUserId(NF.getInt("ID"));
			} else {
				//update it
				String updateStmt = "UPDATE Food_Item SET Dish_Name = '"+f.getFoodName()+"' , Price = " + f.getPrice() + " , Ingreadents = '" + f.getIngredients()
									+ "' WHERE ID = " + f.getUserId() + ";";
				setData(updateStmt);
			}
		} catch (SQLException e) {
			System.err.println("Error in setFoodItem");
			e.printStackTrace();
		}
	}	

	//Adds/updates a food item to the database
	public void addCoupon(Coupon c, User u) {
		//add new Coupon record
		String insertStmt = "INSERT INTO Coupons (Amount,User_ID) Values (5.0,"+u.getUserId()+");";
		setData(insertStmt);
	}
	
	//Deletes a coupon from the database
	public void removeCoupon(Coupon c, User u) {
		//delete coupon record
		String delStmt = "DELETE FROM Coupons WHERE ID = " + c.getId() + ";";
		setData(delStmt);
	}
	
	//Returns a new user obj from the database, searched by email.
	public User getUser(String email, String password) {
		//search database for user by email
		String stmt = "SELECT * FROM User WHERE Email = '" + email + "' AND Password = '" + password + "';";
		ResultSet r = getData(stmt);
		User u = null;
		try {
			//move to first data point
			if(r.next() == false) {//if result set is of size zero
				return null;//user does not exist
			}
			//add in data
			u = new User(r.getString("UserName"), r.getString("Email"), r.getString("Password"));//make new user obj
			u.setUserId(r.getInt("ID"));
		} catch(SQLException e) {
			System.err.println("Error in getUser");
			e.printStackTrace();
		}
		return u;
	}
	
	//Returns a new user obj from the database, searched by email.
	public Customer getCustomer(String email, String password) {
		Customer u = null;
		try {
			//search database for user by email
			String stmtCust = "SELECT * FROM User WHERE Role = 0 AND Email = '" + email + "' AND Password = '" + password + "';";
			ResultSet cust = getData(stmtCust);
			
			//move to first data point
			if(cust.next() == false) {//if result set is of size zero
				return null;//user does not exist
			}
			//add in data
			u = new Customer(cust.getString("UserName"), cust.getString("Email"), cust.getString("Password"));//make new customer obj
			u.setUserId(cust.getInt("ID"));
			//set customer's payment info and coupons
			u.setCard(getPaymentInfo(u));
			u.setCoupon(getCoupons(u));

			//get the coustomer's cart
			u.setCart(getCarts(u));
			u.pastOrders = u.getCart().size();

		} catch(SQLException e) {
			System.err.println("Error in getCustomer");
			e.printStackTrace();
		}
		return u;
	}
	
	//Returns a new user obj from the database, searched by email.
	public Manager getManager(String email, String password) {
		//search database for user by email
		String stmt = "SELECT * FROM User WHERE Role = 1 AND Email = '" + email + "' AND Password = '" + password + "';";
		ResultSet r = getData(stmt);
		Manager u = null;
		try {
			//move to first data point
			if(r.next() == false) {//if result set is of size zero
				return null;//user does not exist
			}
			//add in data
			u = new Manager(r.getString("UserName"), r.getString("Email"), r.getString("Password"));//make new user obj
			u.setUserId(r.getInt("ID"));
			u.menu = getMenu("Breakfast");		//TODO manuly getting menu, if more menus are added change this to a search and add menu[] arg
		} catch(SQLException e) {
			System.err.println("Error in getManager");
			e.printStackTrace();
		}
		return u;
	}
	
	//Returns a new menu obj from the database, searched by name.
	public Menu getMenu(String menuName) {
		//search database for menu by name
		String menuStmt = "SELECT * FROM Menu WHERE Name = '" + menuName + "';";
		ResultSet m = getData(menuStmt);
		Menu menu = null;
		try {
			if(m.next() == false) {
				return null;
			}
			int menuID = m.getInt("ID");
			menu = new Menu(m.getString("Name"));
			menu.setUserId(menuID);

			//get each food item with that menuID
			String foodStmt = "SELECT * FROM Food_Item WHERE Menu_ID = " + menuID + ";";
			ResultSet foods = getData(foodStmt);
			while(foods.next()) {
				foodItem f = new foodItem(foods.getString("Dish_Name"), foods.getString("Ingreadents"), foods.getDouble("Price"));
				f.setUserId(foods.getInt("ID"));
				menu.addFoodItem(f);
			}
		} catch(SQLException e) {
			System.err.println("Error in getMenu");
			e.printStackTrace();
		}
		return menu;
	}
	
	//Returns a new food item obj from the database, searched by name.
	public foodItem getFoodItem(String name) {
		//search database for foodItem by name
		String foodStmt = "SELECT * FROM Food_Item WHERE Dish_Name = '" + name + "';";
		ResultSet foods = getData(foodStmt);
		foodItem f = null;
		try {
			if(foods.next() == false) {
				return null;
			}
			//convert to foodItem
			f = new foodItem(foods.getString("Dish_Name"),foods.getString("Ingreadents"), foods.getDouble("Price"));
			f.setUserId(foods.getInt("ID"));
		} catch (SQLException e) {//add in data
			System.err.println("Error in getFoodItem");
			e.printStackTrace();
		}
		return f;
	}
	
	//gets any coupon(s) that a user may have.
	public ArrayList<Coupon> getCoupons(User u) {
		//search database for coupons by user_id
		String couponStmt = "SELECT * FROM Coupons WHERE User_ID = " + u.getUserId() + ";";
		ResultSet coupons = getData(couponStmt);
		ArrayList<Coupon> c = new ArrayList<>();
		try {
			while(coupons.next()) {
				Coupon cou = new Coupon();
				cou.haveCoupon = true;
				cou.setUserId(u.getUserId());
				cou.setId(coupons.getInt("ID"));
				c.add(cou);
			}
		} catch (SQLException e) {//add in data
			System.err.println("Error in getCoupons");
			e.printStackTrace();
		}
		return c;
	}
	
	//Returns a payment info obj, searched by user.
	public Payment getPaymentInfo(User u) {
		//search database for userID by email
		String userStmt = "SELECT * FROM User WHERE ID = " + u.getUserId() + ";";
		ResultSet user = getData(userStmt);
		Payment p = null;
		try {
			if(user.next() == false) {
				return null;
			}
			//add in data
			p = new Payment(user.getInt("CardNum"), user.getInt("CCV"), user.getInt("EXPDate"));
		} catch (SQLException e) {
			System.err.println("Error in getPaymentInfo");
			e.printStackTrace();
		}
		return p;
	}
	
	//gets all carts for a customer
	public ArrayList<Cart> getCarts(Customer u) {
		String cartStmt = "SELECT * FROM 'Order' WHERE User_ID = " + u.getUserId() + ";";
		ResultSet carts = getData(cartStmt);
		ArrayList<Cart> orders = new ArrayList<>(); 
		try {
			//for each cart
			while(carts.next()) {
				Cart c = new Cart();//make a cart obj
				c.setUserId(carts.getInt("ID"));//set its ID 
				c.totalPrice = carts.getDouble("Price");
				//get all transactions for this order
				String transactionStmt = "SELECT * FROM 'Transaction' WHERE Order_ID = " + carts.getInt("ID") + ";";
				ResultSet trans = getData(transactionStmt);
				//for each transaction
				while(trans.next()) {
					c.quantity.add(trans.getInt("Quantity"));//add the number of this food item bought
					String foodStmt = "SELECT * FROM Food_Item WHERE ID = " + trans.getInt("Dish_ID") + ";";
					ResultSet food = getData(foodStmt);
					food.next();
					foodItem f = new foodItem(food.getString("Dish_Name"),food.getString("Ingreadents"), food.getDouble("Price"));
					f.setUserId(food.getInt("ID"));
					c.foods.add(f);//add food to cart
				}
				orders.add(c);
			}
		} catch (SQLException e) {
			System.err.println("Error in getCarts");
			e.printStackTrace();
		}
		
		return orders;
	}
	
	private void setData(String stmt) {
		try {
			PreparedStatement pstmt = conn.prepareStatement(stmt);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.err.println("ERROR: SQL set Statement failed\nQuerry: "+stmt+"\n\nFull Trace:");
			e.printStackTrace();
		}
		return;
	}
	
	private ResultSet getData(String stmt) {
		ResultSet r;
		try {
			PreparedStatement pstmt = conn.prepareStatement(stmt);
			r = pstmt.executeQuery();
		} catch (SQLException e) {
			System.err.println("ERROR: SQL get Statement failed\nQuerry: "+stmt+"\n\nFull Trace:");
			e.printStackTrace();
			return null;
		}
		return r;
	}

}
