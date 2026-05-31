import java.util.Map;
import java.util.Comparator;
import java.util.HashMap;

public class Solution {
    public static void main(String[] args){}

    public int majorityElement(int[] nums) {
        // 首先想到的想法是最大根堆
        // PriorityQueue<Map.Entry<Integer, Integer>> maxHeap = new PriorityQueue<>(Comparator.comparingInt(Map.Entry<Integer, Integer>::getValue).reversed());
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for(var num : nums){
            hashMap.merge(num, 1, Integer::sum);
        }
        return hashMap.entrySet().stream().max(Comparator.comparingInt(Map.Entry::getValue)).get().getKey();
    }

    public int majorityElementOPT(int[] nums){
        int currNum = nums[0];
        int count = 0;
        for(var num : nums){
            if(count == 0){
                currNum = num;
            }
            if(num == currNum){
                count++;
            }else{
                count--;
            }
        }
        return currNum;
    }
}
