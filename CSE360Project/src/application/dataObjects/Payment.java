package application.dataObjects;

public class Payment extends Customer{
    
    private Integer cardNumber;
    private Integer ccv;
    private Integer expDate;
    
    public Payment(Integer cardNumber, Integer ccv, Integer expDate) {
    	super(name, email, password);
    	this.cardNumber = cardNumber;
    	this.ccv = ccv;
    	this.expDate = expDate;
    }

    public void addCardNumber(Integer newCard){
        this.cardNumber = newCard;
    }
    public void addCcv(Integer newCcv){
        this.ccv = newCcv;
    }
    public void addExpDate(Integer newExp){
        this.expDate = newExp;
    }
    public String toString() {
    	return("Card Number: " + cardNumber + "\nCCV: "+ ccv+
    			"\nExpiration Date: " + expDate);
    }
}
