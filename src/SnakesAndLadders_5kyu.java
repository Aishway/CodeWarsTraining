import java.util.HashMap;


public class SnakesAndLadders_5kyu {
    // Introduction
    //Snakes and Ladders is an ancient Indian board game regarded today as a worldwide classic. It is played between
    // two or more players on a gameboard having numbered, gridded squares. A number of "ladders" and "snakes"
    // are pictured on the board, each connecting two specific board squares. (Source Wikipedia)
    //
    //Task
    //Your task is to make a simple class called SnakesLadders. The test cases will call the method play(die1, die2)
    // independantly of the state of the game or the player turn. The variables die1 and die2 are the die thrown in a
    // turn and are both integers between 1 and 6. The player will move the sum of die1 and die2.
    //The Board
    //
    //Rules
    //1.  There are two players and both start off the board on square 0.
    //
    //2.  Player 1 starts and alternates with player 2.
    //
    //3.  You follow the numbers up the board in order 1=>100
    //
    //4.  If the value of both die are the same then that player will have another go.
    //
    //5.  Climb up ladders. The ladders on the game board allow you to move upwards and get ahead faster.
    // If you land exactly on a square that shows an image of the bottom of a ladder, then you may move the player
    // all the way up to the square at the top of the ladder. (even if you roll a double).
    //
    //6.  Slide down snakes. Snakes move you back on the board because you have to slide down them. If you land exactly
    // at the top of a snake, slide move the player all the way to the square at the bottom of the snake or chute.
    // (even if you roll a double).
    //
    //7.  Land exactly on the last square to win. The first person to reach the highest square on the board wins.
    // But there's a twist! If you roll too high, your player "bounces" off the last square and moves back.
    // You can only win by rolling the exact number needed to land on the last square. For example,
    // if you are on square 98 and roll a five, move your game piece to 100 (two moves), then "bounce"
    // back to 99, 98, 97 (three, four then five moves.)
    //
    //8.  If the Player rolled a double and lands on the finish square “100” without
    // any remaining moves then the Player wins the game and does not have to roll again.
    //Returns
    //Return Player n Wins!. Where n is winning player that has landed on square 100 without any remainding moves left.
    //
    //Return Game over! if a player has won and another player tries to play.
    //
    //Otherwise return Player n is on square x. Where n is the current player and x is the sqaure they are currently on.

    public static void main(String[] args) {
        System.out.println(play(1, 1));
        System.out.println(play(1, 5));
        System.out.println(play(6, 2));
        System.out.println(play(1, 1));
    }

    public static String play(int die1, int die2) {
        int finish = 100;
        SnakesLadders snake1 = new SnakesLadders("Adam", 1);
        SnakesLadders snake2 = new SnakesLadders("Ambroz", 1);
        boolean switchSnakes = true;

        SnakesLadders turnSnake = currentPlayer(snake1, snake2, switchSnakes);
        int thrown = die1 + die2;

        if (turnSnake.getPlaceInTable() + thrown == finish) {
            turnSnake.setPlaceInTable(turnSnake.getPlaceInTable() + thrown);
            if (turnSnake == snake1) {
                return "Player 1 Wins!";
            } else {
                return "Player 2 Wins!";
            }
        } else if (snake1.getPlaceInTable() >= 100 || snake2.getPlaceInTable() >= 100) {
            return "Game over!";
        } else if (turnSnake.getPlaceInTable() + thrown > finish) {
            int count = (turnSnake.getPlaceInTable() + thrown) - 100;
            turnSnake.setPlaceInTable(100 - count);
            if (switchSnakes == true) {
                switchSnakes = false;
            } else switchSnakes = true;
        } else {
            if (die1 == die2) {
                int a = turnSnake.getPlaceInTable() + die1;
                if (isHereLadder(a) != 0) {
                    turnSnake.setPlaceInTable(isHereLadder(a));
                } else if (isHereSnake(a) != 0) {
                    turnSnake.setPlaceInTable(isHereSnake(a));
                } else {
                    turnSnake.setPlaceInTable(a);
                }
            } else {
                int a = turnSnake.getPlaceInTable() + thrown;
                if (isHereLadder(a) != 0) {
                    turnSnake.setPlaceInTable(isHereLadder(a));
                } else if (isHereSnake(a) != 0) {
                    turnSnake.setPlaceInTable(isHereSnake(a));
                } else {
                    turnSnake.setPlaceInTable(a);
                }

                if (switchSnakes) {
                    switchSnakes = false;
                    return "Player 1 is on square " + snake1.getPlaceInTable();
                } else {
                    switchSnakes = true;
                    return "Player 2 is on square " + snake2.getPlaceInTable();
                }
            }
        }

        if (switchSnakes) {
            return "Player 1 is on square " + snake1.getPlaceInTable();
        } else {
            return "Player 2 is on square " + snake2.getPlaceInTable();
        }

    }

    public static SnakesLadders currentPlayer(SnakesLadders a, SnakesLadders b, boolean switchSnakes) {
        if (switchSnakes) {
            return a;
        }
        return b;
    }


    public static int isHereLadder(int table) {

        HashMap<Integer, Integer> ladderMap = new HashMap<>();
        ladderMap.put(2, 38);
        ladderMap.put(7, 14);
        ladderMap.put(8, 31);
        ladderMap.put(15, 26);
        ladderMap.put(21, 42);
        ladderMap.put(28, 84);
        ladderMap.put(36, 44);
        ladderMap.put(51, 67);
        ladderMap.put(71, 91);
        ladderMap.put(78, 98);
        ladderMap.put(87, 94);

        for (Integer key : ladderMap.keySet()) {
            if (key.equals(table)) {
                return ladderMap.get(key);
            }
        }
        return 0;
    }

    public static int isHereSnake(int table) {

        HashMap<Integer, Integer> snakeMap = new HashMap<>();
        snakeMap.put(99, 80);
        snakeMap.put(95, 75);
        snakeMap.put(92, 88);
        snakeMap.put(89, 68);
        snakeMap.put(74, 53);
        snakeMap.put(64, 60);
        snakeMap.put(62, 19);
        snakeMap.put(49, 11);
        snakeMap.put(46, 25);
        snakeMap.put(16, 6);

        for (Integer key : snakeMap.keySet()) {
            if (key.equals(table)) {
                return snakeMap.get(key);
            }
        }
        return 0;
    }
}


class SnakesLadders {
    private String name;
    private Integer placeInTable;

    public SnakesLadders(String name, Integer placeInTable) {
        this.name = name;
        this.placeInTable = placeInTable;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Integer getPlaceInTable() {
        return placeInTable;
    }

    public void setPlaceInTable(Integer placeInTable) {
        this.placeInTable = placeInTable;
    }
    // Doesnt really work as succesfull kata solution. Codewars has his own class with Snakes .. I did it just for fun.
    // with refactor it will work but I was lazy :D

}