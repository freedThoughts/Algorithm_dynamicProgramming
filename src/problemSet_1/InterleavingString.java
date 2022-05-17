package problemSet_1;

public class InterleavingString {

    public boolean isInterleave(String s1, String s2, String s3) {

        if (s1.charAt(0) != s3.charAt(0)) {
            String s = s1;
            s1 = s2; s2 = s;
        }

        int i = 0, j = 0, k = 0;
        while ((i < s1.length() || j < s2.length() ) && k < s3.length()) {
            while(i < s1.length() && k < s3.length() && s1.charAt(i) == s3.charAt(k)) {
                i++; k++;
            }

            while (j < s2.length() && k < s3.length() && s2.charAt(j) == s3.charAt(k)) {
                j++; k++;
            }
            if (!(i < s1.length() && k < s3.length() && s1.charAt(i) == s3.charAt(k))) break;
        }

        if (k == s3.length() && i == s1.length() && j == s2.length()) return true;
        return false;
    }

}
