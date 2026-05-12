public class Solution {
    public static void main(String[] args){
        int[][] arr = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        rotate(arr);
    }

    public static void rotate(int[][] matrix) {
        int row_num = matrix.length;
        int col_num = matrix[0].length;

        
        // 先转置
        for(int i = 0; i < row_num; i++){
            for(int j = i + 1; j < col_num; j++){
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
        for(int i = 0; i < row_num; i++){
            lineReverse(matrix[i]);
        }

        for(int i = 0; i < row_num; i++){
            for(int j = 0; j < col_num; j++){
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }

    public static void lineReverse(int[] nums){
        for(int i = 0; i < nums.length / 2; i++){
            int tmp = nums[i];
            nums[i] = nums[nums.length - i - 1];
            nums[nums.length - i - 1] = tmp;
        }
    }
}
