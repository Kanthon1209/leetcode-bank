// 时间复杂度: o(n)
// 空间复杂度: 注意空间复杂度指的是算法运行过程中额外使用的内存空间的峰值: o(n)
public class Solution {
    public static void main(String[] args){

    }

    public int trap(int[] height) {
        int n = height.length;
        int[] lMax = new int[n]; // Java 创建数组的时候必须要指定数组的容量, 数组本质上是一片连续的内存空间, 创建的时候都是 0, 如果是 int 数组的话
        int[] rMax = new int[n];
        int l_top = 0;
        int r_top = 0;
        // 从左往右遍历, 记录每一个位置左边最大的值
        for(int i = 0; i < n; i++){
            lMax[i] = l_top;
            if (height[i] > l_top){
                l_top = height[i];
            }
        }
        // 从右往左遍历, 记录每一个位置右边最大的值
        for(int i = n - 1; i >= 0; i--){
            rMax[i] = r_top;// 当前位置的高度不会影响左右最大高度, 第一个记录的侧边最大值就是0, 确实边上也不能容水
            if(height[i] > r_top){
                r_top = height[i];
            }
        }
        int sum = 0;
        for(int i = 0; i < n; i++){
            int dif = Math.min(lMax[i], rMax[i]) - height[i]; 
            if (dif > 0){
                sum += dif;
            }
        }
        return sum;
    }
}
