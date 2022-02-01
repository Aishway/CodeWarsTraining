import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ArrayDiff_6kyu {
    // Your goal in this kata is to implement a difference function, which subtracts one list from another and
    // returns the result.
    //
    //It should remove all values from list a, which are present in list b keeping their order.
    //
    //Kata.arrayDiff(new int[] {1, 2}, new int[] {1}) => new int[] {2}
    //If a value is present in b, all of its occurrences must be removed from the other:
    //
    //Kata.arrayDiff(new int[] {1, 2, 2, 2, 3}, new int[] {2}) => new int[] {1, 3}
    public static void main(String[] args) {
        System.out.println(Arrays.toString(arrayDiff(new int[]{1, 2}, new int[]{1})));
        System.out.println(Arrays.toString(arrayDiff(new int[]{1, 2, 2}, new int[]{1})));
        System.out.println(Arrays.toString(arrayDiff(new int[]{1, 2, 2}, new int[]{2})));
    }

    public static int[] arrayDiff(int[] a, int[] b) {
        List<Integer> listOne = Arrays.stream(a).mapToObj(e -> e).collect(Collectors.toList());
        List<Integer> list = Arrays.stream(b).mapToObj(e -> e).collect(Collectors.toList());
        listOne.removeAll(list);
        return listOne.stream().mapToInt(Integer::intValue).toArray();
    }
}
