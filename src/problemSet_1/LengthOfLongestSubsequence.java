package problemSet_1;

import java.util.List;

// https://www.interviewbit.com/problems/length-of-longest-subsequence/
public class LengthOfLongestSubsequence {

    public int longestSubsequenceLength(final List<Integer> A) {
        if (A.size() == 0) return 0;
        int[] arr = new int[A.size()];
        for(int i = 1; i < arr.length; i++) {
            for(int j = 0; j < i; j++) {
                if (A.get(j) < A.get(i))
                    arr[i] = Math.max(arr[i], arr[j]+1);
            }
        }
        int ans = arr[arr.length-1] +1;
        int[] arr2 = new int[arr.length];
        for(int i = arr2.length-2; i >= 0; i--) {
            for(int j = arr2.length-1; j > i ; j--) {
                if (A.get(j) < A.get(i))
                    arr2[i] = Math.max(arr2[i], arr2[j] +1);
            }
            ans = Math.max(ans, arr[i] + arr2[i] +1);
        }

        return ans;
    }
}
