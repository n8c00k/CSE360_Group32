package application.dataObjects;

public class User {
    
    protected static Integer userId;
    protected static String name;
    protected static String email;
    protected static String password;
    
    public User(String name, String email, String password) {
    	this.name = name;
    	this.email = email;
    	this.password = password;
    }

    public void updateProfile(){

    }
    // public void setId(Integer x){}

    public void setName(String newName){
        this.name = newName;
    }
    public void setEmail(String newEmail){
        this.email = newEmail;
    }
    public void setPassword(String newPass){
        this.password = newPass;
    }

}
