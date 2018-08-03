package courseera;

import java.util.ArrayList;
import java.util.Scanner;

public class Change {
    private static int getChange(int m) {
        //write your code here
        int remainValue = m;
        ArrayList<Integer> coins = new ArrayList<>();
        while(remainValue >= 0){
            if(remainValue == 0) return coins.size();
            if(remainValue >= 10){
                coins.add(1);
                remainValue = remainValue - 10;
            }else if(remainValue >= 5){
                coins.add(1);
                remainValue = remainValue - 5;
            }
            else if(remainValue >= 1){
                coins.add(1);
                remainValue = remainValue - 1;
            }
        }
        return coins.size();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        System.out.println(getChange(m));

    }
}

