import java.util.HashSet;

/**
 * Created by Yu Yujie on 09/03/2018.
 *
 * Problem 3: Longest Substring Without Repeating Characters
 *
 * Description:
 * Given a string, find the length of the longest substring without repeating characters.
 *
 * Examples:
 * Given "abcabcbb", the answer is "abc", which the length is 3.
 * Given "bbbbb", the answer is "b", with the length of 1.
 * Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring,
 * "pwke" is a subsequence and not a substring.
 */
public class LongestSubstringWithoutRepeatingCharactres {

    public static void main(String[] args)
    {
        String str = "pwwkew";
        System.out.println(new LongestSubstringWithoutRepeatingCharactres().lengthOfLongestSubstring(str));
    }

    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0;

        for (int i = 0; i<s.length(); i++)
        {
            HashSet<Character> temp = new HashSet<>();
            for (int j=i; j>=0; j--)
            {
                if(!temp.contains(s.charAt(j)))
                {
                    temp.add(s.charAt(j));
                    if(temp.size() > maxLength)
                    {
                        maxLength = temp.size();
                    }
                }
                else
                {
                    break;
                }
            }
        }

        return maxLength;
    }
}
