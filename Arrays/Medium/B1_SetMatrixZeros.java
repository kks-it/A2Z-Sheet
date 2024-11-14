package Arrays.Medium;

import java.util.Arrays;

public class B1_SetMatrixZeros {
    public static void main(String[] args) {
        Solution_A10 sol = new Solution_A10();

        int[][] matrix = {{0,1,2,0},{3,4,5,2},{1,3,1,5}};

        sol.setZeroes(matrix);

        for(int[] arr: matrix){
            for(int num: arr){
                System.out.printf("%d\t", num);
            }
            System.out.println();
        }
    }
}

class Solution_A10 {
    public void setZeroes(int[][] matrix) {
        boolean row0 = false, col0 = false;
        for (int[] nums : matrix) {
            if (nums[0] == 0) {
                col0 = true;
                break;
            }
        }

        for(int i = 0; i < matrix[0].length; i++){
            if(matrix[0][i] == 0){
                row0 = true;
                break;
            }
        }



        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                if(matrix[i][j] == 0){
                    matrix[i][0] = matrix[0][j] = 0;
                }
            }
        }

        for(int i = 1; i < matrix.length; i++){
            for(int j = 1; j < matrix[0].length; j++){
                if(matrix[i][0] == 0 || matrix[0][j] == 0){
                    matrix[i][j] = 0;
                }
            }
        }

        if(col0){
            for(int i = 0; i < matrix.length; i++){
                matrix[i][0] = 0;
            }
        }

        if(row0){
            Arrays.fill(matrix[0], 0);
        }
    }
}
