public class TreeQueue {

	public static TreeNode root;
	public static TreeNode head;
	public static TreeNode tail;

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
		System.out.println ("This program will create a binary tree with six ints and print them out in a queue.");
		System.out.println ();

		createTree ();
		printNodes ();
	}

	private static void createTree () {
		int count = 0;
		root = null;

		while (count <= 6) {
			int number = (int)(Math.random () * 100);
			System.out.println (number);
			treeInsert (number);
			count ++;
		}
	}

	private static void treeInsert (int n) {
		if (root == null) {
			root = new TreeNode (n);
			enqueue (n);
			return;
		}
		if (root.left == null) {
			root.left = new TreeNode (n);
			enqueue (n);
		}
		else {
			root.right = new TreeNode (n);
			enqueue (n);
			root = root.left;
		}
	}

	private static void enqueue (int n) {
		TreeNode newTail = new TreeNode ();
		newTail.item = n;

		if (head == null) {
			head = newTail;
			tail = newTail;
		}
		else {
			tail.next = newTail;
			tail = newTail;
		}
	}

	private static void printNodes () {
		if (head == null) {
			throw new IllegalStateException ("Queue is empty.");
		}
		while (true) {
			int firstItem = head.item;
			head = head.next;
			
			if (head == null) {
				break;
			}
			System.out.print (firstItem + " ");
		}
		System.out.println ();
	}
}