/*
 * To check if a tree is height-balanced, get the height of left and right subtrees. 
 * Return true if difference between heights is not more than 1 and left and right subtrees are balanced, 
 * otherwise return false.
 * 
 */
package tree;

/**
 *
 * @author Parzival
 */
public class BinaryTreeBalance {

    static Node root; 
    
    public static void main(String[] args) {
        
        BinaryTreeBalance bt = new BinaryTreeBalance();
        bt.root = new Node(1);
        bt.root.left = new Node(2);
        bt.root.right = new Node(3);
        bt.root.left.left = new Node(4);
        bt.root.left.right = new Node(5);
        
        Boolean ans = isBalanced(root);
        System.out.println("Is the tree balanced? -> "+ans);
    }
    
    private static Boolean isBalanced(Node root) {
        return ((maxDepth(root) - minDepth(root)) <= 1);
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

// Output:
// Is it Balanced? -> false