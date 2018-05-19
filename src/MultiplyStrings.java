
/**
 * Created by Yu Yujie on 19/05/2018.
 *
 * Problem 43: Multiply Strings
 *
 * Description:
 * Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2, also represented as a string.

 * Example 1:

 * Input: num1 = "2", num2 = "3"
 * Output: "6"
 *
 * Example 2:

 * Input: num1 = "123", num2 = "456"
 * Output: "56088"
 *
 * Note:
 * 1. The length of both num1 and num2 is < 110.
 * 2. Both num1 and num2 contain only digits 0-9.
 * 3. Both num1 and num2 do not contain any leading zero, except the number 0 itself.
 * 4. You must not use any built-in BigInteger library or convert the inputs to integer directly.
 *
 * 自己的思路：如果num1的长度为l1, num2的长度为l2，那么他们的结果result最大长度为l1+l2,
 *            并且 num1[i] * num2[j] 的结果将会被放置在result[i+j]~result[i+j+1];
 *
 *            ps: 在遍历num1和num2的时候，一定要从反向遍历，即先从个位开始，否正result的进位就会出问题
 */
public class MultiplyStrings {

    public static void main(String[] args)
    {
        System.out.println(new MultiplyStrings().multiply("123", "456"));
    }

    public String multiply(String num1, String num2) {

        int l1 = num1.length();
        int l2 = num2.length();

        int[] result = new int[l1+l2];

        for (int i = l1 - 1; i >= 0; i--)
        {
            for (int j = l2 - 1; j >= 0; j--)
            {
                int sum = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int p1 = i + j;
                int p2 = i + j + 1;

                sum += result[p2];

                result[p2] = sum % 10;
                result[p1] += sum / 10;
            }
        }

        StringBuffer res = new StringBuffer();
        for(int i : result)
        {
            if(!(res.length() == 0 && i == 0))
                res.append(i);
        }

        return (res.length() == 0) ? "0" : res.toString();
    }
}