package Tree;

import java.util.regex.Pattern;

/**
 * Created by vinit.khandelwal on 3/7/2018.
 */
public class PatternMatching {

    public static void main(String[] args) {
        String minMaxLength = "^[\\s\\S]{12,20}$";
        String upper = ".*[A-Z].*" ,lower = ".*[a-z].*", number = ".*[0-9].*",
                repetition = "[(.)\\1\\1]", whiteSpace = ".*[\\s].*",specialCharacters = ".*[^A-Za-z0-9].*";

        String test = "Test@123Test@123";
//        Pattern pattern = Pattern.compile(repetition);
        System.out.println(passwordValidation(test,false));

    }

    private static boolean passwordValidation(String test , boolean flag){
        String minMaxLengthForInternal = "^[\\s\\S]{12,20}$" , minMaxLengthForExternal = "^[\\s\\S]{10,20}$";
        String upper = ".*[A-Z].*" ,lower = ".*[a-z].*", number = ".*[0-9].*", whiteSpace = ".*[\\s].*",specialCharacters = ".*[^A-Za-z0-9].*";


        String newPassword = test;
        if(newPassword == null) return false;
        if(flag && !Pattern.matches(minMaxLengthForInternal,newPassword)) return false;
        if(!flag && !Pattern.matches(minMaxLengthForExternal,newPassword)) return false;
        if(!Pattern.matches(upper,newPassword)) return false;
        if(!Pattern.matches(lower,newPassword)) return false;
        if(!Pattern.matches(number,newPassword)) return false;
        if(Pattern.matches(whiteSpace,newPassword)) return false;
        if(!Pattern.matches(specialCharacters,newPassword)) return false;
        if(!checkConsecutive(newPassword)) return false;

        return true;

    }

    private static boolean checkConsecutive(String test){
    char [] array = test.toCharArray();
        for(int i = 0 ; i < array.length-2;i++){
            if(array[i] == array[i+1] && array[i+1] == array[i+2] ){
                return false;
            }
        }
        return true;

    }


}
