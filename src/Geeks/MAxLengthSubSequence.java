package Geeks;

import java.util.ArrayList;
import java.util.List;

public class MAxLengthSubSequence {

    public static void main(String[] args) {

        int [] a= new int[]{2, 5, 6, 3, 7, 6, 5, 8};
        List<Integer> result = maxLegthSubSequence(a);
        System.out.println(result);


    }

    public static List<Integer> maxLegthSubSequence(int [] input){
        List<Integer> result = new ArrayList<>();

        for(int i = 0; i < input.length;i++){
            List<Integer> temp = new ArrayList<>();
            for(int j = i; j < input.length-1;j++){
                if(j==0){
                    temp.add(input[j]);
                }else if(input[j]- input[j+1] == 1 || input[j]- input[j+1] == 0)
                    {
                        temp.add(input[j]);
                        temp.add(input[j+1]);
                        j++;
                    }
                 else if(temp.size() > 0 && ((temp.get(temp.size()-1) - input[j] == 1 || temp.get(temp.size()-1) - input[j] == 0))){
                    temp.add(input[j]);
                }
            }
            if(result.size() < temp.size()){
                result.addAll(temp);
            }
        }
        return result;




    }
}
