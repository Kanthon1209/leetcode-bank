public class Solution {
    public static void main(String[] args){}

    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int mid = left + (right - left) / 2;
        while(left < right){
            if(nums[mid] > nums[right]){
                // 那说明最小值在右边区间
                left = mid + 1;
            }else{
                // 也就是 nums[mid] <= nums[right]
                // 那么, 最小值在 [left, mid]
                right = mid;
            }
            mid = left + (right - left) / 2;
        }
        return left;
    }
}
