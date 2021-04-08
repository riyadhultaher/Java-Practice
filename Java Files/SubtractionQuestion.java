public class SubtractionQuestion implements IntQuestion {

	private int a, b;  // The numbers in the problem.
	private int difference;

    public SubtractionQuestion() { // constructor
        
        do {
        	
        	a = (int)(Math.random() * 50 + 1);
       	 	b = (int)(Math.random() * 50);
        	difference = a - b;
       
        } while (difference < 0);
    }

    public String getQuestion() {
        return "What is " + a + " - " + b + " ?";
    }

    public int getCorrectAnswer() {
        return a - b;
    }
}