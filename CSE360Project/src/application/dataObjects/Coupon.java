package application.dataObjects;

public class Coupon {

    public Boolean haveCoupon;
    public Integer userId;
    public Integer Id;

	public Coupon() {

		}
	
	public Integer getUserId() {
    	return userId;
    }
	
	public void setUserId(Integer x){
    	this.userId = x;
    }
	
	public Integer getId() {
    	return Id;
    }
	
	public void setId(Integer x){
    	this.Id = x;
    }

//    public static void validCoupon(){
//        if(Customer.pastOrders == 5) {
//        	Coupon coupon = new Coupon();
//        	Customer.coupons.add(coupon);
//        	Customer.pastOrders = 0;
//        }
//    }
	

}


