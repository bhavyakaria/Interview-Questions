/*
 * Finding Longest Increasing Subsequencec
 */
package dynamic_programming;

import java.util.Arrays;

/**
 *
 * @author Parzival
 */
public class LIS {
    static int[] lookuptable;
    public static void main(String[] args) {
        int arr[] = {10,22,9,33,21,50,41,60};
        lookuptable = new int[arr.length];
        Arrays.fill(lookuptable, 1);
        int result = LIS(arr);
        System.out.println("LIS: "+result);
    }

    public static int LIS(int[] arr) {
        int max = 1;
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if(arr[i] > arr[j] && lookuptable[j] >= lookuptable[i]) {
                    lookuptable[i] = lookuptable[j]+1;
                    if(max < lookuptable[i]) {
                        max = lookuptable[i];
                    }
                }
            }
        }
        return max;
    }
    
}
