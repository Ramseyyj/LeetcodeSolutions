# LeetcodeSolutions

## 深搜回溯题目总结
1. 这一类题目一定要记录好状态参数，即当前情况下有哪些变化可以进行，哪些由于状态的问题无法达到。
2. 在进行搜索并回溯的核心函数内，主要考虑当前的状态是否是一个合法的解法。如果是就返回一个结果，如果不是，就考虑现有状态可以变化出
多少种下一个状态，并遍历所有状态来寻找解法。
3. 在回溯的时候一定要恢复好状态，来保证下一次搜索的时候不受上一次搜索的影响。
