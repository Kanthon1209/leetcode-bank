public class Solution {
    public static void main(String[] args) {
    }

    public int maxProfit(int[] prices) {
        int min = prices[0];
        int maxProfit = Integer.MIN_VALUE;
        for(int i = 0; i < prices.length; i++){
            if(prices[i] < min){
                min = prices[i]; 
            }
            if(prices[i] - min > maxProfit){
                maxProfit = prices[i] - min;
            }
        }
        return maxProfit;
    }
}
