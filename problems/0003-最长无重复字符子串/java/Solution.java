import java.util.HashMap;

// * java 的数组 length 是属性, 因为 数组是 Java JVM 支持的原生数据类型, 或者可以叫内建数据类型
// * java 数组创建的时候就已经指定好了容量, 所以 length 不需要计算, 创建的时候就已经设置好了
// * java 的 String length 是方法, String 并不是 JVM 内建类型
// Java 中 String 实际上是封装了 byte 数组, String 并不是 Java 内建类型

// 如果是对象能力, 那么用方法, 如果是对象结构, 那么用字段 / 属性

public class Solution {
    public static void main(String[] args){
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }

    public static int lengthOfLongestSubstring(String s) {
        if(s == null){ // 注意 null 和 空字符串 之间的区别
            // null 是压根没有
            // 空字符串是存在的, 只不过内容是空的
            // null 不能调用 length(), 但是空字符串可以调用 length()
            return 0;
        }
        int n = s.length();// 字符串的长度是方法, 不像数组那样是属性
        if(n <= 1){
            return n;
        }
        int max_len = 0;

        HashMap<Character, Integer> lastSeen = new HashMap<>();
        int l = 0;
        lastSeen.put(s.charAt(l), l); // 初始化

        for(int r = 1; r < n; r++){
            if(lastSeen.containsKey(s.charAt(r))){
                // 如果右指针新进元素 last_seen 位置在滑动窗口内
                // 那么需要更新左指针
                int last_idx = lastSeen.get(s.charAt(r));
                if(last_idx >= l){
                    l = last_idx + 1;
                }
                // 更新过后将 last_seen 覆盖掉
                lastSeen.replace(s.charAt(r), r);
            }else{
                // 新进元素不在
                lastSeen.put(s.charAt(r), r);
                // putIfAbsent 的作用是在 key -> value 不存在的时候 put, 并将旧 value 返回, 但是
                // HashMap::get 返回的null 可能是 value, 也有可能是 key -> value 压根就是不存在
            }
            // 右指针肯定会更新的, 左指针可能会更新
            int len = r - l + 1;
            if (len > max_len){
                max_len = len;
            }
        }
        return max_len;
    }
}
