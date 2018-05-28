/*
 * Find the middle element of the Linked List
 * 
 * Approach 1:
 * 1. Set two pointers at head
 * 2. Move 1st pointer 1 step at a time and 2nd pointer 2 steps at a time 
 * 3. By the time 2nd pointer reaches the end. 1st pointer will be pointing the middle element.
 * 
 * Approach 2:
 * 1. Count total number of nodes and divide it by 2
 *
 *
 * Time Complexity: O(n/2) (Correct me if wrong)
 */
package linked_list;

/**
 *
 * @author Parzival
 */
public class MiddleOfLinkedList {
    static Node head;
    
    public static void append(int value) {
        Node newNode = new Node(value);
        
        if(head == null) {
            head = newNode;
            return;
        }
        Node current = head; 
        while(current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }
    
    public static void middleElement() {
        Node slow = head;
        Node fast = head;
        
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        System.out.println("Middle Element: "+slow.data);
    }
    
    public static void main(String[] args) {
        MiddleOfLinkedList ml = new MiddleOfLinkedList();
        
        // create a list 10->20->30->40->50
        ml.append(10);
        ml.append(20);
        ml.append(30);
        ml.append(40);
        ml.append(50);
        ml.middleElement();
    }
}

// Output
// Middle Element: 30
