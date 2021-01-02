/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment5;

/**
 *
 * @author maria
 */
public class idk {
    public static void main(String[] args) {
        System.out.println("\n");
        printShape6(4, '!', 4);
    }
    
    public static void printShape6(int row, char symbol, int currentRow) {
        if (row == 0) {
            return;
        }
        String str = "";
        
        if (row == currentRow) {
            
        }
        
        if (row <= currentRow) {
            for (int i = 0; i < currentRow - row; i++) {
                str += "  "; // space 
            }
            for (int i = 0; i < (row * 2) - 1; i++) {
                str += symbol + " ";
            }
            System.out.println(str);
            printShape6(row - 1, symbol, currentRow);
        }
        
    }
}
