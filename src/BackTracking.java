import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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
     * frequency of at least one of the chosen numbers is different.
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

    /**
     * Given a collection of candidate numbers (candidates) and a target number (target),
     * find all unique combinations in candidates where the candidate numbers sum to target.
     * Each number in candidates may only be used once in the combination.
     * Note: The solution set must not contain duplicate combinations.
     * Example 1:
     * Input: candidates = [10,1,2,7,6,1,5], target = 8
     * Output:
     * [
     * [1,1,6],
     * [1,2,5],
     * [1,7],
     * [2,6]
     * ]
     */
    public static void combinationSumII(int index, int[] A, int target, List<List<Integer>> res, List<Integer> list){
        //base case
        if(target == 0){
            res.add(new ArrayList<>(list));
            return;
        }
        //This pattern is for subsequences
        for(int i = index; i < A.length; i++){
            if(i > index && A[i] == A[i-1]) continue;
            if(A[i] > target) break;
            list.add(A[i]);
            combinationSumII(i+1, A, target - A[i], res, list);
            list.remove(list.size()-1);
        }

    }

    /**
     * Find all valid combinations of k numbers that sum up to n such that the
     * following conditions are true:
     * Only numbers 1 through 9 are used.
     * Each number is used at most once.
     * <p>
     * Return a list of all possible valid combinations. The list must not contain the same
     * combination twice, and the combinations may be returned in any order.
     *<p>
     * Example 1:
     *
     * Input: k = 3, n = 7
     * Output: [[1,2,4]]
     * Explanation:
     * 1 + 2 + 4 = 7
     * There are no other valid combinations.
     * Example 2:
     *
     * Input: k = 3, n = 9
     * Output: [[1,2,6],[1,3,5],[2,3,4]]
     * Explanation:
     * 1 + 2 + 6 = 9
     * 1 + 3 + 5 = 9
     * 2 + 3 + 4 = 9
     * There are no other valid combinations.
     * Example 3:
     *
     * Input: k = 4, n = 1
     * Output: []
     * Explanation: There are no valid combinations.
     * Using 4 different numbers in the range [1,9], the smallest sum we can get is 1+2+3+4 = 10 and since 10 > 1, there are no valid combination.
     *
     */

    static void combinationSumIII(int index, int k, int n, List<List<Integer>> res, List<Integer> list){

        //base
        if(list.size() == k){
            int sum = 0;
            for (Integer integer : list) {
                sum += integer;
            }
            if(sum == n)
                res.add(new ArrayList<>(list));
            return;
        }

        for(int in = index; in < 10; in++){
            if(list.size() == k) break;
            list.add(in);
            combinationSumIII(in+1,k, n, res, list);
            list.remove(list.size()-1);
        }
    }


    /**
     * Permutation Patterns
     */

    //Pattern 1 -> O(n!) SP -> 2N
    static void printAllPermutation(int[] A, List<List<Integer>> res, List<Integer> list, Boolean[] numIsPicked){
        if(list.size() == A.length){
            res.add(new ArrayList<>(list));
            return;
        }

        for(int i = 0; i < A.length; i++){
            if(numIsPicked[i] == null){
                numIsPicked[i] = true;
                list.add(A[i]);
                printAllPermutation(A, res, list, numIsPicked);
                list.remove(list.size()-1);
                numIsPicked[i] = null;
            }
        }
    }

    //Pattern Two -> This pattern uses O(n) space complexity
    static void printAllPermutationII(int[] A, List<List<Integer>> res, List<Integer> list){
        if(list.size() == A.length){
            res.add(new ArrayList<>(list));
            return;
        }

        for (int j : A) {
            if (list.contains(j))
                continue;
            list.add(j);
            printAllPermutationII(A, res, list);
            list.remove(list.size() - 1);
        }
    }

    //M coloring problem

    /**
     * Given an undirected graph and an integer M.
     * The task is to determine if the graph can be
     * colored with at most M colors such that no
     * two adjacent vertices of the graph are colored
     * with the same color. Here coloring of a graph
     * means the assignment of colors to all vertices.
     * Print 1 if it is possible to colour vertices
     * and 0 otherwise.
     * Example 1:
     * Input:
     * N = 4
     * M = 3
     * E = 5
     * Edges[] = {(0,1),(1,2),(2,3),(3,0),(0,2)}
     * Output: 1
     * Explanation: It is possible to colour the
     * given graph using 3 colours.
     * @param m - the max number of colors
     * @param n - number of vertices size
     * @return true or false is the m can be used to color all the elements
     *
     */
    public static boolean graphColoring(List<Integer>[] graph, int m, int n) {
        // Your code here
        int[] check = new int[n];
        int size = graph.length;
        return isValid(0, graph, check, m, size);
    }

    static boolean isValid(int node, List<Integer>[] graph, int[] check, int m, int n){

        //base case
        if(node == n){
            return true;
        }

        for(int i = 1; i <= m; i++){
            if(isSafe(i, node, graph, check)){
                check[node] = 1;
                if(isValid(node+1, graph, check, m, n))
                    return true;
                check[node] = 0;
            }
        }
        return false;
    }

    static boolean isSafe(int color, int node, List<Integer>[] graph, int[] check){

        for(int row: graph[node]){
            if(check[row] == color)
                return false;
        }
        return true;
    }


    /**
     * Write a program to solve a Sudoku puzzle by filling the empty cells.
     *
     * A sudoku solution must satisfy all of the following rules:
     *
     * Each of the digits 1-9 must occur exactly once in each row.
     * Each of the digits 1-9 must occur exactly once in each column.
     * Each of the digits 1-9 must occur exactly once in each of the 9 3x3 sub-boxes of the grid.
     * The '.' character indicates empty cells.
     *
     *
     *
     * Example 1:
     *
     *
     * Input: board = [["5","3",".",".","7",".",".",".","."],
     * ["6",".",".","1","9","5",".",".","."],
     * [".","9","8",".",".",".",".","6","."],
     * ["8",".",".",".","6",".",".",".","3"],
     * ["4",".",".","8",".","3",".",".","1"],
     * ["7",".",".",".","2",".",".",".","6"],
     * [".","6",".",".",".",".","2","8","."],
     * [".",".",".","4","1","9",".",".","5"],
     * [".",".",".",".","8",".",".","7","9"]]
     * Output: [["5","3","4","6","7","8","9","1","2"],
     * ["6","7","2","1","9","5","3","4","8"],
     * ["1","9","8","3","4","2","5","6","7"],
     * ["8","5","9","7","6","1","4","2","3"],
     * ["4","2","6","8","5","3","7","9","1"],
     * ["7","1","3","9","2","4","8","5","6"],
     * ["9","6","1","5","3","7","2","8","4"],
     * ["2","8","7","4","1","9","6","3","5"],
     * ["3","4","5","2","8","6","1","7","9"]]
     * Explanation: The input board is shown above and the only valid solution is shown below:
     */

      public static boolean sudokuSolve(String[][] board){
          if(board.length == 0)
              return false;

          for(int row = 0; row < 9; row++){
              for(int col = 0; col < 9; col++){
                  if(board[row][col] == "."){
                      for(char c = '1'; c <= '9'; c++){
                          if(itCan(board, row, col,c)){
                              board[row][col] = String.valueOf(c);
                              if(sudokuSolve(board))
                                  return true;
                              else{
                                  board[row][col] = ".";
                              }
                          }
                      }
                      return false;
                  }
              }
          }
          return true;
      }

      static  boolean itCan(String[][] board, int row, int col, char c){
          for(int i = 0; i < 9; i++){
              if(board[row][i].equals(String.valueOf(c)))
                  return false;
              if(Objects.equals(board[i][col], String.valueOf(c)))
                  return false;
              if(Objects.equals(board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3], String.valueOf(c)))
                  return false;
          }
          return true;
      }
}


































