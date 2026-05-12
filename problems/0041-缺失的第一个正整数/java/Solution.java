import java.util.Arrays;

public class Solution {
    public static void main(String[] args){

    } 

    public int firstMissingPositive(int[] nums) {
        for(int i = 0; i < nums.length; i++){
            while(
                nums[i] >= 1 &&
                nums[i] <= nums.length &&
                nums[nums[i] - 1] != nums[i] // 必须是 正确位置上的元素 不是当前元素, 不能是当前位置上元素不在正确位置
                // 因为正确位置上的正确元素可能有很多个相同的正确元素, 正确位置上已经是正确元素了就不用再换了

                // 如果用当前位置是正确元素但是不在正确位置, 如果存在多个正确位置正确元素的话, 会无限循环
            ){
                swap(nums, i, nums[i] - 1); // 前面是当前元素下标, 后面是目标位置下标
            }
        }
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != i + 1){ // 如果当前位置的元素和映射元素不同, 那就说明缺失这个元素,  
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
