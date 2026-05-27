import java.util.List;
import java.util.HashSet;

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];// 用于存储
        HashSet<String> hashSet = new HashSet<>(wordDict);
        dp[0] = true;
        for(int i = 1; i <= s.length(); i++){
            for(int j = 0; j < i; j++){
                if(dp[j] == true && hashSet.contains(s.substring(j, i))){
                    dp[i] = true;
                }
            }
        }
        return dp[s.length()];
    }
}