import java.util.Arrays;

public class MatrixAddition_6kyu {
//    Write a function that accepts two square matrices (N x N two dimensional arrays), and return the sum of the two.
//    Both matrices being passed into the function will be of size N x N (square), containing only integers.
//
//How to sum two matrices:
//
//Take each cell [n][m] from the first matrix, and add it with the same [n][m] cell from the second matrix.
// This will be cell [n][m] of the solution matrix.
//
//Visualization:
//
//|1 2 3|     |2 2 1|     |1+2 2+2 3+1|     |3 4 4|
//|3 2 1|  +  |3 2 3|  =  |3+3 2+2 1+3|  =  |6 4 4|
//|1 1 1|     |1 1 3|     |1+1 1+1 1+3|     |2 2 4|
//Example
//matrixAddition(
//  [ [1, 2, 3],
//    [3, 2, 1],
//    [1, 1, 1] ],
////      +
//  [ [2, 2, 1],
//    [3, 2, 3],
//    [1, 1, 3] ] )
//
//// returns:
//  [ [3, 4, 4],
//    [6, 4, 4],
//    [2, 2, 4] ]

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(matrixAddition(new int[][]{{1, 2, 3}, {3, 2, 1}, {1, 1, 1}},
                new int[][]{{2, 2, 1}, {3, 2, 3}, {1, 1, 3}})));
    }

    public static int[][] matrixAddition(int[][] a, int[][] b) {
       int [][]arr = new int[a.length][a[0].length];

        for (int i = 0; i <a.length ; i++) {
            for (int j = 0; j < b.length; j++) {
                arr[i][j] = a[i][j] + b[i][j];
            }
        }
        return arr;
    }
}
