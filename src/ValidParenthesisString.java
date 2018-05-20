
/**
 * Created by Yu Yujie on 20/05/2018.
 *
 * Problem 678: Valid Parenthesis String
 *
 * Description:
 * Given a string containing only three types of characters: '(', ')' and '*', write a function to check
 * whether this string is valid. We define the validity of a string by these rules:
 *
 * 1. Any left parenthesis '(' must have a corresponding right parenthesis ')'.
 * 2. Any right parenthesis ')' must have a corresponding left parenthesis '('.
 * 3. Left parenthesis '(' must go before the corresponding right parenthesis ')'.
 * 4. '*' could be treated as a single right parenthesis ')' or a single left parenthesis '(' or an empty string.
 * 5. An empty string is also valid.
 *
 * Example 1:
 * Input: "()"
 * Output: True
 *
 * Example 2:
 * Input: "(*)"
 * Output: True
 *
 * Example 3:
 * Input: "(*))"
 * Output: True
 *
 * Note:
 * The string size will be in the range [1, 100].
 *
 * 自己的思路：用一个计数器count来判断括号序列是否有效;
 *
 *            如果是(，count += 1;
 *            如果是)，count -= 1;
 *            如果是*，count -= 1 或者 count += 0 或者 count += 1 ,这个时候就有三个路线。
 *
 *            最后我们可以发现，随着*的出现，路线的不断增加，所有路线的计数器是连续的，所有我们只需要记录下最小的和最大的即可。
 *            再摒弃小于0的情况，如果最后的所有路线里面有存在计数器为0的，说明括号序列是有效的。
 *
 */
public class ValidParenthesisString {

    public static void main(String[] args)
    {
        System.out.println(new ValidParenthesisString().checkValidString("(**())"));
    }

    public boolean checkValidString(String s) {

        int low = 0;
        int high = 0;
        for (int i = 0; i < s.length(); i++)
        {
            if (s.charAt(i) == '(')
            {
                low++;
                high++;
            }
            else if (s.charAt(i) == ')')
            {
                if (low > 0)
                {
                    low--;
                }
                high--;
            }
            else
            {
                if(low > 0)
                {
                    low--;
                }
                high++;
            }

            if(high < 0)
            {
                return false;
            }
        }

        return low == 0;
    }
}
