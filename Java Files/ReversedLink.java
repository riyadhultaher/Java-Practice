import textio.TextIO;

public class ReversedLink {

    private static class ListNode {

        int item;
        ListNode next;
    }

    private static ListNode reverse (ListNode list) {

        ListNode rev = null;
        ListNode runner = list;

        while (runner != null) {

            ListNode newNode = new ListNode ();
            newNode.item = runner.item;
            newNode.next = rev;
            rev = newNode;
            runner = runner.next;
        }
    
        return rev;
    }

    private static void printList (ListNode start) {

        ListNode runner;
        runner = start;

        while (runner != null) {

            System.out.print (" " + runner.item);
            runner = runner.next;
        }
    }

    public static void main (String [] args) {

        ListNode list = null;
        ListNode reversedList;
        int count = 0;

        while (true) {

            printList (list);
            System.out.println ();
            reversedList = reverse (list);
            printList (reversedList);
            System.out.println ();
            count ++;

            if (count == 6) {

                break;
            }
            ListNode head = new ListNode ();
            head.item = (int)(Math.random () * 100);
            head.next = list;
            list = head;

        }
        
        System.out.println ();
    }
}