import java.text.StringCharacterIterator;
import java.util.ArrayList;

/**
 * Created by Yu Yujie on 10/03/2018.
 *
 * Problem 792: Number of Matching Subsequences
 *
 * Description:
 * Given string S and a dictionary of words words, find the number of words[i] that is a subsequence of S.
 *
 * Example :
 * Input:
 * S = "abcde"
 * words = ["a", "bb", "acd", "ace"]
 * Output: 3
 * Explanation: There are three words in words that are a subsequence of S: "a", "acd", "ace".
 */
public class NumberOfMatchingSubsequences {
    public static void main(String[] args)
    {
        String str = "abcde";
        String[] words = {"a", "bb", "acd", "ace"};
        System.out.println(new NumberOfMatchingSubsequences().numMatchingSubseq(str, words));
    }

    public int numMatchingSubseq(String S, String[] words) {
        ArrayList<StringCharacterIterator>[] subsequenceDict = new ArrayList[128];

        for(int i = 0; i <= 'z'; i++)
            subsequenceDict[i] = new ArrayList<>();

        for (String str: words)
            subsequenceDict[str.charAt(0)].add(new StringCharacterIterator(str));

        for (char c : S.toCharArray())
        {
            ArrayList<StringCharacterIterator> temp = subsequenceDict[c];
            subsequenceDict[c] = new ArrayList<>();
            for (StringCharacterIterator it : temp)
                subsequenceDict[it.next() % it.DONE].add(it);
        }

        return subsequenceDict[0].size();
    }
}
