import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yu Yujie on 09/03/2018.
 *
 * Problem 119: Pascal's Triangle II
 *
 * Description:
 * Given an index k, return the kth row of the Pascal's triangle.
 *
 * For example, given k = 3,
 * Return [1,3,3,1].
 */
public class PascalTriangleII {

    public static void main(String[] args) throws Exception {
        System.out.println(new PascalTriangleII().getRow(3));
    }

    public List<Integer> getRow(int rowIndex) {

        List<Integer> result = new ArrayList<Integer>();

        result.add(0, 1);

        for (int i=0; i<rowIndex; i++)
        {
            for (int j=0; j<i; j++)
            {
                result.set(j, result.get(j) +result.get(j+1));
            }
            result.add(0, 1);
        }

        return result;
    }
}
