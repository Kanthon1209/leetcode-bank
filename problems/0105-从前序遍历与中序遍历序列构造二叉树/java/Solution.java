import java.util.HashMap;

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

    HashMap<Integer, Integer> hashMap = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // pre 可以确定根节点
        // in 可以确定, 左半部分

        for (int i = 0; i < inorder.length; i++) {
            hashMap.put(inorder[i], i);
        }
        int preL = 0;
        int preR = preorder.length - 1;
        return build(preorder, preL, preR, inorder, preL, preR);
    }

    public TreeNode build(int[] preorder, int preL, int preR, int[] inorder, int inL, int inR){
        if(preL > preR){
            // 我们这种方法
            return null;
        }
        if(preL == preR){
            TreeNode node = new TreeNode(preorder[preL]);// 说明只有一个元素
            return node;
        }
        // 通过前序遍历和中序遍历数组构建对应的树, 最后是返回这两个数组对应的树的根节点
        int rootNum = preorder[preL];
        TreeNode root = new TreeNode(rootNum);
        int midIdx = hashMap.get(rootNum);// 为的是确定左右部分的范围, 找到 Idx 并不是元素
        int leftPartSize = midIdx - inL; // 当前区间的左半部分长度知道了

        root.left = build(preorder, preL + 1, preL + leftPartSize, inorder, inL, midIdx - 1);
        root.right = build(preorder, preL + leftPartSize + 1, preR, inorder, midIdx + 1, inR);
        return root;
    } 
}
