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

    public int kthSmallest(TreeNode root, int k) {
        this.k = k;
        inorder(root);
        return this.res;
    }

    int counter = 0;
    int res;
    int k;

    public void inorder(TreeNode node){
        if(node == null) return;
        inorder(node.left);
        this.counter++;
        if(this.counter == k){
            this.res = node.val;
        }
        inorder(node.right);
    }
}
