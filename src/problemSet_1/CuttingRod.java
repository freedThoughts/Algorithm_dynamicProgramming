package problemSet_1;

public class CuttingRod {
    public static void main(String[] strings) {
        int[] rodLenArr = {1, 2, 3, 4, 5, 6, 7, 8};//{1, 2, 3, 4};
        int[] priceArr = {3, 5, 8, 9, 10, 17, 17, 20};//{2, 5, 7, 8};
        System.out.println(getMaxValue(rodLenArr, priceArr));


        int[] rodLenArr2 = {1, 2, 3, 4};
        int[] priceArr2 = {2, 5, 7, 8};
        int len = 5;
        System.out.println(getMaxValue(rodLenArr2, priceArr2, 5));

    }

    // https://www.youtube.com/watch?v=IRwVmTmN6go
    private static int getMaxValue(int[] rodLen, int[] price, int len) {
        int[][] matrix = new int[rodLen.length+1][len+1];
        for (int i = 1; i< matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (rodLen[i-1] > j) {
                    matrix[i][j] = matrix[i-1][j];
                } else
                    matrix[i][j] = Math.max(matrix[i-1][j], price[i-1] + matrix[i][j-rodLen[i-1]]);
            }
        }
        return matrix[rodLen.length][len];
    }



    //https://www.geeksforgeeks.org/cutting-a-rod-dp-13/
    private static int getMaxValue(int[] rodLength, int[] price) {
        int[] result = new int[rodLength.length];
        for (int i = 0; i < rodLength.length; i++) {
            result[i] = price[i];
            for (int j = 0, k = i-1; j <= k; j++, k--) {
                result[i] = Math.max(result[j] + result[k], result[i]);
            }
        }
        return result[rodLength.length-1];
    }
}
