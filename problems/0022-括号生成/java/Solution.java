import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(){}

    public List<String> generateParenthesis(int n) {
        backtrack(n, 0, 0, new StringBuilder());
        return this.res;
    }

    List<String> res = new ArrayList<>();

    public void backtrack(int n, int left, int right, StringBuilder path){
        if(path.length() == 2 * n){
            // n 表示的是有几对括号
            res.add(path.toString());
        }
        if(left < n){
            path.append('(');
            backtrack(n, left + 1, right, path);// 0 号括号已经用过了, 接下来只能使用 1 号括号了
            // ↑ 函数内部会恢复到进入函数时候的状态
            path.deleteCharAt(path.length() - 1);// 函数内部恢复状态, 我们这里只需要将本层修改的恢复就行
        }
        if(right < left){
            path.append(')');
            backtrack(n, left, right + 1, path);
            path.deleteCharAt(path.length() - 1);
        }
    }
}
