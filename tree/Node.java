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
public class Node {
    int data;
    Node left,right;
    
    Node(int data) {
        this.data = data;
        left = right = null;
    }
}
