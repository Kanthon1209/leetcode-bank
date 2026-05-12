import java.util.Deque;
import java.util.ArrayDeque;

public class Solution {
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static void main(String[] args) {

    }

    public ListNode reverseList(ListNode head) {
        Deque<ListNode> deque = new ArrayDeque<>();
        while(head != null){
            deque.offerLast(head);
        }
        ListNode res = deque.pollFirst();
        ListNode p = res;
        while(!deque.isEmpty()){
            p.next = deque.pollFirst();
            p = p.next;
        }
        return res;
    }

    public ListNode reverseListV1(ListNode head) {
        if(head == null) return head;
        if(head.next == null) return head;
        ListNode prev = head;
        ListNode curr = head.next;
        ListNode next = curr.next;
        while(curr != null){
            curr.next = prev;
            prev = curr;
            curr = next;
            if(next != null){
                next = next.next;
            }
        }
        head.next = null;
        return prev;
    }
}
