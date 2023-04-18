package zuochengyun;


import java.util.ArrayList;

//给定两个数组A,B，如A= {0，1，1}，B={1,2,3}
//A[0]=0,B[0]=1,表示0到1有一条双向道路，给定数字N，共N+1个节点，所有节点都连通且无环
//默认办公室在0节点，其他所有节点上都有一个居民，每天所有居民都前往0节点上班，所有居民都有一辆五座的车，且乐意与别人拼车
//无论车的负重是多少，只要走过一条路就要耗费1单位的汽油，求所有居民去办公室所需花费的最少汽油数量
public class minFuel {
    public static int cnt=0;
    public static int minFuel(int[] a,int[] b,int n){
        ArrayList<ArrayList<Integer>> graph=new ArrayList<>();
        //建图完毕
        for(int i=0;i<=n;i++){
            graph.add(new ArrayList<>());
        }
        for(int i=0;i<=n;i++){
            graph.get(a[i]).add(b[i]);
            graph.get(b[i]).add(a[i]);
        }
        //用来标记每个点是否已被遍历过，若为0则尚未遍历，若不为0则已经遍历
        int[] dfn=new int[n+1];
        //以size[n]为头的树共有几个节点
        int[] size=new int[n+1];
        //到达cost[n]所需花费的总油耗数
        int[] cost=new int[n+1];
        cnt=0;
        dfs(graph,0,dfn,size,cost);
        return cost[0];
    }
    private static void dfs(ArrayList<ArrayList<Integer>> graph, int cur, int[] dfn, int[] size, int[] cost){
        dfn[cur]=++cnt;
        size[cur]=1;
        for(int next:graph.get(cur)){
            size[cur]+=size[next];
            cost[cur]+=cost[next];
            //+4是向上取整
            cost[cur]+=(size[next]+4)/5;
        }

    }
}
