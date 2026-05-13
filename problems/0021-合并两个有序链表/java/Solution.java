public class Solution {
    public static void main(String[] args){

    }

    public class ListNode{
        int val;
        ListNode next;

        public ListNode(){};
        public ListNode(int val){
            this.val = val;
            this.next = null;
        }
        public ListNode(int val, ListNode next){
            this.val = val;
            this.next = next;
        }
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode();
        ListNode head = dummy;
        while(list1 != null && list2 != null){
            if(list1.val < list2.val){
                head.next = new ListNode(list1.val);
                list1 = list1.next;
            }else{
                head.next = new ListNode(list2.val);
                list2 = list2.next;
            }
            head = head.next;
        }
        while(list1 != null){
            head.next = new ListNode(list1.val);
            head = head.next;
            list1 = list1.next;
        }
        while(list2 != null){
            head.next = new ListNode(list2.val);
            head = head.next;
            list2 = list2.next;
        }
        return dummy.next;
    }

public ListNode mergeTwoListsOptimal(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode();
        ListNode tail = dummy; // 因为我们是往尾部不断加元素, 所以用 tail 指针表示结尾节点
        while(list1 != null && list2 != null){
            if(list1.val < list2.val){
                tail.next = new ListNode(list1.val);
                list1 = list1.next;
            }else{
                tail.next = new ListNode(list2.val);
                list2 = list2.next;
            }
            tail = tail.next;
        }
        tail.next = list1 == null ? list2 : list1;
        return dummy.next;
    }
}
