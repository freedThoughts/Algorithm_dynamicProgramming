package problemSet_1;

/**
 * Created by Prakash on 23-05-2018.
 */
public class LongestCommonSubsequence_DP {

    private static int getLongestCommonSubsequence2(String str1, String str2) {
        int[][] matrix = new int[str1.length()+1][str2.length()+1];
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (str1.charAt(i-1) == str2.charAt(j-1))
                    matrix[i][j] = matrix[i-1][j-1] + 1;
                else
                    matrix[i][j] = Math.max(matrix[i-1][j], matrix[i][j-1]);
            }
        }

        System.out.println(getCommonString2(matrix, str1, str2));
        return matrix[str1.length()][str2.length()];
    }

    private static String getCommonString2(int[][] matrix, String str1, String str2) {
        StringBuffer stringBuffer = new StringBuffer();

        int i = matrix.length-1, j = matrix[0].length-1;
        while (i > 0 && j > 0) {
            if (str1.charAt(i-1) == str2.charAt(j-1)) {
                char[] chars = {str1.charAt(i-1)};
                stringBuffer = new StringBuffer(new String(chars)).append(stringBuffer);
                i--; j--;
            } else if (matrix[i][j] == matrix[i-1][j]) {
                i--;
            } else
                j--;
        }
        return new String(stringBuffer);

    }

    private static int getLongestCommonSubsequence(String str1, String str2){
        int[][] matrix = new int[str1.length() +1][str2.length() +1];


        for(int str1Ch = 0; str1Ch < str1.length() +1; str1Ch ++){
            for(int str2Ch = 0; str2Ch < str2.length() +1; str2Ch ++){

                if(str1Ch == 0 || str2Ch == 0){
                    matrix[str1Ch][str2Ch] = 0;
                    continue;
                }

                if(str1.charAt(str1Ch -1) != str2.charAt(str2Ch -1)){
                    matrix[str1Ch][str2Ch] = Math.max(matrix[str1Ch -1][str2Ch], matrix[str1Ch][str2Ch-1]);
                    continue;
                }

                matrix[str1Ch][str2Ch] = 1 + matrix[str1Ch -1][str2Ch -1];
            }
        }

        System.out.println(getCommonString(matrix, str1, str2));
        return matrix[str1.length()][str2.length()];
    }

    private static String getCommonString(int[][] matrix, String str1, String str2){
        int row = str1.length();
        int column = str2.length();

        int subsequenceLength = matrix[row][column];
        char[] subsequence = new char[subsequenceLength];
        int indexOfSubSequence = subsequenceLength -1;

        while(row > 0 && column > 0){
            if(str1.charAt(row -1) == str2.charAt(column -1)){
                subsequence[indexOfSubSequence] = str1.charAt(row -1);
                indexOfSubSequence --;
                row --;
                column --;
                continue;
            }
            if(matrix[row -1][column] > matrix[row][column -1]){
                row--;
                continue;
            }
            column--;
        }
        return new String(subsequence);
    }

    public static void main(String[] s){
        System.out.println(getLongestCommonSubsequence2("AGGTAB", "GXTXAYB"));
    }
}
