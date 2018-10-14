package problemSet_1;

import java.util.Scanner;

public class LongestCommonSubsequenceDP {
	
	private static int getLengthLCS(String str1, String str2){
		int max = 0;
		//StringBuilder commonString = new StringBuilder();
		int result [][] = new int[str1.length()+1][str2.length()+1];
		for(int i = 1; i < result.length; i++){
			for(int j = 1; j < result[i].length; j++){
				if(str1.charAt(i-1) == str2.charAt(j-1)){
					result[i][j] = result[i-1][j-1] + 1;
					//commonString.append(str1.charAt(i-1));
				} else {
					result[i][j] = Math.max(result[i][j-1], result[i-1][j]);
				}
				
				max = max < result[i][j] ? result[i][j] : max;
			}
		}
		
		//System.out.println("Common Sequence :- "+commonString); .. Doesn't work
		return max;
	}

	public static void main(String[] args) {
		System.out.println("Enter Strings ");
        Scanner in = new Scanner(System.in);
        String str1 = in.next();
        String str2 = in.next();
        in.close();
        
        System.out.println("Length : " + getLengthLCS(str1, str2));

	}

}
