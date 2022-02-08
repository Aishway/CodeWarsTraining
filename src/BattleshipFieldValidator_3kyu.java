import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BattleshipFieldValidator_3kyu {
//    Write a method that takes a field for well-known board game "Battleship" as an argument and returns true if it
//    has a valid disposition of ships, false otherwise. Argument is guaranteed to be 10*10 two-dimension array.
//    Elements in the array are numbers, 0 if the cell is free and 1 if occupied by ship.
//
//Battleship (also Battleships or Sea Battle) is a guessing game for two players. Each player has a 10x10 grid
// containing several "ships" and objective is to destroy enemy's forces by targetting individual cells on his field.
// The ship occupies one or more cells in the grid. Size and number of ships may differ from version to version. In this
// kata we will use Soviet/Russian version of the game.
//
//
//Before the game begins, players set up the board and place the ships accordingly to the following rules:
//There must be single battleship (size of 4 cells), 2 cruisers (size 3), 3 destroyers (size 2) and 4 submarines
// (size 1). Any additional ships are not allowed, as well as missing ships.
//Each ship must be a straight line, except for submarines, which are just single cell.
//
//The ship cannot overlap or be in contact with any other ship, neither by edge nor by corner.
//
//This is all you need to solve this kata. If you're interested in more information about the game, visit this link.
//    1x battleship = 4;
//    2x cruiser = 3;
//    3x destroyer = 2;
//    4x submarine = 1;

    public static void main(String[] args) {
//        int[][] battleField = {
//                {1, 0, 0, 0, 0, 1, 1, 0, 0, 0},
//                {1, 0, 1, 0, 0, 0, 0, 0, 1, 0},
//                {1, 0, 1, 0, 1, 1, 1, 0, 1, 0},
//                {1, 0, 0, 0, 0, 0, 0, 0, 0, 0},
//                {0, 0, 0, 0, 0, 0, 0, 0, 1, 0},
//                {0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
//                {0, 0, 0, 0, 0, 0, 0, 0, 1, 0},
//                {0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
//                {0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
//                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}};

//        int[][] battleField = {
//                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
//                {0, 0, 0, 0, 0, 1, 0, 0, 0, 0},
//                {0, 0, 0, 0, 0, 1, 0, 0, 1, 0},
//                {1, 0, 0, 0, 0, 1, 0, 0, 1, 0},
//                {0, 0, 0, 0, 1, 0, 0, 0, 1, 0},
//                {0, 0, 0, 0, 1, 0, 1, 1, 1, 0},
//                {0, 0, 1, 0, 1, 0, 0, 0, 0, 0},
//                {0, 0, 1, 0, 0, 0, 0, 0, 0, 0},
//                {0, 0, 1, 0, 0, 0, 0, 0, 0, 0},
//                {0, 1, 1, 0, 1, 1, 0, 0, 0, 0}};

        int[][] battleField = {
                {1, 0, 0, 0, 0, 1, 1, 0, 0, 0},
                {1, 0, 1, 0, 0, 0, 0, 0, 1, 0},
                {1, 0, 1, 0, 1, 1, 1, 0, 1, 0},
                {1, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 1, 0},
                {0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 0, 1, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}};

        System.out.println(fieldValidator(battleField));
    }

    public static boolean fieldValidator(int[][] field) {
        if (isHereBattleshipWithContact(field)) {
            return false;
        }

        int[] possibleShips = new int[]{1, 1, 1, 1, 2, 2, 2, 3, 3, 4};
        int a = 0;
        List<Integer> takeBattleships = new ArrayList<>();

        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                if (field[i][j] == 1) {
                    if ((i + 1) <= 9 && field[i + 1][j] == 1) {
                        while ((i + a) <= 9 && field[i + a][j] == 1) {
                            field[i + a][j] = 0;
                            a++;
                        }
                        takeBattleships.add(a);
                    } else if ((j + 1) <= 9 && field[i][j + 1] == 1) {
                        while ((j + a) <= 9 && field[i][j + a] == 1) {
                            field[i][j + a] = 0;
                            a++;
                        }
                        takeBattleships.add(a);
                    } else {
                        takeBattleships.add(1);
                    }
                    a = 0;
                }
            }
        }
        int[] sortedExistingBattleships = takeBattleships.stream().mapToInt(Integer::intValue).sorted().toArray();

        if (possibleShips.length != sortedExistingBattleships.length) {
            return false;
        }
        for (int i = 0; i < possibleShips.length; i++) {
            if (sortedExistingBattleships[i] != possibleShips[i]) {
                return false;
            }
        }
        return true;
    }

    public static boolean isHereBattleshipWithContact(int[][] field) {

        int[][] possibleWrongShips = new int[][]{{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
        int[][] impossibleShips = new int[][]{{-1, -1}, {-1, 1}, {1, -1}, {1, 1}};
        int match = 0;
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                if (field[i][j] == 1) {

                    for (int k = 0; k < impossibleShips.length; k++) {
                        int[] matches = impossibleShips[k];
                        int o = i + matches[0];
                        int p = j + matches[1];
                        if (o >= 0 && o <= 9 && p >= 0 && p <= 9 && field[o][p] == 1) {
                            return true;
                        }
                    }

                    for (int k = 0; k < possibleWrongShips.length; k++) {
                        int[] matches = possibleWrongShips[k];
                        int o = i + matches[0];
                        int p = j + matches[1];
                        if (o >= 0 && o <= 9 && p >= 0 && p <= 9 && field[o][p] == 1) {
                            match++;
                        }
                    }
                    if (match > 2) {
                        return true;
                    }
                    match = 0;
                }

            }
        }
        return false;
    }
}
