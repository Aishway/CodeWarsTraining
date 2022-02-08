import java.util.Arrays;

public class NextBiggerNumberWithTheSameDigits_4kyu {
//    Create a function that takes a positive integer and returns the next bigger number that can be formed by
//    rearranging its digits. For example:
//
//            12 ==> 21
//            513 ==> 531
//            2017 ==> 2071
//    nextBigger(num: 12)   // returns 21
//    nextBigger(num: 513)  // returns 531
//    nextBigger(num: 2017) // returns 2071
//    If the digits can't be rearranged to form a bigger number, return -1 (or nil in Swift):
//
//            9 ==> -1
//            111 ==> -1
//            531 ==> -1
//    nextBigger(num: 9)   // returns nil
//    nextBigger(num: 111) // returns nil
//    nextBigger(num: 531) // returns nil

    public static void main(String[] args) {
        //   System.out.println(nextBiggerNumber(12));
        //    System.out.println(nextBiggerNumber(513));
        //   System.out.println(nextBiggerNumber(2017));
        //  System.out.println(nextBiggerNumber(144));
        System.out.println(nextBiggerNumber(10990));
    }

    public static long nextBiggerNumber(long n) {
        if (String.valueOf(n).length() < 1) {
            return -1;
        }

        String number = String.valueOf(n);
        char[] temporalarray = number.toCharArray();

        for (int i = temporalarray.length - 2; i >= 0; i--) {
            for (int j = temporalarray.length - 1; j >= 0; j--) {
                if (temporalarray[i] < temporalarray[j]) {
                    char temp = temporalarray[i];
                    temporalarray[i] = temporalarray[j];
                    temporalarray[j] = temp;
                    Arrays.sort(temporalarray, i + 1, temporalarray.length);
                    return Long.parseLong(String.valueOf(temporalarray));
                }
            }
        }
        return -1;
    }
}
