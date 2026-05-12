import java.util.Arrays;

public class Solution {
    public static void main(String[] args){

    }

    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        int[] tmp = Arrays.copyOfRange(nums, nums.length - k, nums.length);
        int[] backup = nums.clone();
        for(int i = k; i < nums.length; i++){
            nums[i] = backup[i - k];
        }
        for(int i = 0; i < k; i++){
            nums[i] = tmp[i];
        }
    }
}
