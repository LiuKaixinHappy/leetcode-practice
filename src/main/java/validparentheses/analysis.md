# 20. Valid Parentheses

#### 要求

- 输入：只包含`(`,`)`,`{`,`}`,`[`,`]`的字符串
- 输出：括号是否匹配

备注：空字符串算合法

例：
```
Input: "()"
Output: true

Input: "(]"
Output: false
```
#### 分析
遍历字符串，如果是左括号，入栈，如果右括号，看与栈顶是否匹配。

查看是否匹配，可以用map，将时间复杂度控制在O(1)。由于括号较少，也可以在写代码时写出来，使空间复杂度较小。

时间复杂度：O(n)，空间复杂度：O(n)

#### 特殊情况及边界（测试用例）

- 空串
- 以右括号开头

#### 实现

```java
public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> map = new HashMap<>();

        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (!map.containsKey(cur)) {
                stack.push(cur);
            } else if (!stack.empty() && map.get(cur) == stack.peek()) {
                stack.pop();
            } else {
                return false;
            }
        }

        return stack.empty();
    }
```

#### 总结

1. 使用栈的peek或pop操作时，需要保证栈非空。