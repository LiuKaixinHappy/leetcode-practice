# 232. Implement Queue using Stacks

## 要求

用栈实现队列。只能使用栈的基本操作。

备注：
假设不会在队列为空时调用peek与pop。

## 分析
用两个栈，可以在push的时候将数据从栈in倒入栈out，也可以在pop时将数据从栈in倒入栈out。

- push时维护
    - push时间复杂度：O(n)
    - pop时间复杂度：O(1)
    - peek时间复杂度：O(1)
- pop时维护
    - push时间复杂度：O(1)
    - pop时间复杂度：只有栈out为空时，才会执行一次搬运，复杂度O(n)，其他时候复杂度O(1)，平均复杂度O(1)
    - peek时间复杂度：O(1)

因此在pop时维护较好。

peek需要注意，在out栈为空时，应该返回in栈栈底的元素，否则返回out栈栈顶，因此需要又一个变量来维护in栈栈底元素。

## 特殊情况及边界（测试用例）
考虑两个栈的情况
- push，push，pop，peek
- push，push，peek
- push, pop, push, peek

## 实现

```java
class MyQueue {

    Stack<Integer> in = new Stack<>();
    Stack<Integer> out = new Stack<>();
    int inTop = 0;
    
    /** Initialize your data structure here. */
    public MyQueue() {
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        if (in.isEmpty()) {
            inTop = x;
        }
        in.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if (out.isEmpty()) {
            while(!in.isEmpty()) {
                out.push(in.pop());
            }
        }
        return out.pop();
    }
    
    /** Get the front element. */
    public int peek() {
        if (out.isEmpty()) {
            return inTop;
        } 
        return out.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return in.isEmpty() && out.isEmpty();
    }
}
```

## 总结

1. 有数据搬运操作时，注意分析不同搬运时刻所需的代价。