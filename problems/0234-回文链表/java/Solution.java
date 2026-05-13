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

    public boolean isPalindromeOptimal(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null){// 注意, 一定要用短路与, 在判断 fast.next != null 的基础上判断下两个都不是 null
            slow = slow.next;
            fast = fast.next.next;
        }
        slow = slow.next;// 如果是偶数长度, 那么 slow 会停在上半部分的最后一个元素, 如果是奇数, 那么 slow 会停留在中间
        // 如果是偶数个元素, 那么中间的步数就是奇数个, 比如 4 个元素, 那么从 0 号元素走到 3号元素就需要走三步
        // 往下继续走一步, 刚好是下半部分的第一个元素
        ListNode b = reverse(slow);
        ListNode a = head;
        while(b != null){
            if(a.val != b.val){
                return false;
            }
            a = a.next;
            b = b.next;
            // 因为 b 的长度比较短, 所以用 b 来推进遍历
        }
        return true;
    }

    public static ListNode reverse(ListNode head){ 
        // 题目不是写完了就 OK, 写完了可以问问 AI 最优的写法是什么
        // 比如这里, 可以将 prev = null
        if(head == null) return null;
        ListNode prev = null; // 这里用
        ListNode curr = head;
        ListNode next = head.next;
        while(curr != null){
            curr.next = prev;
            prev = curr;
            curr = next;
            if(next != null){
                next = next.next;
            }
        }
        return prev;
    }
}
