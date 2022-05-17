package problemSet_1;

public class UniqueBinarySearchTreesii {

    public int numTrees(int A) {
        if (A == 0) return 0;
        if (A == 1) return 1;
        int[] arr = new int[A+1];
        arr[0] = 1;
        arr[1] = 1;
        arr[2] = 2;

        int i = 3;
        while(i <= A) {
            int val = 0;
            for(int j = i-1; j >=0; j--) {
                val += (arr[j] * arr[i-1-j]);
            }
            arr[i] = val;
            i++;
        }
        return arr[A];

    }
}
