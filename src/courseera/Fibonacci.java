package courseera;

import java.util.Scanner;

/**
 * Created by vinit.khandelwal on 1/19/2018.
 */


    public class Fibonacci {
        private static long calc_fib(int n) {
            long fib [] = new long[n+1];
            if(n == 0) return 0;
            if(n == 1) return 1;
            fib[0] = 0;
            fib[1] = 1;
            for(int i = 2 ;i <=n;i++){
                fib[i] = (fib[i-1]+fib[i-2])%10;
            }
            return fib[n];

        }

        public static void main(String args[]) {
            Scanner in = new Scanner(System.in);
            int n = in.nextInt();

            System.out.println(calc_fib(n));
        }
    }

