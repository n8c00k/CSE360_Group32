package application.dataObjects;

public class User {
    
    protected Integer userId;
    protected String name;
    protected String email;
    protected String password;
    
    
    public User( String name, String email, String password) {
    	this.name = name;
    	this.email = email;
    	this.password = password;
    }

    public void updateProfile(){
    	setUserId(userId);
    	setName(name);
    	setEmail(email);
    	setPassword(password);
    }
    public void setUserId(Integer x){
    	this.userId = x;
    }

    public void setName(String newName){
        this.name = newName;
    }
    
    public void setEmail(String newEmail){
        this.email = newEmail;
    }
    
    public void setPassword(String newPass){
        this.password = newPass;
    }
    
    public Integer getUserId() {
    	return userId;
    }
    
    public String getName() {
    	return name;
    }
    
    public String getEmail() {
    	return email;
    }
    
    public String getPassword() {
    	return password;
    }

}
