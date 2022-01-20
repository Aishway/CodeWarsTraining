import java.util.Arrays;
import java.util.stream.LongStream;

public class RowOfTheOddTriangle {
    public static void main(String[] args) {

//        Given a triangle of consecutive odd numbers:
//
//        1
//        3     5
//        7     9    11
//        13    15    17    19
//        21    23    25    27    29
//...
//        find the triangle's row knowing its index (the rows are 1-indexed), e.g.:
//
//        odd_row(1)  ==  [1]
//        odd_row(2)  ==  [3, 5]
//        odd_row(3)  ==  [7, 9, 11]
//        Note: your code should be optimized to handle big inputs.

        System.out.println(Arrays.toString(oddRow(5)));
    }

    public static long[] oddRow(int n) {
        long row = ((long) n * n) - (n - 1);
        return LongStream.range(0, n).map(e -> row + e * 2).toArray();
    }
}
