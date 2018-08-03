package Geeks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaxPairArray {

    public static void main(String[] args) {
        MaxPairArray maxPairArray = new MaxPairArray();
        int array [] = new int[]{};
        System.out.println(maxPairArray.maxArr2(Arrays.asList(-70, -64, -6, -56, 64,
                61, -57, 16, 48, -98)));
    }

    /**
     * Brute force approach
     * @param A
     * @return
     */
    public int maxArr(List<Integer> A) {
        int maxSum =0;
        // int dp[][] = new int dp[A.length+1][A.length+1];
        // Arrays.fill()
        for(int i = 0 ; i < A.size();i++){
            for(int j = i;j < A.size();j++){

                maxSum = Math.max(maxSum,getSum(i,j,A.get(i),A.get(j)));
            }

        }
        return maxSum;

    }

    /**
     * Optmised approach
     * @param A
     * @return
     */
    public int maxArr2(List<Integer> A) {
        int maxSum =0;
        // int dp[][] = new int dp[A.length+1][A.length+1];
        // Arrays.fill()
        // in algorithm.
        int max1 = Integer.MIN_VALUE;
        int min1 = Integer.MAX_VALUE;
        int max2 = Integer.MIN_VALUE;
        int min2 = Integer.MAX_VALUE;

        for (int i = 0; i < A.size(); i++)
        {

            // Updating max and min variables
            // as described in algorithm.
            max1 = Math.max(max1, A.get(i) + i);
            min1 = Math.min(min1, A.get(i) + i);
            max2 = Math.max(max2, A.get(i) - i);
            min2 = Math.min(min2, A.get(i) - i);
        }

        // Calculating maximum absolute difference.
        return Math.max(max1 - min1, max2 - min2);

    }

    public int getSum(int i, int j,int x,int y){
        if(i ==j) return 0;
        else {
            return Math.abs(Math.abs(i-j) + Math.abs(x-y));
        }
    }
}
