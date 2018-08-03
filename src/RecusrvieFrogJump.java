import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RecusrvieFrogJump {




        public static List <List<Integer>> results = new ArrayList<List<Integer>>();

        public static void main(String[] args){
            int sum = 5;
            List <Integer> way = new ArrayList<Integer>();
            printJumpWays(way, 0, sum);
        }

        /**
         * @param way
         * @param currentValue
         * @param sum
         */
        public static void printJumpWays(List <Integer> way, int currentValue, int sum){
            List <Integer> currentWay = new ArrayList<Integer>();
            if(currentValue < sum){
                currentWay.addAll(way);
                currentWay.add(1);
                printJumpWays (currentWay, currentValue+1, sum);
                currentWay = new ArrayList<Integer>();

                currentWay.addAll(way);
                currentWay.add(2);
                printJumpWays (currentWay, currentValue+2, sum);
            }

            if (currentValue == sum){
                int count1 = Collections.frequency(way,1);
                int count2 = Collections.frequency(way,2);
                if(results.size() == 0) results.add(way);
                for(List<Integer> l1 : results){
                    if(Collections.frequency(l1,1) == count1 && Collections.frequency(l1,2) == count2){

                    }else{
                        results.add(way);
                        System.out.println(way);
                    }

                }


                return;
            }

            if (currentValue > sum){
                return;
            }
        }

    }

