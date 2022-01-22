import java.util.Arrays;
import java.util.Locale;
import java.util.Objects;

public class FindTheUniquetStringJava {
    // just because it looks like fun


    //There is an array of strings. All strings contains similar letters except one. Try to find it!
    //
    //findUniq([ 'Aa', 'aaa', 'aaaaa', 'BbBb', 'Aaaa', 'AaAaAa', 'a' ]) === 'BbBb'
    //findUniq([ 'abc', 'acb', 'bac', 'foo', 'bca', 'cab', 'cba' ]) === 'foo'
    //Strings may contain spaces. Spaces is not significant, only non-spaces symbols matters. E.g. string that contains only spaces is like empty string.
    //
    //It’s guaranteed that array contains more than 3 strings.

    public static void main(String[] args) {
        System.out.println(findUniq(new String[]{"Aa", "aaa", "aaaaa", "BbBb", "Aaaa", "AaAaAa", "a"}));
        System.out.println(findUniq(new String[]{"Tom Marvolo Riddle", "I am Lord Voldemort", "Harry Potter"}));
        System.out.println(findUniq(new String[]{"abc", "acb", "bac", "foo", "bca", "cab", "cba"}));
        System.out.println(findUniq(new String[]{"silvia", "vasili", "victor"}));
    }

    public static String findUniq(String[] stringArray) {

        String[] returnArr = new String[stringArray.length];
        int count = 0;

        for (int i = 0; i < stringArray.length; i++) {
            StringBuilder sb = new StringBuilder();
            char[] arr = stringArray[i].toLowerCase(Locale.ROOT).toCharArray();
            Arrays.sort(arr);
            for (char ch : arr) {
                sb.append(ch);
            }
            returnArr[i] = sb.toString();
        }

        String a = Arrays.stream(returnArr).filter(e -> !e.contains(returnArr[0])).findAny().get();
        for (int s = 0; s < returnArr.length; s++) {
            if (Objects.equals(returnArr[s], a)) {
                count = s;
            }
        }
        return stringArray[count];
    }
}
