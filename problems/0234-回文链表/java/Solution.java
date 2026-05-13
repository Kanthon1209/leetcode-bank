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

    public boolean isPalindrome(ListNode head) {
        ListNode p = head;
        int length = 0;
        while(p != null){
            length++;
            p = p.next;
        }
        int count = 0;
        p = head;
        while(p != null){
            count++;
            p = p.next;
            if(count == (length + 1 )/ 2){
                break;
            }
        }
        ListNode a = head;
        ListNode b = p;
        while(a != null){
            if(a.val == b.val){
                a = a.next;
                b = b.next;
            }else{
                return false;
            }
        }
        return true;
    }
}
