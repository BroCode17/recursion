import java.util.List;

public class BackTracking {
    /**
     * Time complexity -> O(2^N)
     * Space complexity -> O(N) -> Auxiliary Stack Space
     * @param index -> starting index of the Array/List
     * @param sum -> Parameterized Variable sum
     * @param k -> The target value
     * @param A -> Array/List
     * @param list -> Container to store the numbers whose sum is k
     */
    //Print All Subarray whose Sum equal to K
    //Pattern 1
    static  void printAllSubarrayWhoseSumEqualToK(int index, int sum, int k, int[] A, List<Integer> list){
        //Base case
        if(index >= A.length){
            //Check if sum == k
            if(sum == k){
                System.out.println(list.toString());
            }
            return;
        }

        //Pick
        int pick = A[index];
        sum += pick;
        list.add(pick);
        printAllSubarrayWhoseSumEqualToK(index  + 1, sum, k, A, list);
        //Not pick
        sum -= pick;
        list.remove(list.size()-1);

        //Call the function for the next element => index;
        printAllSubarrayWhoseSumEqualToK(index + 1, sum, k, A, list);
    }

    //Print A Subarray whose Sum equal to K
    //Pattern 2
    static boolean printASubarrayWhoseSumEqualToK(int index, int sum, int k, int[] A, List<Integer> list){
        //Base condition
        if(index == A.length){
            if(sum == k){
                System.out.println(list);
                return true;
            }
            else
                return false;
        }

        //Pick
        int pick  = A[index];
        sum += pick;
        list.add(pick);
        //Check if method returns true then break from the function
        if(printASubarrayWhoseSumEqualToK(index+1, sum, k, A, list))
                return true;

        //Not function return false then
        sum -= pick;
        list.remove(list.size() -1);

        return printASubarrayWhoseSumEqualToK(index + 1, sum, k, A, list);
    }

    //Print A Subarray whose Sum equal to K
    //Pattern 3
    static int countAllSubarrayWhoseSumEqualToK(int index, int sum, int k, int[] A){
        //This will condition will never execute unless array contains only
        //Positive integers
        if(sum > k) return 0;
        //Base condition
        if(index == A.length){
            if(sum == k){
                return 1;
            }
            else
                return 0;
        }

        //Pick
        int pick  = A[index];
        sum += pick;
        //Check if method returns true then break from the function
        int left = countAllSubarrayWhoseSumEqualToK(index+1, sum, k, A);
        //Not function return false then
        sum -= pick;

        int right = countAllSubarrayWhoseSumEqualToK(index + 1, sum, k, A);

        return left + right;
    }
}
