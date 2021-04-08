import textio.TextIO;

/* 
* This program does basic arithmetic. More specifically it will do addition,
* subtraction, multiplication, and division. It will ask the user to specify the 
* numbers to perform as well as the expression of the arithmetic.You can perform the 
* arithmetic on numbers with decimals but you can only perform the arithmetic on two 
* numbers at a time. The program ends when the user enters 0 as the first number.
*/

public class ArithmeticMethods {

	/*
	* Preconditions: User is able to input numbers and expressions.
	* Postconditions: Program will display the result of the numbers 
	* that were input to perform. The program will end when the user
	* inputs 0 as their first number.
	*/

	public static void main (String [] args) {

		double resultOfArithmetic;
		boolean tryAgain;

		resultOfArithmetic = 0;
		tryAgain = false;

		System.out.println ("This program does basic arithmetic. It will add, subtract, multiply, and divide any number, even with decimals, you input. The program will only do this with two numbers at a time.");


		while (true) {

			resultOfArithmetic = computeArithmeticViaProvidedInput (resultOfArithmetic);


			if (resultOfArithmetic == 0) {

				System.out.println ("Goodbye.");
				break;
			}
		
			System.out.println ("Your result is " + resultOfArithmetic);
			System.out.println ();
			System.out.println ("Would you like to try again?");
			tryAgain = TextIO.getBoolean ();


			if (tryAgain == false) {

				System.out.println ("Goodbye.");
				break;
			}
		
			System.out.println ();

		}
	
		System.out.println ();

	}

	/*
	* Preconditions: User is able to input numbers and expressions.
	* Postconditions: This method will perform the necessary tasks to add, subtract,
	* multiply or divide. It will return the result to the main method. A variable named
	* roundedResult is returned which rounds the result to two decimal places.
	*/

	private static double computeArithmeticViaProvidedInput (double roundedResult) {

		double firstNumber;
		double secondNumber;
		char expression;
		double result;

		System.out.println("Please enter the first number or enter 0 if you no longer wish to continue.");
		firstNumber = TextIO.getDouble ();


		if (firstNumber == 0) {

			roundedResult = 0;
			return roundedResult;
		}
	
		System.out.println ("Please enter the expression.");
		expression = TextIO.getChar ();


		while (! (expression == '+') || (expression == '-') || (expression == '*') || (expression == '/')) {

			System.out.println ("Invalid expression. Please try again.");
			expression = TextIO.getChar ();
		}

		System.out.println ("Please enter the second number.");
		secondNumber = TextIO.getDouble ();


		switch (expression) {

			case '+' :
			result = firstNumber + secondNumber;
			roundedResult = Math.round (result * 100.0) / 100.0;
			break;

			case '-' :
			result = firstNumber - secondNumber;
			roundedResult = Math.round (result * 100.0) / 100.0;
			break;

			case '*' :
			result = firstNumber * secondNumber;
			roundedResult = Math.round (result * 100.0) / 100.0;
			break;

			case '/' :
			result = firstNumber / secondNumber;
			roundedResult = Math.round (result * 100.0) / 100.0;
			break;
		}
		
		return roundedResult;
	}
}