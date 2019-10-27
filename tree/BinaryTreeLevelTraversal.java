/*
 * Traversing the tree level by level.
 * Storing all nodes at same level together.
 * 
 * Approach:
 * Start with level 0 and keep on incrementing it as me move down
 * Use the level as key to store all the nodes in HashMap
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
public class BinaryTreeLevelTraversal {
    static Node root;
    static int level=0;
    static Map<Integer,List<Integer>> map = new HashMap<>();
    
    
    public static void main(String[] args) {
        BinaryTreeLevelTraversal bt = new BinaryTreeLevelTraversal();
        bt.root = new Node(1);
        bt.root.left = new Node(2);
        bt.root.right = new Node(3);
        bt.root.left.left = new Node(4);
        bt.root.left.right = new Node(5);
        bt.root.right.left = new Node(8);
        bt.root.left.left.left = new Node(10);
        
        levelTraversal(root,level);
        map.forEach((k,v) -> {
            System.out.println("Nodes at Level "+k+" : "+v);
            int sum=0;
            for (int i : v) {
                sum+= i;
            }
            System.out.println("Total:"+sum);
        });  
    }

    private static void levelTraversal(Node node, int level) {
        if (null == node)
            return;

        List<Integer> list = null;
        if (map.containsKey(level)) {    
            list = map.get(level);
        } else {
            list = new ArrayList<Integer>();
        }

        list.add(node.data);
        map.put(level, list);
        levelTraversal(node.left, level + 1);
        levelTraversal(node.right, level + 1);   
    }   
}

// Output:
/* Nodes at Level 0 : [1]
 * Total:1
 * Nodes at Level 1 : [2, 3]
 * Total:5
 * Nodes at Level 2 : [4, 5, 8]
 * Total:17
 * Nodes at Level 3 : [10]
 * Total:10
 */
