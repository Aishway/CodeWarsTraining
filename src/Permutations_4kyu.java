import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Permutations_4kyu {
    // In this kata you have to create all permutations of an input string and remove duplicates, if present.
    // This means, you have to shuffle all letters from the input in all possible orders.

    public static void main(String[] args) {
        System.out.println(singlePermutations("a"));
    }

    public static List<String> singlePermutations(String s) {
        return permutation("", s);
    }

    private static List<String> permutation(String prefix, String str) {
        List<String> permutations = new ArrayList<>();
        int n = str.length();
        if (n == 0) {
            permutations.add(prefix);
        } else {
            for (int i = 0; i < n; i++) {
                permutations.addAll(permutation(prefix + str.charAt(i), str.substring(i + 1, n) + str.substring(0, i)));
            }
        }
        permutations = permutations.stream().distinct().collect(Collectors.toList());
        return permutations;
    }
}
