import java.util.Arrays;

public class Solution {
    public static void main(String[] args){

    } 

    public int firstMissingPositive(int[] nums) {
        for(int i = 0; i < nums.length; i++){
            while(
                nums[i] >= 1 &&
                nums[i] <= nums.length &&
                nums[nums[i] - 1] != nums[i]
            ){
                swap(nums, i, nums[i] - 1); // 前面是当前元素下标, 后面是目标位置下标
            }
        }
        Arrays.stream(nums).forEach(System.out::println);
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != i + 1){
                return i + 1;
            }
        }
        return nums.length + 1;
    }

    public static void swap(int[] nums, int idx_a, int idx_b){
        int tmp = nums[idx_a];
        nums[idx_a] = nums[idx_b];
        nums[idx_b] = tmp;
    }
}
