public class Solution {
    public static void main(String[] args){

    }

    public void setZeroes(int[][] matrix) {
        boolean firstRowZero = false;
        boolean firstColZero = false;
        int row_num = matrix.length;
        int col_num = matrix[0].length;
        for(int i = 0; i < row_num; i++){
            for(int j = 0; j < col_num; j++){
                if(matrix[i][j] == 0){
                    if(i == 0){
                        firstRowZero = true;
                    }
                    if(j == 0){
                        firstColZero = true;
                    }
                    matrix[i][0] = 0; // 标记 i 行 0 列 元素 为 0, 表示 i 行需要处理为 0
                    matrix[0][j] = 0;
                }
            }
        }

        for(int i = 1; i < row_num; i++){
            if(matrix[i][0] == 0){
                for(int j = 0; j < col_num; j++){
                    matrix[i][j] = 0;
                }
            } 
        }

        for(int i = 1; i < col_num; i++){
            if(matrix[0][i] == 0){
                for(int j = 0; j < row_num; j++){
                    matrix[j][i] = 0;
                }
            }
        }

        // 应该先把第一行第一列以外的处理完了再来处理第一行第一列, 否则, 你第一行要置零, 你全置零了, 那处理列的时候, 谁还知道要把哪些列置零?
        if(firstRowZero){
            for(int i = 0; i < col_num; i++){
                matrix[0][i] = 0;
            }
        }
        if(firstColZero){
            for(int i = 0; i < row_num; i++){
                matrix[i][0] = 0;
            }
        }
    }
}
