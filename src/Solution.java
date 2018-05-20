import java.util.Arrays;

public class Solution {

    public static void main(String[] args)
    {
        System.out.println("fasdfa".indexOf(""));
        System.out.println(new Solution().nextGreaterElement(12));
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