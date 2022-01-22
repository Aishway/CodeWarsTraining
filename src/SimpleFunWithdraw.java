import java.util.ArrayList;
import java.util.Arrays;

public class SimpleFunWithdraw {
    //Task
    //An ATM ran out of 10 dollar bills and only has 100, 50 and 20 dollar bills.
    //
    //Given an amount between 40 and 10000 dollars (inclusive) and assuming that the ATM wants to use as few bills as possible, determinate the minimal number of 100, 50 and 20 dollar bills the ATM needs to dispense (in that order).
    //
    //Example
    //For n = 250, the result should be [2, 1, 0].
    //
    //For n = 260, the result should be [2, 0, 3].
    //
    //For n = 370, the result should be [3, 1, 1].
    //
    //Input/Output
    //[input] integer n Amount of money to withdraw. Assume that n is always exchangeable with [100, 50, 20] bills.
    //[output] integer array An array of number of 100, 50 and 20 dollar bills needed to complete the withdraw (in that order).

    public static void main(String[] args) {

        System.out.println(Arrays.toString(withdraw(40)));
        System.out.println(Arrays.toString(withdraw(250)));
        System.out.println(Arrays.toString(withdraw(260)));
        System.out.println(Arrays.toString(withdraw(230)));

    }

    public static int[] withdraw(int n) {

        int[] result = new int[3];
        if (n % 100 == 10 || n % 100 == 30) {
            result[0] = (n / 100) - 1;
            n -= ((n / 100) - 1) * 100;
        } else {
            result[0] = n / 100;
            n -= n / 100 * 100;
        }
        int m = 0;
        int count = 0;

        if ((n / 50) > 1 && (n % 50) % 20 == 0) {
            result[1] = n / 50;
            result[2] = (n % 50) / 20;
        } else {
            m = n;
            while (m % 50 != 0){
                count++;
                m-=20;
            }
            result[1] = (n - ( count * 20)) / 50;
            result[2] = count;
        }
        return result;
    }
}
