/*
 * Print a Binary Tree in Vertical Order
 *           1
 *        /    \
 *      2       3
 *     / \    /   \
 *    4   5  6     7
 *            \     \
 *             8     9 
 *              
 *			  
 * The output of print this tree vertically will be:
 * 4
 * 2
 * 1 5 6
 * 3 8
 * 7
 * 9 
 *
 * Approach:
 * 1. Calculate the horizontal distance from the root(0)
 * 2. Towards right -> increment
 * 3. Towards left -> decrement
 * 4. Store nodes.data in HashMap with key being their horizontal distance 
 *
 *
 */
package tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Parzival
 */
public class BinaryTreeVerticalOrder {
    static Node root;
    static Map<Integer,List<Integer>> map = new HashMap<>();
    static int count = 0; 
    public static void main(String[] args) {
        
        BinaryTreeVerticalOrder bt = new BinaryTreeVerticalOrder();
        bt.root = new Node(1);
        bt.root.left = new Node(2);
        bt.root.right = new Node(3);
        bt.root.left.left = new Node(4);
        bt.root.left.right = new Node(5);
        bt.root.right.left = new Node(8);
        
        printVerticalOrder(root,count);
        map.forEach((k,v) -> {
            System.out.println("Node at distance "+k+" : "+v);
            int sum=0;
            for (int i : v) {
                sum+= i;
            }
            System.out.println("Total:"+sum);
        });
        
    }

    private static void printVerticalOrder(Node node, int distance) {
        if (null == node)
            return;

        List<Integer> list = null;
        if (map.containsKey(distance)) {    
            list = map.get(distance);
        } else {
            list = new ArrayList<Integer>();
        }

        list.add(node.data);
        map.put(distance, list);
        printVerticalOrder(node.left, distance - 1);
        printVerticalOrder(node.right, distance + 1);
        
        
    }
    
}
