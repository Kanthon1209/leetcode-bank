public class Solution {
    public static void main(String[] args){}

    public int[] searchRange(int[] nums, int target) {
        int left = lowerBound(nums, target);
        if(left == nums.length || nums[left] != target){
            return new int[]{-1, -1};
        }
        int right = lowerBound(nums, target + 1) - 1;
        return new int[]{left, right};
    }

    public int lowerBound(int[] nums, int target){
        int left = 0;
        int right = nums.length;
        int mid = left + (right - left) / 2;
        while(left <= right){
            if(nums[mid] < target){
                // 说明 mid 位置以及左边所有的元素都是小于 target 的
                left = mid + 1;// 更新过后, left 的左边全都是 < target 的
            }else{
                right = mid - 1;// right 右边所有的元素都是 >= target 的
            }
            // 这个循环重复, 肯定会把 right 指向一个最终位置, 这个位置的右边全都是 >= target 的, left 左边全都是 < target 的
            mid = left + (right - left) / 2;
        }
        return left;//target应该在的位置
    }
}
