

import java.util.Scanner;

/**
 * Created by vinit.khandelwal on 1/19/2018.
 */
public class Pisano {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long a = scanner.nextLong();
        int b = scanner.nextInt();
        System.out.println(getFibonacciHugePisano(a, b));
    }

    private static long getFibonacciHugePisano(long n, long m) {
        if (n <= 1)
            return n;

        long beforePrevious  = 0;
        long previous = 1;
        long a = -1;
        long current = -1;

        for (long i = 2; i <= n; i++) {
            current = (beforePrevious + previous) % m;

            if (a == 0 && current == 1) {
                long period = (i + 1) - 2;
                long reductionN = n % period;
                return getFibonacciHugePisano(reductionN, m);

            }
            else {
                a = current;
                beforePrevious = previous;
                previous = current;
            }
        }

        return current;
    }
}
