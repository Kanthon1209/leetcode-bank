public class Solution {
    public static void main(String[] args) {

    }

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

    public ListNode swapPairs(ListNode head) {
        if (head == null)
            return null;
        if (head.next == null)
            return head;
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode ll = dummy;
        ListNode l = head;
        ListNode r = head.next;
        ListNode rr = head.next.next;
        while (l != null) {
            l.next = rr;
            ll.next = r;
            r.next = l;
            //
            ll = l;
            l = rr;
            if (l == null || l.next == null) {
                return dummy.next;
            } else {
                r = l.next;
                rr = r.next;
            }
        }
        return dummy.next;
    }
}
