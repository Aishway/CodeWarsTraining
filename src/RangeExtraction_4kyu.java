public class RangeExtraction_4kyu {
//    A format for expressing an ordered list of integers is to use a comma separated list of either
//
//individual integers
//or a range of integers denoted by the starting integer separated from the end integer in the range by a dash, '-'.
// The range includes all integers in the interval including both endpoints. It is not considered a range unless it
// spans at least 3 numbers. For example "12,13,15-17"
//Complete the solution so that it takes a list of integers in increasing order and returns a correctly formatted
// string in the range format.
//
//Example:
//
//Solution.rangeExtraction(new int[] {-10, -9, -8, -6, -3, -2, -1, 0, 1, 3, 4, 5, 7, 8, 9, 10, 11, 14, 15, 17, 18, 19, 20})
//# returns "-10--8,-6,-3-1,3-5,7-11,14,15,17-20"

    public static void main(String[] args) {
        System.out.println(rangeExtraction(new int[]{-10, -9, -8, -6, -3, -2, -1, 0, 1, 3, 4, 5, 7, 8, 9, 10, 11, 14, 15, 17, 18, 19, 20}));
        System.out.println(rangeExtraction(new int[]{-6, -3, -2, -1, 0, 1, 3, 4, 5, 7, 8, 9, 10, 11, 14, 15, 17, 18, 19, 20}));
        System.out.println(rangeExtraction(new int[]{-39, -38, -35, -33, -32, -31, -28, -27, -24, -21, -18, -17, -16, -13, -10, -8, -6, -4, -1, 1, 4, 6, 8, 11, 13, 15, 18}));
    }

    public static String rangeExtraction(int[] arr) {
        StringBuilder sb = new StringBuilder();
        int count;

        for (int i = 0; i <= arr.length - 1; i++) {
            sb.append(arr[i]);
            count = i;
            while (count < arr.length - 1 && arr[count] + 1 == arr[count + 1]) {
                count++;
            }

            if (i + 1 < count) {
                i = count;
                sb.append("-" + arr[i]);
            }
            sb.append(",");
        }
        return sb.toString().substring(0,sb.length()-1);
    }
}
