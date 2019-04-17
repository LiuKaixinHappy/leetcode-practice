package threesum;

import java.util.*;

public class ThreeSum {
    class SortByAbsoluteValue implements Comparator<Integer> {
        @Override
        public int compare(Integer a, Integer b) {
            if (a < 0 && b < 0) {
                return Math.abs(b) - Math.abs(a);
            } else {
                return b - a;
            }
        }
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> results = new LinkedList<>();
        if (nums.length < 3) {
            return results;
        }
        Integer[] arr = Arrays.stream(nums).boxed().toArray(Integer[]::new);
        Arrays.sort(arr, new SortByAbsoluteValue());

        Map<Integer, Integer> map = new HashMap<>();
        int divider = 0;
        Integer count;
        for (int i = 0; i < arr.length; i++) {
            int cur = arr[i];
            if (cur >= 0) {
                divider = i + 1;
            }
            count = map.get(cur);
            map.put(cur, count == null ? 1 :count + 1);
        }
        int length = arr.length;
        int positiveIndex = 0;
        int negativeIndex = divider;
        if (map.get(0) != null && map.get(0) > 2) {
            addToResults(results, 0, 0, 0);
        }
        while (positiveIndex <= divider && negativeIndex < length) {
            int posElem = arr[positiveIndex];
            int negElem = arr[negativeIndex];
            int absNegElem = Math.abs(negElem);
            if (posElem < Math.abs(arr[negativeIndex])) {
                find(results, arr, map, positiveIndex, divider, negElem);
                negativeIndex = negativeIndex + map.get(negElem);
            } else if (posElem >= absNegElem) {
                find(results, arr, map, negativeIndex, length, posElem);
                positiveIndex = positiveIndex + map.get(posElem);
            }
        }
        return results;
    }

    private void find(List<List<Integer>> results,
                      Integer[] arr,
                      Map<Integer, Integer> map,
                      int start,
                      int end,
                      int biggerElem) {
        int absBiggerElem = biggerElem < 0 ? Math.abs(biggerElem) : biggerElem;
        double halfOfBiggerElem = absBiggerElem / 2.0;
        for (int i = start; i < end; i++) {
            int cur = arr[i];
            if (i > 0 && cur == arr[i - 1]) {
                continue;
            }
            if (isLessThanHalf(cur, halfOfBiggerElem)) {
                break;
            }
            int complement = 0 - cur - biggerElem;
            Integer complementCount = map.get(complement);
            if (complementCount == null) {
                continue;
            }
            if (complement != cur || complementCount >= 2) {
                addToResults(results, biggerElem, cur, complement);
            }
        }
    }

    private void addToResults(List<List<Integer>> results, int e1, int e2, int e3) {
        List<Integer> result = new LinkedList<>();
        result.add(e2);
        result.add(e1);
        result.add(e3);
        results.add(result);
    }

    private boolean isLessThanHalf(int cur, double halfOfBiggerElem) {
        if (cur < 0) {
            return Math.abs(cur) < halfOfBiggerElem;
        }
        return cur < halfOfBiggerElem;
    }


}
