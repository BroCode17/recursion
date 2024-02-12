import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

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

    public static  void combinationSumOne(){
        int[] array = {2,3,6,7};
        int target = 7;
        List<List<Integer>> res  = new ArrayList<>();
        BackTracking.combinationSumI(0, array, target,res, new ArrayList<>()); //

        res.forEach(System.out::println);
    }
    public static  void combinationSumTwo(){
        int[] array = {10,1,2,7,6,1,5};
        int target = 8;
        List<List<Integer>> res  = new ArrayList<>();
        Arrays.sort(array);
        BackTracking.combinationSumII(0, array, target,res, new ArrayList<>()); //

        res.forEach(System.out::println);
    }

    //Permutation
    public static  void permutationOne(){
        int[] array = {3,1,2};
        List<List<Integer>> res  = new ArrayList<>();

        BackTracking.printAllPermutation( array, res, new ArrayList<>(), new Boolean[array.length]); //
        System.out.println("Permutation I");
        res.forEach(System.out::println);
    }

    public static  void permutationTwo(){
        int[] array = {3,1,2};
        List<List<Integer>> res  = new ArrayList<>();

        BackTracking.printAllPermutationII( array, res, new ArrayList<>()); //
        System.out.println("Permutation II");
        res.forEach(System.out::println);
    }

    public static void mColoring(int n, int m){
        List<Integer>[] G = new ArrayList[n];

        for(int i = 0; i < n; i++)
            G[i] = new ArrayList<>();
        G[0].add(1);
        G[1].add(0);
        G[1].add(2);
        G[2].add(1);
        G[2].add(3);
        G[3].add(2);
        G[3].add(0);
        G[0].add(3);
        G[0].add(2);
        G[2].add(0);

        System.out.println(BackTracking.graphColoring( G, m, n));
    }

    public static  void sudoku(){
        String[][] board = {{"5", "3", ".", ".", "7", ".", ".", ".", "."},
                {"6", ".", ".", "1", "9", "5", ".", ".", "."},
                {".", "9", "8", ".", ".", ".", ".", "6", "."},
                {"8", ".", ".", ".", "6", ".", ".", ".", "3"},
                {"4", ".", ".", "8", ".", "3", ".", ".", "1"},
                {"7", ".", ".", ".", "2", ".", ".", ".", "6"},
                {".", "6", ".", ".", ".", ".", "2", "8", "."},
                {".", ".", ".", "4", "1", "9", ".", ".", "5"},
                {".", ".", ".", ".", "8", ".", ".", "7", "9"}};

        BackTracking.sudokuSolve(board);
        for(String[] row: board){
            System.out.println(Arrays.toString(row));
        }
    }
    public static void main(String[] args) {

        //Print All Sub Array whose Sum Equal To K
        printSubSumOfK(); //return [3,1],[4]

        //Print Sub Array whose Sum Equal To K
        printASubSumOfK(); // return [3,1]

        //count All Sub Array whose Sum Equal To K
        countSubOfSumOfK(); // return 2

        //Combination Sum
        combinationSumOne(); // return [2,2,3], [7];

        combinationSumTwo(); // return [[1,1,6],[1,2,5],[1,7],[2,6]]
        //Permutation I
        permutationOne(); // returns [[3, 1, 2],[3, 2, 1],[1, 3, 2],[1, 2, 3],[2, 3, 1],[2, 1, 3]]

        //Permutation II
        permutationTwo(); // returns [[3, 1, 2],[3, 2, 1],[1, 3, 2],[1, 2, 3],[2, 3, 1],[2, 1, 3]]

        //M Coloring
        mColoring(4,3); //return true;

        //Sudoku Solver;
        sudoku();
    }
}