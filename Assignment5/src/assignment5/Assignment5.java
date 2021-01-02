package assignment5;
import java.util.Random;

/**
 * class for Assignment 5 to create various recursion methods
 * @author maria ramlochan
 */
public class Assignment5 {

    /**
     * Main method for testing purposes
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        printShape(5, '@');
        System.out.println("\n");
        printShape2(5, '@');
        System.out.println("\n");
        printShape3(5, '!', 5);
        System.out.println("\n");
        printShape4(5, '!', 5);
        System.out.println("\n");
        generateMatrix(4, 4);
    }
    
    /**
     * A method that print a certain pattern displayed as below: 
     * 
     * @ @ @ @ @
     * @ @ @ @
     * @ @ @
     * @ @
     * @
     * 
     * @param row the number of row
     * @param symbol the character symbol
     */
    public static void printShape(int row, char symbol) {
      if (row == 0)
          return;
      for (int i = 0; i < row; i++)
            System.out.printf("%c%s", symbol, " ");
      System.out.print("\n"); 
      printShape(row - 1, symbol); 
    }
    
    /**
     * A method that print a certain pattern displayed as below:
     * 
     * @
     * @ @
     * @ @ @
     * @ @ @ @
     * @ @ @ @ @ 
     * 
     * @param row the number of row
     * @param symbol the character symbol
     */
    public static void printShape2(int row, char symbol) {
        if (row == 0)
          return;
        printShape2(row - 1, symbol);
        for (int i = 0; i < row; i++) 
            System.out.printf("%c%s", symbol, " ");
        System.out.println();
    }
    
    /**
     * A method that print a certain pattern displayed as below:
     * 
     *       !
     *     ! ! !
     *   ! ! ! ! !
     * ! ! ! ! ! ! ! 
     * 
     * @param row the number of the row
     * @param symbol the character symbol
     * @param currentRow the current row 
     */
    public static void printShape3(int row, char symbol, int currentRow) {
        if (row == 0) {
            return;
        }
        printShape3(row - 1, symbol, currentRow++);
        for (int i = 0; i < currentRow - row; i++) { 
            System.out.print("  ");
        } 
        for(int j = 0; j < (row * 2) - 2; j++) { //removing two symbols from row
            System.out.print(symbol + " ");  
        }
        System.out.println(symbol);
    }
    
    /**
     * A method that print a certain pattern displayed as below:
     * 
     *       !
     *     ! ! !
     *   ! ! ! ! !
     * ! ! ! ! ! ! !
     *   ! ! ! ! !
     *     ! ! !
     *       !
     * 
     * @param row the number of the longest row
     * @param symbol the character symbol
     * @param currentRow the current row 
     */
    public static void printShape4(int row, char symbol, int currentRow) {
        if (row == 0) {
            return;
        }
        if (currentRow == row) { //do once row and currentRow are equal
            printShape3(row, symbol, currentRow++); //calling the previous method
            row--; //decrease the row not to get an extra row printed twice
        }
        for (int i = 0; i < currentRow - row; i++) {
            System.out.print("  ");
        } 
        for(int i = 0; i < (row * 2) - 2; i++) { //removing the two extra symbol
            System.out.print(symbol + " ");  
        }
        System.out.println(symbol);
        printShape4(row - 1, symbol, currentRow);
    }
    
    /**
     * A method  that generate a random matrix with random number between [0, 10),
     * the sum of the diagonal and the sub-diagonal should be the same you try 100
     * times and none of the matrix's satisfied
     * @param row the number of row
     * @param col the number of column
     */
    public static void generateMatrix(int row, int col) {
        Random random = new Random();
        int[][] matrix = new int[row][col];
        int sumDiagonal = 0, sumSubDiagonal = 0;
        int retry = 100;

        if (row == col) { //checking if it is a metrix where row and column are equal
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    matrix[i][j]= random.nextInt(10);
                    System.out.print(matrix[i][j] + "\t");
                    if (i == j)
                        sumDiagonal += matrix[i][j];
                    if ((i + j) == col - 1) //getting the other end of the diagonal
                        sumSubDiagonal += matrix[i][j];
                }
                System.out.print("\n");
            }
            System.out.println("Diagonal: " + sumDiagonal);
            System.out.println("Sub-Diagonal: " + sumSubDiagonal + "\n");

            if (sumDiagonal == sumSubDiagonal)
                System.out.println("Diagonals are equal");
            else {
                generateMatrix(row, col);
                retry--;
                if (retry == 0)
                    System.out.println("No more tries");
            }
        }
        else
            System.out.println("This is not a matrix");
    } 
}
