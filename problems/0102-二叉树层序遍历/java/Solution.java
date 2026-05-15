import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Queue;
import java.util.List;
import java.util.LinkedList;

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

    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        int size = queue.size();
        List<List<Integer>> resList = new LinkedList<>();
        while(!queue.isEmpty()){
            List<Integer> list = new LinkedList<>();
            for(int i = 0; i < size; i++){
                TreeNode node = queue.poll();
                list.add(node.val);
                if(node.left != null){
                    queue.offer(node.left);
                }
                if(node.right != null){
                    queue.offer(node.right);
                }
            }
            resList.add(list);
        }
        return resList;
    }
}