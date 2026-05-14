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

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0)
            return null; // 短路或, lists == null 的时候就不会判断后面的了
        return divide(lists, 0, lists.length - 1); // 分开后对左右两边进行同样的处理, 直到划分成为只有一个链表的时候左右进行合并成为一个
    }

    public ListNode divide(ListNode[] lists, int l, int r) {
        // 区间是左闭右闭的
        if (l == r) {
            return lists[l]; // 如果只有一个区间内就一个链表元素, 那么就达到切分最终目的了, 可以返回等待合并了
        }
        // 否则, 说明超过更多元素, 那么继续拆分
        int mid = (l + r) / 2;

        // 返回的应该是什么?
        ListNode left = divide(lists, l, mid); // 左半部分合并成的一个链表
        ListNode right = divide(lists, mid + 1, r); // 右半部分合并成为的一个链表
        return merge(left, right); // 这里, 只有在前面拿到单个链表之后才会走到, 才会对那两个链表
        //
    }

    public ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
        ListNode head = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                head.next = l1;// 注意是将节点赋值, 不是将 node.val 赋值, 要不然要不断新建节点, 再说, 我们要用原来的节点, 不是新建节点
                l1 = l1.next;
            } else {
                head.next = l2;
                l2 = l2.next;
            }
            head = head.next;
        }
        if (l1 != null) {
            head.next = l1;
        }
        if (l2 != null) {
            head.next = l2;
        }
        return dummy.next; // 返回的是合并后的头节点
    }
}