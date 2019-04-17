# 15. 3Sum

## 要求

- 输入：数字数组
- 输出：所有「三个数和为0的组合」，不可重复

例：
```
Given array nums = [-1, 0, 1, 2, -1, -4],

A solution set is:
[
  [-1, 0, 1],
  [-1, -1, 2]
]
```
## 分析
###  Version 1
最暴力的方式为三层循环，时间复杂度O(n^3)，一定会超时。

如果使用hashmap存储原数组，可以将最里面一层循环去掉（即选两个数，看第三个数是否存在与数组），时间复杂度变为O(n^2)。

但是这种思路还存在一个棘手的问题：去重。嵌套链表去重存在一定代价，因此如果能在加入的时候就控制不重复最好。

通过对原数组排序，可以避免重复加入的情况。

1. 先对原数组从大到小排序，排到负数的时候从小到大排列。因为希望每次都拿绝对值最大的数，去找绝对值小于它的两个数，这样的单向约束，可以有效避免重复；
    
    ```
    [-1, 0, 1, 2, -1, -4]
    
    after sorting：
    [2, 1, 0, -4, -1, -1]

    ```
1. 为了使找数的复杂度最低，需要将排序后的数组存入hashmap，因为数组中可能包含重复元素，因此hashmap的存储最好能体现这一信息，所以设置key为数，value为元素个数；
    
    ```
    [2, 1, 0, -4, -1, -1]
    
    hashmap：
    {
        2: 1,
        1: 1,
        0: 1,
        -4: 1,
        -1: 2    
    }

    ```
1. 取一个绝对值较大的数，这个数可能是正也可能是负，因此还需要知道正负数的开始索引，正数为0，负数的索引则需要遍历得知，为了效率，可以在上一步生成hashmap的时候顺便记录负数开始索引，即正负分界线；
    例:
    ```
    sorted array:
    [2, 1, 0, -4, -1, -1]
    
    hashmap：
    {
        2: 1,
        1: 1,
        0: 1,
        -4: 1,
        -1: 2    
    }
    
    divider：3

    ```
1. 设置两个指针分别指向整数开始索引与负数开始索引，比较两数绝对值，如果正数大，则遍历负数区，遍历完后正数指针后移，继续与副指针对比；如果负数大，则遍历正数区，遍历完后负数指针后移，继续与正数指针比较。直到正数指针超出正数区或负数指针超出负数区。

**注意：**
- 如果计算出来的第三个数字与当前正指针或负指针所指元素值相同，则读取map的value，看是否大于2，大于2则加入结果，否则不加入；
- 如果正指针或负指针与上一次元素值相同，则continue，避免重复。（如正指针为2，负指针为-1，遍历负数区，遇到-1时，找到一个组合[2,-1,-1]，负指针后移，又是-1，则跳过）；
- [0,0,0,0,...]在上述算法中属于特殊情况，需要在一开始的时候判断，如果存在3个以上的0，就先把这种组合加入结果集。
**可优化：**
- 如果当前正在遍历的元素绝对值小于固定指针所指元素绝对值的1/2，则可提前终止。如`[5, -3, -2]`，正指针指向5，遍历负数区，找到-3，负指针后移，此时|-2|已经小于5/2，可以终止循环。

例：
![21555479567_.pic_hd](https://ws1.sinaimg.cn/large/006tNc79ly1g25kse9kwaj30u0140npe.jpg)

### Version 2(再度优化)
    
修改排序，直接从小到大排列，其余不变

### Version 3(其他解法)

```java
public List<List<Integer>> threeSum(int[] nums) {
    List<List<Integer>> res = new ArrayList<>();
    Arrays.sort(nums);
    for (int i = 0; i + 2 < nums.length; i++) {
        if (i > 0 && nums[i] == nums[i - 1]) {              // skip same result
            continue;
        }
        int j = i + 1, k = nums.length - 1;  
        int target = -nums[i];
        while (j < k) {
            if (nums[j] + nums[k] == target) {
                res.add(Arrays.asList(nums[i], nums[j], nums[k]));
                j++;
                k--;
                while (j < k && nums[j] == nums[j - 1]) j++;  // skip same result
                while (j < k && nums[k] == nums[k + 1]) k--;  // skip same result
            } else if (nums[j] + nums[k] > target) {
                k--;
            } else {
                j++;
            }
        }
    }
    return res;
}
```


## 实现
- V1

```java
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
        results.add(Arrays.asList(cur, complement, posElem));
    }
    while (true) {
        if (positiveIndex > divider || negativeIndex >= length) {
            break;
        }
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
                  int end, int 
                  biggerElem) {
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
             results.add(Arrays.asList(cur, complement, posElem));
        }
    }
}

private boolean isLessThanHalf(int cur, double halfOfBiggerElem) {
    if (cur < 0) {
        return Math.abs(cur) < halfOfBiggerElem;
    }
    return cur < halfOfBiggerElem;
}

```
- V2

```java
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
```

- V3

## 总结

1. 有时候可以通过排序结合一些约束避免重复。
1. 测试用例要考虑全面，比如多个0对于上述算法的影响。
1. 存在局部遍历（分块遍历）时，可以考虑while+多个指针以不同步调来回移动的方式。