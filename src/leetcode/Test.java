package leetcode;

import java.text.SimpleDateFormat;

/**
 * Created by vinit.khandelwal on 3/20/2018.
 */
public class Test {

    public static void main(String[] args) {

        String s= "10:30";
        String [] sta = s.split(":");
    }

    static int findParkingPrice(String entryTime, String leavingTime) {
        String [] entryArray = entryTime.split(":");
        int startHour = Integer.parseInt(entryArray[0]);
        int startMin = Integer.parseInt(entryArray[1]);

        String [] leavingArray = leavingTime.split(":");
        int leaveHour = Integer.parseInt(leavingArray[0]);
        int leaveMin = Integer.parseInt(leavingArray[1]);

        int totalHour = (leaveHour - startHour) + (leaveMin-startMin > 0 ? 1 :0);

        if(totalHour < 1){
            return 2+3;
        }
        else{
            return 2+3+((totalHour -1)*4) ;
        }

    }
}
