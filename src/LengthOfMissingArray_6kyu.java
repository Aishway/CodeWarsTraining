import java.util.Arrays;

public class LengthOfMissingArray_6kyu {
//    You get an array of arrays.
//If you sort the arrays by their length, you will see, that their length-values are consecutive.
//But one array is missing!
//
//
//You have to write a method, that return the length of the missing array.
//
//Example:
//[[1, 2], [4, 5, 1, 1], [1], [5, 6, 7, 8, 9]] --> 3
//
//If the array of arrays is null/nil or empty, the method should return 0.
//
//When an array in the array is null or empty, the method should return 0 too!
//There will always be a missing element and its length will be always between the given arrays.
//
//Have fun coding it and please don't forget to vote and rank this kata! :-)

    public static void main(String[] args) {
        System.out.println(getLengthOfMissingArray(new Object[][]{new Object[]{1, 2},
                new Object[]{4, 5, 1, 1}, new Object[]{1}, new Object[]{5, 6, 7, 8, 9}}));
    }

    public static int getLengthOfMissingArray(Object[][] arrayOfArrays) {
        if (arrayOfArrays == null || arrayOfArrays.length == 0) {
            return 0;
        }

        int arr[] = new int[arrayOfArrays.length];

        for (int i = 0; i < arrayOfArrays.length; i++) {
            if (arrayOfArrays[i] == null || arrayOfArrays[i].length == 0) {
                return 0;
            }
            int j = arrayOfArrays[i].length;
            arr[i] = j;
        }

        arr = Arrays.stream(arr).sorted().toArray();

        int a = arr[0];

        for (int i = 0; i < arr.length; i++) {
            if (a != arr[i]) {
                return a;
            }
            a++;
        }

        return 0;
    }
}
