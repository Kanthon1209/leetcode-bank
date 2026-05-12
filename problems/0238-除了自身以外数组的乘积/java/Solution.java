public class Solution {
    public static void main(String[] args){

    }

    public int[] productExceptSelf(int[] nums) {
        int[] prefix = new int[nums.length]; // 用来记录 0 ~ i 的乘积
        int[] suffix = new int[nums.length]; // 用来记录 0 ~ i 的乘积
        int tmp = 1;
        prefix[0] = 1;
        suffix[nums.length - 1] = 1;
        for(int i = 1; i < nums.length; i++){
            // prefix[i] 表示的是该位置前所有元素乘积, 不包含该位置元素
            // prefix[0] 应该是1, prefix
            tmp *= nums[i - 1];
            prefix[i] = tmp;
        }
        tmp = 1;
        for(int i = nums.length - 2; i >= 0; i--){
            tmp *= nums[i + 1];
            suffix[i] = tmp;
        }
        int[] res = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            res[i] = prefix[i] * suffix[i];
        }
        return res;
    }
}
