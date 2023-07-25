package Google;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseScheduleII {
    public int[] findOrder(int numCourses,int[][] prerequisites){
        List<Integer>[] graph=buildGraph(numCourses,prerequisites);
        int[] indegree=new int[numCourses];
        for(int[] ele:prerequisites){
            int from=ele[0];
            int to=ele[1];
            indegree[to]++;
        }
        Queue<Integer> queue=new LinkedList<>();
        for(int i=0;i<indegree.length;i++){
            if(indegree[i]==0){
                queue.offer(i);
            }
        }
        int[] res=new int[numCourses];
        int count=0;
        while(!queue.isEmpty()){
            int cur=queue.poll();
            res[count]=cur;
            count++;
            for(int next:graph[cur]){
                indegree[next]--;
                if(indegree[next]==0){
                    queue.offer(next);
                }
            }
        }
        if(count!=numCourses){
            return new int[]{};
        }
        return res;

    }
    private List<Integer>[] buildGraph(int numCourses,int[][] prerequisites){
        List<Integer>[] graph=new LinkedList[numCourses];
        for(int i=0;i<numCourses;i++){
            graph[i]=new LinkedList<>();
        }
        for(int[] index:prerequisites){
            int from=index[0];
            int to=index[1];
            graph[from].add(to);
        }
        return graph;
    }
}
