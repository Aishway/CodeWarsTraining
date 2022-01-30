import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ValidParentheses_5kyu {
//Write a function that takes a string of parentheses, and determines if the order of the parentheses is valid.
// The function should return true if the string is valid, and false if it's invalid.
//
//Examples
//"()"              =>  true
//")(()))"          =>  false
//"("               =>  false
//"(())((()())())"  =>  true
//Constraints
//0 <= input.length <= 100
//
//Along with opening (() and closing ()) parenthesis, input may contain any valid ASCII characters. Furthermore, the
// input string may be empty and/or not contain any parentheses at all. Do not treat other forms of brackets as
// parentheses (e.g. [], {}, <>).

    public static void main(String[] args) {
        //   System.out.println(validParentheses("(dsgdsg))2432"));
        System.out.println(validParentheses("7L(m?())w7M(k(E([w>zfyee6"));
    }

    public static boolean validParentheses(String parens) {
        List<Character> list = new ArrayList<>();

        for (int i = 0; i < parens.length(); i++) {
            if (parens.charAt(i) == '(' || parens.charAt(i) == ')') {
                list.add(parens.charAt(i));
            }
        }
        list.add(' ');

        boolean sayFin = false;
        int m = 0;

        while (!sayFin) {
            m = list.size();

            for (int i = 0; i < list.size() -1; i++) {
                if (Objects.equals(list.get(i), '(') && Objects.equals(list.get(i + 1), ')')) {
                    list.remove(i + 1);
                    list.remove(i);
                }
            }
            if (m == list.size()) {
                sayFin = true;
            }
        }

        long i = list.stream().filter(e -> Objects.equals(e, '(') || Objects.equals(e, ')')).count();
        return i <= 0;
    }
}
