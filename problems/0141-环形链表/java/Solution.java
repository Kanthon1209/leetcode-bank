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

    // 相对速度是 1, 只要 fast 比 slow 多跑一圈就可以相遇了
    public boolean hasCycleOptimal(ListNode head) {
        // 最优方法不用 HashSet, 不用额外空间辅助
        if(head == null) return false;
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                return true;
            }
        }
        return false;
    }
}
