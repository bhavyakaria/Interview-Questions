/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tree;

/**
 *
 * @author Parzival
 */
public class BinaryTreeBalance {

    static Node root; 

    private static Boolean isBalanced(Node root) {
        return ((maxDepth(root) - minDepth(root)) <= 1);
    }
    
    public static void main(String[] args) {
        
        BinaryTreeBalance bt = new BinaryTreeBalance();
        bt.root = new Node(1);
        bt.root.left = new Node(2);
        
        bt.root.left.left = new Node(4);
        bt.root.left.right = new Node(5);
        
        
        Boolean ans = isBalanced(root);
        System.out.println("Is it Balanced? -> "+ans);
    }

    private static int maxDepth(Node root) {
        if(root == null) {
            return 0;
        }
        
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }

    private static int minDepth(Node root) {
        if(root == null) {
            return 0;
        }
        
        return 1 + Math.min(minDepth(root.left), minDepth(root.right));
    }
    
}
