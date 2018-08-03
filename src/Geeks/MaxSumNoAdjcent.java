package Geeks;

public class MaxSumNoAdjcent {


    public static void getMaxSumOfNoAdjacent(int [] a){


        int dp [] = new int[a.length];
        dp[0] = a[0];
        dp[1] = Math.max(a[0],a[1]);
        for(int i = 2; i <a.length;i++){
            dp[i] = Math.max((dp[i-2]+a[i]),a[i-1]);
        }
        System.out.println(dp[a.length-1]);

    }

    public static void main(String[] args) {
        int a [] = {5, 6, 10, 100, 10, 5};
        getMaxSumOfNoAdjacent(a);
    }

}
