import java.util.ArrayList;
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

    /**
     * Given an array of distinct integers candidates and a target integer target, return a list of all unique combinations
     * of candidates where the chosen numbers sum to target. You may return the combinations in any order.
     * The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the
     * frequencyof at least one of the chosen numbers is different.
     * The test cases are generated such that the number of unique combinations
     * that sum up to target is less than 150 combinations for the given input.
     * Example 1:
     * Input: candidates = [2,3,6,7], target = 7
     * Output: [[2,2,3],[7]]
     * Explanation:
     * 2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
     * 7 is a candidate, and 7 = 7.
     * These are the only two combinations.
     **/

    public static void combinationSumI(int index, int[] A, int target, List<List<Integer>> res, List<Integer> list){
        //base case
        if(index  == A.length){
            if(target == 0){
                res.add(new ArrayList<>(list));
            }
            return;
        }

        //pick
        if(A[index] <= target){
            list.add(A[index]);
            combinationSumI(index, A, target - A[index], res, list);
            list.remove(list.size()-1);
        }

        combinationSumI(index +1, A,target, res, list);

    }
}
