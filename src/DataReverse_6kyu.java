import java.util.Arrays;

public class DataReverse_6kyu {
    // A stream of data is received and needs to be reversed.
    //
    //Each segment is 8 bits long, meaning the order of these segments needs to be reversed, for example:
    //
    //11111111  00000000  00001111  10101010
    // (byte1)   (byte2)   (byte3)   (byte4)
    //should become:
    //
    //10101010  00001111  00000000  11111111
    // (byte4)   (byte3)   (byte2)   (byte1)
    //The total number of bits will always be a multiple of 8.
    //
    //The data is given in an array as such:
    //
    //[1,1,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,0,1,0,1,0,1,0]
    //Note: In the C and NASM languages you are given the third parameter which is the number of segment blocks.

    public static void main(String[] args) {
        System.out.println(Arrays.toString(DataReverse(new int[]{1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 0, 1, 0, 1, 0, 1, 0})));
    }

    public static int[] DataReverse(int[] data) {
        int[][] newArr = new int[(data.length / 8)][8];
        int a = 0;
        int b = 0;

        for (int i = 0; i < data.length; i++) {
            newArr[a][b] = data[i];
            b++;
            if ((i + 1) % 8 == 0) {
                a++;
                b = 0;
            }
        }

        int[] result = new int[data.length];
        int index = 0;

        for (int i = newArr.length-1; i >= 0; i--) {
            for (int j = 0; j < newArr[i].length; j++) {
                result[index] = newArr[i][j];
                index++;
            }
        }
        return result;
    }
}
