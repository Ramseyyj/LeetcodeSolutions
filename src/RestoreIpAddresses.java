import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yu Yujie on 24/05/2018.
 *
 * Problem 93: Restore IP Addresses
 *
 * Description:
 * Given a string containing only digits, restore it by returning all possible valid IP address combinations.
 *
 * Example:
 * Input: "25525511135"
 * Output: ["255.255.11.135", "255.255.111.35"]
 *
 * 自己的思路：回溯算法，假设字符串s的next之前的子串已经划分完毕，我们寻找下一个可以划分的Ip子串，并进行递归
 *            然后把这个子串再回溯恢复，重新从next出寻找下一个可以划分的IP子串，以此类推。
 */
public class RestoreIpAddresses {
    List<String> resList = new ArrayList<>();
    List<String> currList = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println(new RestoreIpAddresses().restoreIpAddresses("25525511135"));
    }

    public List<String> restoreIpAddresses(String s) {
        if (s.length() < 4 || s.length() > 12) {
            return resList;
        }
        backTracking(s, 0);
        return resList;
    }

    private void backTracking(String s, int next) {
        if (currList.size() == 4 && next >= s.length()) {
            StringBuilder sb = new StringBuilder("");
            int i;
            for (i = 0; i< currList.size() - 1; i++) {
                sb.append(currList.get(i)).append('.');
            }
            sb.append(currList.get(i));
            resList.add(sb.toString());
        }

        for (int i = next; i < s.length(); i++) {
            String substr = s.substring(next, i+1);
            if (isValidIpPart(substr)) {
                currList.add(substr);
                backTracking(s, i + 1);
                currList.remove(currList.size() - 1);
            }
        }
    }

    private boolean isValidIpPart(String s) {
        if (s.length() > 3 || (s.length() > 1 && s.charAt(0) == '0')) {
            return false;
        } else if (Integer.parseInt(s) > 255) {
            return false;
        } else {
            return true;
        }
    }
}
