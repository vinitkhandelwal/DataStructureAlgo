package DP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CoinChange {

    public static void main(String[] args) {

        int arr[] = {1, 2};
        int m = arr.length;


        int n = 2;
//        System.out.println(countWays(arr,m,n));
//        System.out.println(coinChange(4, arr));

        System.out.println(findOptimalChange(2,arr));
    }

    static int coinChange(int n, long[] m) {
        int[] result = new int[1 + m.length];

        // Base case (If given value is 0)
        result[0] = 1;

        // Pick all coins one by one and update the table[] values
        // after the index greater than or equal to the value of the
        // picked coin
        for (int i = 0; i < m.length; i++) {
            for (int j = (int) m[i]; j <= n; j++)
                result[j] = result[j] + result[(int) (j - m[i])];
        }

        return result[n];
    }

    static long countWays(int S[], int m, int n)
    {
        //Time complexity of this function: O(mn)
        //Space Complexity of this function: O(n)

        // table[i] will be storing the number of solutions
        // for value i. We need n+1 rows as the table is
        // constructed in bottom up manner using the base
        // case (n = 0)
        long[] table = new long[n+1];

        // Initialize all table values as 0
        Arrays.fill(table, 0);   //O(n)

        // Base case (If given value is 0)
        table[0] = 1;

        // Pick all coins one by one and update the table[]
        // values after the index greater than or equal to
        // the value of the picked coin
        for (int i=0; i<m; i++)
            for (int j=S[i]; j<=n; j++)
                table[j] = table[j]+ table[j-S[i]];

        return table[n];
    }

    public static class CoinChangeAnswer {
        public int OPT[][];  	// contains the optimal solution
        // during every recurrence step.
        public String optimalChange[][]; // string representation of optimal solutions.

        /**
         * List of all possible solutions for the target
         */
        public ArrayList<String> allPossibleChanges = new ArrayList<String>();

        /**
         * The target amount.
         */
        private int target;

        /**
         * Copy of the denominations that was used to generate this solution
         */
        public int[] denoms;

        public CoinChangeAnswer(int target, int[] denoms) {
            this.target = target;
            this.denoms = denoms;
        }
    };

    public static CoinChangeAnswer findOptimalChange(int target, int[] denoms) {
        CoinChangeAnswer soln = new CoinChangeAnswer(target,denoms);
        StringBuilder sb = new StringBuilder();

        // initialize the solution structure
        for(int i=0; i<soln.OPT[0].length ; i++) {
            soln.OPT[0][i] = i;
            soln.optimalChange[0][i] = sb.toString();
            sb.append(denoms[0]+" ");
        }

        // Read through the following for more details on the explanation
        // of the algorithm.
        // http://condor.depaul.edu/~rjohnson/algorithm/coins.pdf
        for(int i=1 ; i<denoms.length ; i++) {
            for(int j=0; j<target+1 ; j++) {
                int value = j;
                int targetWithPrevDenomiation = soln.OPT[i-1][j];
                int ix = (value) - denoms[i];
                if( ix>=0 && (denoms[i] <= value )) {
                    int x2 = denoms[i] + soln.OPT[i][ix];
                    if(x2 <= target && (1+soln.OPT[i][ix] < targetWithPrevDenomiation)) {
                        String temp = soln.optimalChange[i][ix] + denoms[i] + " ";
                        soln.optimalChange[i][j] = temp;
                        soln.OPT[i][j] = 1 + soln.OPT[i][ix];
                    } else {
                        soln.optimalChange[i][j] = soln.optimalChange[i-1][j]+ " ";
                        soln.OPT[i][j] = targetWithPrevDenomiation;
                    }
                } else {
                    soln.optimalChange[i][j] = soln.optimalChange[i-1][j];
                    soln.OPT[i][j] = targetWithPrevDenomiation;
                }
            }
        }
        return soln;
    }
}
