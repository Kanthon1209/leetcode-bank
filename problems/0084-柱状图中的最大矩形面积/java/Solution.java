import java.util.Deque;
import java.util.ArrayDeque;

public class Solution{
    public int largestRectangleArea(int[] heights) {
        // 一个柱子能够构成的最大面积取决于左右第一个更小元素的位置差
        // 找左边第一个最小元素
        int[] leftLess = new int[heights.length];
        Deque<Integer> leftStack = new ArrayDeque<>();
        for(int i = heights.length - 1; i >= 0; i--){// 注意最后一个元素的下标是 heights.length - 1
            while(!leftStack.isEmpty() && heights[leftStack.peekLast()] > heights[i]){
                int idx = leftStack.pollLast();
                leftLess[idx] = i;
            }
            leftStack.offerLast(i);
        }
        while(!leftStack.isEmpty()){// 剩下的元素, 左边没有找到更小的, 那么更小元素下标设置为 左边界, 也就是 -1
            leftLess[leftStack.pollLast()] = -1;
        }

        // 这样找的是右边的最小的元素
        int[] rightLess = new int[heights.length];
        Deque<Integer> rightStack = new ArrayDeque<>();
        for(int i = 0; i < heights.length; i++){
            while(!rightStack.isEmpty() && heights[rightStack.peekLast()] > heights[i]){
                // 不空的时候才能 peekLast, 栈中存放的是下标
                // 如果当前的元素小于栈中存放的下标对应的元素, 那么说明是该元素右边第一个小元素
                int idx = rightStack.pollLast();
                rightLess[idx] = i;// 下一个比自己小的元素下标是?
            }
            rightStack.offerLast(i); // 把本元素下标填入到栈中
        }
        // 最后栈中是一些没有找到下一个更小元素的元素对应下标
        while(!rightStack.isEmpty()){
            rightLess[rightStack.pollLast()] = heights.length;
        }
        // 没有找到更小元素, 那么右边都能取, 所以设置为边界右边一个
        // 也就是将下标设置为 length;


        // 然后就是遍历这个leftless 数组和 rightless 数组
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < heights.length; i++){
            int tmp = heights[i] * (rightLess[i] - leftLess[i] - 1);
            if(tmp > max){
                max = tmp;
            }
        }
        return max;
    }
}