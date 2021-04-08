import textio.TextIO;

public class CountTheChange {
	
	public static void main (String [] args) {

		int quarters;
		int dimes;
		int nickels;
		int pennies;
		double total;

		System.out.println("How many quarters do you have?");
		quarters = TextIO.getlnInt();
		System.out.println("How many dimes do you have?");
		dimes = TextIO.getlnInt();
		System.out.println("How many nickels do you have?");
		nickels = TextIO.getlnInt();
		System.out.println("How many pennies do you have?");
		pennies = TextIO.getlnInt();

		total = (quarters * 0.25) + (dimes * 0.10) + (nickels * 0.05) + (pennies * 0.01);

		System.out.println("You have $" + total + " in total change.");
	}
}