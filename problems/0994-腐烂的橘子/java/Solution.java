import java.util.Queue;
import java.util.LinkedList;

public class Solution {
    public static void main(String[] args){}

    int fresh = 0;

    public int orangesRotting(int[][] grid) {
        if(grid == null) return -1;
        if(grid.length == 0) return -1;
        if(grid[0] == null) return -1;
        if(grid[0].length == 0) return -1;
        int rowNum = grid.length;
        int colNum = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();// 双端链表可以拿来做
        for(int i = 0; i < rowNum; i++){
            // 第一遍遍历, 作用是统计信息, 把腐烂橘子加入到队列中, 然后再处理, 处理一圈, 
            for(int j = 0; j < colNum; j++){
                if(grid[i][j] == 2){
                    queue.offer(new int[]{i, j});// 将腐烂橘子放进去
                }
                if(grid[i][j] == 1){
                    this.fresh++;
                }
            }
        }
        if(this.fresh == 0){
            return 0;// 如果根本没有新鲜橘子, 那么0个回合
        }
        if(queue.isEmpty()){
            return -1;// 根本没有腐烂的橘子, 你感染个集贸
        }
        // 如果进行过一波传染, 但是没有新鲜的橘子被传染, 也就是新鲜数量没有改变, 且大于0, 那么有橘子不可达, 返回
        // 从队列中取出第一波初始腐烂的橘子, 由此开始传染
        int loopCounter = 0;
        while(!queue.isEmpty()){
            int oldFresh = this.fresh;
            int size = queue.size(); // 为的是固定下来
            for(int i = 0; i < size; i++){// 不能在循环的时候动态调用 queue.size(), 进循环之前要固定size
                // 因为循环内部会修改 size
                int[] pair = queue.poll();// 这个橘子肯定是腐烂的橘子了
                int x = pair[0];
                int y = pair[1];
                infect(grid, x - 1, y, queue);
                infect(grid, x + 1, y, queue);
                infect(grid, x, y - 1, queue);
                infect(grid, x, y + 1, queue);
            }
            if(oldFresh != this.fresh){
                // 说明这一轮进行了感染, 那么 loopCounter++
                loopCounter++;
            }else{
                if(this.fresh > 0){
                    return -1;
                }else{
                    // 没有进行感染 this.fresh 到 0 了, 说明这一波是最后一波
                    return loopCounter;
                }
            }
        }
        return loopCounter;
    }

    public void infect(int[][] grid, int i, int j, Queue<int[]> queue){
        // 作用是, 如果输入一个腐烂橘子的坐标
        // 把该橘子周围的一圈的新鲜橘子都变成腐烂橘子, 如果有新转换的橘子, 那么把新转换的橘子加入到 队列 中
        if(grid == null) return;
        if(grid.length == 0) return;
        if(grid[0] == null) return;
        if(grid[0].length == 0) return;
        int rowNum = grid.length;
        int colNum = grid[0].length;
        if(i < 0 || i >= rowNum || j < 0 || j >= colNum){
            return; // 这个格子是不符合要求的
        }
        if(grid[i][j] == 1){
            // 新鲜的橘子, 感染了, 放进 queue 中, 下一波从这波橘子开始感染
            grid[i][j] = 2;
            this.fresh--;
            queue.offer(new int[]{i, j});
        }
    }
}
