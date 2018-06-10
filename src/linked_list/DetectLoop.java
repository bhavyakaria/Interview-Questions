/*
 * Flyods Cycle Detection Algorithm is used to detect the loop in the Linked List.
 *
 * For Detection of Loop:
 * 1. Start two pointers(Slow and Fast) from head
 * 2. Slow moves 1 step per iteration and Fast moves 2 steps per iteration
 * 3. If they meet then there is loop or else no loop.
 *
 * For Detecting starting Point of Loop:
 * 1. Start one pointer from head and one from position previous(Slow and Fast) pointer met.
 * 2. Move both pointer 1 step per iteration 
 * 3. The point they meet is the starting point of the loop
 *
 * For Removing the Loop:
 * 1. Add a counter in while(ptr1 == ptr2) of Detecting  loop and multiple it by 2
 *    (As the distance covered by ptr1 will be half)
 * 2. Iterate till counter > 0
 * 3. Make the node.next = null
 */

package linked_list;

/**
 *
 * @author Parzival
 */
public class DetectLoop {
    
    static Node head;
    static Node slow2, start;
    static int count=1;
    
    public static void main(String[] args) {
        DetectLoop dl = new DetectLoop();
        
        Node n1 = new Node(20);
        Node n2 = new Node(50);
        Node n3 = new Node(40);
        Node n4 = new Node(60);
        Node n5 = new Node(30);
        Node n6 = new Node(10);
        Node n7 = new Node(80);
        
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;
        n7.next = n3;
        dl.head = n1;
        
        if (isloop(dl.head)) {
            System.out.println("Loop Present");
            start = startingLoopPoint(dl.head);
            System.out.println("Starting Point: "+start.data);
        } else {
            System.out.println("Loop Not Present");
        }
        RemoveLoop();
        if (isloop(dl.head)) {
            System.out.println("Loop Present");
            start = startingLoopPoint(dl.head);
            System.out.println("Starting Point: "+start.data);
        } else {
            System.out.println("Loop Not Present");
        }
    }

    private static boolean isloop(Node head) {
        Node slowptr = head;
        Node fastptr = head;
        
        // fastptr.next condition is required because if its null and yet we move then 
        // we will get NPE at fastptr.next.next
        while (fastptr != null && fastptr.next != null) {
            slowptr = slowptr.next;
            fastptr = fastptr.next.next;

            if (slowptr == fastptr) {
                slow2 = slowptr;
                System.out.println("Node: "+slowptr.data);
                return true;
            }
        }

        return false;
    }

    private static Node startingLoopPoint(Node head) {
        Node ptr1 = head;
        Node ptr2 = slow2;
        
        while(true) {
            if(ptr1 == ptr2) {
                break;
            }
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
            count++;
        }
        return ptr1;
    }
    
    private static void RemoveLoop() {
        
        int total = count*2;
        while(total > 0) {
            head = head.next;
            total--;
        }
        head.next = null;
        //System.out.println("Total: "+ptr.data);
    }
}