import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Map;

public class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        // 放的是元素 -> 频次, 访问的时候去最小根堆中看一下
        PriorityQueue<Map.Entry<Integer, Integer>> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(Map.Entry::getValue));
        for(var item : nums){
            hashMap.merge(item, 1, Integer::sum);// 如果没有 k-v, 那么默认值是 k-1, 如果有, 那么就调用函数把旧值和1输入这个函数计算新的值
        }
        for(var entry : hashMap.entrySet()){
            priorityQueue.offer(entry);
            if(priorityQueue.size() > k){
                priorityQueue.poll();// 弹出堆顶最小的
            }
        }
        int[] res = new int[priorityQueue.size()];
        int idx = 0;
        // 注意啊! PriorityQueue 的迭代器返回元素的时候不会按照排序返回
        // 如果想要按照排序返回, 应该用 poll
        while(!priorityQueue.isEmpty()){
            res[idx++] = priorityQueue.poll().getKey();
        }
        return res;
    }
}
