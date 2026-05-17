public class Solution {
    public static void main(String[] args) {

    }

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
        dfs(root, targetSum);
        return this.count;
    }

    int count = 0;

    public void dfs(TreeNode node, int target){
        if(node == null) return;
        preOrder(node, target);
        dfs(node.left, target);
        dfs(node.right, target);
    }

    public void preOrder(TreeNode node, int remain){
        if(node == null) return;
        if(node.val == remain){
            // 如果当前节点 val 恰好和需要的相等, 那么就 count++
            this.count++;
        }
        // 如果满足条件了, 也应该继续往下, 因为后面还是有可能符合要求的
        preOrder(node.left, remain - node.val);
        preOrder(node.right, remain - node.val);
    }
}
