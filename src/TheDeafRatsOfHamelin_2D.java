public class TheDeafRatsOfHamelin_2D {
//    Story
//Those pesky rats have returned and this time they have taken over the Town Square.
//
//The Pied Piper has been enlisted again to play his magical tune and coax all the rats towards him.
//
//But some of the rats are deaf and are going the wrong way!
//
//Kata Task
//How many deaf rats are there?
//
//Input Notes
//The Town Square is a rectangle of square paving stones (the Square has 1-15 pavers per side)
//The Pied Piper is always present
//Output Notes
//Deaf rats are those that are moving to paving stone further away from the Piper than where they are now
//Use Euclidian distance for your calculations
//Legend
//P = The Pied Piper
//← ↑ → ↓ ↖ ↗ ↘ ↙ = Rats going in different directions
//space = Everything else
//Examples
//ex1 - has 1 deaf rat
//
//↗ P
//  ↘   ↖
//  ↑
//↗
//ex2 - has 7 deaf rats
//
//    ↗
//P ↓   ↖ ↑
//    ←   ↓
//  ↖ ↙   ↙
//↓ ↓ ↓

//https://www.baeldung.com/java-distance-between-two-points


    public static void main(String[] args) {
        System.out.println(countDeafRats(new char[][]{
                "        ↗".toCharArray(),
                "P ↓   ↖ ↑".toCharArray(),
                "    ←   ↓".toCharArray(),
                "  ↖ ↙   ↙".toCharArray(),
                "↓ ↓ ↓    ".toCharArray()
        }));

        System.out.println(countDeafRats(new char[][]{
                "↗ P     ".toCharArray(),
                "  ↘    ↖".toCharArray(),
                "  ↑     ".toCharArray(),
                "↗       ".toCharArray(),}));
    }

    public static int countDeafRats(char[][] townSquare) {
        int x_line = 0;
        int y_line = 0;
        int countPoorDeafRats = 0;

        for (int i = 0; i < townSquare.length; i++) {
            for (int j = 0; j < townSquare[i].length; j++) {
                if (townSquare[i][j] == 'P') {
                    x_line = i;
                    y_line = j;
                }
            }
        }


        for (int i = 0; i < townSquare.length; i++) {
            for (int j = 0; j < townSquare[i].length; j++) {
                char ch = townSquare[i][j];
                double wherePiperRun = enclidianDistance(x_line, y_line, i, j);

                switch (ch) {
                    case '←':
                        if (wherePiperRun < enclidianDistance(x_line, y_line, i, j - 1)) {
                            countPoorDeafRats++;
                        }
                        break;
                    case '↑':
                        if (wherePiperRun < enclidianDistance(x_line, y_line, i - 1, j)) {
                            countPoorDeafRats++;
                        }
                        break;
                    case '→':
                        if (wherePiperRun < enclidianDistance(x_line, y_line, i, j + 1)) {
                            countPoorDeafRats++;
                        }
                        break;
                    case '↓':
                        if (wherePiperRun < enclidianDistance(x_line, y_line, i + 1, j)) {
                            countPoorDeafRats++;
                        }
                        break;
                    case '↖':
                        if (wherePiperRun < enclidianDistance(x_line, y_line, i - 1, j - 1)) {
                            countPoorDeafRats++;
                        }
                        break;
                    case '↗':
                        if (wherePiperRun < enclidianDistance(x_line, y_line, i - 1, j + 1)) {
                            countPoorDeafRats++;
                        }
                        break;
                    case '↘':
                        if (wherePiperRun < enclidianDistance(x_line, y_line, i + 1, j + 1)) {
                            countPoorDeafRats++;
                        }
                        break;
                    case '↙':
                        if (wherePiperRun < enclidianDistance(x_line, y_line, i + 1, j - 1)) {
                            countPoorDeafRats++;
                        }
                        break;
                }
            }
        }
        return countPoorDeafRats;

    }

    public static double enclidianDistance(
            double x1,
            double y1,
            double x2,
            double y2) {
        return Math.sqrt((y2 - y1) * (y2 - y1) + (x2 - x1) * (x2 - x1));
    }
}
