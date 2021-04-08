import textio.TextIO;

public class Arithmetic {
	
	public static void main (String [] args) {

		double firstNumber;
		double secondNumber;
		char expression;
		double result;

		System.out.println("This program does basic arithmetic.");


		while (true) {
			
			result = 0;

			System.out.println("Please enter the first number or enter 0 if you no longer wish to proceed.");
			firstNumber = TextIO.getDouble();


			if (firstNumber == 0) {

				System.out.println("Goodbye.");
				break;
			}

			System.out.println("Please enter the expression.");
			expression = TextIO.getChar();


			while ( ! (expression == '+' || expression == '-' || expression == '*' || expression == '/')) {

				System.out.println("That is not a valid expression. Please try again.");
				expression = TextIO.getChar();
			}
			
			System.out.println("Enter the second number.");
			secondNumber = TextIO.getDouble();

			
			switch (expression) {

				case '+' :
					result = firstNumber + secondNumber;
					break;

				case '-' :
					result = firstNumber - secondNumber;
					break;

				case '*' :
					result = firstNumber * secondNumber;
					break;

				case '/' :
					result = firstNumber / secondNumber;
					break;
			}	
		
			System.out.println("Your result is " + result);

		}
	
	}

}