/*
 * Add two numbers represented by Linked List.
 * Input:
 * First List: 5->6->3  // represents number 365
 * Second List: 8->4->2 //  represents number 248
 * Output
 * Resultant list: 3->1->6  // represents number 613
 * 
 * Approach:
 * 1. Loop till either list not null
 * 2. add nodes from both list
 * 3. Update the carry and sum
 * 4. Store the sum in temp node 
 */
package linked_list;

/**
 *
 * @author Parzival
 */
public class AddTwoNumbers {
    static Node head1,head2;
    
    // Add the node in the beginning
    public static void prepend(Node head,int value) {
        Node newNode = new Node(value);
        
        if(head == null) {
            head = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }
    
    // Print the Linked List
    public static void display(Node head) {
        Node current = head;
        while(current.next != null) {
            System.out.print(current.data+" ");
            current = current.next;
        }
        System.out.print(current.data);
    }
    
    
    public static void main(String[] args) {
        AddTwoNumbers a1 = new AddTwoNumbers();
        
        // Linked List 1
        a1.head1 = new Node(5);
        a1.head1.next = new Node(2);
        a1.head1.next.next = new Node(1);
        // Linked List 2
        a1.head2 = new Node(6);
        a1.head2.next = new Node(5);
        a1.head2.next.next = new Node(4);
        
        a1.display(head1);
        System.out.println("");
        a1.display(head2);
        System.out.println("");
        Node result = a1.addTwoNumbers(head1, head2);
        a1.display(result);
        System.out.println("");
    }

    private Node addTwoNumbers(Node first, Node second) {
        Node result = null;
        Node prev = null; 
        Node temp = null;
        int carry = 0, sum;
        
        while(first != null || second != null) {
            
            // If List are of different sizes then we will add zero to it.
            sum = carry + (first != null?first.data:0)+(second != null?second.data:0);
            
            // If addition is greater than 10 then we will make carry 1 and reduce the sum.
            carry = (sum>=10)?1:0;
            sum = sum%10;
            
            // Store the added value in temp node.
            temp = new Node(sum);
            
            if(result == null) {
                result = temp;
            } else {
                prev.next = temp;
            }
            prev = temp;
            
            // Check if node null or not.
            if(first != null) {
                first = first.next;
            }
            if(second != null) {
                second = second.next;
            }
        }
        // If in the end there is carry then directly append. 
        if(carry > 0) {
            temp.next = new Node(carry);
        }
        return result;
    }
}
