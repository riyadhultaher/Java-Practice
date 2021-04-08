public class WordQuestion implements IntQuestion {

    private int question;  // The numbers in the problem.

    public WordQuestion() { // constructor
        
        question = (int)(Math.random() * 2);
    }

    public String getQuestion() {
       
        switch (question) {

            case 0 :
            return "What is the meaning of the world?";

            default :
            return "What is the Master Chief's number?";
        }
    }

    public int getCorrectAnswer() {
       
        switch (question) {

            case 0 :
            return 42;

            default :
            return 117;
        }
    }
}

