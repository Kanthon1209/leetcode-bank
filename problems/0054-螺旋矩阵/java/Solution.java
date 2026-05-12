import java.util.ArrayList;
import java.util.List;

public class Solution{
    public static void main(String[] args){
        // int[][] matrix = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        int[][] matrix = new int[][]{{1}};
        spiralOrder(matrix);
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        if(matrix == null) return null;
        if(matrix.length == 0) return null;
        if(matrix[0].length == 0) return null;

        // 定义一个四个方向数组
        int[][] direction = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int row_num = matrix.length;
        int col_num = matrix[0].length;
        int[][] flag = new int[row_num][col_num];
        List<Integer> list = new ArrayList<>();
        int r_idx = 0;
        int c_idx = 0;

        int direction_idx = 0;
        int[] current_direction = direction[0];
        System.out.println(direction[0][0] + "" + direction[0][1]);
        while(
            r_idx >= 0 &&
            r_idx < row_num &&
            c_idx >= 0 &&
            c_idx < col_num &&
            flag[r_idx][c_idx] == 0){ // 如果当前格子没有走过
            System.out.println(r_idx + " " + c_idx + ": " +  matrix[r_idx][c_idx]);
            list.add(matrix[r_idx][c_idx]);
            flag[r_idx][c_idx] = 1; // 标记这个地方走过了
            if(
                r_idx + current_direction[0] < row_num &&
                r_idx + current_direction[0] >= 0 &&
                c_idx + current_direction[1] < col_num &&
                c_idx + current_direction[1] >= 0 && 
                flag[r_idx + current_direction[0]][c_idx + current_direction[1]] == 0 // 下一个位置没有走过

            ){// 如果当前坐标往当前方向走一步仍然在约束内, 并且那个地方还没有走过, 那么就在这方向上走一步
                r_idx += current_direction[0];
                c_idx += current_direction[1];
            }else{// 否则, 说明到边缘了, 那么换方向
                direction_idx += 1;
                direction_idx %= 4;
                current_direction = direction[direction_idx];
                r_idx += current_direction[0];
                c_idx += current_direction[1];
                // 如果换完方向就不能走了, 那就直接结束
            }
        }
        return list;
    }
}