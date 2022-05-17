package problemSet_1;

import java.util.ArrayList;
import java.util.Arrays;

// https://leetcode.com/problems/maximum-length-of-pair-chain/
// https://www.interviewbit.com/problems/chain-of-pairs/
public class ChainOfPairs {

    public int findLongestChain33(int[][] pairs) {

        Arrays.sort(pairs, (a, b) -> ((Integer)a[0]).compareTo((Integer) b[0]));
        int[] arr = new int[pairs.length];
        for(int i = 1; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if(pairs[j][1] < pairs[i][0])
                    arr[i] = Math.max(arr[i], arr[j]+1);
            }
        }

        return arr[arr.length-1]+1;
    }

    public static void main(String[] arg) {

        ArrayList<ArrayList<Integer>> A = new ArrayList<>();
/*        ArrayList<Integer> a = new ArrayList<>();
        a.add(5);
        a.add(24);
        A.add(a);

        a = new ArrayList<>();
        a.add(39);
        a.add(60);
        A.add(a);

        a = new ArrayList<>();
        a.add(15);
        a.add(28);
        A.add(a);

        a = new ArrayList<>();
        a.add(27);
        a.add(40);
        A.add(a);

        a = new ArrayList<>();
        a.add(50);
        a.add(90);
        A.add(a);*/

/*  [98, 894]
  [397, 942]
  [70, 519]
  [258, 456]
  [286, 449]
  [516, 626]
  [370, 873]
  [214, 224]
  [74, 629]
  [265, 886]
  [708, 815]
  [394, 770]
  [56, 252]*/


        ArrayList<Integer> a = new ArrayList<>();
        a.add(98);
        a.add(894);
        A.add(a);

        a = new ArrayList<>();
        a.add(397);
        a.add(942);
        A.add(a);

        a = new ArrayList<>();
        a.add(70);
        a.add(519);
        A.add(a);

        a = new ArrayList<>();
        a.add(258);
        a.add(449);
        A.add(a);

        a = new ArrayList<>();
        a.add(286);
        a.add(449);
        A.add(a);

        a = new ArrayList<>();
        a.add(516);
        a.add(626);
        A.add(a);

        a = new ArrayList<>();
        a.add(370);
        a.add(873);
        A.add(a);

        a = new ArrayList<>();
        a.add(214);
        a.add(224);
        A.add(a);



        a = new ArrayList<>();
        a.add(74);
        a.add(629);
        A.add(a);

        a = new ArrayList<>();
        a.add(265);
        a.add(886);
        A.add(a);

        a = new ArrayList<>();
        a.add(708);
        a.add(815);
        A.add(a);

        a = new ArrayList<>();
        a.add(394);
        a.add(770);
        A.add(a);

        a = new ArrayList<>();
        a.add(56);
        a.add(252);
        A.add(a);


        System.out.println(solve(A));

    }

    public static int solve(ArrayList<ArrayList<Integer>> A) {
        int[][] matrix = new int[A.size()][A.size()];
        for(int i = 0; i < A.size(); i++) {
            matrix[i][i] = 1;
        }

        for(int k = 1; k < A.size(); k++) {
            for (int i = 0, j = k; j < A.size(); i++, j++) {
                int max = 0;
                for(int m = i, n = i, p = i+1, q = j; n < j; n++, p++) {
                    max = Math.max(max, inChain(A, matrix, m, n, p, q));
                }
                matrix[i][j] = max;
            }
        }

        return matrix[0][matrix[0].length-1];
    }

    static int inChain(ArrayList<ArrayList<Integer>> A, int[][] matrix, int m, int n, int p, int q){
        int aVal = A.get(n).get(1);
        int bVal = A.get(p).get(0);
        if (aVal < bVal) return matrix[m][n] + matrix[p][q];
        return Math.max(matrix[m][n], matrix[p][q]);
    }
}
