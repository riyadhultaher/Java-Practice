import textio.TextIO;

public class BirthdayProblem {

    public static void main(String[] args) {

        boolean[] used;
        int count;
        int match;

        used = new boolean[365];
        count = 0;
        match = 0;

        
        while (match != 3) {
             
            int birthday;
            birthday = (int)(Math.random()*365);
            count++;

            System.out.printf("Person %d has birthday number %d%n", count, birthday);

           
            if (used[birthday]) {  
                    
                match ++;
            }

            used[birthday] = true;

        }

        System.out.println();
        System.out.println("A three person birthday was found after " + count + " tries.");
    }

}