public class Solution {
    public static void main(String[] args){}

    public int numIslands(char[][] grid){
        // 如果一个地点有陆地, 并且四周都是水, 那么就是新建岛屿
        // 如果一个地点是陆地, 四周至少一个陆地, 判断该陆地是否属于已有岛屿, 如果已经属于岛屿, 那么该地块也属于对应的岛屿, 否则, 将该地块新建岛屿, 后面如果到那个地块的时候, 会由于和本地块相邻被加入本地块所属岛屿内
        // 但是用什么来充当岛屿呢
        if(grid == null) return 0;
        if(grid.length == 0) return 0;
        if(grid[0] == null) return 0;
        int rowNum = grid.length;
        int colNum = grid[0].length;
        int islandCount = 0;
        for(int i = 0; i < rowNum; i++){
            for(int j = 0; j < colNum; j++){
                if(grid[i][j] == '1'){
                    islandCount += 1;
                    dfs(grid, i, j);
                }
            }
        }
        return islandCount;
    }

    public void dfs(char[][] grid, int i, int j){
        if(grid == null) return;
        if(grid.length == 0) return;
        if(grid[0] == null) return;
        int rowNum = grid.length;
        int colNum = grid[0].length;
        if(i < 0 || i >= rowNum || j < 0 || j >= colNum) return; // 越界的格子就不用处理了
        if(grid[i][j] == '0') return; // 如果当前的 0 , 那也不用处理了
        // 走到这里说明当前地块是 1 咯, 难就置为 0
        // 什么时候进行 islandCount++ 操作
        grid[i][j] = '0';// 将当前地块置为0, 并dfs所有相邻地块
        dfs(grid, i - 1, j);
        dfs(grid, i + 1, j);
        dfs(grid, i, j - 1);
        dfs(grid, i, j + 1);
    }
}
