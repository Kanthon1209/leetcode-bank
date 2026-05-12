public class Solution {
    public static void main(String[] args){
        int[][] arr = new int[][]{{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
        System.out.println(new Solution().searchMatrix(arr, 5));
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        // 从右上角开始, 不断检查当前元素是和 target 关系, 如果大, 那么左移动
        // 如果小于目标值, 那么向下移动

        // 如果从左上角出发, 那么不知道下一个元素选取哪一个
        int row_num = matrix.length;
        int col_num = matrix[0].length;
        int i = 0;
        int j = col_num - 1;
        while(i < row_num && j >= 0){
            if(matrix[i][j] == target){
                return true;
            }
            if(matrix[i][j] > target){
                j--;
            }else{
                i++;
            }
        }
        return false;
    }
}
