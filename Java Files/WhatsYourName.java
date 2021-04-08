import textio.TextIO;

public class WhatsYourName {
	
	public static void main (String [] args) {

		String userName;
		int nameSpace;
		String firstName;
		String lastName;
		char firstInitial;
		char lastInitial;

		System.out.println("Please enter your first name and last name, separated by a space.");
		userName = TextIO.getln();

		nameSpace = userName.indexOf(' ');
		firstName = userName.substring(0,nameSpace);
		lastName = userName.substring(nameSpace + 1);

		firstInitial = firstName.charAt(0);
		lastInitial = lastName.charAt(0);

		System.out.println("Your first name is " + firstName + ", which has " + firstName.length() + " characters");
		System.out.println("Your last name is " + lastName + ", which has " + lastName.length() + " characters");
		System.out.println("Your initials are " + firstInitial + lastInitial);
	}
}