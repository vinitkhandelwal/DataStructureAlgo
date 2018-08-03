import java.math.BigInteger;
import java.util.*;

public class HackerRank {
    public static void main(String[] args) {
        String s = "hackerhappy";
        String t = "hackerrank";
        int k = 2;
        System.out.println(appendAndDelete(s, t, k));
    }

    static boolean appendAndDelete(String str1, String str2, int k) {
        {
            // Case A (i)
            if ((str1.length() + str2.length()) < k)
                return true;

            // finding common length of both string
            int commonLength = 0;
            for (int i = 0; i < Math.min(str1.length(),
                    str2.length()); i++) {
                if (str1 == str2)
                    commonLength++;
                else
                    break;
            }

            // Case A (ii)-
            if ((k - str1.length() - str2.length() +
                    2 * commonLength) % 2 == 0)
                return true;

            // Case B
            return false;
        }

    }
}
