public class Solution {
    public static void main(){}

    public boolean exist(char[][] board, String word) {
        if(board == null) return false;
        if(board.length == 0) return false;
        if(board[0] == null) return false;
        if(board[0].length == 0) return false;
        int rowNum = board.length;
        int colNum = board[0].length;
        for(int i = 0; i < rowNum; i++){
            for(int j = 0; j < colNum; j++){
                boolean[][] visited = new boolean[rowNum][colNum];
                if(backtrack(board, 0, i, j, word, visited)) return true;// 
            }
        }
        return false;
    }

    public boolean backtrack(char[][] board, int idx, int rowIdx, int colIdx, String word, boolean[][] visited){
        int rowNum = board.length;
        int colNum = board[0].length;
        if(rowIdx < 0 || rowIdx >= rowNum || colIdx < 0 || colIdx >= colNum) return false;// 进入函数再判断当前格子符不符合, 首先是格子合法与否
        // 还有一个问题, 走过的路径不能再走, 并不是说访问过的就不能访问, 而是已经采纳过的方格不能够再次采纳
        if(visited[rowIdx][colIdx]) return false;
        
        
        // 格子合法我们再来看内容合法与否
        char c = word.charAt(idx);
        if(board[rowIdx][colIdx] == c){
            visited[rowIdx][colIdx] = true;// 如果当前的格子符合 当前下标, 那么就标记, 
            // 内容合法我们来看是不是恰好是最后一位
            if(idx == word.length() - 1){
                // 如果是最后一位匹配上了
                return true;
            }
            // 内容合法但是并没有到达最后一位, 检查周围四个格子, 是不是下一个字母
            // 但是周围四个格子不能回头再检查前面已经走通的, 用 visited

            // 先看下四周能不能走得通, 走通或者走不通都把当前节点visted = false, 因为我已经要退出坐标了
            boolean flag = backtrack(board, idx + 1, rowIdx + 1, colIdx, word, visited)
                || backtrack(board, idx + 1, rowIdx - 1, colIdx, word, visited)
                || backtrack(board, idx + 1, rowIdx, colIdx + 1, word, visited)
                || backtrack(board, idx + 1, rowIdx, colIdx - 1, word, visited);
            visited[rowIdx][colIdx] = false;
            return flag;
        }
        return false;
    }
}
