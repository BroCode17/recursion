import java.util.ArrayList;

public class Main {

    public static void printSubSumOfK(){
        int[] array = {3,1,2,4};
        int k = 4;
        BackTracking.printAllSubarrayWhoseSumEqualToK(0, 0, k,array, new ArrayList<>());
    }

    public static  void printASubSumOfK(){
        int[] array = {3,1,2,4};
        int k = 4;
        BackTracking.printASubarrayWhoseSumEqualToK(0, 0, k,array, new ArrayList<>());
    }

    public static  void countSubOfSumOfK(){
        int[] array = {3,1,2,4};
        int k = 4;
        int count = BackTracking.countAllSubarrayWhoseSumEqualToK(0, 0, k,array); //

        System.out.println(count);
    }
    public static void main(String[] args) {

        //Print All Sub Array whose Sum Equal To K
        printSubSumOfK(); //return [3,1],[4]

        //Print Sub Array whose Sum Equal To K
        printASubSumOfK(); // return [3,1]

        //count All Sub Array whose Sum Equal To K
        countSubOfSumOfK(); // return 2
    }
}