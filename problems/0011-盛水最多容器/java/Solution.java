public class Solution {
    public static void main(String[] args){

    }

    public static int maxArea(int[] height){
        int i = 0;
        int j = height.length - 1;
        int max = 0;
        while(i != j){
            int size = (j - i) * Math.min(height[i], height[j]);
            if (size > max){
                max = size;
            }
            if(height[i] < height[j]){
                i += 1;
            }else{
                j -= 1;
            }
        }
        return max;
    }
}