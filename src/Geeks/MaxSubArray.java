package Geeks;

public class MaxSubArray {

    public static void main(String[] args) {

        int arr[] = new int[]{-2, -3, -1, -4, -6};

        int maxSubArray = arr[0];
        int currentMax = arr[0];

        for(int i = 1;i < arr.length;i++){

           currentMax = Math.max(currentMax+arr[i],arr[i]);
           maxSubArray = Math.max(maxSubArray,currentMax);


        }



        System.out.println(maxSubArray);

    }
}
