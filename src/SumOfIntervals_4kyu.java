import java.util.*;

public class SumOfIntervals_4kyu {
//    Write a function called sumIntervals/sum_intervals() that accepts an array of intervals, and returns the sum of
//    all the interval lengths. Overlapping intervals should only be counted once.
//
//Intervals
//Intervals are represented by a pair of integers in the form of an array. The first value of the interval will always
// be less than the second value. Interval example: [1, 5] is an interval from 1 to 5. The length of this interval is 4.
//
//Overlapping Intervals
//List containing overlapping intervals:
//
//[
//   [1,4],
//   [7, 10],
//   [3, 5]
//]
//The sum of the lengths of these intervals is 7. Since [1, 4] and [3, 5] overlap, we can treat the interval as [1, 5],
// which has a length of 4.
//
//Examples:
//// null argument
//Interval.sumIntervals(null);  // => 0
//
//// empty intervals
//Interval.sumIntervals(new int[][]{});  // => 0
//Interval.sumIntervals(new int[][]{2,2}, {5,5});  // => 0
//
//// disjoined intervals
//Interval.sumIntervals(new int[][]{
//  {1,2},{3,5}
//});  // => (2-1) + (5-3) = 3
//
//// overlapping intervals
//Interval.sumIntervals(new int[][]{
//  {1,4},{3,6},{2,8}
//});  // [1,8] => 7
//    https://www.w3schools.com/java/java_hashset.asp


    public static void main(String[] args) {
        System.out.println(sumIntervals(new int[][]{{1, 2}, {2, 6}, {6, 55}}));
        System.out.println(sumIntervals(new int[][]{{1, 2}, {6, 10}, {11, 15}}));
    }

    public static int sumIntervals(int[][] intervals) {
        if (intervals == null)
            return 0;

        Set<Integer> result = new HashSet<>();
        for (int i = 0; i < intervals.length; i++) {
            for (int j = intervals[i][0]; j < intervals[i][1]; j++) {
                result.add(j);
            }
        }
        return result.size();
    }
}
