public class TripleTrouble_6kyu {
//    Write a function
//
//TripleDouble(long num1, long num2)
//which takes numbers num1 and num2 and returns 1 if there is a straight triple of a number at any place in num1 and
// also a straight double of the same number in num2.
//
//If this isn't the case, return 0
//
//Examples
//TripleDouble(451999277, 41177722899) == 1 // num1 has straight triple 999s and
//                                          // num2 has straight double 99s
//
//TripleDouble(1222345, 12345) == 0 // num1 has straight triple 2s but num2 has only a single 2
//
//TripleDouble(12345, 12345) == 0
//
//TripleDouble(666789, 12345667) == 1

    public static void main(String[] args) {
        System.out.println(TripleDouble(451999277L, 41177722899L));
        System.out.println(TripleDouble(1222345L, 12345L));
        System.out.println(TripleDouble(12345L, 12345L));
    }

    public static int TripleDouble(long num1, long num2) {
        String numberOne = String.valueOf(num1) + " ";
        String numberTwo = String.valueOf(num2) + " ";
        int count = 1;
        char findChar = ' ';
        char findSecondChar = ' ';
        int countSecond = 1;

        for (int i = 0; i < numberOne.length() - 1; i++) {
            if (numberOne.charAt(i) == numberOne.charAt(i + 1)) {
                count++;
            } else {
                count = 1;
            }

            if (count == 3) {
                findChar = numberOne.charAt(i);
            }
        }

        for (int i = 0; i < numberTwo.length() - 1; i++) {
            if (numberTwo.charAt(i) == numberTwo.charAt(i + 1)) {
                countSecond++;
            } else {
                countSecond = 1;
            }

            if (countSecond == 2) {
                findSecondChar = numberTwo.charAt(i);
                if (findChar == findSecondChar) {
                    return 1;
                }
            }
        }
        return 0;
    }
}
