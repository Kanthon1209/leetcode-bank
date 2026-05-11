
public class Solution {
    public static void main(String[] args){

    }

    public String minWindow(String s, String t) {
        int[] window = new int[128];
        int[] need = new int[128]; // 全都是 0, Java 创建数组是这样的, 这个数组, 我们打算用来记录为了达到目标, 我们的滑动窗口内的需求情况
        
        for(int i = 0; i < t.length(); i++){
            need[t.charAt(i)]++; // Java 中 char 是可以当作数组下标使用的, 本质上是一个 unsigned 2B 整数
        }

        int required = 0;
        for(int i = 0; i < need.length; i++){
            if(need[i] > 0){
                required++;
            }
        }
        int valid = 0;
        int l = 0;
        int r = 0;

        int min_len = Integer.MAX_VALUE;
        String min_str = new String();
        while(r < s.length()){
            window[s.charAt(r)]++; // 右指针当前位置元素, window 对应位置 ++
            if(window[s.charAt(r)] == need[s.charAt(r)]){ //  如果窗口内的某一个字符达到和 need 相等这个条件了
                // 一定要用 == 我们只要一次就行, 我们逮住某一个字符达到要求的临界点, 记录一下

                // 如果右指针移动的结果使得 window 内的字符满足了目标字符串的要求, 那么
                // 那么该字符也就达到条件了
                valid++;
            }
            while(valid == required){ // 我们要持续这个过程直到 valid 与 required 不等
                // 如果达到条件的字符数量达到了需要的字符数量, 那么这个窗口刚好达到了条件, 我们需要记录窗口长度, 并开始将左指针向右移动
                if (r - l + 1< min_len){ // 如果小于最小窗口我们再记录, 否则不进行记录
                    // 0, 1, 2, 3 长度是 4, 应该是 r - l + 1 才是窗口长度
                    min_len = r - l + 1;
                    min_str = s.substring(l, r + 1);// 截取子串的时候也是, 也是左闭右开
                }
                // 移动左指针 l, 直到窗口中的元素刚好不满足目标
                if(window[s.charAt(l)] == need[s.charAt(l)]){// 如果出现了 "窗口内某一个字符数量达不到目标字符串要求的数量"
                    // 应该也是 == , 因为这里判断过后, 我们就要移动左指针到下一个位置, 那时候就是不满足的状态了
                    // 那么重新进入右指针往右的过程
                    valid--;
                }
                window[s.charAt(l)]--; // 不应该先删除, 万一刚好 window['A'] == 2 == need['A'] == 2
                l++;
            }
            r++;
        }
        return min_str;
    }
}
