public class Solution {
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

    public static void main(String[] args) {

    }

    public boolean isValidBST(TreeNode root) {
        inorder(root);
        return this.flag;
    }

    long current = Long.MIN_VALUE;// 这里, 如果节点就最小值, 那就
    boolean flag = true;

    public void inorder(TreeNode node) {
        if (node == null)
            return;
        inorder(node.left);
        if (node.val <= this.current) {
            this.flag = false;
        }
        inorder(node.right);
    }
}
