package Google;

import java.util.LinkedList;
import java.util.List;

public class CourseSchedule {
    private boolean hasCycle;
    private boolean[] visited;
    private boolean[] onPath;
    public boolean canFinish(int[] courses,int[][] preReq){
        List<Integer>[] graph=BuildGraph(courses,preReq);
        visited=new boolean[courses.length];
        onPath=new boolean[courses.length];
        for(int i=0;i<courses.length;i++){
            traverse(graph,i);
        }
        return !hasCycle;
    }
    private List<Integer>[] BuildGraph(int[] courses,int[][] preReq){
        List<Integer>[] graph=new LinkedList[courses.length];
        for(int i=0;i<courses.length;i++){
            graph[i]=new LinkedList<>();
        }
        for(int[] s: preReq){
            int start=s[0];
            int end=s[1];
            graph[start].add(end);
        }
        return graph;
    }
    private void traverse(List<Integer>[] graph,int pos){
        if(onPath[pos]){
            return;
        }
        if(visited[pos] || hasCycle){
            return;
        }
        onPath[pos]=true;
        visited[pos]=true;
        for(int p:graph[pos]){
            traverse(graph,p);
        }
        onPath[pos]=false;
    }
}
