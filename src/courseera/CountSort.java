package courseera;

import java.util.ArrayList;

/**
 * Created by vinit.khandelwal on 2/15/2018.
 */
public class CountSort {

    public static void main(String[] args) {

        int a[] = new int[]{1,1,2,3,4,5,4,4,4,4,4,5,2,2,2,1,1,1,3,4,5,7};
         int count[] = new int[8];

        for(int i = 0 ;i < a.length;i++){
            count[a[i]] = count[a[i]]+1;
        }
        System.out.println(count);
        ArrayList<Integer> result= new ArrayList<>();
        for(int i = 1; i < count.length;i++){

        }
    }
}
