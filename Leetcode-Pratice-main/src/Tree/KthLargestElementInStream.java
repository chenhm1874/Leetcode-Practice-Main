package Tree;

import java.util.PriorityQueue;

public class KthLargestElementInStream {
    //第k个大或第k个小的类似题目，第一考虑PriorityQueue
    public class KthLargest{
        private int k;
        private PriorityQueue<Integer> pq=new PriorityQueue<>();
        public KthLargest(int k,int[] nums){
           for(int e:nums){
               pq.offer(e);
               if(pq.size()>k){
                   pq.poll();
               }
           }
           this.k=k;
        }
        public int add(int val){
            pq.offer(val);
            if(pq.size()>k){
                pq.poll();
            }
            return pq.peek();
        }
    }

}
