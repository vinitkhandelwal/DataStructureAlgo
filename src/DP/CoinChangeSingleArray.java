package DP;

public class CoinChangeSingleArray {

    public static void main(String[] args) {

        long coins[] = new long[]{1,2,3};
        int target = 4;
        System.out.println(getWays(target,coins));
    }

    static void coinChane(int target,int coins[]){
          int[] DP = new int[target+1];
        DP[0] = 1;
        for(int i = 0;i < coins.length;i++){

            for(int amount = 0 ; amount<=target;amount++){

                if(amount < coins[i]){
                    DP[amount] = DP[amount]+DP[amount-i];
                }


            }

        }
    }

    static long getWays(long n, long[] c) {
        long dp[] = new long[(int)n+1];
        dp[0] = 1;
//        dp[1] = 1;
        for(long coin: c){

            for(long amount = 0 ; amount <=n;amount++){
                if(coin <= amount) {
                    dp[Math.toIntExact(amount)] += dp[Math.toIntExact(amount - coin)];
                }
            }



        }
        return dp[Math.toIntExact(n)];



    }
}
