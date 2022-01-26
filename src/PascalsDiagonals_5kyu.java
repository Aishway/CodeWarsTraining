public class PascalsDiagonals_5kyu {
    // Create a function that returns an array containing the first l numbers from the nth diagonal of Pascal's triangle.
    //
    //n = 0 should generate the first diagonal of the triangle (the ones).
    //The first number in each diagonal should be 1.
    //If l = 0, return an empty array.
    //Both n and l will be non-negative integers in all test cases.

    public static void main(String[] args) {

    }

    public static long[] generateDiagonal(int n, int l) {
        long[] result = new long[l];
        if(l > 0) { result[0] = 1;}
        for(int i = 1; i < l; i++) {
            result[i] =  ( result[i-1] *  (n + i) /  i);
        }

        return result;
    }
}
