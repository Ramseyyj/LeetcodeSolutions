
/**
 * Created by Yu Yujie on 10/03/2018.
 *
 * Problem 5: Longest Palindromic Substring
 *
 * Description:
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
 *
 * Example:
 *
 * Input: "babad"
 *
 * Output: "bab"
 *
 * Note: "aba" is also a valid answer.
 *
 * Input: "cbbd"
 *
 * Output: "bb"
 *
 * 自己的思路：遍历s中的所有字符，并且从当前字符开始向两边扫描出最长的回文子串;
 *
 * 其他思路：DP解法，s(i,j)是回文子串，则s(i+1,j-1)也必须得是回文子串，以此得出DP的方程，
 *
 *          如果 s[j] = s[i] 并且 dp[i+1][j-1] >= 0  则 dp[i][j] = dp[i+1][j-1] + 2
 *          否则 dp[i][j] = -1;
 *
 *          dp[i][j]表示从i到j是否为回文子串，是就存储回文子串的长度，不是就存储-1;
 */
public class LongestPalindromicSubstring {

    public static void main(String[] args)
    {
        String str = "babad";
        System.out.println(new LongestPalindromicSubstring().longestPalindrome(str));
    }

    public String longestPalindrome(String s) {
        int maxLength = 1;
        int maxStartIndex = 0;
        int maxEndIndex = 0;

        for (int i = 0; i<s.length()-1; i++)
        {
            int tempStartIndex = i-1;
            int tempEndIndex = i+1;
            int tempLength = 1;

            while(tempStartIndex >=0 && tempEndIndex < s.length() && s.charAt(tempStartIndex) == s.charAt(tempEndIndex))
            {
                tempLength += 2;
                tempStartIndex -= 1;
                tempEndIndex += 1;
            }

            if(tempLength > maxLength)
            {
                maxLength = tempLength;
                maxStartIndex = tempStartIndex + 1;
                maxEndIndex = tempEndIndex - 1;
            }

            tempStartIndex = i;
            tempEndIndex = i+1;
            tempLength = 0;

            while(tempStartIndex >=0 && tempEndIndex < s.length() && s.charAt(tempStartIndex) == s.charAt(tempEndIndex))
            {
                tempLength += 2;
                tempStartIndex -= 1;
                tempEndIndex += 1;
            }

            if(tempLength > maxLength)
            {
                maxLength = tempLength;
                maxStartIndex = tempStartIndex + 1;
                maxEndIndex = tempEndIndex - 1;
            }

        }

        return s.substring(maxStartIndex, maxEndIndex+1);
    }

}
