import java.util.Queue;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class Solution {
    public static void main(String[] args){

    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> pres = new ArrayList<>();
        for(int i = 0; i < numCourses; i++){
            List<Integer> list = new ArrayList<>();
            pres.add(list);
        }
        int[] indegree = new int[numCourses]; // 每一门课程我们都要统计 入度 是多少
        for(int[] arr : prerequisites){
            int self = arr[0];
            int pre = arr[1];// 要先学的课程, 也就是说, 学完这个才能学 self
            pres.get(pre).add(self);// 学完 pre 能学的课程汇总一下, 到时候找起来方便
            // 同时入度信息也统计一下
            // 注意 x, y 表示的是, 学了 y 才能学 x, 也就是 y -> x
            indegree[self]++;
        }
        Queue<Integer> queue = new ArrayDeque<>();
        int courseCount = 0;
        for(int i = 0; i < numCourses; i++){
            if(indegree[i] == 0){
                queue.offer(i); // 表示 0 号课程是可以学的
            }
        }
        // 
        while(!queue.isEmpty()){
            // 如果没有空, 那么就拿出来顶部的, 学了, 看看有多少课程因为学了这门课刚好达到能够学习的条件
            int pre = queue.poll(); // 顶部课程编号
            courseCount++;
            for(int next : pres.get(pre)){
                // 这门课程是哪些课程的前驱课程
                // 这些课程的入度全都减一
                indegree[next]--;
                // 如果该课程的入度为 0, 也就是该课程的所有前驱课程都学完了, 那么该课程也可以用来更新一波了
                if(indegree[next] == 0){
                    courseCount++;
                    queue.offer(next);// 把可学的节点放到队列中等待处理完看看
                }
            }
        }
        return courseCount == numCourses ? true : false;
    }
}
