package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vinit.khandelwal on 2/19/2018.
 */
public class LetterCasePerm {

    public static void main(String[] args) {
        String x = "aa1bc";
        System.out.println(letterCasePermutation(x));
    }

        public static List<String> letterCasePermutation(String S) {
            int B = 0;
            for (char c: S.toCharArray())
                if (Character.isLetter(c))
                    B++;

            List<String> ans = new ArrayList();

            for (int bits = 0; bits < 1<<B; bits++) {
                int b = 0;
                StringBuilder word = new StringBuilder();
                for (char letter: S.toCharArray()) {
                    if (Character.isLetter(letter)) {
                        if (((bits >> b++) & 1) == 1)
                            word.append(Character.toLowerCase(letter));
                        else
                            word.append(Character.toUpperCase(letter));
                    } else {
                        word.append(letter);
                    }
                }

                ans.add(word.toString());
            }

            return ans;

        }

}
