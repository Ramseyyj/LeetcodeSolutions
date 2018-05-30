import java.text.StringCharacterIterator;

/**
 * Created by Yu Yujie on 12/03/2018.
 *
 * Problem 6. ZigZag Conversion
 *
 * Description:
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to
 * display this pattern in a fixed font for better legibility)
 *
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * And then read line by line: "PAHNAPLSIIGYIR"
 * Write the code that will take a string and make this conversion given a number of rows:*
 * string convert(string text, int nRows);
 * convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
 */
public class ZigZagConversion {

    public static void main(String[] args)
    {
        String str = "ABC";
        System.out.println(new ZigZagConversion().convert(str, 2));
    }

    public String convert(String s, int numRows) {
        int i = 0;
        int j = 0;
        boolean flag = true;
        StringBuilder[] sbs = new StringBuilder[numRows];
        StringCharacterIterator it = new StringCharacterIterator(s);

        if(numRows == 1 || s.length() <= numRows)
        {
            return s;
        }

        for (j = 0; j < numRows; j++)
        {
            sbs[j] = new StringBuilder();
        }

        for (char ch = it.first(); ch != StringCharacterIterator.DONE; ch = it.next() )
        {
            sbs[i].append(ch);
            if (flag)
            {
                i++;
                if(i == numRows)
                {
                    i -= 2;
                    flag = false;
                }
            }
            else
            {
                i--;
                if(i == -1)
                {
                    i = 1;
                    flag = true;
                }
            }
        }

        StringBuilder result = new StringBuilder();
        for (j = 0; j < numRows; j++)
        {
            result.append(sbs[j].toString());
        }

        return result.toString();
    }
}
