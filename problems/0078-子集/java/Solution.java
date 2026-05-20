import java.util.List;
import java.util.ArrayList;

public class Solution {
    public static void main(){}

    List<List<Integer>> res;
    public List<List<Integer>> subsets(int[] nums) {
        backtrack(nums, 0, new ArrayList<Integer>());
        return this.res;
    }


    public void backtrack(int[] nums, int start, List<Integer> path){
        res.add(new ArrayList<>(path));
        for(int i = start; i < nums.length; i++){
            path.add(nums[i]);
            backtrack(nums, start + 1, path);
            path.removeLast();
        }
    }
}
