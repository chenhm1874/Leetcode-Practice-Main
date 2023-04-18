package Tree;

import java.util.*;

//这个问题中. 每个进程都有一个唯一的 PID(进程id) 和 PPID(父进程id)。每个进程只有一个父进程，但可能有一个或多个子进程，这就像一个树形结构。并且只有一个进程的PPID是0，这意味着这个进程没有父进程。所有的pid都是不同的正整数。
//
//我们使用两个整数列表来表示进程列表，其中第一个列表包含每个进程的PID，第二个列表包含对应的PPID。
//
//现在给定这两个列表，以及一个你要终止(kill)的进程的ID，返回将在最后被终止的进程的PID列表。（当一个进程被终止时，它的所有子进程将被终止。返回的列表没有顺序要求）
public class KillProcess {
    public List<Integer> killProcess(List<Integer> pid,List<Integer> ppid,int kill){
        Map<Integer,List<Integer>> tree=new HashMap<>();
        for(int i=0;i<pid.size();i++){
            int child=pid.get(i);
            int parent=ppid.get(i);
            tree.putIfAbsent(parent,new ArrayList<>());
            tree.get(parent).add(child);
        }
        List<Integer> ans= new LinkedList<>();
        Queue<Integer> queue=new LinkedList<>();
        queue.offer(kill);
        while (!queue.isEmpty()){
            int cur=queue.poll();
            ans.add(cur);
            if(tree.containsKey(cur)){
                queue.addAll(tree.get(cur));
            }
        }
        return ans;
    }
}
