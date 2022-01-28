import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class ShortestKnightPath4_kyu {
    // Given two different positions on a chess board, find the least number of moves it would take a knight to get
    // from one to the other. The positions will be passed as two arguments in algebraic notation. For example,
    // knight("a3", "b5") should return 1.
    //
    //The knight is not allowed to move off the board. The board is 8x8.
    //
    //For information on knight moves, see https://en.wikipedia.org/wiki/Knight_%28chess%29
    //
    //For information on algebraic notation, see https://en.wikipedia.org/wiki/Algebraic_notation_%28chess%29
    //
    //(Warning: many of the tests were generated randomly. If any do not work, the test cases will return the input,
    // output, and expected output; please post them.)

    public static void main(String[] args) {
        System.out.println(knight("g2","h1"));
    }

    public static int knight(String start, String finish) {
        String[][] chessBoard = new String[][]{{"a8", "b8", "c8", "d8", "e8", "f8", "g8", "h8"},
                                               {"a7", "b7", "c7", "d7", "e7", "f7", "g7", "h7"},
                                               {"a6", "b6", "c6", "d6", "e6", "f6", "g6", "h6"},
                                               {"a5", "b5", "c5", "d5", "e5", "f5", "g5", "h5"},
                                               {"a4", "b4", "c4", "d4", "e4", "f4", "g4", "h4"},
                                               {"a3", "b3", "c3", "d3", "e3", "f3", "g3", "h3"},
                                               {"a2", "b2", "c2", "d2", "e2", "f2", "g2", "h2"},
                                               {"a1", "b1", "c1", "d1", "e1", "f1", "g1", "h1"},};

        int[] startPosition = new int[2];
        int[] finalPosition = new int[2];

        int[][] possibleMoves = new int[][]{{-2, -1}, {-2, 1}, {-1, -2}, {-1, 2}, {2, 1}, {2, -1}, {1, -2}, {1, 2}};
        boolean doWeHaveMatch = false;
        int countSteps = 0;
        List<int[]> listOfMoves = new ArrayList<>();

        for (int i = 0; i < chessBoard.length; i++) {
            for (int j = 0; j < chessBoard[i].length; j++) {
                if (Objects.equals(chessBoard[i][j], start)) {
                    startPosition[0] = i;
                    startPosition[1] = j;
                } else if (Objects.equals(chessBoard[i][j], finish)) {
                    finalPosition[0] = i;
                    finalPosition[1] = j;
                }
            }
        }

        listOfMoves.add(new int[]{startPosition[0], startPosition[1]});
        List<int[]> temporalMoves = new ArrayList<>();

        while (!doWeHaveMatch) {
            countSteps++;

            for (int i = 0; i < possibleMoves.length; i++) {
                int [] temporal = new int[2];
                int [] second = possibleMoves[i];
                for (int list = 0; list < listOfMoves.size(); list++) {
                    temporal = listOfMoves.get(list);
                    int a = temporal[0] + second[0];
                    int b = temporal[1] + second[1];
                    if (a < 0 || b < 0 || a >= chessBoard.length || b >= chessBoard.length){}
                    else {
                    temporalMoves.add(new int [] {a,b});}
                }
            }

            for (int i = 0; i < temporalMoves.size(); i++) {
                int[] temporal = temporalMoves.get(i);
                if (temporal[0] == finalPosition[0] && temporal[1] == finalPosition[1]) {
                    doWeHaveMatch = true;
                }
            }
            listOfMoves = temporalMoves.stream().collect(Collectors.toList());
        }
            return countSteps;
    }
}
