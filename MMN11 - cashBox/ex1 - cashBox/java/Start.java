import java.util.Scanner;

public class Start {
	public static void claerscreen () {
		System.out.print ("\u000c");
	}
	static CashBox cash = new CashBox ();
	static Scanner in = new Scanner (System.in);
	static boolean running = true;
	private static Product x;
	
	
	public static void main (String[] args) {
		while (running) {
			
			System.out.println("\nEnter 0 for check/change money in the cashbox"
							+ "\nEnter 1 for start adding item to the list"
							+ "\nEnter 2 for the list of item "
							+ "\nEnter 3 for paymant"
							+ "\nEnter 4 for check out");
			int answer = in.nextInt();
			switch (answer){
			case 0:
				System.out.println("Enter 0 for check and 1 for change");
				int x = in.nextInt();
				CheckOrChange(x);
			break;
			case 1:
				addItem();
			break;
			case 2:
				System.out.println(cash.toString());	
			break;
			case 3:
				Paymant();
			break;
			case 4:
				System.out.println(cash.gettotalsum());
				running=false;
			break;	
			}
			 System.exit(0);
		}
	
	}

	private static void Paymant() {
		System.out.println("the paymant is" + cash.paymant());	
		double x = in.nextDouble();
while (x<cash.paymant()){
	System.out.println("need" + x+cash.paymant() + "maney");
x=x+in.nextDouble();
}
System.out.println(cash.toString()+ "\n" + cash.paymant());
System.out.println(cash.charge(x));
	}


	private static void addItem() {
	
		boolean add = true;
		while(add){
		x = new Product ();
		System.out.println("Enter the name of the item");
		x.setName( in.next());
		System.out.println("Enter the amount of the item");
		x.setAmount(in.nextInt());
		System.out.println("Enter the price of the item");
		x.setPrice( in.nextDouble());
		
		cash.addproduct(x);
		System.out.println("Enter 1 to add more");
		if (!(in.nextInt()==1))
		add=false;
		}
		
	}


	private static void CheckOrChange(int answer) {
	
		if (answer == 0)
				System.out.println(cash.gettotalsum());
		else 
			System.out.println("Enter amount of maney");
		cash.settotalsum(in.nextDouble());
		
	}
	
}

