/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linked_list;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Parzival
 */
public class RemoveDuplicates {
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
        RemoveDuplicates rd = new RemoveDuplicates();
        
        // create a list 10->20->30->40->50
        rd.append(10);
        rd.append(20);
        rd.append(30);
        rd.append(40);
        rd.append(50);
        rd.append(40);
        
        usingHashTable();
        
    }

    private static void usingHashTable() {
        Map<Integer,Integer> map = new HashMap<>();
        Node current = head;
        while(current.next != null) {
            if(map.containsKey(current.data)) {
                System.out.println("Duplicate: "+current.data);
            } else{
                map.put(current.data, 1);
            }
            current = current.next;
        }
        if(map.containsKey(current.data)) {
            System.out.println("Duplicate: "+current.data);
        }
    }
    
}
