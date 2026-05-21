import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static void main(String[] args){}

    public List<List<String>> solveNQueens(int n) {
        backtrack(n, 0, new boolean[n], new boolean[2 * n - 1], new boolean[2 * n - 1], new ArrayList<>());
        return this.res;
    }

    List<List<String>> res = new ArrayList<>();

    public void backtrack(int n, int row, boolean[] cols, boolean[] diagMain, boolean[] diagAnti, List<String> path){
        if(row == n){
            // 都能走到这里了, 说名 [0, n - 1] 都找到符合的了
            this.res.add(new ArrayList<>(path));// 缓冲内容克隆存放一下
            return;
        }
        // start 表示
        for(int i = 0; i < n; i++){
            if(!cols[i] && !diagMain[n - 1 - i + row] && !diagAnti[row + i]){
                cols[i] = true;
                diagMain[n - 1 - i + row] = true;
                diagAnti[i + row] = true;
                char[] chars = new char[n];
                Arrays.fill(chars, '.');
                chars[i] = 'Q';
                path.add(new String(chars));
                backtrack(n, row + 1, cols, diagMain, diagAnti, path);
                // 恢复状态, 不要干扰到其他的
                cols[i] = false;
                diagMain[n - 1 - i + row] = false;
                diagAnti[i + row] = false;
                path.removeLast();// 从缓冲路径中删除最后一个
            }
        }
    }
}
