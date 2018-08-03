package Geeks;

import java.math.BigInteger;
import java.util.*;
import java.util.concurrent.Executor;

public class LongestCommonSubSequence {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
    String s[] = new String []{"31415926535897932384626433832795" ,"1" ,"3" ,"10","3","5"};
        LongestCommonSubSequence ls = new LongestCommonSubSequence();
        printArray(ls.bigSorting(s));
    }

   static String[] bigSorting(String[] unsorted) {

        Arrays.sort(unsorted,new sorter());
        return  unsorted;

    }



   static class sorter implements Comparator<String>{

        @Override
        public int compare(String o1, String o2) {
            if(o1.length() < o2.length()) return -1;
            else if(o1.length() > o2.length()) return 1;
            else{
                return o1.compareTo(o2);
            }
        }
    }

   static int lcs( char[] X, char[] Y, int m, int n )
    {
        int L[][] = new int[m+1][n+1];

    /* Following steps build L[m+1][n+1] in bottom up fashion. Note
         that L[i][j] contains length of LCS of X[0..i-1] and Y[0..j-1] */
        for (int i=0; i<=m; i++)
        {
            for (int j=0; j<=n; j++)
            {
                if (i == 0 || j == 0)
                    L[i][j] = 0;
                else if (X[i-1] == Y[j-1])
                    L[i][j] = L[i-1][j-1] + 1;
                else
                    L[i][j] = Math.max(L[i-1][j], L[i][j-1]);
            }
        }

        printArray(L);
        return L[m][n];
    }

    public static void printArray(int [][] a){
        for(int i = 0 ; i < a.length;i++){
            for(int j = 0 ; j < a[i].length;j++){
                System.out.print(a[i][j] + " ,");
            }
            System.out.println(" ");
        }
    }

    public static <T> void  printArray(T [] a){
        for(int i = 0 ; i < a.length;i++){
            System.out.print(a[i] + " ");
        }
    }
}
