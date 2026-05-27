import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;

public class Solution {
    public static void main(String[] args){}

    public List<Integer> partitionLabels(String s) {
        int[] mapper = new int[26];
        for(int i = 0; i < s.length(); i++){
            mapper[s.charAt(i) - 'a'] = i;
        }
        int idx = 0;
        int upBound = mapper[s.charAt(0) - 'a'];
        List<Integer> res = new ArrayList<>();
        while(idx < s.length()){
            int sectionLength = 0;
            upBound = mapper[s.charAt(idx) - 'a'];// 进入区间开始先获取当前区间上限
            while(idx <= upBound){
                // 当前指针小于区间上界的时候
                // 看下当前指针指向的字母对应的上界是多少, 有没有突破当前区间上界
                int lastIdx = mapper[s.charAt(idx) - 'a'];
                if(lastIdx > upBound){// 有没有突破当前区间上界
                    // 如果当前的字母最后一次出现位置, 大于当前的upBound, 那么更新 upBound
                    upBound = lastIdx;// 如果突破了当前区间上界, 那么更新区间上界
                }
                sectionLength++;// 当前元素是被纳入区间的, 区间长度++
                idx++;// 指针指向下一个元素, 准备处理下一个元素
            }
            // 当前区间处理完毕了, 那么就把当前的区间长度放到返回数组中
            res.add(sectionLength);
        }
        return res;
    }
}
