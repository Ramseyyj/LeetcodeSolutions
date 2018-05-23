import java.util.*;

public class Solution {

    public static void main(String[] args)
    {
        System.out.println(new Solution().partition("aab"));
    }

    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<List<String>>();
        ArrayList<String> handledList = new ArrayList<String>();
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