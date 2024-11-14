package Arrays.Medium;

import java.util.ArrayList;
import java.util.List;

public class B3_SprialMatrix {
    public static void main(String[] args){
        int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        Solution_A12 sol = new Solution_A12();
        List<Integer> spiralOrdered = sol.spiralOrder(matrix);

        System.out.println("result:");
        System.out.println(spiralOrdered);
    }
}

class Solution_A12{
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();

        int left = 0, right = matrix[0].length - 1, up = 0, down = matrix.length - 1;

        while(left <= right && up <= down){
            //left to right
            if(up <= down){
                for(int i = left; i <= right; i++){
                    list.add(matrix[up][i]);
                }
                up++;
            }

            //up to down
            if(left <= right){
                for(int i = up; i <= down; i++){
                    list.add(matrix[i][right]);
                }
                right--;
            }

            //right to left
            if(up <= down) {
                for (int i = right; i >= left; i--) {
                    list.add(matrix[down][i]);
                }
                down--;
            }

            //down to up
            if(left <= right) {
                for (int i = down; i >= up; i--) {
                    list.add(matrix[i][left]);
                }
                left++;
            }
        }

        return list;

    }
}
