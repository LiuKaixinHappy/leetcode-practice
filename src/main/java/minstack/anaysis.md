# 155. Min Stack

## 要求

实现一个可以返回最小元素的栈

例：
```
MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin();   --> Returns -3.
minStack.pop();
minStack.top();      --> Returns 0.
minStack.getMin();   --> Returns -2.
```
## 分析
维护一个最小元素变量，重点在于最小值的历史记录。

当入栈时，如果最小变量比当前值大，则先将最小变量入栈，再将当前值入栈；出栈时，如果栈顶值==最小值，则执行两次出栈，最小值刷新为第二次出栈值。

需要注意以下两点
- 保存上次的最小值，pop之后最小值为上次最小值
- 有值等于最小值的元素进来时，也要记录，因为弹走一个还剩一个

出栈时间复杂度：O(1)

入栈时间复杂度：O(1)

最小值时间复杂度：O(1)

## 特殊情况及边界（测试用例）
注意验证栈顶元素

- 最小值不重复，不pop
- 最小值不重复，pop
- 最小值重复，pop

## 实现

```java
public class MinStack {
    Stack<Integer> stack = new Stack<>();
    int min = Integer.MAX_VALUE;

    public void push(int x) {
        if (min >= x) {
            stack.push(min);
            min = x;
        }
        stack.push(x);
    }

    public void pop() {
        if (!stack.empty()) {
            if (stack.pop() == min) {
                min = stack.pop();
            }
        }
    }

    public int top() {
        if (!stack.empty()) {
            return stack.peek();
        }
        return -1;
    }

    public int getMin() {
        return min;
    }
}
```
