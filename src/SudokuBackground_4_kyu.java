import java.util.Arrays;


public class SudokuBackground_4_kyu {
//    Sudoku is a game played on a 9x9 grid. The goal of the game is to fill all cells of the grid with digits from
//    1 to 9, so that each column, each row, and each of the nine 3x3 sub-grids (also known as blocks) contain all of
//    the digits from 1 to 9.
//(More info at: http://en.wikipedia.org/wiki/Sudoku)
//
//Sudoku Solution Validator
//Write a function validSolution/ValidateSolution/valid_solution() that accepts a 2D array representing a Sudoku board,
// and returns true if it is a valid solution, or false otherwise. The cells of the sudoku board may also contain 0's,
// which will represent empty cells. Boards containing one or more zeroes are considered to be invalid solutions.
//
//The board is always 9 cells by 9 cells, and every cell only contains integers from 0 to 9.

    public static void main(String[] args) {

        int[][] sudoku = {
                {5, 3, 4, 6, 7, 8, 9, 1, 2},
                {6, 7, 2, 1, 9, 5, 3, 4, 8},
                {1, 9, 8, 3, 4, 2, 5, 6, 7},
                {8, 5, 9, 7, 6, 1, 4, 2, 3},
                {4, 2, 6, 8, 5, 3, 7, 9, 1},
                {7, 1, 3, 9, 2, 4, 8, 5, 6},
                {9, 6, 1, 5, 3, 7, 2, 8, 4},
                {2, 8, 7, 4, 1, 9, 6, 3, 5},
                {3, 4, 5, 2, 8, 6, 1, 7, 9}
        };
        System.out.println(check(sudoku));
    }


    public static boolean check(int[][] sudoku) {
        if (sudoku.length < 9) {
            return false;
        }

        int count = 0;
        boolean isUnigue = true;
        int[] uniqueArray = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};


        for (int i = 0; i < sudoku.length; i++) {
            for (int j = 0; j < sudoku[i].length; j++) {
                if (sudoku[i][j] == 0) {
                    count++;
                }
                int[] sortedArray = Arrays.stream(sudoku[j]).sorted().toArray();
                for (int sort = 0; sort < sortedArray.length; sort++) {
                    if (sortedArray[sort] != uniqueArray[sort] && sortedArray[sort] != 0) {
                        return false;
                    }
                }

                if (sudoku[j][i] == 0) {
                    count++;
                }
            }
        }

        for (int i = 0; i < sudoku.length; i++) {
            int[] sortedArray = Arrays.stream(sudoku[i]).sorted().toArray();
            for (int sort = 0; sort < sortedArray.length; sort++) {
                if (sortedArray[sort] != uniqueArray[sort] && sortedArray[sort] != 0) {
                    return false;
                }
                if (sortedArray[i] == 0) {
                    count++;
                }

            }
        }

        for (int i = 0; i < sudoku.length; i = i + 3) {
            int[] smallArr = new int[9];
            int wh = 0;
            while (wh < 3) {
                smallArr[wh] = sudoku[i][wh];
                wh++;
            }

            wh = 0;
            while (wh < 3) {
                smallArr[wh + 3] = sudoku[i + 1][wh];
                wh++;
            }

            wh = 0;
            while (wh < 3) {
                smallArr[wh + 6] = sudoku[i + 2][wh];
                wh++;
            }

            smallArr = Arrays.stream(smallArr).sorted().toArray();

            for (int m = 0; m < smallArr.length; m++) {
                if (smallArr[m] != uniqueArray[m] && smallArr[m] != 0) {
                    return false;
                }
                if (smallArr[m] == 0) {
                    count++;
                }
            }
        }

        if (count > 1) {
            return false;
        }

        return true;
    }
}
