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
public class CreateBinaryTree {
    
    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5,6,7,8,9};
        int length = arr.length;
        Node tree = createBinaryTree(arr,0,length-1);
        traverseInOrder(tree);
    }
    public static void traverseInOrder(Node node) {
        if (node != null) {
            traverseInOrder(node.left);
            
            traverseInOrder(node.right);
            System.out.print(" " + node.data);
        }
    }

    private static Node createBinaryTree(int[] arr, int start, int end) {
        
        if(start > end) {
            return null;
        }
        
        int mid = (start+end)/2;
        Node root = new Node(arr[mid]);
        root.left = createBinaryTree(arr,start,mid-1);
        root.right = createBinaryTree(arr,mid+1,end);
        
        return root;
    }
    
}
