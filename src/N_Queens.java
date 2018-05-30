import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Yu Yujie on 28/05/2018.
 *
 * Problem 51. N-Queens
 *
 * Description:
 * The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens
 * attack each other. Given an integer n, return all distinct solutions to the n-queens puzzle. Each solution
 * contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both
 * indicate a queen and an empty space respectively.
 *
 *  Example:
 *
 * Input: 4
 * Output: [
 *   [".Q..",  // Solution 1
 *   "...Q",
 *   "Q...",
 *   "..Q."],
 *
 *   ["..Q.",  // Solution 2
 *   "Q...",
 *   "...Q",
 *   ".Q.."]
 * ]
 *
 * Explanation: There exist two distinct solutions to the 4-queens puzzle as shown above.
 *
 * 自己的思路：深搜回溯，主要用三个数组来记录棋盘的位置情况。
 *              column 用来记录哪些列已经被占用；
 *              plus 用来记录坐标x加y的值哪些已经被占用
 *              minus 用来记录坐标x减y的值哪些已经被占用，因为x减y可能出现负值，所以我们整体加了一个n-1来把它变为正值；
 *              
 *              plus和minus是来保证对角线上没有其他的queen，因为一个对角线上，要么x加y为一个固定的值，要么x减y为一个固定值
 */
public class N_Queens {

    public static void main(String[] args) {
        System.out.println(new N_Queens().solveNQueens(4));
    }

    List<List<String>> resList = new ArrayList<>();
    ArrayList<String> currList = new ArrayList<>();
    boolean[] column;
    boolean[] plus;
    boolean[] minus;

    public List<List<String>> solveNQueens(int n) {
        column = new boolean[n];
        plus = new boolean[2*n - 1];
        minus = new boolean[2*n - 1];
        backTracking(n, 0);
        return resList;
    }

    private void backTracking(int n, int next) {
        if (next == n) {
            resList.add(new ArrayList(currList));
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!column[i] && !plus[next + i] && !minus[n + next - i - 1]) {
                char[] str = new char[n];
                Arrays.fill(str, '.');
                str[i] = 'Q';

                currList.add(new String(str));
                column[i] = true;
                plus[next + i] = true;
                minus[n + next - i - 1] = true;

                backTracking(n, next + 1);

                currList.remove(currList.size() - 1);
                column[i] = false;
                plus[next + i] = false;
                minus[n + next - i - 1] = false;
            }
        }
    }
}
