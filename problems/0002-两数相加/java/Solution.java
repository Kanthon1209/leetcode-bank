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

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 麻烦的是, 可能两个位数不同
        int c = 0;
        ListNode dummy = new ListNode();
        ListNode tail = dummy;
        while (!(l1 == null && l2 == null)) {
            int a = l1 == null ? 0 : l1.val;
            int b = l2 == null ? 0 : l2.val;
            int sum = a + b + c;
            c = sum / 10;
            sum = sum % 10;
            tail.next = new ListNode(sum);
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
            tail = tail.next;
        }
        if(c != 0){ // 结果有可能比两个链表中最长的那一条还要长
            tail.next = new ListNode(c);
        }
        return dummy.next;
    }
}
