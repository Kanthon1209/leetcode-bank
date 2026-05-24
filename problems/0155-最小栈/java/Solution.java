import java.util.Deque;
import java.util.ArrayDeque;

class MinStack {

    // 关键是, 加入的时候要判断是不是最小的元素, 并喜欢最小元素
    // pop 出去的时候要知道
    private Deque<Integer> stack = new ArrayDeque<>();
    private Deque<Integer> minStack = new ArrayDeque<>();
    public MinStack() {

    }
    
    public void push(int val) {
        if(this.minStack.isEmpty()){
            this.minStack.offerLast(val);
        }else if(val < this.minStack.peekLast()){
            // 如果 val 比最小值还要小, 那么放进去
            this.minStack.offerLast(val);
        }else{
            // 否则复制一个最小值放进去
            this.minStack.offerLast(this.minStack.peekLast());// 如果本来啥都没有就 peek 怎么办
        }
        this.stack.offerLast(val);
    }
    
    public void pop() {
        this.stack.pollLast();
        this.minStack.pollLast();
    }
    
    public int top() {
        return this.stack.peekLast();
    }
    
    public int getMin() {
        return this.minStack.peekLast();
    }
}