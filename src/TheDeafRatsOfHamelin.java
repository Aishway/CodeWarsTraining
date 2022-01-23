public class TheDeafRatsOfHamelin {
//    Story
//The Pied Piper has been enlisted to play his magical tune and coax all the rats out of town.
//
//But some of the rats are deaf and are going the wrong way!
//
//Kata Task
//How many deaf rats are there?
//
//Legend
//P = The Pied Piper
//O~ = Rat going left
//~O = Rat going right
//Example
//ex1 ~O~O~O~O P has 0 deaf rats
//
//ex2 P O~ O~ ~O O~ has 1 deaf rat
//
//ex3 ~O~O~O~OP~O~OO~ has 2 deaf rats


    public static void main(String[] args) {

        System.out.println(countDeafRats("~O~O~O~O P"));
        System.out.println(countDeafRats("P O~ O~ ~O O~"));
        System.out.println(countDeafRats("~O~O~O~OP~O~OO~"));
    }

    public static int countDeafRats(final String town) {

        String rats = town;
        rats = rats.replaceAll(" ", "");
        int countWayChanging = 0;
        int countPoorDeafRats = 0;
        boolean goRight = false;

        for (int i = 0; i < rats.length()-1; i= i +2) {

            if (rats.charAt(i) == 'P' && countWayChanging % 2 == 0) {
                goRight = true;
                countWayChanging++;
                i = i + 1;
            } else if (rats.charAt(i) == 'P' && countWayChanging % 2 != 0) {
                goRight = false;
                countWayChanging++;
                i = i + 1;
            }

            if (!(rats.charAt(i) + "" + rats.charAt(i + 1)).equals(findWay(goRight))) {
                countPoorDeafRats++;
            }
        }
        return countPoorDeafRats;
    }

    public static String findWay(boolean doWeGoRight) {
        String right = "O~";
        String left = "~O";

        if (doWeGoRight) {
            return right;
        }
        return left;
    }
}
