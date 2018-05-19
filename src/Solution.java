public class Solution {

    public static void main(String[] args)
    {
        System.out.println(new Solution().reverseWords("   a   b "));
    }

    public String reverseWords(String s) {

        StringBuilder word = new StringBuilder("");
        StringBuilder result = new StringBuilder("");

        for(char ch : s.toCharArray())
        {
            if (ch == ' ')
            {
                if (word.length() != 0)
                {
                    result.insert(0, word.toString());
                    result.insert(0, " ");

                    word = new StringBuilder("");
                }
            }
            else
            {
                word.append(ch);
            }
        }

        if (word.length() != 0)
        {
            result.insert(0, word.toString());
        }

        return result.toString().trim();
    }
}