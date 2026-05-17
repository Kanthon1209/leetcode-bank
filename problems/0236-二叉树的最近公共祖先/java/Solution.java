public class Solution {
    public static void main(String[] args) {

    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return dfs(root, p, q);
    }

    public TreeNode dfs(TreeNode node, TreeNode p, TreeNode q){
        if(node == null) return null;
        if(node == p || node == q){
            return node;
        }
        // 说明当前节点不是 空, 并且, 当前节点也不是目标节点
        // 那么就看左右子树了
        TreeNode left = dfs(node.left, p, q);
        TreeNode right = dfs(node.right, p, q);
        if(left != null && right != null){
            // 左右子树都有返回结果, 那就说明左右一边一个咯, 那当前节点就是共同祖先节点
            return node;
        }
        return left != null ? left : right;// 能走到这里, 说明, left, right 至少一个是 null
        // 那么就返回这个非空的节点, 表明, 我们这个子树从两个中找只找到这个节点
        // 如果两个都找到了, 那就返回的是共同祖先节点了, 这个就是正确答案了, 会逐层向上传导
    }
}
