import java.util.HashMap;

public class Solution {
    public static void main(String[] args) {

    }

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head) {
        HashMap<Node, Node> hashMap = new HashMap<>();
        Node curr = head;
        while(curr != null){// 创建 HashMap 存放 oldNode -> newNode 映射关系
            hashMap.put(curr, new Node(curr.val));
            curr = curr.next;
        }
        curr = head;

        // 第一遍将 Node 创建出来

        // 第二遍
        while(curr != null){
            Node copy = hashMap.get(curr);
            copy.next = hashMap.get(curr.next); // 虽然 curr.next 是原始数组的 Node, 但是在 HashMap 中对应的是新节点
            copy.random = hashMap.get(curr.random);
            curr = curr.next;
        }

        return hashMap.get(head);
    }
}
