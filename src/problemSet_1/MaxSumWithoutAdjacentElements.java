package problemSet_1;

import java.util.ArrayList;
// https://www.interviewbit.com/problems/max-sum-without-adjacent-elements/
public class MaxSumWithoutAdjacentElements {

    public static void main(String[] arg) {
        ArrayList<ArrayList<Integer>> A = new ArrayList<>();
        ArrayList<Integer> a = new ArrayList<>();
        a.add(74);
        a.add(66);
        A.add(a);

        a = new ArrayList<>();
        a.add(37);
        a.add(38);
        A.add(a);

        a = new ArrayList<>();
        a.add(82);
        a.add(16);
        A.add(a);

        a = new ArrayList<>();
        a.add(1);
        a.add(1);
        A.add(a);

        System.out.println(adjacent(A));



/*                [74, 37, 82, 1]
                [66, 38, 16, 1]*/
    }

    public static int adjacent(ArrayList<ArrayList<Integer>> A) {
        int last = Math.max(A.get(1).get(0), A.get(1).get(1));
        int secLast = Math.max(A.get(0).get(0), A.get(0).get(1));
        int ans = Math.max(last, secLast);

        for(int i = 2; i < A.size(); i++) {
            int max = Math.max(A.get(i).get(0), A.get(i).get(1));
            ans =  Math.max(max + secLast, last);
            secLast = Math.max(secLast, last);
            last = ans;
        }

        return ans;
    }
}
