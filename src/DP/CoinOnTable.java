package DP;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;

public class CoinOnTable {

    public static void main(String[] args) {



        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(new File("D:\\development\\DataStructureAlgo\\src\\DP\\input.txt"))));
          int  n = Integer.parseInt(br.readLine());
          int  a[] = new int[n];
          int i = 0;
          boolean flag = true;
            String st;
          while((st = br.readLine()) != null){

              a[i] = Integer.parseInt(st);
              i++;

          }

//            int n  = 3;
//            int a[] = new int[]{1,2,2};
            System.out.println(candies(n,a));

        } catch (Exception e) {
            e.printStackTrace();
        }




    }

    static long candies(int n, int[] arr) {
        long dp[] = new long[n];
        Arrays.fill(dp,1);
        for(int candidate = 1 ; candidate < n;candidate++){
            if(arr[candidate] > arr[candidate-1]) {
                dp[candidate] += dp[candidate - 1];
            }

        }

        for(int candidate = n-2 ; candidate >= 0;candidate--){
            if(arr[candidate] > arr[candidate+1] && dp[candidate] <= dp[candidate+1]){
                dp[candidate] = dp[candidate+1] + 1;
            }

        }



        return Arrays.stream(dp).sum();

    }


}
