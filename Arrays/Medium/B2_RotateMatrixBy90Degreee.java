package Arrays.Medium;

public class B2_RotateMatrixBy90Degreee {
    public static void main(String[] args) {
        Solution_A11 sol = new Solution_A11();

        int[][] matrix = {{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}};

        System.out.println("Before-->");
        for(int[] arr: matrix){
            for(int num: arr){
                System.out.printf("%d\t", num);
            }
            System.out.println();
        }
        sol.rotate(matrix);

        System.out.println("\n\nAfter-->");
        for(int[] arr: matrix){
            for(int num: arr){
                System.out.printf("%d\t", num);
            }
            System.out.println();
        }
    }
}


class Solution_A11 {
    public void rotate(int[][] matrix) {
        transpose(matrix);
        reverseRows(matrix);
    }

    private static void transpose(int[][] matrix){
        for(int i = 1; i < matrix.length; i++){
            for(int j = 0; j < i; j++ ){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }

    private static void reverseRows(int[][] matrix){
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix.length / 2; j++){
                int cols = matrix[0].length;

                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][cols - 1 - j];
                matrix[i][cols - 1 - j] = temp;
            }
        }
    }
}