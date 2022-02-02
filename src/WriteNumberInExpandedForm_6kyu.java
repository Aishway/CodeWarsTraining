import java.lang.reflect.Array;
import java.util.Arrays;

public class WriteNumberInExpandedForm_6kyu {
//    You will be given a number and you will need to return it as a string in Expanded Form. For example:
//
//Kata.expandedForm(12); # Should return "10 + 2"
//Kata.expandedForm(42); # Should return "40 + 2"
//Kata.expandedForm(70304); # Should return "70000 + 300 + 4"
//NOTE: All numbers will be whole numbers greater than 0.

    public static void main(String[] args) {
        System.out.println(expandedForm(12));
        System.out.println(expandedForm(70304));
    }

    public static String expandedForm(int num) {
        String number = String.valueOf(num);
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < number.length(); i++) {
            String firstNumber = String.valueOf(number.charAt(i));

            if (i != number.length() - 1) {
                firstNumber = firstNumber + "0".repeat((number.length() - 1) - i);
            }

            if (firstNumber.charAt(0) != '0') {
                sb.append(firstNumber).append(" + ");
            }
        }
        return sb.substring(0, sb.length() - 3);
    }
}
