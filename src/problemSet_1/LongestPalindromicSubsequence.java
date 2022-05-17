package problemSet_1;

/**
 * Created by Prakash on 13-10-2018.
 */

// https://leetcode.com/problems/longest-palindromic-subsequence/submissions/
public class LongestPalindromicSubsequence {


    public int longestPalindromeSubseq(String s) {
        int len = s.length();
        int[][] matrix = new int[len][len];

        for(int k = 0; k < len; k++) {
            for(int i = 0, j = k; j < len; j++, i++){
                if (s.charAt(i) == s.charAt(j)) {
                    if (i == j) matrix[i][j] = 1;
                    else matrix[i][j] = 2 + matrix[i+1][j-1];
                    continue;
                }

                int max = 0;
                for(int m = i; m < j; m++)
                    max = Math.max(max, Math.max(matrix[i][m], matrix[m+1][j]));
                matrix[i][j] = max;
            }
        }
        return matrix[0][len-1];
    }



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
