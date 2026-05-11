import java.util.Deque;
import java.util.ArrayDeque;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args){
        int[] arr = new int[]{1,-1};
        maxSlidingWindow(arr, 1);
        Arrays.stream(maxSlidingWindow(arr, 1)).forEach(System.out::println);
    }   
    
    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null){// 空
            return null;
        }
        if (nums.length == 0){// 空数组
            return null;
        }
        if (nums.length <= k){
            int max = nums[0];
            for(int i = 0; i < nums.length; i++){
                if(nums[i] > max){
                    max = nums[i];
                }
            }
            return new int[]{max};
        }
        // 滑动窗口可以初始化
        Deque<Integer> dq = new ArrayDeque<>();// deque 中不是放具体的元素, 而是放元素的下标, 这样就能避免
        dq.push(0);
        for(int i = 1; i < k; i++){// 初始化
            while(!dq.isEmpty() && nums[dq.peekLast()] < nums[i]){ // 非空且最后一个元素小于当前元素的时候, 将他们全都移除, 他们没有机会再成为最大的了
                // 因为在当前元素滚蛋之前, 他们就会先滚蛋, 没有机会, 但是如果当前元素小于队列中的, 那么有机会, 等前面的滚蛋了, 还有机会
                dq.pollLast();
            }
            dq.offerLast(i);
        }

        // dq 初始化完毕了, 可以滑动窗口了
        int l = 0;
        int r = k; // 右指针已经指向窗口外的第一个元素了
        // 如果滑动窗口大小是 1, 那么总共有 nums.length 个窗口
        int[] res = new int[nums.length + 1 - k];
        while(r < nums.length){// 隐含了 l < nums.length
            res[l] = nums[dq.getFirst()];// 当前窗口的最大值就是顶部的元素咯, 但是不要弹出来, 因为可能不在边界
            // dq.remove(l); // 从队列中移除边界元素, 当然, 这个边界元素可能会被右边大元素挤掉, 但是这里不应该用这种方式删除, 这样删除是要遍历 deque 的
            if(dq.peekFirst() <= l){
                dq.pollFirst();
            }
            // 不能这样移除, 因为
            // 这里是新进元素了
            while(!dq.isEmpty() && nums[dq.peekLast()] < nums[r]){ // 非空且最后一个元素小于当前元素的时候, 将他们全都移除, 他们没有机会再成为最大的了
                // peekLast 是安全的, 不会抛出异常, 我们已经用短路与了, 只有非空的时候才会进行后续的操作, 这里用 peekLast 更加合适
                // 因为在当前元素滚蛋之前, 他们就会先滚蛋, 没有机会, 但是如果当前元素小于队列中的, 那么有机会, 等前面的滚蛋了, 还有机会
                // dq.removeLast(); // 相同的, 确认是非空的了, 那么 pollLast 是比较合适的
                dq.pollLast(); // Retrieves and removes the last element of this deque, or returns null if this deque is empty.
            }
            // 与 add 对应的安全操作是 offer / offerLast, 有
            dq.offerLast(r); // 一定会加入吗? 一定会加入, 左边删除的时候一定会保证删除的是边界元素
            r++;
            l++;
        }
        // 最后一个窗口要处理
        res[l] = nums[dq.peekFirst()];

        return res;
    }
}
