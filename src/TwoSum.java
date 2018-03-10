
/**
 * Created by Yu Yujie on 09/03/2018.
 *
 * Problem 1: Two Sum
 *
 * Description:
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 * Example:
 * Given nums = [2, 7, 11, 15], target = 9,
 *
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 */
public class TwoSum {

    public static void main(String[] args) {
        int[] nums = {3, 2, 4};
        int[] ans = new TwoSum().twoSum(nums, 6);
        for (int i : ans)
            System.out.println(i);
    }

    public int[] twoSum(int[] nums, int target) {
        int i = 0;
        int j = 0;

        out:
        for(i=0; i<nums.length; i++)
        {
            for(j=i+1; j< nums.length; j++)
            {
                if(nums[i] + nums[j] == target)
                {
                    break out;
                }
            }
        }

        return new int[]{i, j};
    }
}
