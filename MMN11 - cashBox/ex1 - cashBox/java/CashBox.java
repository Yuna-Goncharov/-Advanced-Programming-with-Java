import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CashBox implements Serializable {
	
	private static final long serialVersionUID = 1L;
	public static void claerscreen () {
		System.out.print ("\u000c");
	}
	private List<Product> Productarry;
	private double totalsum;
	public CashBox () {
	 Productarry=new ArrayList<Product>();
	}
	public void addproduct (Product product) {
		Productarry.add(product);
			
		}
	public String toString(){
		String total ="\n";
		Iterator<Product> i = Productarry.iterator();
		while (i.hasNext()){
			Product x =(Product) i.next();
			total = total + x.toString();
		}
		return total;
	}
	public void settotalsum () {
	totalsum = 0;
	}
	public void settotalsum (double x) {
		totalsum = x;
		}
	
	public double paymant () {
		double paymant =0;
		Iterator<Product> i = Productarry.iterator();
		while (i.hasNext()){
			Product x =(Product) i.next();
			paymant = paymant + x.getAmount()*x.getPrice();
		}
		return paymant;
	}
	public double gettotalsum(){
		return totalsum;
		}
	public double charge (double z) {
		double x = gettotalsum();
		double y = paymant();
		double change = 0;
		double charge =z ;
        Productarry.clear();
		x=x+y;
		change=charge-y;
		settotalsum(x);
		return change;
	}
	
}

