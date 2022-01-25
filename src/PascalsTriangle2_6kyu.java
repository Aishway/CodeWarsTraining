import java.util.Arrays;

public class PascalsTriangle2_6kyu {
    //Here you will create the classic Pascal's triangle.
    //Your function will be passed the depth of the triangle and your code has to return the corresponding pascal triangle up to that depth.
    //
    //The triangle should be returned as a nested array. For example:
    //
    //pascal(5) -> [ [1], [1,1], [1,2,1], [1,3,3,1], [1,4,6,4,1] ]
    //To build the triangle, start with a single 1 at the top, for each number in the next row you just take the two numbers above it and add them together, except for the edges, which are all 1. e.g.:
    //
    //      1
    //    1   1
    //  1   2   1
    //1   3   3   1


    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(pascal(5)));
    }

    public static int[][] pascal(int depth) {

        int[][] matrix = new int[depth][];
        for (int i = 0; i < depth; i++) {
            matrix[i] = new int[i + 1];
            matrix[i][0] = 1;
            matrix[i][i] = 1;
            for (int j = 1; j < i; j++) {
                matrix[i][j] = matrix[i - 1][j] + matrix[i - 1][j - 1];
            }
        } return matrix;
        }
    }
