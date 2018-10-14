package problemSet_1;

import java.util.ArrayList;
import java.util.List;

public class MinimumCoinsFormTotal_DP {

    private static int getMinCoins(int[] coinsDenomination, int total){
        int[] numberOfCoinsRequired = new int[total +1];
        int[] indexOfCoinFormingTotal = new int[total +1];

        numberOfCoinsRequired[0] = 0;
        indexOfCoinFormingTotal[0] = -1;
        for(int i = 1; i < total +1; i++){
            numberOfCoinsRequired[i] = Integer.MAX_VALUE -1;
            indexOfCoinFormingTotal[i] = -1;
        }

        for(int i = 0; i < coinsDenomination.length; i++){
            for(int j = 0; j < numberOfCoinsRequired.length; j++){
                if(coinsDenomination[i] > j)
                    continue;

                int temp = (1 + numberOfCoinsRequired[j - coinsDenomination[i]]);
                if(temp < numberOfCoinsRequired[j]){
                    numberOfCoinsRequired[j] = temp;
                    indexOfCoinFormingTotal[j] = i;
                }
            }
        }

        // Print the coins selected
        for(Integer i : getCoinsPicked(indexOfCoinFormingTotal, coinsDenomination))
            System.out.print(i + " ");
        System.out.println();

        return numberOfCoinsRequired[total];
    }

    private static List<Integer> getCoinsPicked(int[] indexOfCoinFormingTotal, int[] coinsDenomination){
        List<Integer> list = new ArrayList<>();
        int index = indexOfCoinFormingTotal.length -1;
        while(index > 0){
            list.add(coinsDenomination[indexOfCoinFormingTotal[index]]);
            index -= coinsDenomination[indexOfCoinFormingTotal[index]];
        }

        return index == 0 ? list : null;
    }

    public static void main(String[] s){
        int[] coinsDenomination = {7, 2, 3, 6};
        int total = 13;

        System.out.println(getMinCoins(coinsDenomination, total));
    }
}
