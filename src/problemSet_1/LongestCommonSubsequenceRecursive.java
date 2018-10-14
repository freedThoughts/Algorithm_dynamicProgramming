package problemSet_1;

import java.util.Scanner;

public class LongestCommonSubsequenceRecursive {
	
	private static int getLengthLCS(int i, int j, String str1, String str2){
		if(i == str1.length() || j == str2.length())
			return 0;
		
		else if(str1.charAt(i) == str2.charAt(j))
			return 1 + getLengthLCS(++i, ++j, str1, str2);
		
		else return Math.max(getLengthLCS(++i,  j, str1, str2), 
				getLengthLCS(i, ++j, str1, str2));
	}

	public static void main(String[] args) {
		System.out.println("Enter Strings ");
        Scanner in = new Scanner(System.in);
        String str1 = in.next();
        String str2 = in.next();
        in.close();
        
        System.out.println("Length : " + getLengthLCS(0, 0, str1, str2));
	}

}
