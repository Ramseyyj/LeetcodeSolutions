
/**
 * Created by Yu Yujie on 30/05/2018.
 *
 * Problem 647. Palindromic Substrings
 *
 * Description:
 * Given a string, your task is to count how many palindromic substrings in this string.
 * The substrings with different start indexes or end indexes are counted as different substrings
 * even they consist of same characters.
 *
 * Example 1:
 *  Input: "abc"
 *  Output: 3
 *  Explanation: Three palindromic strings: "a", "b", "c".
 *
 * Example 2:
 *  Input: "aaa"
 *  Output: 6
 *  Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".
 *
 * Note:
 *  The input string length won't exceed 1000.
 *
 * 自己的思路：DP解法，s(i,j)是回文子串，则s(i+1,j-1)也必须得是回文子串，以此得出DP的方程，
 *
 *           dp[i][j]为回文子串，当且仅当 s[i] == s[j] 且 (j-i<3 或者 dp[i+1][j-1]为回文子串)
 *
 *           dp[i][j]表示从i到j是否为回文子串;
 *
 * 其他思路：遍历s中的所有字符，并且从当前字符开始向两边扫描出回文子串的个数并进行累加;
 */
public class PalindromicSubstrings {

    public static void main(String[] args)
    {
        String str = "aaa";
        System.out.println(new PalindromicSubstrings().countSubstrings(str));
    }

    public int countSubstrings(String s) {
        int result = 0;
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j >= 0; j--) {
                dp[j][i] = (s.charAt(j) == s.charAt(i) && (i-j < 3 || dp[j+1][i-1]));
                if (dp[j][i]) result++;
            }
        }

        return result;
    }
}
