# 1. Two Sum

#### 要求

- 输入：数字数组，以及目标和
- 输出：数组中能组成目标和的两个数字的索引

备注：每个数组中能构成目标和的两个数字只有一组，且不会是同一个元素。

#### 分析

遍历数字，每取一个数字计算出互补的数字是否在数组中，在，则返回两者索引，否则，下一个。

遍历数字：O(n)，不可避免。

计算互补数字：O(1)。

互补数字是否在数组中：O(1)~O(n)，若存储结构为hashmap，查找可优化为O(1)，但会使用额外的空间，所以空间复杂度将从O(1)降为O(n)。

最优：时间复杂度O(n)，空间复杂度O(n)。

#### 实现

```java
public int[] twoSum(int[] nums, int target) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
        int complement = target - nums[i];
        if (map.containsKey(complement)) {
            return new int[]{map.get(complement), i};
        }
        map.put(nums[i], i);
    }
    return new int[]{};
}
```

