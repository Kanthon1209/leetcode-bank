import java.util.PriorityQueue;
import java.util.concurrent.ThreadLocalRandom;

public class Solution {
    // 1. 排序
    // 2. 维护一个大小为 k 的最小堆, 如果当前元素大于堆顶元素, 那么就替换掉, 然后修复最小堆(所有非叶子节点递归调整一遍)
    // 3. quickSelect, 选中一个元素, 遍历一遍, 如果比该元素大, 那么放到该元素的左边, 否则, 放到该元素的右边(如果该元素坐标
    // 比 pivot 坐标小, 那么就交换, 相当于放到右边了, 否则不换, 相当于放在左边)

    // Java 中的最小堆: PriorityQueue, 默认是最小堆

    public int findKthLargest(int[] nums, int k) {
        int target = k - 1;

        int left = 0;
        int right = nums.length - 1;

        while(true){
            int pivotIdx = partition(nums, left, right);// 用区间右边界元素作为 pivot 进行划分, 返回 pivot 下标
            if(pivotIdx == target){
                return nums[target]; // 
            }
            if(pivotIdx > target){
                right = pivotIdx - 1;
            }else{
                left = pivotIdx + 1;
            }
        }
    }

    public int partition(int nums[], int left, int right){
        // 首先明确这个函数的作用:
            // 区间最右的元素设置为 pivot, 将该区间变成 < pivot 的, == pivot 的, > pivot 的
        int randIdx = ThreadLocalRandom.current().nextInt(left, right + 1);// pivot 是一个值
        int pivot = nums[randIdx];
        int slow = left;
        swap(nums, randIdx, right);// 换一下位置, 换到 right 指向的位置
        for(int i = left; i < right; i++){
            if(nums[i] > pivot){
                // 如果大于pivot, 那么就把这个数字换到预留的空格
                swap(nums, i, slow);
                slow++;
            }
        }
        // 最后把 slow 和 指向 pivot 的换一下, 也就是 right 
        swap(nums, slow, right);
        // 这样换过之后, slow 左边的全都是 大于 pivot 的
        return slow;
    }

    public void swap(int[] nums, int first, int second){
        // 交换数组中的两个元素
        int tmp = nums[first];
        nums[first] = nums[second];
        nums[second] = tmp;
    }
}
