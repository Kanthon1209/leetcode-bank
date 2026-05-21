public class Solution {
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int mid = (left + right) / 2;// 只要有加法存在的地方就要考虑整数溢出问题
        while(left <= right){
            // 只要区间内有元素就应该继续判断
            if(nums[mid] < target){
                // 那么这个位置以及这个位置以前全都是 < target 的
                left = mid + 1;
            }else{
                // 这个位置以及这个位置以后都是 >= target 的
                right = mid - 1;
                // 如果 nums[mid] >= target, 就会执行, 也就是说, 如果刚好 = 也会执行, 那
            }
            mid = left + (left + right) / 2;//如果是奇数个, 那么会停在中央, 如果是偶数个, 那么会停在左半部分最后一个位置
        }
        // 循环结束后, [0, left) 全都是小于 target的, [left, ...) 全都是 >= target 的
        return left;
}
