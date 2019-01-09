import java.io.Serializable;

public class Product implements Serializable{
	

	private static final long serialVersionUID = 1L;
	
	public static void clearscreen() {
		System.out.print('\u000c');
	}
	private String name;
	private int amount;
	private double price; // the price is for 1 amount 
	public String toString(){
	return amount + " " + name + " " + amount*price;
	}
	public void setName (String x){
	name=x;	
	}
	public String getName (){
		return name;
	}
	public void setAmount (int x) {
	if (x>1)  amount=x;
	else	amount=1;
	}
	public int getAmount () {
		return amount;
	}
	public void setPrice (double x) {
		if (x>0) price=x;
		else price=0;
	}
	public double getPrice () {
		return price ;
	}
}