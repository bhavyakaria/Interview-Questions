/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sorting_questions;

/**
 *
 * @author Parzival
 */
public class InversionCount {
    
    public static void main(String[] args) {
        int arr[] = {1, 20, 6, 4, 5};
        
        int total = mergeSort(arr,0,arr.length-1);
        System.out.println("Total:"+total);
    }

    private static int mergeSort(int[] arr, int start, int end) {
        
        int count = 0;
        if(start < end) {
            int middle = (start + end)/2;
            
            count = mergeSort(arr,start,middle);
            count += mergeSort(arr,middle+1,end);
            
            count += merge(arr,start,middle,end);  
        }
        return count;
    }
    
    public static int merge(int arr[], int start, int middle, int end) {
        int count=0;
        
        int n1 = middle - start + 1;
        int n2 = end - middle;
        
        int L[] = new int[n1];
        int R[] = new int[n2];
        
        for (int i = 0; i < n1; i++) {
            L[i] = arr[start+i];
        }
        for (int i = 0; i < n2; i++) {
            R[i] = arr[middle+1+i];
        }
        
        int i = 0, j = 0;
        int k = start;
        
        while((i < n1) && (j < n2)) {
            if(L[i] <= R[j]) {
                arr[k++] = L[i++];
            } else {
                arr[k++] = R[j++];
                count = count + (middle - i);
            }
            
        }
        
        while(i < n1) {
            arr[k++] = L[i++];
        }
        
        while(j < n2) {
            arr[k++] = R[j++];
        }
        
        return count;
    }
    
}
