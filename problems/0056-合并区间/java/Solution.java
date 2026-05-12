import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args){

    }

    public int[][] merge(int[][] intervals) {
        // 如果 (a, b) 中的 b, 大于 (c, d) 中的c, 那么 就要进行合并
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        int l = intervals[0][0];
        int r = intervals[0][1];
        List<int[]> res = new ArrayList<>();
        for(int i = 1; i < intervals.length; i++){ // 从第二个区间开始处理, 
            int cur_l = intervals[i][0];
            int cur_r = intervals[i][1];
            if(cur_l <= r){ // 注意, 每次写边界条件的时候一定要注意, < 和 <= 一定要严谨判断, 
            // 要不然, debug 的时候根本不知道从哪里下手

            // 这里为什么是 <=, 因为边界重合也是重合啊
                r = Math.max(cur_r, r);
            }else{
                // 说明没有重叠, 那么工作区间应该换掉了
                // 应该进行记录
                res.add(new int[]{l, r});
                l = cur_l; // 更新工作区间
                r = cur_r; 
            }
        }
        res.add(new int[]{l, r}); // 添加到 res 只发生在没有发生重叠的时候, 所以, 如果最后处理的连续区间
        // 一直重叠, 那么将不会触发存储

        // Java 泛型, 运行时候会进行 Type Erasure, 类型擦除, 泛型信息在运行时不存在

        // List 其实是集合, 要转换成数组, 可以用 toArray
        return res.toArray(int[][]::new);

        // 对于 String 这样的 普通 Java 类, String::new 确实是构造方法引用
        // 但是 int[][]::new 并不是 int[][] 的构造方法, 因为 int[][] 不是普通 Java 类, 是 JVM 内建数据类型
        // 数组类型 没有源码, 因为是原生支持的, 源码应该是 C/Cpp, 也就没有 Java 源码
        // int[][]::new 等价于 size -> new int[size][]
        // T[]::new 等价于 size -> new T[]
    }
}
