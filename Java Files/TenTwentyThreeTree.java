public class TenTwentyThreeTree {

	public static TreeNode root;

	public static class TreeNode {
		double item;
		TreeNode left;
		TreeNode right;

		TreeNode (double n) {
			item = n;
		}
	
		TreeNode () {
		}
	}
	
	public static void main (String [] args) {
		root = null;

		for (int i = 0; i < 1023; i ++) { 
			treeInsert (Math.random ());
		}

		int totalLeaves = countLeaves (root);
		int depthSum = averageDepth (root, 0);
		int depthMax = maxDepth (root, 0);
		double averageDepth = ((double)depthSum / totalLeaves);

		System.out.println (totalLeaves);
		System.out.println (averageDepth);
		System.out.println (depthMax);
	}

	private static void treeInsert (double newItem) {
		if (root == null) {
      		root = new TreeNode (newItem);
      		return;
   		}
   		TreeNode runner;
   		runner = root;
   		
   		while (true) {
      		if ( newItem < runner.item) {
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

	private static int countLeaves (TreeNode runner) {
		if (runner == null) {
			return 0;
		}
		else if (runner.left == null && runner.right == null) {
			return 1;
		}
		else {
			return countLeaves (runner.right) + countLeaves (runner.left);
		}
	}

	private static int averageDepth (TreeNode runner, int d) {
		if (runner == null) {
			return 0;
		}
		else if (runner.right == null && runner.left == null) {
			return d;
		}
		else {
			return averageDepth (runner.right, d + 1) + averageDepth (runner.left, d + 1);
		}
	}

	private static int maxDepth (TreeNode runner, int d) {
		if (runner == null) {
			return 0;
		}
		else if (runner.right == null && runner.left == null) {
			return d;
		}
		else {
			int leftMax = maxDepth (runner.left, d + 1);
			int rightMax = maxDepth (runner.right, d + 1);

			if (leftMax > rightMax) {
				return leftMax;
			}
			else {
				return rightMax;
			}
		}
	}
}