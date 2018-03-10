
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
