/*
 * Merge Sort
 * In this we divide the array in two halves and 
 * sort each halves and merge to get sorted array.
 *
 * Time Complexity : O(nlogn) -> In all three(worst,average,best) cases
 * Space Complexity: O(n)
 *
 * Applicaction:
 * 1. Used to sort Linked List because nodes in linked list are stored randomly at different memory locations.
 *    And Random access is low in Merge Sort.
 *
 */
package sorting_algos;

/**
 *
 * @author Parzival
 */
public class MergeSort {
    
    public static void main(String[] args) {
        
        MergeSort ms = new MergeSort();
        int array[] = {10,50,30,40,80,70,90,20,60};
        
        System.out.println("Array before sorting:");
        display(array);
        
        mergeSort(array,0,array.length-1);
        
        System.out.println("Array after sorting:");
        display(array);
    }

    private static void mergeSort(int[] array,int start,int end) {
        
        if(start < end) {
            // Find the middle
            int middle = (start+end)/2;
            
            // Sort first and second halve
            mergeSort(array, start, middle);
            mergeSort(array, middle+1, end);
            
            // Merge the sorted halves
            merge(array, start, middle, end);
        }
        
    }
    
    public static void display(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]+" ");
        }
        System.out.println("");
    }

    private static void merge(int[] array, int start, int middle, int end) {
        // Finding the size of two arrays
        int n1 = middle - start +1;
        int n2 = end - middle;
        
        // Create temp array
        int L[] = new int[n1];
        int R[] = new int[n2];
        
        // Copy data to temp array
        for (int i = 0; i < n1; ++i) {
            L[i] = array[start+i];
        }
        for (int i = 0; i < n2; ++i) {
            R[i] = array[middle+1+i];
        }
        
        /* Merge the temp array */
        // Initialize index 
        int i=0, j=0;
        int k=start;
        while(i < n1 && j < n2) {
            if(L[i] <= R[j]) {
                array[k] = L[i++];
            } else {
                array[k] = R[j++];
            }
            k++;
        }
        
        // Copy the remaining of array L
        while(i < n1) {
            array[k++] = L[i++];
        }
        
        // Copy the remaining of array R
        while(j < n2) {
            array[k++] = R[j++];
        }
        
    }
    
}
