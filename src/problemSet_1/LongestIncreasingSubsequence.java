package problemSet_1;

/**
 * Created by Prakash on 13-10-2018.
 */
public class LongestIncreasingSubsequence {
    public static void main(String[] a) {
        int[] arr = {3, 4, -1, 0, 6, 2, 3};
        int[] answer = new int[arr.length];
        answer[0] = 1;
        for (int i = 1; i < arr.length; i++) {
            int resultIndex = -1;
            for (int j = i -1; j >=0; j--)
                if (arr[j] < arr[i] && (resultIndex == -1 ||
                        // When previous calculated index i.e resultIndex have same length as of index j.
                        // We will take index holding minimum value
                        (answer[resultIndex] == answer[j] && arr[resultIndex] > arr[j]))) {
                    resultIndex = j;
                }

            answer[i] = 1 + (resultIndex == -1 ? 0 : answer[resultIndex]);
        }

        for (int i : answer)
            System.out.println(i);
    }
}
