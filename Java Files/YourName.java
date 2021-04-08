import textio.TextIO;

public class YourName {
	
	public static void main (String [] args) {

		String yourName;
		String upperCaseName;

		System.out.println("What is your name?");
		yourName = TextIO.getln();
		upperCaseName = yourName.toUpperCase();

		System.out.println("Hello, " + upperCaseName + ", nice to meet you!");
	}
}