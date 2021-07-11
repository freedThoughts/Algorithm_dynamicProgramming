package problemSet_1;

public class KnapsackProblem01Recursive {


	
	private static int getFinalValue(int[] val, int[] wt, int W, int index){
		
		if(index == val.length || W < wt[index])
			return 0;
		
		return Math.max(val[index] + getFinalValue(val, wt, W-wt[index], index+1),
				getFinalValue(val, wt, W, index+1));

	}
	
	public static void main(String[] arg){
		int[] val = {60, 100, 120};
		int[] wt = {10, 20, 30};
		int W = 50;
		int result = getFinalValue(val, wt, W, 0);
		System.out.println(result);
		
	}

}
