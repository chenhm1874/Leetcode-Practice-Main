package zuochengyun;

import java.util.Arrays;
import java.util.HashSet;

//给定区间的范围[xi,yi],求一个坐标集合set要和所有给定区间都有交集，求这个set最少包含几个数
//对每个区间进行加工，包含第一个数据的值，它本身属性（开头/结尾），该区间结尾（如果有）
//再次准备一个set，遇到开头事件在set中添加结尾值，遇到结尾事件若set中包含该结尾则将其放入最后的答案集中，依次类推
public class MinSetForEveryRange {
    public static int minSet(int[][] ranges){
        int n= ranges.length;
        //event[i]={a,b,c}
        //a==0表示这是个区间的开始事件，区间的结束位置是b
        //a==1表示这是个区间的结束事件，b的值没有意义
        //c表示这个事件的时间点，无论开始或结束事件都会有该值
        int[][] events=new int[n<<1][3];
        for(int i=0;i<n;i++){
            events[i][0]=0;
            events[i][1]=ranges[i][1];
            events[i][2]=ranges[i][0];
            events[i+n][0]=1;
            events[i+n][2]=ranges[i][1];
        }
        Arrays.sort(events,(a,b)-> a[2]-b[2]);
        HashSet<Integer> set=new HashSet<>();
        int ans=0;
        for (int[] event:events){
            if(event[0]==0){
                set.add(event[1]);
            }
            else {
                if(set.contains(event[2])){
                    ans++;
                    set.clear();
                }
            }
        }
        return ans;  
    }
}
