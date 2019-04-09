已完成:
1. [1. Two Sum](https://leetcode.com/problems/two-sum/)
   
   | 次数 | 时间 | 内容 |
   | ------ | ------ | ------ |
   | 1 | 20min | 分析+实现+总结+测试 |
2. [2. Add Two Numbers](https://leetcode.com/problems/add-two-numbers/)
   
   | 次数 | 时间 | 内容 |
   | ------ | ------ | ------ |
   | 1 | 20min | 分析+实现+总结+测试 |
   
3. [19. Remove Nth Node From End of List](https://leetcode.com/problems/remove-nth-node-from-end-of-list/)
   
   | 次数 | 时间 | 内容 |
   | ------ | ------ | ------ |
   | 1 | 40min | 分析+实现(7min)+总结+测试 |
   
4. [20. Valid Parentheses](https://leetcode.com/problems/valid-parentheses/)

   | 次数 | 时间 | 内容 |
   | ------ | ------ | ------ |
   | 1 | 40min | 分析+实现(7min)+总结+测试 |
总结:
1. 先想解决思路，不必考虑复杂度，也不必考虑数据结构；再看每一步是否有可优化的点，从数据结构与算法的角度考虑。
2. 查找优化，想hash table/hash map，但是要注意空间复杂度的提升。
3. 考虑各种情况，也就是TDD中的先思考测试用例，从最简单的一个下手，可能没有时间去重构，因此需要纵观测试用例，直接考虑普适情况。
4. 解决链表问题时考虑只有一个元素及head被移除的情况，通常需要添加哨兵
5. 使用栈的peek或pop操作时，需要保证栈非空。