
/**
 * Created by Yu Yujie on 20/05/2018.
 *
 * Problem 214: Shortest Palindrome
 *
 * Description:
 * Given a string s, you are allowed to convert it to a palindrome by adding characters in front of it.
 * Find and return the shortest palindrome you can find by performing this transformation.
 *
 * Example 1:
 * Input: "aacecaaa"
 * Output: "aaacecaaa"
 *
 * Example 2:
 * Input: "abcd"
 * Output: "dcbabcd"
 *
 * 自己的思路：这个题目的关键是找到最长的回文前缀LPP，但是如果直接遍历去找的话时间复杂度会比较高。
 *            我们采取一种折中的办法，不一定要一次找到那LPP，我们可以用如下的循环来找到一个长于LPP的前缀mid:
 *            for (int i = s.length() - 1; i >= 0; i--)
 *            {
 *                if(s.charAt(i) == s.charAt(mid)) mid++;
 *            }
 *
 *           当s本身自己也是一个回文的时候，mid的长度就等于LPP，所以我们必须对mid递归调用shortestPalindrome方法来
 *           继续添加前缀来保证中间的字符串也是一个回文。
 *
 */
public class ShortestPalindrome {

    public static void main(String[] args)
    {
        System.out.println(new ShortestPalindrome().shortestPalindrome("aacecaaa"));
    }

    public String shortestPalindrome(String s) {

        int mid = 0;
        for (int i = s.length() - 1; i >= 0; i--)
        {
            if(s.charAt(i) == s.charAt(mid))
            {
                mid++;
            }
        }

        if (mid == s.length())
        {
            return s;
        }

        return new StringBuilder(s.substring(mid)).reverse().toString() +
                shortestPalindrome(s.substring(0, mid)) + s.substring(mid);
    }
}
