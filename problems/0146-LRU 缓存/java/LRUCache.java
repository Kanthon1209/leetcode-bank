import java.util.HashMap;

public class LRUCache {
    int capacity;
    int size;
    ListNode head;
    ListNode tail;
    HashMap<Integer, ListNode> hashMap;

    public LRUCache(int capacity) {
        // get / put 要以 o(1) 时间复杂度运行, 那就用 HashMap 咯?
        this.hashMap = new HashMap<>(); // 常数级别看元素是否在容器中
        this.head = new ListNode();
        this.tail = new ListNode();
        this.head.next = tail;
        this.tail.prev = head;
        this.capacity = capacity;
        this.size = 0;
        // 如果超过 容量就应该在 入元素的时候同时删元素了
    }

    public void addHead(ListNode node) {
        node.next = this.head.next;// 新节点前后节点设置好
        node.prev = this.head;
        this.head.next.prev = node; //
        this.head.next = node;
    }

    public void removeNode(ListNode node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }


    public int get(int key) {
        if(this.hashMap.containsKey(key)){
            // get 也是一次使用, 要把节点放到最前
            ListNode node = this.hashMap.get(key);
            this.removeNode(node);
            this.addHead(node);
            return node.val;
        }else{
            return -1;
        }
    }

    public void put(int key, int value) { // 放入的时候也是 o(1) 的时间复杂度
        // 放元素的时候应该先看, HashMap 中是否有该元素
        if (!this.hashMap.containsKey(key)) {
            // 如果该元素不在容器中, 那么需要加入该元素, 这个时候要判断 size 与 capacity
            if (this.size == this.capacity) {
                // 容器已经是满的状态了
                // 删除队尾元素, 新元素添加到队首, 不改变 size
                this.hashMap.remove(this.tail.prev.key);// 把 HashMap 中对应的节点删除掉
                this.removeNode(this.tail.prev); // 从实际存储位置删除掉节点
                // HashMap 中对应的元素也要删除
                ListNode node = new ListNode(key, value);
                hashMap.put(key, node);
                this.addHead(node);
            } else {
                // 容器没有满, 继续放元素就是, 首先是创建一个新的节点, 连接到队首
                // 放了元素要加容量
                ListNode node = new ListNode(key, value);
                this.addHead(node); // 往双向链表中放节点
                this.hashMap.put(key, node);
                this.size++;
                // 并且把该节点 val 作为 HashMap 的 key, 节点作为 value 存放到 HashMap 中
            }
        } else {
            // 容器中已经有该元素了, 那么将该元素对应的节点放到队首, 并将 value 进行更新
            ListNode node = this.hashMap.get(key);
            node.val = value; // 更改该节点元素
            this.removeNode(node); 
            this.addHead(node); 
            // 容量不改变的
        }
    }
}

class ListNode {
    int key;
    int val;
    ListNode prev;
    ListNode next;

    public ListNode() {
    };

    public ListNode(int key, int val) {
        this.key = key;
        this.val = val;
    }

}