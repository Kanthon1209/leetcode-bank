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

    int maxPathSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        //
        dfs(root);
        return maxPathSum;
    }

    public int dfs(TreeNode node) {
        // 首先明确, 这个函数返回的是什么, 应该是单链最大可能值, 为的是给上层使用
        // 上层要判断左右子树返回的答案 加当前的 节点可能的最大值是多少, 左右如果有负数, 那么就不要了
        // 负数是怎么出现的呢, 是节点当前的值加上两边(非负)后还小于 0 导致的
        if (node == null)
            return 0;
        int leftVal = Math.max(0, dfs(node.left));
        int rightVal = Math.max(0, dfs(node.right));
        if (node.val + leftVal + rightVal > this.maxPathSum) {
            this.maxPathSum = node.val + leftVal + rightVal; // 更新最大值
            // 左右只可能增益, 但是本节点不知道
        }
        // 如果当前节点
        return node.val + Math.max(leftVal, rightVal); // 返回当前节点加两条单链路中增益最大的那条路, 必须把当前 node.val 加上, 想要吃到子链路的加成就必须走当前节点
    }
    // 和 0427 相比, 该问题关键点在于, 不要求路径是单向的(只能自上往下这种), 也就是说, 一个根节点可以
}
