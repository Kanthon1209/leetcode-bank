class Solution {
    public int longestValidParentheses(String s) {
        if(s == null) return 0;
        if(s.length() == 0 || s.length() == 1) return 0;
        int max = Integer.MIN_VALUE;
        int[] dp = new int[s.length()];// 初始化全都是 0
        for(int i = 1; i < s.length(); i++){
            // dp[1] 肯定是0, 不管是( / )
            switch(s.charAt(i)){
                case '(':
                    // 直接不合法, 没有后文了, 设置为 0
                    dp[i] = 0;
                    break;
                case ')':
                    // 看前一个
                    switch(s.charAt(i - 1)){
                        case '(':
                            // 前一个位置是(, 刚好和自己构成一对括号
                            if(i >= 2){
                                // 如果之前还有元素, 那么
                                dp[i] = dp[i - 2] + 2;
                            }else{
                                dp[i] = 2;
                            }
                            break;
                        case ')':
                            // 如果前一个是), 那么看看
                            if(i - dp[i - 1] - 1 >= 0){
                                // 如果前面那个位置不越界再说
                                switch(s.charAt(i - dp[i - 1] - 1)){
                                    case '(':
                                        // 还要进行越界判断
                                        if(i - dp[i - 1] - 2 >= 0){
                                            dp[i] = dp[i - 1] + 2 + dp[i - dp[i - 1] - 2];
                                        }else{
                                            // 前面的位置前一个元素如果又越界了
                                            dp[i] = dp[i - 1] + 2;
                                        }
                                        break;
                                    case ')':
                                        dp[i] = 0;
                                        break;
                                }
                            }else{
                                // 前面那个位置越界了, 没有机会合法了捏
                                dp[i] = 0;
                            }
                            break;
                    }
                    break;
            }
            max = Math.max(dp[i], max);
        }
        return max;
        //case 末尾写个 break
    }
}