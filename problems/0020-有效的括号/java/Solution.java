import java.util.Deque;
import java.util.HashMap;
import java.util.ArrayDeque;

class Solution {
    public boolean isValid(String s) {
        Deque<Character> queue = new ArrayDeque<>();
        HashMap<Character, Character> hashMap = new HashMap<>();
        hashMap.put('}', '{');
        hashMap.put(']', '[');
        hashMap.put(')', '(');
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '['){
                queue.offerLast(s.charAt(i));
            }else{
                // 那就肯定是右括号了
                if(queue.isEmpty()){
                    return false;
                }
                char c = queue.peekLast();
                if(hashMap.get(s.charAt(i)) != c){
                    return false;
                }else{
                    // 说明取出来的括号是匹配的
                    // 那么就弹出来
                    queue.pollLast();
                }
            }
        }
        if(queue.isEmpty()){
            return true;
        }else{
            return false;
        }
    }
}