import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FindTheParityOutlier {
    public static void main(String[] args) {

// You are given an array (which will have a length of at least 3, but could be very large) containing integers.
// The array is either entirely comprised of odd integers or entirely comprised of even integers except for
// a single integer N. Write a method that takes the array as an argument and returns this "outlier" N.
//
//Examples
//[2, 4, 0, 100, 4, 11, 2602, 36]
//Should return: 11 (the only odd number)
//
//[160, 3, 1719, 19, 11, 13, -21]
//Should return: 160 (the only even number)
    }

//    static int find(int[] integers){
//      List<Integer> i =   Arrays.stream(integers).filter(e -> e % 2 == 0).boxed().collect(Collectors.toList());
//      return i.size() == 1 ? i.get(0) : Arrays.stream(integers).filter(e -> e % 2 != 0).findFirst().getAsInt();
//    }}

}
