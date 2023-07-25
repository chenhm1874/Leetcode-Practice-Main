package Google;

import java.util.LinkedHashMap;

public class LRUCache {
    int cap;
    LinkedHashMap<Integer,Integer> cache=new LinkedHashMap<>();
    public LRUCache(int capacity) {
        this.cap=capacity;
    }
    public int get(int key){
        if(!cache.containsKey(key)){
            return -1;
        }
        makeRecent(key);
        return cache.get(key);
    }
    public void put(int key,int val){
        if(cache.containsKey(key)){
            cache.put(key,val);
            makeRecent(key);
            return;
        }
        if(cache.size()>this.cap){
            int OldestKey=cache.keySet().iterator().next();
            cache.remove(OldestKey);
        }
        cache.put(key,val);
    }
    private void makeRecent(int key){
        int val=cache.get(key);
        cache.remove(key);
        cache.put(key,val);
    }
}
