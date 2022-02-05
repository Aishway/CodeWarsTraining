import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class SumConsecutives_6kyu {
//    You are given a list/array which contains only integers (positive and negative). Your job is to sum only the
//    numbers that are the same and consecutive. The result should be one list.
//
//Extra credit if you solve it in one line. You can assume there is never an empty list/array and there will always be
// an integer.
//
//Same meaning: 1 == 1
//
//1 != -1

    public static void main(String[] args) {
        List<Integer> i = Arrays.asList(1, 4, 4, 4, 0, 4, 3, 3, 1);
        System.out.println(sumConsecutives(i));
    }

    public static List<Integer> sumConsecutives(List<Integer> s) {
        List<Integer> result = new ArrayList<>();
        int count = 1;

        for (int i = 0; i < s.size() - 1; i++) {
            if (s.get(i) == s.get(i + 1)) {
                count++;
            } else {
                result.add(s.get(i) * count);
                count = 1;
            }
        }

        if (count > 1) {
            result.add(s.get(s.size() - 1) * count);
        } else {
            result.add(s.get(s.size() - 1));
        }
        return result;
    }
}
