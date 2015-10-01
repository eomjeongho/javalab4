package kr.ac.embedded.kookmin.sales;

/**
 * Class for a sale of one item with discount expressed as a percent of the
 * price, but no other adjustments. Class invariant: The price is always
 * nonnegative; the name is a nonempty string; the discount is always
 * nonnegative.
 */

public class DiscountSale extends Sale {
	private double	discount;	// A percent of the price. Cannot be negative.
								
	public DiscountSale() {
		discount = 0; 
	}
	
	/**
	 * Precondition: theName is a nonempty string; thePrice is nonnegative;
	 * theDiscount is expressed as a percent of the price and is nonnegative.
	 */
	public DiscountSale(String theName, double thePrice, double theDiscount) {
		this.setName(theName);
		this.setPrice(thePrice);
		this.discount = theDiscount;
	}
	
	public DiscountSale(DiscountSale originalObject) {
		this.setName(originalObject.getName());
		this.setPrice(originalObject.getPrice());
		this.discount = originalObject.discount;
	}
	
	public static void announcement() {
		System.out.println("This is the DiscountSale class.");
	}
	
	public double bill() {
		return (this.getPrice() - (this.getPrice()*this.discount/100));
	}
	
	public double getDiscount() {
		return this.discount; 
	}
	
	/**
	 * Precondition: Discount is nonnegative.
	 */
	public void setDiscount(double newDiscount) {
		this.discount = newDiscount;
	}
	
	public String toString() {
		return (getName() + " Price = $" + getPrice() + " Discount = " + discount + "%\n" + "   Total cost = $" + bill());
	}
	
	public boolean equals(Object otherObject) {
		if (otherObject == null)
			return false;
		else if (getClass() != otherObject.getClass())
			return false;
		else {
			Sale otherSale = (Sale) otherObject;
			return (this.getName().equals(otherSale.getName()) && (this.getPrice() == otherSale.getPrice()));
		}
	}
	
	
	public DiscountSale clone() {
		return new DiscountSale(this);
	}
}
