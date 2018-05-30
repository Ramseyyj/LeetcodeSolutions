import java.util.Arrays;

/**
 * Created by Yu Yujie on 19/05/2018.
 *
 * Problem 556. Next Greater Element III
 *
 * Description:
 * Given a positive 32-bit integer n, you need to find the smallest 32-bit integer
 * which has exactly the same digits existing in the integer n and is greater in
 * value than n. If no such positive 32-bit integer exists, you need to return -1.
 *
 * Example 1:
 * Input: 12
 * Output: 21
 *
 * Example 2:
 * Input: 21
 * Output: -1
 *
 * 自己的思路：首先把int转成char[] numArray，然后从后往前遍历，直到找到一个数a（它的后面存在比它更大的数），a的下标为p1。
 *            将这个数a和它后面比它大的最小数交换位置。最后将numArray在p1后面的所有数按从小到大的顺序排列。
 */
class NextGreaterElementIII {

    public static void main(String[] args)
    {
        System.out.println(new NextGreaterElementIII().nextGreaterElement(516325));
    }

    public int nextGreaterElement(int n) {

        char[] numArray = Integer.toString(n).toCharArray();
        int p1 = numArray.length - 1, p2 = numArray.length - 1;
        boolean flag = true;

        while (flag && p1 > 0)
        {
            p1--;
            char temp = numArray[p1+1];
            p2 = p1+1;
            for (int i = p1 + 1; i < numArray.length; i++)
            {
                if (numArray[i] > numArray[p1])
                {
                    flag = false;
                    if(numArray[i] < temp)
                    {
                        temp = numArray[i];
                        p2 = i;
                    }
                }
            }
        }

        if(p1 == -1 || flag)
        {
            return -1;
        }
        else
        {
            char temp = numArray[p1];
            numArray[p1] = numArray[p2];
            numArray[p2] = temp;

            Arrays.sort(numArray, p1+1, numArray.length);
        }

        try
        {
            return Integer.parseInt(new String(numArray));
        }
        catch(NumberFormatException  e)
        {
            return -1;
        }
    }
}