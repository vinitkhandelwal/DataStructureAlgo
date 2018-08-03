package Geeks;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

public class MaxProduct {

    public int maxProduct(int[] a) {
       int max = a[0];
       int min = a[0];
       int result = a[0];

       for(int i = 1 ; i < a.length;i++){
           int temp = max;
           max = Math.max(Math.max(a[i]* max, a[i] * min),a[i]);
           min = Math.min(Math.min(a[i]* temp,a[i] * min),a[i]);
           if(result < max){
               result = max;
           }
       }

       return result;

    }

//    public static void main(String[] args) {
//        MaxProduct maxProduct = new MaxProduct();
//        int a [] = new int[]{6, -3, -10, 0, 2};
//        System.out.println(maxProduct.maxProduct(a));
//    }

    public static void main(String[] args) throws NoSuchAlgorithmException {
        System.out.println(sha1("Aprr2018$ä"));
    }

    static String sha1(String input) throws NoSuchAlgorithmException {
        MessageDigest mDigest = MessageDigest.getInstance("SHA1");
        byte[] result = mDigest.digest(input.getBytes());
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < result.length; i++) {
            sb.append(Integer.toString((result[i] & 0xff) + 0x100, 16).substring(1));
        }

        List<Integer> list = new ArrayList<>();



        return sb.toString();
    }

}
