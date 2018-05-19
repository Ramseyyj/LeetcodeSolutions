
/**
 * Created by Yu Yujie on 19/05/2018.
 *
 * Problem 91: Decode Ways
 *
 * Description:
 * A message containing letters from A-Z is being encoded to numbers using the following mapping:
 *
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * Given a non-empty string containing only digits, determine the total number of ways to decode it.

 * Example 1:
 * Input: "12"
 * Output: 2
 * Explanation: It could be decoded as "AB" (1 2) or "L" (12).
 *
 * Example 2:
 * Input: "226"
 * Output: 3
 * Explanation: It could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).
 *
 * 自己的思路：使用DP解法，分两种情况讨论，s[i]和s[i-1]是否可以组合
 *
 *            如果可以组合并且s[i] = '0':  dp[i][0] = 0;
 *                                       dp[i][1] = dp[i-1][0];
 *
 *            如果可以组合并且s[i] != '0':  dp[i][0] = dp[i-1][0] + dp[i-1][1];
 *                                        dp[i][1] = dp[i-1][0];
 *
 *            如果不可以组合并且s[i] = '0': 直接返回0，这种情况下没有解法可以满足条件
 *            如果不可以组合并且s[i] != '0': dp[i][0] = dp[i-1][0] + dp[i-1][1];
 *                                         dp[i][1] = 0;
 *
 *            ps: 还要考虑s开头就是0的情况，这种情况也是直接返回0
 *
 */
public class DecodeWays {

    public static void main(String[] args)
    {
        System.out.println(new DecodeWays().numDecodings("226"));
        System.out.println(new DecodeWays().numDecodings("0"));
        System.out.println(new DecodeWays().numDecodings("10"));
        System.out.println(new DecodeWays().numDecodings("230"));
    }

    public int numDecodings(String s) {

        if(s.charAt(0) == '0')
        {
            return 0;
        }

        int[][] dp = new int[s.length()][2];

        dp[0][0] = 1;
        dp[0][1] = 0;

        for (int i = 1; i < s.length(); i++)
        {
            dp[i][0] = dp[i-1][0] + dp[i-1][1];

            if(canCombine(s.charAt(i-1), s.charAt(i)))
            {
                if(s.charAt(i) == '0')
                {
                    dp[i][0] = 0;
                }

                dp[i][1] = dp[i-1][0];
            }
            else
            {
                if(s.charAt(i) == '0')
                {
                    return 0;
                }
                dp[i][1] = 0;
            }
        }

        return dp[s.length()-1][0] + dp[s.length()-1][1];
    }

    private boolean canCombine(char ch1, char ch2)
    {
        if (ch1 > '2')
        {
            return false;
        }
        else if (ch1 == '2' && ch2 > '6')
        {
            return false;
        }
        else
        {
            return true;
        }

    }
}