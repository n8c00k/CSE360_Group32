package application.dataObjects;

class Coupon {
	
    public Boolean haveCoupon;
    
	public Coupon() {
			
		}
	
	
    public static void validCoupon(){
        if(Customer.pastOrders == 5) {
        	Coupon coupon = new Coupon();
        	Customer.coupons.add(coupon);
        	Customer.pastOrders = 0;
        }
    }

}


