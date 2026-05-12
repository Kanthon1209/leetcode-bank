import java.util.HashSet;

public class Solution {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        HashSet<ListNode> hashSet = new HashSet<>();
        while(headA != null){
            hashSet.add(headA);
            headA = headA.next;
        }
        while(headB != null){
            if(hashSet.contains(headB)){ // 
                return headB;
            }else{
                headB = headB.next;
            }
        }
        return null;
    }
}
