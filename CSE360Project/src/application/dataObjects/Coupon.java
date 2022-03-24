package application.dataObjects;

class Coupon extends Customer{

    public Boolean haveCoupon;

    public static void validCoupon(){
        if(pastOrders == 5) {
        	Coupon coupon = new Coupon();
        	coupons.add(coupon);
        	pastOrders = 0;
        }
    }

}


