import textio.TextIO;

public class HowManyEggs {
	
	public static void main (String [] args) {

		int inputEggs;
		int grossEggs;
		int dozenEggs;
		int remainderEggs;
		int grossRemainder;

		System.out.println("How many eggs do you have?");
		inputEggs = TextIO.getInt();

		grossEggs = inputEggs / 144;
		grossRemainder = inputEggs % 144;
		dozenEggs = grossRemainder / 12;
		remainderEggs = grossRemainder % 12;

		System.out.println("Your number of eggs is " + grossEggs + " gross, " + dozenEggs + " dozen, and " + remainderEggs);
	}
}