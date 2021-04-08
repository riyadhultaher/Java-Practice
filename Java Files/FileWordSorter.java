import java.util.*;
import textio.TextIO;

public class FileWordSorter {

	public static void main (String [] args) {

		ArrayList <String> wordList;
		String currentWord;
		int i;
		int j;

		wordList = new ArrayList <String> ();

		System.out.println ("This program will read a text file and rearrange the words to be in alphabetical order.");
		System.out.println ();


		try {

			TextIO.readFile ("FileWordSorterText.txt");
		}
	
		catch (IllegalArgumentException e) {

			System.out.println ("Unable to read file.");
			System.exit (1);
		}
	
		do {

			currentWord = readNextWord ();
			
			if (wordList.indexOf (currentWord) == -1) {
			
				wordList.add (currentWord);
			}
		
		} while (currentWord != null);
	
		wordList.remove (wordList.size () - 1);


		for (i = wordList.size () - 1; i > 0; i --) {

			String temp;
				
			
			for (j = 0; j < wordList.size (); j ++) {


				if (wordList.get (j).compareToIgnoreCase (wordList.get (i)) > 0) {

					temp = wordList.get (j);
					wordList.set (j, wordList.get (i));
					wordList.set (i, temp);
				}
			}
		}

		for (String word : wordList) {

			System.out.println (word);
		}
	}

	private static String readNextWord () {
   		
   		char ch = TextIO.peek ();
   		

   		while (ch != TextIO.EOF && ! Character.isLetter (ch)) {
          
      		TextIO.getAnyChar();
      		ch = TextIO.peek();
  		}
   
   		if (ch == TextIO.EOF) {
      
      		return null;
   		}
   
   		String word = "";
   		

   		while (true) {
      		
      		word += TextIO.getAnyChar ();
      		ch = TextIO.peek ();
      		

      		if ( ch == '\'' ) {
            
         		TextIO.getAnyChar ();
         		ch = TextIO.peek ();
         	
         		
         		if (Character.isLetter (ch)) {
            	
            		word += "\'" + TextIO.getAnyChar ();
            		ch = TextIO.peek ();
         		}
         		
         		else {
            		
            		break;
	      		}
      		}			
      
      		if ( ! Character.isLetter (ch) ) {
            
         		break;
      		}
      
   		}
   
   		return word;
	}
}