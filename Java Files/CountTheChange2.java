import textio.TextIO;

public class CountTheChange2 {

	public static void main (String [] args) {

		double quarters;
		double dimes;
		double nickels;
		double pennies;
		double total;

		System.out.println("How many quarters do you have?");
		quarters = TextIO.getlnInt();
		System.out.println("How many dimes do you have?");
		dimes = TextIO.getlnInt();
		System.out.println("How many nickels do you have?");
		nickels = TextIO.getlnInt();
		System.out.println("How many pennies do you have?");
		pennies = TextIO.getlnInt();

		quarters *= 0.25;
		dimes *= 0.10;
		nickels *= 0.05;
		pennies *= 0.01;

		total = quarters + dimes + nickels + pennies;

		System.out.print("Your total amount of money is $");
		System.out.printf("%1.2f" , total);
		System.out.println();
	}
}