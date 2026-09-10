package Hashing;

import java.util.HashMap;
import java.util.Map;

public class  SubMatrix {

    public int numSubmatrixSumTarget(int[][] matrix, int target) {

        int row = matrix.length;
        int cols = matrix[0].length;

        int count = 0;

        for (int top = 0; top < row; top++) {

            int[] colSum = new int[cols];

            for (int bot = top; bot < row; bot++) {

                for (int col = 0; col < cols; col++) {
                    colSum[col] += matrix[bot][col];
                }

                count += countSubArray(colSum, target);
            }
        }

        return count;
    }

    public int countSubArray(int[] colSum, int target) {

        Map<Integer, Integer> map = new HashMap<>();

        map.put(0, 1);

        int sum = 0;
        int count = 0;

        for (int n : colSum) {

            sum += n;

            int need = sum - target;

            if (map.containsKey(need)) {
                count += map.get(need);
            }

            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return count;
    }

    // Main method
    public static void main(String[] args) {

        SubMatrix obj = new  SubMatrix();

        int[][] matrix = {
                {0, 1, 0},
                {1, 1, 1},
                {0, 1, 0}
        };

        int target = 0;

        int result = obj.numSubmatrixSumTarget(matrix, target);

        System.out.println("Number of submatrices = " + result);
    }
}
