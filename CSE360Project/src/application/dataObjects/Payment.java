package application.dataObjects;

public class Payment {

    private Integer cardNumber;
    private Integer ccv;
    private Integer expDate;

    public Payment(Integer cardNumber, Integer ccv, Integer expDate) {
    	this.cardNumber = cardNumber;
    	this.ccv = ccv;
    	this.expDate = expDate;
    }

//    public void updatePaymentInfo(){
//    	setCardNumber(cardNumber);
//    	setCcv(ccv);
//    	setExpDate(expDate);
//    }

    public void setCardNumber(Integer cardNum){
    	this.cardNumber = cardNum;
    }

    public void setCcv(Integer ccvNum){
    	this.ccv = ccvNum;
    }

    public void setExpDate(Integer date){
    	this.expDate = date;
    }

    public Integer getCardNumber() {
    	return cardNumber;
    }

    public Integer getCcv() {
    	return ccv;
    }

    public Integer getExpDate() {
    	return expDate;
    }

    @Override
	public String toString() {
    	return("Card Number: " + cardNumber + "\nCCV: "+ ccv+
    			"\nExpiration Date: " + expDate);
    }
}
