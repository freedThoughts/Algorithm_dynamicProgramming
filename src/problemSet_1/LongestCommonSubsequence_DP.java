package problemSet_1;

/**
 * Created by Prakash on 23-05-2018.
 */
public class LongestCommonSubsequence_DP {

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
        System.out.println(getLongestCommonSubsequence("AGGTAB", "GXTXAYB"));
    }
}
