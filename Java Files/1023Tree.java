public class 1023Tree {

	public static class TreeNode {
		int item;
		TreeNode left;
		TreeNode right;
		TreeNode next;

			TreeNode (int n) {
			item = n;
		}
	
		TreeNode () {
		}
	}
	
	public static void main (String [] args) {
		int depth = 0;

	}

	private static void createTree () {
		int count = 0;
		root = null;

		while (count <= 1023) {
			int number = (int)(Math.random () * 100);
			treeInsert (number);
			count ++;
		}
	}

	private static void treeInsert (int newItem) {
		if (root == null) {
      		root = new TreeNode (newItem);
      		return;
   		}
   		TreeNode runner;
   		runner = root;
   		
   		while (true) {
      		if ( newItem.compareTo (runner.item) < 0 ) {
         		if ( runner.left == null ) {
            		runner.left = new TreeNode (newItem);
            		return;
         		}
        		else {
        			runner = runner.left;
      			}
      		}
      		else {      
        		if (runner.right == null) {
            		runner.right = new TreeNode (newItem);
            		return;
         		}
        		else {
            		runner = runner.right;
      			}
      		}
   		}
	}
}