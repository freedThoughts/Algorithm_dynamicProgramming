package problemSet_1;

/**
 * Created by Prakash on 13-10-2018.
 */
public class LongestPalindromicSubsequence {
    public static void main(String[] a) {
        String str = "azbdba";
        char[] chars = str.toCharArray();
        int[][] matrix = new int[chars.length][chars.length];
        for (int i = 0; i < chars.length; i++)
            matrix[i][i] = 1;

        int len = 0;
        while (len < chars.length) {
            for (int i = 0; i < chars.length - len; i++){
                int j = i + len;
                solveIt(chars, matrix, i, j);
            }
            len++;
        }
        System.out.println(matrix[0][chars.length -1]);
    }

    private static void solveIt(char[] chars, int[][] matrix, int startIndex, int endIndex){
        if (startIndex == endIndex)
            matrix[startIndex][endIndex] = 1;
        else if (chars[startIndex] == chars[endIndex]) {
            int newStart = startIndex +1;
            int newEnd = endIndex -1;
            matrix[startIndex][endIndex] = 2 + ((newEnd - newStart) >= 0 ? matrix[newStart][newEnd] : 0);
        } else {
            matrix[startIndex][endIndex] = Math.max(matrix[startIndex][endIndex -1], matrix[startIndex +1][endIndex]);
        }

    }
}
