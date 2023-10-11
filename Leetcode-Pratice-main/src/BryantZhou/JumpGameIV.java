package BryantZhou;

import java.util.*;

public class JumpGameIV {
    public int minJump(int[] arr){
        if(arr.length==1){
            return 0;
        }
        int jump=0;
        int len=arr.length;
        Map<Integer, List<Integer>> map=new HashMap<>();
        for(int i=0;i<len;i++){
            map.putIfAbsent(arr[i],new ArrayList<>()).add(i);
        }
        Queue<Integer> queue=new LinkedList<>();
        queue.offer(0);
        Set<Integer> seen=new HashSet<>();
        while (!queue.isEmpty()){
            int size=queue.size();
            while (size-->0){
                int curIndex=queue.poll();
                if(curIndex == len-1){
                    return jump;
                }
                if(curIndex+1<len && seen.add(curIndex+1)){
                    queue.offer(curIndex+1);
                }
                if(curIndex-1>=0 && seen.add(curIndex-1)){
                    queue.offer(curIndex-1);
                }
                if(map.containsKey(arr[curIndex])){
                    for(int neighbor: map.get(arr[curIndex])){
                        if(seen.add(neighbor)){
                            queue.offer(neighbor);
                        }
                    }
                }

            }
            jump++;
        }
        return -1;
    }
}
