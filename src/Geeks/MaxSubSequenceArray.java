package Geeks;

public class MaxSubSequenceArray {

    public static void main(String[] args) {

        int a[] = new int[]{2, -1, 2, 3, 4, -5};

        int maxSum = a[0];

        for(int i = 1; i< a.length;i++){

            maxSum = Math.max(Math.max(a[i]+maxSum,maxSum),a[i]);

        }

        System.out.println(maxSum);

    }
}
