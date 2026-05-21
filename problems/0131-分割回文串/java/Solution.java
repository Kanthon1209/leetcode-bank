import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<List<String>> partition(String s) {
        backtrack(s, 0, new ArrayList<>());
        return this.res;
    }

    List<List<String>> res = new ArrayList<>();

    public void backtrack(String s, int start, List<String> path){
        if(start == s.length()){
            // 说明处理到头了
            this.res.add(path);
            return;
        }
        for(int i = start; i < s.length(); i++){
            // 先明确一下, 这个 i 指的是什么, 这个 i 是闭合区区间终止位置, 并不是长度
            if(isPalindrome(s, start, i)){
                // 如果
                path.add(s.substring(start, i + 1));
                backtrack(s, i + 1, path);//
                path.removeLast();
            }
        }
    }

    public boolean isPalindrome(String s, int start, int end) {
        while(start < end){
            if(s.charAt(start) != s.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
