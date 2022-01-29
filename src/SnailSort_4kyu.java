import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SnailSort_4kyu {
    //    Given an n x n array, return the array elements arranged from outermost elements to the middle element,
//    traveling clockwise.
//
//array = [[1,2,3],
//         [4,5,6],
//         [7,8,9]]
//snail(array) #=> [1,2,3,6,9,8,7,4,5]
//For better understanding, please follow the numbers of the next array consecutively:
//
//array = [[1,2,3],
//         [8,9,4],
//         [7,6,5]]
//snail(array) #=> [1,2,3,4,5,6,7,8,9]
//This image will illustrate things more clearly:
//
//
//NOTE: The idea is not sort the elements from the lowest value to the highest; the idea is to traverse the 2-d array
// in a clockwise snailshell pattern.
//
//NOTE 2: The 0x0 (empty matrix) is represented as en empty array inside an array [[]].
    public static void main(String[] args) {
        int[][] array
                = {{1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}};

        System.out.println(Arrays.toString(snail(array)));
    }

    public static int[] snail(int[][] array) {
        List<Integer> list = new ArrayList<>();
        if (array[0].length ==0 ) { return new int[]{}; }
        int leftRight = 0;
        int bottomLeft = 0;
        int arraySize = array.length;
        boolean doWeHaveWholeCircle = false;

        while (!doWeHaveWholeCircle) {

            for (int i = leftRight; i < arraySize-1; i++) {
                list.add(array[leftRight][i]);
            }

            for (int i = leftRight; i < arraySize-1; i++) {
                list.add(array[i][arraySize-1]);
            }

            for (int i = arraySize-1; i > bottomLeft; i--) {
                list.add(array[arraySize-1][i]);
            }

            for (int i = arraySize-1; i > bottomLeft; i--) {
                list.add(array[i][bottomLeft]);
            }

            if (arraySize - leftRight == 1 ) {
                list.add(array[leftRight][leftRight]);
            }

            leftRight++;
            bottomLeft++;
            arraySize--;

            if (arraySize == array.length / 2) {
                doWeHaveWholeCircle = true;
            }
        }

        int [] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++){
            result[i] = list.get(i);
        }
        return result;
    }
}

