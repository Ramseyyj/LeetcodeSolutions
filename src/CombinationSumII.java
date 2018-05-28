import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Yu Yujie on 25/05/2018.
 *
 * Problem 40: Combination Sum II
 *
 * Description:
 * Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.
 *
 * Each number in candidates may only be used once in the combination.
 *
 * Note:
 *  All numbers (including target) will be positive integers.
 *  The solution set must not contain duplicate combinations.
 *
 * Example 1:
 *  Input: candidates = [10,1,2,7,6,1,5], target = 8,
 *  A solution set is:
 *  [
 *  [1, 7],
 *  [1, 2, 5],
 *  [2, 6],
 *  [1, 1, 6]
 *  ]
 *
 * Example 2:
 *  Input: candidates = [2,5,2,1,2], target = 5,
 *  A solution set is:
 *  [
 *  [1,2,2],
 *  [5]
 *  ]
 *
 * 自己的思路：回溯算法，这个题目的关键一点是不能有重复的答案，为了保证这一点，需要做两件事情：
 *            1. 先对candidates数组进行排序；
 *            2. 在backTracking中，在搜索的同一层中，对一样的数字只需要搜索一次，即下面的语句保证这个要求：
 *                  if (i > next && candidates[i] == candidates[i - 1]) {
 *                      continue;
 *                  }
 *
 */
public class CombinationSumII {

    public static void main(String[] args) {
        int[] candidates = new int[]{4,4,2,1,4,2,2,1,3};
        System.out.println(new CombinationSumII().combinationSum2(candidates, 6));
    }

    List<List<Integer>> resList = new ArrayList<>();
    ArrayList<Integer> currList = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        backTracking(candidates, target, 0, 0);
        return resList;
    }

    private void backTracking(int[] candidates, int target, int next, int sum) {
        if (sum == target) {
            resList.add(new ArrayList<>(currList));
            return;
        }

        for (int i = next; i < candidates.length && sum + candidates[i] <= target; i++) {
            if (i > next && candidates[i] == candidates[i - 1]) {
                continue;
            }
            currList.add(candidates[i]);
            backTracking(candidates, target, i + 1, sum + candidates[i]);
            currList.remove(currList.size() - 1);
        }
    }
}
