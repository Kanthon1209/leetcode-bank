public class Solution {
    public static void main(String[] args){}

    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null) return false;
        if(matrix.length == 0) return false;
        if(matrix[0] == null) return false;
        if(matrix[0].length == 0) return false;
        int rowNum = matrix.length;
        int colNum = matrix[0].length;
        int left = 0;
        int right = rowNum * colNum -1;
        // 不过是进行二维和一维的转换
        int mid = left + (right - left) / 2;
        while(left <= right){
            if(getValue(mid, matrix) < target){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
            mid = left + (right - left) / 2;
        }
        if(left == rowNum * colNum) return false;
        return getValue(left, matrix) == target;
    }

    public int getValue(int idx, int[][] matrix){
        int colNum = matrix[0].length;
        int rowIdx = idx / colNum;// 看看能被分配几行元素
        int colIdx = idx % colNum;
        return matrix[rowIdx][colIdx];
    }
}
