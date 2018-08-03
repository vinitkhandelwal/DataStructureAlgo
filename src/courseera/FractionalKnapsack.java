//package courseera;
//
//import java.math.BigDecimal;
//import java.math.RoundingMode;
//import java.util.*;
//
//import static java.math.BigDecimal.ROUND_HALF_UP;
//
//public class FractionalKnapsack {
//    private  double getOptimalValue(int capacity, int[] values, int[] weights) {
//        double value = 0;
//        List<WeightPerUnit> valuesPerUnit = new ArrayList<WeightPerUnit>();
//        for(int i = 0;i < values.length;i++){
//            WeightPerUnit weightPerUnit = new WeightPerUnit();
//            weightPerUnit.setValue(values[i]);
//            weightPerUnit.setWeight(weights[i]);
//            weightPerUnit.setValuePerUnit(values[i],weights[i]);
//            valuesPerUnit.add(weightPerUnit);
//        }
//        Collections.sort(valuesPerUnit);
//        Collections.reverse(valuesPerUnit);
//        double weight = 0;
//        for(WeightPerUnit valuePerUnit : valuesPerUnit){
//            if(weight == capacity){
//                return BigDecimal.valueOf(value).setScale(3, ROUND_HALF_UP).doubleValue();
//            }else{
//                double remaingWeight = capacity - weight;
//                if(valuePerUnit.getWeight() <= remaingWeight){
//                    value = value + BigDecimal.valueOf(valuePerUnit.getWeight()*valuePerUnit.getValuePerUnit()).setScale(3, ROUND_HALF_UP).doubleValue();
//                    weight = (weight +  valuePerUnit.getWeight());
//                }
//                else{
//                    value = value +  BigDecimal.valueOf(remaingWeight*valuePerUnit.getValuePerUnit()).setScale(3, ROUND_HALF_UP).doubleValue();
//                    weight = (weight +  remaingWeight);
//                }
//            }
//
//        }
//        return BigDecimal.valueOf(value).setScale(3, ROUND_HALF_UP).doubleValue();
//
//    }
//
////    private  double getSubOptimalValue(int capacity, int[] values, int[] weights) {
////        double value = 0;
////        List<WeightPerUnit> valuesPerUnit = new ArrayList<WeightPerUnit>();
////        for (int i = 0; i < values.length; i++) {
////            WeightPerUnit weightPerUnit = new WeightPerUnit();
////            weightPerUnit.setValue((double) values[i]);
////            weightPerUnit.setWeight((double) weights[i]);
////            weightPerUnit.setValuePerUnit((double) values[i], (double) weights[i]);
////            valuesPerUnit.add(weightPerUnit);
////        }
//////        Collections.sort(valuesPerUnit);
//////        Collections.reverse(valuesPerUnit);
////        double weight = 0;
////        for (int i = 0; i < valuesPerUnit.size(); i++) {
////            if (weight == capacity) {
////                return value;
////            } else {
////                int j = 0;
////                double valuePer = 0;
////                for (int j = 0; j < valuesPerUnit.size(); j++) {
////                    if(valuePer < valuesPerUnit.get(j).){
////
////                }
////
////                    WeightPerUnit valuePerUnit = valuesPerUnit.get(j);
////                    double remaingWeight = capacity - weight;
////                    if (valuePerUnit.getWeight() <= remaingWeight) {
////                        value = value + valuePerUnit.getWeight() * valuePerUnit.getValuePerUnit();
////                        weight = (weight + valuePerUnit.getWeight());
////                    } else {
////                        value = value + remaingWeight * valuePerUnit.getValuePerUnit();
////                        weight = (weight + remaingWeight);
////                    }
////                }
////
////            }
////
////
////        }
////        return value;
////    }
//
//    public static void main(String args[]) {
//        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
//        int capacity = scanner.nextInt();
//        int[] values = new int[n];
//        int[] weights = new int[n];
//        for (int i = 0; i < n; i++) {
//            values[i] = scanner.nextInt();
//            weights[i] = scanner.nextInt();
//        }
//        System.out.println(new FractionalKnapsack().getOptimalValue(capacity, values, weights));
//    }
//
//    class WeightPerUnit implements Comparable<WeightPerUnit>{
//        int weight;
//        int value;
//        float valuePerUnit;
//
//        public double getWeight() {
//            return weight;
//        }
//
//        public void setWeight(int weight) {
//            this.weight = weight;
//        }
//
//        public int getValue() {
//            return value;
//        }
//
//        public void setValue(int value) {
//            this.value = value;
//        }
//
//        public float getValuePerUnit() {
//            return valuePerUnit;
//        }
//
//        public void setValuePerUnit(int value, int weight) {
//            this.valuePerUnit = (float)value/(float)weight;
//        }
//
//
//        @Override
//        public int compareTo(WeightPerUnit o) {
//
//            return Float.compare(this.getValuePerUnit(),o.getValuePerUnit());
//        }
//    }
//}
//
