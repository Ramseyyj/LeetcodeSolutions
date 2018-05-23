import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yu Yujie on 23/05/2018.
 *
 * Problem 5: Palindrome Partitioning
 *
 * Description:
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 * Return all possible palindrome partitioning of s.
 *
 * Example:
 *
 * Input: "aab"
 * Output:
 * [
 * ["aa","b"],
 * ["a","a","b"]
 * ]
 *
 * 自己的思路：回溯算法，假设字符串s的next之前的子串已经划分完毕，我们寻找下一个可以划分的回文子串，并进行递归
 *            然后把这个子串再回溯恢复，重新从next出寻找下一个可以划分的回文子串，以此类推。
 */
public class PalindromePartitioning {

    public static void main(String[] args) {
        System.out.println(new PalindromePartitioning().partition("aab"));
    }

    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        ArrayList<String> handledList = new ArrayList<>();
        backTracking(result, handledList, s, 0);
        return result;
    }

    private void backTracking(List<List<String>> result, ArrayList<String> handledList, String s, int next) {
        if (handledList.size() > 0 && next >= s.length()) {
            result.add((ArrayList<String>) handledList.clone());
        }

        for (int i = next; i < s.length(); i++) {
            if (isPalindrome(s, next, i)) {
                handledList.add(s.substring(next, i+1));
                backTracking(result, handledList, s, i + 1);
                handledList.remove(handledList.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s, int l, int r) {
        int i = l, j = r;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }

        return true;
    }
}
