package problemSet_1;

import java.util.*;

/**
 * Created by Prakash on 09-10-2018.
 */
public class KnapsackProblem01DP_TopDown {

    public static void main(String[] a) {
        int[] val = {2, 4, 6, 9};//{60, 100, 120};
        int[] wt = {2, 2, 4, 5};//{10, 20, 30};
        int W = 8;//50;

        Set<Item> remainingItems = new HashSet<>(val.length * 4/3 +1);
        for (int i = 0; i < val.length; i++)
            remainingItems.add(new Item(wt[i], val[i] ));

        // We need linkedHashMap because first index having maximum value, would be our solution.
        // parents and super-parents of our index (mentioned above line) will all have values more than or equal to our solution index.
        Map<Index, Integer> indexIntegerMap = new LinkedHashMap<>();
        indexIntegerMap.put(new Index(W, remainingItems), solveIt(remainingItems, W, indexIntegerMap));
        printIt(indexIntegerMap);
    }

    static int solveIt (Set<Item> remainingItems, int remainingWeight, Map<Index, Integer> indexIntegerMap){
        if (remainingItems.size() == 0 || remainingWeight == 0)
            return 0;
        Index index = new Index(remainingWeight, remainingItems);
        if (indexIntegerMap.containsKey(index))
            return indexIntegerMap.get(index);

        Iterator<Item> iterator = remainingItems.iterator();
        int maxValueWhenItemPicked = 0;
        Item item = iterator.next();

        // As we already have current item saved in local variable, we are removing current item from remainingItems Set.
        // So that we can pass the remainingItems in next recursive call.
        iterator.remove();
        if (item.itemWeight <= remainingWeight) {
            maxValueWhenItemPicked = item.itemValue + solveIt(remainingItems, remainingWeight - item.itemWeight, indexIntegerMap);
        }
        int maxValueWhenItemNotPicked = solveIt(remainingItems, remainingWeight, indexIntegerMap);

        // We are adding item back to remainingItems set, when we are done with processing of it's children recursive calls and returning back to root method call
        // This is required because, parent method may have it's other unprocessed children, which need a remainingItems set with all the items at parent node.
        remainingItems.add(item);

        // We will choose the path which results in maximum value
        int maxValue = Math.max(maxValueWhenItemNotPicked, maxValueWhenItemPicked);

        // Forming a new Set with current items to put on map
        // We can not use existing remainingItems set because, remainingItems set is keep on changing at each recursive call
        // and will be back to original set having all the items in it at the end.
        Set<Item> items = new HashSet<>(remainingItems.size() * 4/3 +1);
        remainingItems.stream().forEach(item1 -> items.add(item1));
        index.remainingItems = items;
        indexIntegerMap.put(index, maxValue);

        return maxValue;
    }

    static void printIt(Map<Index, Integer> indexIntegerMap){
        int maxValue = Integer.MIN_VALUE;
        Set<Item> selectedItems = null;
        for (Map.Entry<Index, Integer> entry : indexIntegerMap.entrySet()) {
            if (entry.getValue() > maxValue){
                maxValue = entry.getValue();
                selectedItems = entry.getKey().remainingItems;
            }
        }
        selectedItems.stream().forEach(item -> System.out.println("Item - Weight :" + item.itemWeight + " and Value : " + item.itemValue));
    }

    private static class Item {
        Integer itemWeight;
        Integer itemValue;

        public Item() {
        }

        public Item(Integer itemWeight, Integer itemValue) {
            this.itemWeight = itemWeight;
            this.itemValue = itemValue;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Item)) return false;

            Item item = (Item) o;

            if (!itemWeight.equals(item.itemWeight)) return false;
            return itemValue.equals(item.itemValue);
        }

        @Override
        public int hashCode() {
            int result = itemWeight.hashCode();
            result = 31 * result + itemValue.hashCode();
            return result;
        }
    }

    private static class Index {
        Integer remainingWeight;
        Set<Item> remainingItems;

        public Index() {
        }

        public Index(Integer remainingWeight, Set<Item> remainingItems) {
            this.remainingWeight = remainingWeight;
            this.remainingItems = remainingItems;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Index)) return false;

            Index index = (Index) o;

            if (!remainingWeight.equals(index.remainingWeight)) return false;
            return remainingItems.equals(index.remainingItems);
        }

        @Override
        public int hashCode() {
            int result = remainingWeight.hashCode();
            result = 31 * result + remainingItems.hashCode();
            return result;
        }
    }
}
