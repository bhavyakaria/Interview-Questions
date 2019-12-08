/*
 * Reversing the Linked List
 */

/**
 *
 * @author Parzival
 */
public class ReverseLinkedList {
	static Node head;

	ReverseLinkedList() {
		head = null;
	}

	private static void reverseLinkedList() {
		Node current = head;
		Node prev = null;
		Node next = head.next;

		while (current != null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		head = prev;
	}

	public static void append(int value) {
		Node newNode = new Node(value);

		if (head == null) {
			head = newNode;
			return;
		}

		Node currentNode = head;
		while (currentNode.next != null) {
			currentNode = currentNode.next;
		}
		currentNode.next = newNode;
	}

	// Print the Linked List
    public static void display() {

        System.out.println("");
        Node current = head;
        while(current.next != null) {
            System.out.print(current.data+" ");
            current = current.next;
        }
        System.out.print(current.data);
    }

	public static void main(String[] args) {
		ReverseLinkedList list = new ReverseLinkedList();

		list.append(10);
		list.append(20);
		list.append(30);
		list.append(40);

		display();
		reverseLinkedList();
		display();

	}

}