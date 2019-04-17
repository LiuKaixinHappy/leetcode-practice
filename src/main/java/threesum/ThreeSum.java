package threesum;

import java.util.*;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> results = new LinkedList<>();
        if (nums.length < 3) {
            return results;
        }

        Arrays.sort(nums);

        Map<Integer, Integer> map = new HashMap<>();
        int divider = 0;
        Integer count;
        for (int i = 0; i < nums.length; i++) {
            int cur = nums[i];
            if (cur < 0) {
                divider = i + 1;
            }
            count = map.get(cur);
            map.put(cur, count == null ? 1 :count + 1);
        }
        int length = nums.length;
        int positiveIndex = length - 1;
        int negativeIndex = 0;
        if (map.get(0) != null && map.get(0) > 2) {
            results.add(Arrays.asList(0, 0, 0));
        }
        while (negativeIndex < divider && positiveIndex >= divider) {
            int posElem = nums[positiveIndex];
            int negElem = nums[negativeIndex];
            int absNegElem = Math.abs(negElem);
            if (posElem < absNegElem) {
                for (int i = positiveIndex; i >= divider; i--) {
                    int cur = nums[i];
                    if (i < positiveIndex && cur == nums[i + 1]) {
                        continue;
                    }
                    if (cur < absNegElem / 2.0) {
                        break;
                    }
                    check(results, map, negElem, cur);
                }
                negativeIndex = negativeIndex + map.get(negElem);
            } else {
                for (int i = negativeIndex; i < divider; i++) {
                    int cur = nums[i];
                    if (i > 0 && cur == nums[i - 1]) {
                        continue;
                    }
                    if (Math.abs(cur) < posElem / 2.0) {
                        break;
                    }
                    check(results, map, posElem, cur);
                }
                positiveIndex = positiveIndex - map.get(posElem);
            }
        }
        return results;
    }

    private void check(List<List<Integer>> results, Map<Integer, Integer> map, int posElem, int cur) {
        int complement = 0 - cur - posElem;
        Integer complementCount = map.get(complement);
        if (complementCount != null) {
            if (complement != cur || complementCount >= 2) {
                results.add(Arrays.asList(cur, complement, posElem));
            }
        }
    }

}
