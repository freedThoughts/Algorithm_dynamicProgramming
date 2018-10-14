package problemSet_1;

/**
 * Created by Prakash on 23-08-2018.
 */
public class EggDropping {

    public static void main(String[] a) {
        int floors = 10;
        int eggs = 2;
        int[][] matrix = new int[eggs+1][floors +1];
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < 2; j++){
                if(j == 0)
                    matrix[i][j] = 0;
                else
                    matrix[i][j] = 1;
            }
        }

        for(int j = 1; j < floors+1; j++ ){
            matrix[1][j] = j;
        }

        for(int i = 2; i < matrix.length; i++){
            for(int j = 2; j < floors+1; j++){
                if(i > j){
                    matrix[i][j] = matrix[i-1][ j];
                    continue;
                }
                int minValue = Integer.MAX_VALUE;
                for(int k = 2; k <= j; k++){
                    int value = 1 + Math.max(matrix[i-1][k-1], matrix[i][j-k]);
                    minValue = Math.min(minValue, value);
                }
                matrix[i][j] = minValue;
            }
        }

        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < floors+1; j++){
                System.out.print(matrix[i][j] +"  ");
            }
            System.out.println();
        }

    }
}
