import java.util.Arrays;

public class CatchingCarMileageNumbers {
//  7777...8?!??!", exclaimed Bob, "I missed it again! Argh!" Every time there's an interesting number coming up, he notices and then promptly forgets. Who doesn't like catching those one-off interesting mileage numbers?
//
//Let's make it so Bob never misses another interesting number. We've hacked into his car's computer, and we have a box hooked up that reads mileage numbers. We've got a box glued to his dash that lights up yellow or green depending on whether it receives a 1 or a 2 (respectively).
//
//It's up to you, intrepid warrior, to glue the parts together. Write the function that parses the mileage number input, and returns a 2 if the number is "interesting" (see below), a 1 if an interesting number occurs within the next two miles, or a 0 if the number is not interesting.
//
//Note: In Haskell, we use No, Almost and Yes instead of 0, 1 and 2.
//
//"Interesting" Numbers
//Interesting numbers are 3-or-more digit numbers that meet one or more of the following criteria:
//
//Any digit followed by all zeros: 100, 90000
//Every digit is the same number: 1111
//The digits are sequential, incementing†: 1234
//The digits are sequential, decrementing‡: 4321
//The digits are a palindrome: 1221 or 73837
//The digits match one of the values in the awesomePhrases array
//† For incrementing sequences, 0 should come after 9, and not before 1, as in 7890.
//‡ For decrementing sequences, 0 should come after 1, and not before 9, as in 3210.
//
//So, you should expect these inputs and outputs:
//
//// "boring" numbers
//CarMileage.isInteresting(3, new int[]{1337, 256});    // 0
//CarMileage.isInteresting(3236, new int[]{1337, 256}); // 0
//
//// progress as we near an "interesting" number
//CarMileage.isInteresting(11207, new int[]{}); // 0
//CarMileage.isInteresting(11208, new int[]{}); // 0
//CarMileage.isInteresting(11209, new int[]{}); // 1
//CarMileage.isInteresting(11210, new int[]{}); // 1
//CarMileage.isInteresting(11211, new int[]{}); // 2
//
//// nearing a provided "awesome phrase"
//CarMileage.isInteresting(1335, new int[]{1337, 256}); // 1
//CarMileage.isInteresting(1336, new int[]{1337, 256}); // 1
//CarMileage.isInteresting(1337, new int[]{1337, 256}); // 2
//Error Checking
//A number is only interesting if it is greater than 99!
//Input will always be an integer greater than 0, and less than 1,000,000,000.
//The awesomePhrases array will always be provided, and will always be an array, but may be empty. (Not everyone thinks numbers spell funny words...)
//You should only ever output 0, 1, or 2.


    public static void main(String[] args) {
//        System.out.println(isInteresting(3, new int[]{1337, 256}));
//        System.out.println(isInteresting(1336, new int[]{1337, 256}));
//        System.out.println(isInteresting(1337, new int[]{1337, 256}));
//        System.out.println(isInteresting(11208, new int[]{1337, 256}));
//        System.out.println(isInteresting(11209, new int[]{1337, 256}));
        System.out.println(isInteresting(109, new int[]{}));


    }

    public static int isInteresting(int number, int[] awesomePhrases) {
        System.out.println(number);
        System.out.println(Arrays.toString(awesomePhrases));

        if (String.valueOf(number).length() >= 3) {
            if (isFollowedByNumbers(number)) {
                return 2;
            } else if (isTheSameNumber(number)) {
                return 2;
            } else if (isIncementing(number)) {
                return 2;
            } else if (isDecrementing(number)) {
                return 2;
            } else if (isPalindrome(number)) {
                return 2;
            } else if (isInArray(number, awesomePhrases)) {
                return 2;
            }
        }

        if (String.valueOf(number + 1).length() >= 3) {
            if (isFollowedByNumbers(number + 1)) {
                return 1;
            } else if (isTheSameNumber(number + 1)) {
                return 1;
            } else if (isIncementing(number + 1)) {
                return 1;
            } else if (isDecrementing(number + 1)) {
                return 1;
            } else if (isPalindrome(number + 1)) {
                return 1;
            } else if (isInArray(number + 1, awesomePhrases)) {
                return 1;
            }
        }

        if (String.valueOf(number + 2).length() >= 3) {
            if (isFollowedByNumbers(number + 2)) {
                return 1;
            } else if (isTheSameNumber(number + 2)) {
                return 1;
            } else if (isIncementing(number + 2)) {
                return 1;
            } else if (isDecrementing(number + 2)) {
                return 1;
            } else if (isPalindrome(number + 2)) {
                return 1;
            } else if (isInArray(number + 2, awesomePhrases)) {
                return 1;
            }
        }
        return 0;
    }

    public static boolean isFollowedByNumbers(int number) {
        String numberToString = String.valueOf(number);
        for (int i = 1; i < numberToString.length(); i++) {
            if (numberToString.charAt(i) == '0') {
            } else {
                return false;
            }
        }
        return true;
    }

    public static boolean isTheSameNumber(int number) {
        String numberToString = String.valueOf(number);
        for (int i = 0; i < numberToString.length() - 1; i++) {
            if (numberToString.charAt(i) == numberToString.charAt(i + 1)) {
            } else {
                return false;
            }
        }
        return true;
    }

    public static boolean isDecrementing(int number) {
        int[] digits = Integer.toString(number).chars().map(c -> c - '0').toArray();

        for (int i = 0; i < digits.length - 1; i++) {
            if (digits[i] == 0 && digits[i - 1] == 1 && i == digits.length - 1) {
            } else if (digits[i] - 1 == digits[i + 1]) {
            } else {
                return false;
            }
        }
        return true;
    }

    public static boolean isIncementing(int number) {
        int[] digits = Integer.toString(number).chars().map(c -> c - '0').toArray();

        for (int i = 0; i < digits.length - 1; i++) {
            if (digits[i] == 9 && digits[i + 1] == 0 && i + 1 == digits.length - 1) {
            } else if (digits[i] + 1 == digits[i + 1]) {
            } else {
                return false;
            }
        }
        return true;
    }

    public static boolean isPalindrome(int number) {
        int temp = number;
        int reverse = 0;
        int start = 0;
        while (number != 0) {
            start = number % 10;
            reverse = reverse * 10 + start;
            number = number / 10;
        }
        if (reverse == temp) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isInArray(int number, int[] array) {
        if (array.length == 0) {
            return false;
        }

        for (int i : array) {
            if (i == number) {
                return true;
            }
        }

        return false;
    }
}




