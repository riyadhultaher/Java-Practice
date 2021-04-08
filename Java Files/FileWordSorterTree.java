import java.util.*;
import textio.TextIO;

public class FileWordSorterTree {

	public static TreeNode root;

	public static class TreeNode {
       
        String item;      
        TreeNode left;   
        TreeNode right;   
        
        TreeNode(String str) {

            item = str;
        }
    }  

	public static void treeInsert(String newItem) {
        
        if ( root == null ) {
               
            root = new TreeNode( newItem );
            return;
        }
        
        TreeNode runner;  
        runner = root;   
        
        while (true) {
           
            if ( newItem.compareTo(runner.item) < 0 ) {
              
                if ( runner.left == null ) {
                    
                    runner.left = new TreeNode( newItem );
                    return;  
                }
                else
                    
                    runner = runner.left;
            }
           
           else {
                    
                if ( runner.right == null ) {
                    
                    runner.right = new TreeNode( newItem );
                    return;  
                }
                else {
                    
                    runner = runner.right;
                }
            }
        } 
    }  

	 public static boolean treeContains( TreeNode root, String item ) {
        
        if ( root == null ) {
                
            return false;
        }
        else if ( item.equals(root.item) ) {
                
            return true;
        }
        else if ( item.compareTo(root.item) < 0 ) {
                
            return treeContains( root.left, item );
        }
        else {
                
            return treeContains( root.right, item );
        }
    }  

	 public static void treeList(TreeNode node) {
       
        if ( node != null ) {
            
            treeList(node.left);             
            System.out.println("  " + node.item);  
            treeList(node.right);            
        }
    } 

	public static void main (String [] args) {

		String item;
		int i;
		int j;

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

			boolean containsDuplicate;
			item = readNextWord ();
			
			if (item != null) {
				
				containsDuplicate = treeContains (root, item);

				if (containsDuplicate == false) {
					
					treeInsert (item);
				}
			}

		} while (item != null);
	
		treeList (root);
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