/*
 * Find if the number is odd or even without using conditional statements
 */
package miscellaneous;

import java.util.Scanner;

/**
 *
 * @author Parzival
 */
public class OddEven {
    
    public static void main(String[] args) {
        String arr[] = {"Even","Odd"};
        
        Scanner sc= new Scanner(System.in);
        
        int number = sc.nextInt();
        
        System.out.println("The number is : "+arr[number%2]);
    }
    
}
