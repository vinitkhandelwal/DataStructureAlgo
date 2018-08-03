package Geeks;

import java.util.Stack;

public class RemoveDuplicates {

    public static void main(String[] args) {
    int a[] = new int[]{1,2,2,1,3,3,5};
        System.out.println(removeDups(a));
        int result [] = removeRecursive(a,false);
    }

    static int [] removeDups(int a[]){
        int temp[] = new int[a.length];
        Stack<Integer> stack = new Stack<>();
        int k = 0;
        for(int i = 0 ; i < a.length;i++){

           if(!stack.isEmpty()){
               if(stack.peek() == a[i]) stack.pop();
               else  stack.push(a[i]);
           }else{
               stack.push(a[i]);
           }
        }
        return temp;
    }

    static int[] removeRecursive(int a[], boolean dups){
        int temp [] = new int[a.length];
        int k = 0;

        if(dups) return temp;
        for(int i = 0; i < a.length-1;i++){

            if(a[i] == a[i+1]){
                dups = true;
                i++;
            }else{
                temp[k] = a[i];
                k++;

            }


        }
        return removeRecursive(temp,dups);
    }
}
