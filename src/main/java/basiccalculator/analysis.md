# 224. Basic Calculator

## 要求

- 输入：字符串公式（一定合法）
- 输出：公式的值

## 分析
思维定式地会想起编译原理时候学过的用两个栈实现四则运算的方法，但是仔细看这个题，只有`+`、`-`、`(`、`)`四种符号，因此不需要那么复杂的方式。

有以下几个容易block的点：
- 一次只能读一个char，当前数字可能不止一位，所以需要用一个变量来存储，每次要在上次的基础上扩大10倍在与当前值求和，如`11`。
- 可以用一个result记录目前走过公式的结果值，该结果值的刷新需要`result += sign * number`，sign代表符号，决定此值是需要加还是减，取决于上一位的符号。
- 当遇到`(`时，代表需要新开辟一块作用域去重复上面的过程，这种情况像栈，因此可以用递归，也可以手动模拟栈，直到遇到`)`，再回到原来的作用域。
- 最后结束遍历时还没有算完，比如`1+1`，最后一位是数字，然后走出循环，还没有与
result相加，因此需要再执行一次计算。

## 特殊情况及边界（测试用例）
考虑是否有空格、是否有括号、括号位置、数字位数

- `"1+1"`
- `"1+11"`
- `" 2-1 + 2 "`
- `"1 + 1"`
- `"(1 + 1) + 2"`
- `"(3-2)-(6-8)"`
- `"1+(1+3)+2"`
- `"2-4-(8+2-6+(8+4-(1)+8-10))"`

## 实现
- 迭代

```java
public int calculate(String s) {
    int number = 0;
    int result = 0;
    int sign = 1;
    Stack<Integer> stack = new Stack<>();
    for (int i = 0; i < s.length(); i++) {
        char cur = s.charAt(i);
        if (Character.isDigit(cur)) {
            number = number * 10 + cur - '0' ;
        } else if (cur == '+'){
            result += sign * number;
            sign = 1;
            number = 0;
        } else if (cur == '-') {
            result += sign * number;
            sign = -1;
            number = 0;
        } else if (cur == '(') {
            stack.push(result);
            stack.push(sign);
            result = 0;
            number = 0;
            sign = 1;
        } else if (cur == ')') {
            result += sign * number;
            number = 0;
            int lastSign = stack.pop();
            int lastResult = stack.pop();
            result = lastResult + lastSign * result;
        }
    }
    if (number != 0) {
        result += sign * number;
    }
    return result;
}
```
- 递归
```java
public int calculate(String s) {
    return calculate(s, 0)[0];
}

private int[] calculate(String s, int start) {
    int number = 0;
    int result = 0;
    int sign = 1;
    int i = start;
    for (; i < s.length(); i++) {
        char cur = s.charAt(i);
        if (cur == ' ') {
            continue;
        } else if (Character.isDigit(cur)) {
            number = number * 10 + cur - '0';
        } else if (cur == '+') {
            result += sign * number;
            sign = 1;
            number = 0;
        } else if (cur == '-') {
            result += sign * number;
            sign = -1;
            number = 0;
        } else if (cur == '(') {
            int[] resultAndIndex = calculate(s, i + 1);
            result += sign * resultAndIndex[0];
            i = resultAndIndex[1];
        } else if (cur == ')') {
            break;
        }
    }
    if (number != 0) {
        result += sign * number;
    }
    return new int[]{result, i};
}
```
## 总结

1. 从字符串中读取数字要注意数字位数。
1. 不要陷入思维定式，要注意当前问题。
1. 将迭代改为递归时，想数据作用域要求清零的时刻，有时需要增加变量；递归改为迭代时在数据作用域清零的时刻手动用栈模拟。