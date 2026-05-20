public class Solution {
    public static void main(String[] args) {
    }

    class Trie {
        TrieNode root;

        class TrieNode{
            TrieNode[] children;
            boolean isEnd; // 初始化为 false;

            public TrieNode(){
                this.children = new TrieNode[26]; // 初始化的时候全都是 null
                // this.children[0] 表示 a
                // 大写字母是靠前的 0100 0001 -> A -> 4 * 16 + 1 = 65
                // 小写字母        0110 0001 -> a -> 6 * 16 + 1 = 97
            }
        }

        public Trie() {
            this.root = new TrieNode();
        }

        public void insert(String word) {
            TrieNode node = this.root;
            for(char c : word.toCharArray()){
                if(node.children[c - 'a'] == null){
                    node.children[c - 'a'] = new TrieNode();
                    // 这里并没有将 node 指向的那个位置创建一个新的节点, 而是创建了一个新的节点, 将 node 指向了他, 这样并不行
                }
                // 如果节点不存在就创建出来, 如果存在, 那就什么也不干
                // 不管原来有没有, 到这里都是有的, 将指针移动到下一个位置
                node = node.children[c - 'a'];
            }
            node.isEnd = true;// 既然遍历完了, 肯定该创建的都创建了, node 也是指向的是最后一个节点
        }

        public boolean search(String word) {
            TrieNode node = this.root;
            for(char c : word.toCharArray()){
                node = node.children[c - 'a'];
                if(node == null){
                    return false;
                }
            }
            return node.isEnd;
        }

        public boolean startsWith(String prefix) {
            TrieNode node = this.root;
            for(char c : prefix.toCharArray()){
                node = node.children[c - 'a'];
                if(node == null){
                    return false;
                }
            }// 遍历过后, 发现, 该存在的 Node 都是存在的
            return true;
        }
    }
}
