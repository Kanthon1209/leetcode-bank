import java.lang.StringBuilder;
import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    public static void main(String[] args) {
    }

    // 成员变量的问题是, 重复调用可能会有状态残留
    StringBuilder curr = new StringBuilder("");
    int currNum = 0;
    Deque<StringBuilder> strStack = new ArrayDeque<>();
    Deque<Integer> intStack = new ArrayDeque<>();

    public String decodeString(String s) {
        for(char c : s.toCharArray()){
            if(Character.isDigit(c)){
                // 如果是数字
                this.currNum = this.currNum * 10 + (c - '0');
            }else if(c == '['){
                this.strStack.offerLast(this.curr);
                this.intStack.offerLast(this.currNum);
                this.curr = new StringBuilder("");
                this.currNum = 0;
            }else if(c == ']'){
                //
                StringBuilder prev = this.strStack.pollLast();
                prev.repeat(this.curr.toString(), this.intStack.pollLast());
                this.curr = prev;
            }else{
                this.curr.append(c);
            }
        }
        return this.curr.toString();
    }
}