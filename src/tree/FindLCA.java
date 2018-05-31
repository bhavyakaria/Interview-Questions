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
public class FindLCA {
    static Node root;
    
    public static void main(String[] args) {
        FindLCA bt = new FindLCA();
        bt.root = new Node(1);
        bt.root.left = new Node(2);
        bt.root.right = new Node(3);
        bt.root.left.left = new Node(4);
        bt.root.left.right = new Node(5);
        bt.root.right.left = new Node(8);
        
        Node ans = findLCA(root,4,7);
        System.out.println("Node: "+ans.data);
    }

    private static Node findLCA(Node root, int n1, int n2) {
        if(root == null)
            return null;
        
        if(root.data == n1 || root.data == n2) {
            return root;
        }
        
        Node lca_left = findLCA(root.left,n1,n2);
        Node lca_right = findLCA(root.right,n1,n2);
        
        if(lca_left != null && lca_right != null) {
            return root;
        }
        return  (lca_left != null) ? lca_left : lca_right;
    }
    
}
