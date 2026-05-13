import java.util.HashSet;

public class Solution {
    public static void main(String[] args) {

    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public boolean hasCycle(ListNode head) {
        HashSet<ListNode> hashSet = new HashSet<>();
        while (head != null) {
            if (!hashSet.contains(head)) {
                hashSet.add(head); // 因为我们的节点没有重写 equals 方法, 所以 equals 方法比较的就是两个对象的地址
                head = head.next;
            } else {
                return true;
            }
        }
        return false;
    }
}
