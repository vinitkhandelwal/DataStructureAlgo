package Geeks;

import java.util.TreeSet;

public class MoneySpent {

    public static void main(String[] args) {
        int [] keyboards = new int[]{3,1};
        int [] drives = new int[]{5,2,8};
        int b = 10;
        System.out.println(getMoneySpent(keyboards,drives,b));
    }

    static int getMoneySpent(int[] keyboards, int[] drives, int b) {
        int keyBoardLength = keyboards.length;
        int mouseLength = drives.length;
        boolean outerKeyBoard = false;
        boolean innerKeyBoard = false;
        outerKeyBoard = keyBoardLength > mouseLength ? false:true;
        innerKeyBoard = outerKeyBoard ? true :false;
        TreeSet<Integer> set = new TreeSet<Integer>();
        for(int i = 0 ; i < keyboards.length;i++){
            int price = b;
            if(price < keyboards[i]) continue;
            else{
                price = price - keyboards[i];
            }
            for(int j = 0; j < drives.length;j++){
                if(price < drives[j]) continue;
                else{
                    set.add(keyboards[i]+drives[j]);
                }
            }

        }

        if(set.size() < 1) return -1;
        else return set.pollLast();

    }
}
