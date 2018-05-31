/*
 * Program to create a binary tree from sorted array.
 * 
 * Approach:
 * 1. Find the middle element of the array and make it the root node.
 * 2. Repeat this for the left sub-array and right sub-array.
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
        traversePostOrder(tree);
    }
    public static void traversePostOrder(Node node) {
        if (node != null) {
            traversePostOrder(node.left);
            traversePostOrder(node.right);
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
