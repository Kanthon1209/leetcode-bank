import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(){}
    List<List<Integer>> res = new ArrayList<>(); // 放已经成型的结果

    public List<List<Integer>> permute(int[] nums) {
        boolean[] used = new boolean[nums.length]; // 初始化的时候全都是 0
        backtrack(nums, used, new ArrayList<Integer>());
        return this.res;
    }

    public void backtrack(int[] nums, boolean[] used, List<Integer> path){
        if(path.size() == nums.length){
            this.res.add(new ArrayList<>(path));// 这里不能将 path 直接添加进去, 因为我们还要不断修改 path
            return;
        }

        for(int i = 0; i < used.length; i++){
            if(used[i] == false){
                // 当前的元素还没有用过呢, 那么置为 true, 因为我们要用啦, 然后将该元素加入正在维护的 list 末尾
                path.add(nums[i]);
                used[i] = true;
                backtrack(nums, used, path);
                path.removeLast();
                used[i] = false;
            }
        }
    }
}
