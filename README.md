已完成:
1. [1. Two Sum](https://leetcode.com/problems/two-sum/)
   
   | 次数 | 时间 | 内容 | 日期 |
   | ------ | ------ | ------ | ------ |
   | 1 | 20min | 分析+实现+总结+测试 |2019.04.09|
   
1. [2. Add Two Numbers](https://leetcode.com/problems/add-two-numbers/)
   
   | 次数 | 时间 | 内容 | 日期 |
   | ------ | ------ | ------ | ------ |
   | 1 | 20min | 分析+实现+总结+测试 |2019.04.09|
   
1. [19. Remove Nth Node From End of List](https://leetcode.com/problems/remove-nth-node-from-end-of-list/)
   
   | 次数 | 时间 | 内容 | 日期 |
   | ------ | ------ | ------ | ------ |
   | 1 | 40min | 分析+实现(7min)+总结+测试 | 2019.04.09|
   
1. [20. Valid Parentheses](https://leetcode.com/problems/valid-parentheses/)

   | 次数 | 时间 | 内容 | 日期 |
   | ------ | ------ | ------ | ------ |
   | 1 | 40min | 分析+实现+总结+测试 |2019.04.09|
   
1. [21. Merge Two Sorted Lists](https://leetcode.com/problems/merge-two-sorted-lists/)

   | 次数 | 时间 | 内容 | 日期 |
   | ------ | ------ | ------ | ------ |
   | 1 | 40min | 分析+实现+总结+测试 | 2019.04.09|
   
1. [141. Linked List Cycle](https://leetcode.com/problems/linked-list-cycle/)

   | 次数 | 时间 | 内容 | 日期 |
   | ------ | ------ | ------ | ------ |
   | 1 | 20min | 分析+实现+总结+测试 | 2019.04.09|

1. [155. Min Stack](https://leetcode.com/problems/min-stack/)

   | 次数 | 时间 | 内容 | 日期 |
   | ------ | ------ | ------ | ------ |
   | 1 | 32min | 分析+实现+总结+测试 | 2019.04.09|

1. [206. Reverse Linked List](https://leetcode.com/problems/reverse-linked-list/)

   | 次数 | 时间 | 内容 | 日期 |
   | ------ | ------ | ------ | ------|
   | 1 | 38min | 分析+实现+总结+测试 |2019.04.10|

1. [232. Implement Queue using Stacks](https://leetcode.com/problems/implement-queue-using-stacks/)

   | 次数 | 时间 | 内容 | 日期 |
   | ------ | ------ | ------ | ------|
   | 1 | 33min | 分析+实现+总结+测试 |2019.04.10|
   
1. [234. Palindrome Linked List](https://leetcode.com/problems/palindrome-linked-list/)

   | 次数 | 时间 | 内容 | 日期 |
   | ------ | ------ | ------ | ------ |
   | 1 | 60min | 分析+实现+总结+测试 |2019.04.10|
   | 2 | 20min | 实现 |2019.04.10|
   | 3 | 7min  | 实现 |2019.04.10|

1. [328. Odd Even Linked List](https://leetcode.com/problems/odd-even-linked-list/)

   | 次数 | 时间 | 内容 |日期
   | ------ | ------ | ------ | ------|
   | 1 | 60min | 分析+实现+总结+测试 |2019.04.10|
   | 2 | 4min | 实现 |2019.04.10|
   
1. [844. Backspace String Compare](https://leetcode.com/problems/backspace-string-compare/)

   | 次数 | 时间 | 内容 |日期
   | ------ | ------ | ------ | ------|
   | 1 | 60min | 分析+实现+总结+测试 |2019.04.10|

总结:
1. 先想解决思路，不必考虑复杂度，也不必考虑数据结构；再看每一步是否有可优化的点，从数据结构与算法的角度考虑。
1. 查找优化，想hash table/hash map，但是要注意空间复杂度的提升。
1. 考虑各种情况，也就是TDD中的先思考测试用例，从最简单的一个下手，可能没有时间去重构，因此需要纵观测试用例，直接考虑普适情况。
1. 解决链表问题时考虑只有一个元素及head被移除的情况，通常需要添加哨兵
1. 使用栈的peek或pop操作时，需要保证栈非空。
1. 循环链表时，最好不要以p.next是否为空作为终止条件，因为p可能为空。
1. 做这种原地操作时，一定要注意先保存原链表指针的next，再操作。
1. 快慢指针判断环是很巧妙的思路。
1. 涉及多个指针的，先在纸上画，画完再写程序。
1. 涉及多个指针的，要注意元素个数对其的影响。
1. 有数据搬运操作时，注意分析不同搬运时刻所需的代价。
1. 特别注意空指针问题。
1. 最终字符串取决于后面字符时，考虑倒序遍历。