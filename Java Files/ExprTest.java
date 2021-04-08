import textio.TextIO;

public class ExprTest {

    public static void main (String [] args) {

        String input;
        Expr expression;
        double num;
        double result;

        expression = null;

        System.out.println ("This program will allow you to enter a mathematical expression and have it evaluated.");
        System.out.println ("The parameters of a function must be enclosed with a parentheses.");
        System.out.println ("The main operation of this program is to find the value of x.");
        System.out.println ("If x cannot be evaluated then Undefined will be returned.");
        System.out.println ();


        while (true) {

            System.out.println ("Please enter an expression.");
            input = TextIO.getln ();


            if (input.length () == 0) {

                break;
            }
            
            try {

                 expression = new Expr (input);
            }
        
            catch (IllegalArgumentException e) {

                System.out.println ("Unable to process.");
                System.out.println (e.getMessage ());
                continue;
            }
        
            System.out.println ("Please input a value(s) for x. Press return to end.");
            

            while (true) {

                input = TextIO.getln ();


                if (input.length () == 0) {

                    break;
                }
            
                try {

                    num = Double.parseDouble (input);
                }
           
                catch (NumberFormatException e) {

                    System.out.println ("That is not a legal number.");
                    continue;
                }
            
                result = expression.value (num);


                if (Double.isNaN (result)) {

                    System.out.println ("Undefined.");
                }
            
                else {

                    System.out.println (result);
                }
            }
        }
    }
}