# 844. Backspace String Compare

## 要求

对比两字符串是否相等。`#`代表退格键。

备注：
使用时间复杂度O(n)，空间复杂度O(1)。

## 分析
从后向前遍历对比两字符串，如果遇到`#`，则skip掉下一个非井号的字符。

## 特殊情况及边界（测试用例）
- 两个空串
- 一个空串，一个不空
- 相等字串
- 不想等字串

## 实现

```java
public boolean backspaceCompare(String S, String T) {
    int s = S.length() - 1;
    int t = T.length() - 1;
    int skipS = 0;
    int skipT = 0;
    while(s >= 0 || t >= 0) {
        while (s >= 0) {
            if (S.charAt(s) == '#') {
                skipS++;
                s--;
            } else if (skipS > 0) {
                s--;
                skipS--;
            } else {
                break;
            }
        }
        while (t >= 0) {
            if (T.charAt(t) == '#') {
                skipT++;
                t--;
            } else if (skipT > 0) {
                t--;
                skipT--;
            } else {
                break;
            }
        }
        if (s >= 0 && t >= 0 && S.charAt(s) != T.charAt(t)) {
            return false;
        }
        if ((s >= 0) != (t >= 0)) {
            return false;
        }
        s--;
        t--;

    }
    return true;
}
```

## 总结

1. 最终字符串取决于后面字符时，考虑倒序遍历。