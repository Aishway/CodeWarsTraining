import java.util.*;
public class DuplicateEncoder_6kyu {
//    The goal of this exercise is to convert a string to a new string where each character in the new string is
//    "(" if that character appears only once in the original string, or ")" if that character appears more than once
//    in the original string. Ignore capitalization when determining if a character is a duplicate.
//Examples
//"din"      =>  "((("
//"recede"   =>  "()()()"
//"Success"  =>  ")())())"
//"(( @"     =>  "))(("
//Notes
//Assertion messages may be unclear about what they display in some languages.
// If you read "...It Should encode XXX", the "XXX" is the expected result, not the input!

    public static void main(String[] args) {
        System.out.println(encode("dif"));
    }

    static String encode(String word) {
        word = word.toLowerCase(Locale.ROOT);
        List<String> list = Arrays.asList(word.split(""));
        HashMap<Character, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            int a = (int) list.stream()
                    .filter(e -> Objects.equals(e, String.valueOf(ch))).count();
            map.put(ch, a);
        }

        for (int i = 0; i < word.length(); i++) {
            if (map.get(word.charAt(i)) > 1) {
                sb.append(")");
            } else {
                sb.append("(");
            }
        }
        return sb.toString();
    }
}
