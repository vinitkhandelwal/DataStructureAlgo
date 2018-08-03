package Geeks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class SumOfThreeElement {
    List<Integer> sum = new ArrayList<>();
    List<Integer> store = new ArrayList<>();
    public void append(Integer[] a){


        List<Integer> arrayList = Arrays.asList(a);
        store.addAll(arrayList);
        int j = 0;
        for(int i = 0 ; i < store.size()-2;i++){

            if(sum.size() == i){
                sum.add(store.get(i) + store.get(i+1) + store.get(i+2));
            }
            j++;

        }





    }

    public boolean checkSum(int sumNum){
        for(Integer n : sum){
            if(n == sumNum) return true;
        }
        return false;
    }

    public List<Integer> getSum() {
        return sum;
    }

    public void setSum(List<Integer> sum) {
        this.sum = sum;
    }

    public List<Integer> getStore() {
        return store;
    }

    public void setStore(List<Integer> store) {
        this.store = store;
    }

    public static void main(String[] args) {

        SumOfThreeElement sot = new SumOfThreeElement();
        Integer a [] = new Integer[]{1,2,3};
        sot.append(a);
        sot.append(new Integer[]{4});

        System.out.println(sot.checkSum(5));
        System.out.println(sot.checkSum(6));

        sot.append(new Integer[]{6});
        System.out.println(sot.checkSum(9));
        Random rand = new Random();

        for(int i = 0 ; i < 100000;i++){
            sot.append(new Integer[]{i});

            int numOfCheck = (rand.nextInt(100000));
            if(sot.checkSum(numOfCheck)){
                System.out.println(sot.getStore());
                System.out.println("Size of Array :" + sot.getStore().size());
                System.out.println("Check for Number :" +  numOfCheck + ": " +sot.checkSum(numOfCheck));
            }

        }


    }

    public static void printArray(List<Integer> array){
        for(Integer a : array){
            System.out.print(a+ ",");
        }
        System.out.println(" ");
    }
}
