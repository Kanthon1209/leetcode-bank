import java.util.HashMap;

public class Solution2 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public int pathSum(TreeNode root, int targetSum) {
        this.target = targetSum;
        hashMap.put(0, 1);
        dfs(root);
        return this.counter;
    }

    int currentSum = 0;
    int target = 0;
    int counter = 0;
    HashMap<Integer, Integer> hashMap = new HashMap<>();


    public void dfs(TreeNode node) {
        if (node == null)
            return;
        this.currentSum += node.val; // 目前的路径和

        // 先查询, 看看 HashMap 中有没有符合要求的结果
        if(this.hashMap.containsKey(this.currentSum - this.target)){
            // 如果 HashMap 中有对应的 Key, 统计了数量的
            this.counter += this.hashMap.get(this.currentSum - this.target);// 把数量加上
        }

        // 
        if (this.hashMap.containsKey(this.currentSum)) {
            hashMap.put(this.currentSum, hashMap.get(this.currentSum) + 1);
        } else {
            this.hashMap.put(this.currentSum, 1);// 表示有几个前缀和
        }

        dfs(node.left);
        dfs(node.right);
        hashMap.put(this.currentSum, hashMap.get(this.currentSum) - 1);// 把对应的 - 1
        this.currentSum -= node.val;
        // 删除的时候也要把这个节点相关的删除掉
    }
}
