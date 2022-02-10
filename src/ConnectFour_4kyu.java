import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class ConnectFour_4kyu {

//    Take a look at wiki description of Connect Four game:
//
//Wiki Connect Four
//
//The grid is 6 row by 7 columns, those being named from A to G.
//
//You will receive a list of strings showing the order of the pieces which dropped in columns:
//
//List<String> myList = new ArrayList<String>(Arrays.asList(
//    "A_Red",
//    "B_Yellow",
//    "A_Red",
//    "B_Yellow",
//    "A_Red",
//    "B_Yellow",
//    "G_Red",
//    "B_Yellow"
//));
//The list may contain up to 42 moves and shows the order the players are playing.
//
//The first player who connects four items of the same color is the winner.
//
//You should return "Yellow", "Red" or "Draw" accordingly.

    public static void main(String[] args) {
//        List<String> myList = new ArrayList<String>(Arrays.asList(
//                "A_Yellow",
//                "B_Red",
//                "B_Yellow",
//                "C_Red",
//                "G_Yellow",
//                "C_Red",
//                "C_Yellow",
//                "D_Red",
//                "G_Yellow",
//                "D_Red",
//                "G_Yellow",
//                "D_Red",
//                "F_Yellow",
//                "E_Red",
//                "D_Yellow"
//        ));
        List<String> myList = new ArrayList<String>(Arrays.asList(
                "C_Yellow", "C_Red",
                "B_Yellow", "A_Red", "B_Yellow", "E_Red",
                "B_Yellow", "C_Red", "C_Yellow", "C_Red",
                "E_Yellow", "E_Red", "D_Yellow", "C_Red", "A_Yellow",
                "G_Red","E_Yellow","B_Red", "B_Yellow", "F_Red", "D_Yellow",
                "B_Red", "E_Yellow", "G_Red", "E_Yellow", "F_Red", "D_Yellow", "F_Red", "A_Yellow", "D_Red", "A_Yellow",
                "F_Red", "D_Yellow", "G_Red", "A_Yellow", "G_Red", "F_Yellow", "G_Red", "F_Yellow", "G_Red", "D_Yellow",
                "A_Red"
        ));


//        List<String> myList = new ArrayList<String>(Arrays.asList(
//                "A_Yellow",
//                "B_Red",
//                "B_Yellow",
//                "C_Red",
//                "G_Yellow",
//                "C_Red",
//                "C_Yellow",
//                "D_Red",
//                "G_Yellow",
//                "D_Red",
//                "G_Yellow",
//                "D_Red",
//                "F_Yellow",
//                "E_Red",
//                "D_Yellow"
//        ));

        System.out.println(whoIsWinner(myList));
    }

    public static String whoIsWinner(List<String> piecesPositionList) {
        String[][] matrix = new String[6][7];
        String index = "ABCDEFG";

        for (int i = 0; i < piecesPositionList.size(); i++) {
            String[] arr = piecesPositionList.get(i).split("_");
            int in = index.indexOf(arr[0]);
            int count = 0;

            while (matrix[count][in] != null) {
                count++;
            }

            matrix[count][in] = arr[1];

            String result = findWinner(matrix);

            if (result != "Draw") {
                return result;
            }
        }
        return "Draw";
    }

    public static String findWinner(String[][] matrix) {
        int count = 0;
        int[][] possibleUp = new int[][]{{0, 0}, {0, 1}, {0, 2}, {0, 3}};
        int[][] possibleDown = new int[][]{{0, 0}, {1, 0}, {2, 0}, {3, 0}};
        int[][] possibleCrossRight = new int[][]{{0, 0}, {1, 1}, {2, 2}, {3, 3}};
        int[][] possibleCrossLeft = new int[][]{{0, 0}, {1, -1}, {2, -2}, {3, -3}};
        String s = "";

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {

                s = matrix[i][j];

                for (int k = 0; k < possibleUp.length; k++) {
                    int[] direction = possibleUp[k];
                    int a = i + direction[0];
                    int b = j + direction[1];

                    if (a >= 0 && a < matrix.length && b >= 0 && b < matrix[i].length) {
                        if (Objects.equals(matrix[a][b], s) && s != null) {
                            count++;
                        }
                    }
                }
                if (count == 4) {
                    return s;
                } else {
                    count = 0;
                }

                for (int k = 0; k < possibleDown.length; k++) {
                    int[] direction = possibleDown[k];
                    int a = i + direction[0];
                    int b = j + direction[1];

                    if (a >= 0 && a < matrix.length && b >= 0 && b < matrix[i].length) {
                        if (Objects.equals(matrix[a][b], s) && s != null) {
                            count++;
                        }
                    }
                }
                if (count == 4) {
                    return s;
                } else {
                    count = 0;
                }
                for (int k = 0; k < possibleCrossLeft.length; k++) {
                    int[] direction = possibleCrossLeft[k];
                    int a = i + direction[0];
                    int b = j + direction[1];

                    if (a >= 0 && a < matrix.length && b >= 0 && b < matrix[i].length) {
                        if (Objects.equals(matrix[a][b], s) && s != null) {
                            count++;
                        }
                    }
                }
                if (count == 4) {
                    return s;
                } else {
                    count = 0;
                }

                for (int k = 0; k < possibleCrossRight.length; k++) {
                    int[] direction = possibleCrossRight[k];
                    int a = i + direction[0];
                    int b = j + direction[1];

                    if (a >= 0 && a < matrix.length && b >= 0 && b < matrix[i].length) {
                        if (Objects.equals(matrix[a][b], s) && s != null) {
                            count++;
                        }
                    }
                }
                if (count == 4) {
                    return s;
                } else {
                    count = 0;
                }

            }
        }
        return "Draw";
    }
}
