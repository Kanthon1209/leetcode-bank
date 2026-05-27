import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        new Solution().generate(3);
    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        for(int i = 0; i < numRows; i++){
            List<Integer> row = new ArrayList<>();
            for(int j = 0; j < i + 1; j++){
                if(j == 0 || j == i){// j == i 表示这行的最后一个位置的下标
                    row.add(1);
                }else{
                    row.add(res.get(i - 1).get(j - 1) + res.get(i - 1).get(j));
                }
            }
            res.add(row);
        }
        return res;
    }
}
