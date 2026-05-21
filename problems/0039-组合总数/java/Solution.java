import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtrack(candidates, target, new ArrayList<>());
        return this.res;
        // 首先给排序一下
    }

    List<List<Integer>> res = new ArrayList<>();

    public void backtrack(int[] candidates, int remain, List<Integer> path){
        if(remain == 0){
            res.add(new ArrayList<>(path));// 如果 remain 刚好 == 0, 那不是恰好
        }
        for(int i = 0; i < candidates.length; i++){
            if(remain - candidates[i] < 0){
                break;// 那就打破循环, 不用再往后面看了, 因为后面的循环只会更大, 更没有可能了
            }
            path.add(candidates[i]);
            backtrack(candidates, remain - candidates[i], path);
            path.removeLast();
        }
    }
}