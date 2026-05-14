import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

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

    public ListNode sortListNoneOptimal(ListNode head) {
        // 直接转成 list 呗, 然后
        List<ListNode> list = new ArrayList<>();
        while(head != null){
            list.add(head);
            head = head.next;
        }
        list.sort(Comparator.comparingInt(t -> t.val));
        ListNode dummy = new ListNode();
        ListNode curr = dummy;
        for(int i = 0; i < list.size(); i++){
            curr.next = list.get(i);
            curr = curr.next;
        }
        curr.next = null;
        return dummy.next;
    }

    public ListNode sortList(ListNode head){
        // 标准的做法: 归并排序
        if(head == null) return null;
        if(head.next == null) return head;
        // 先进行二分, 将链表拆成左右两个部分, 然后用合并, 其实就是归并排序咯
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){// 虽然 fast.next 不能是 null, 但是 fast.next.next 可能是 null
            slow = slow.next;
            fast = fast.next.next;// 这里 fast 被设置为 null 下一次就不会进循环了
        }
        // 这样我们就将 slow 放到了 length / 2 位置上, fast 放到了最后一个元素(奇数的时候) / 倒数第二个元素 (偶数数量元素的时候)

        // 分开两个部分
        ListNode right = slow.next;// 一定要用 slow.next, 因为 right 可能和 head 重合
        slow.next = null; // 断开
        ListNode left = head;

        sortList(left);
        sortList(right);
        return merge(left, right);
    }

    public ListNode merge(ListNode l1, ListNode l2){
        ListNode dummy = new ListNode();
        ListNode curr = dummy;
        while(l1 != null && l2 != null){ // 如果两个链表都不是空的
            if(l1.val < l2.val){
                curr.next = l1;
                l1 = l1.next;
            }else{
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }
        if(l1 != null){
            curr.next = l1;
        }
        if(l2 != null){
            curr.next = l2;
        }
        return dummy.next;
    }
}
