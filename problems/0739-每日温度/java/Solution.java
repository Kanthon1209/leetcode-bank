import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        if(temperatures == null) return new int[0];
        Deque<Integer> stack = new ArrayDeque<>();
        int[] res = new int[temperatures.length];
        for(int i = 0; i < temperatures.length; i++){
            while(!stack.isEmpty() && temperatures[stack.peekLast()] < temperatures[i]){
                int prevIdx = stack.pollLast();
                res[prevIdx] = i - prevIdx;
            }
            // 把当前的放到队列
            stack.offerLast(i);
        }
        while(!stack.isEmpty()){
            res[stack.pollLast()] = 0;
        }
        return res;
    }
}