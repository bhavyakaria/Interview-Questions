/*
 * Rotating the Linked List at point k
 * Steps:
 * 1. Iterate till k
 * 2. Store k node in temp node
 * 3. Iterate temp node till temp.next == null
 * 4. Change temp.next = null to temp.next = head
 * 5. New head will be head = k.next
 * 6. And k.next = null (Last Node)
 */
// package linked_list;

import java.util.Scanner;

/**
 *
 * @author Parzival
 */
public class RotateLinkedList {
    static Node head;
    
    RotateLinkedList(){
        head = null;
    }

    private static void RotateList(int point) {
        if(head == null ) {
            return;
        } 
        
        Node current = head;
        
        // Iterate k-1 loops
        for (int i = 1; i < point; i++) {
            current = current.next;
        }
        Node temp = current.next;
        
        while(temp.next != null) {
            temp = temp.next;
        }
        // Pointing last node to the head node
        temp.next = head;
        // Setting k.next as the head node
        head = current.next;
        // Setting k as the last node
        current.next = null;
    }
    
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
    
    // Print the Linked List
    public static void display() {
        Node current = head;
        while(current.next != null) {
            System.out.print(current.data+" ");
            current = current.next;
        }
        System.out.print(current.data);
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        RotateLinkedList rl = new RotateLinkedList();
        // create a list 10->20->30->40->50->60
        rl.append(10);
        rl.append(20);
        rl.append(30);
        rl.append(40);
        rl.append(50);
        rl.append(60);
        rl.display();
        System.out.println("Enter point to rotate the list:");
        int point = sc.nextInt();
        RotateList(point);
        rl.display();
        
    }
}

// Output:
// 10 20 30 40 50 60
// Enter point to rotate the list:
// 4
// 50 60 10 20 30 40 