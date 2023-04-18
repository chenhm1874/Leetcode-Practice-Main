package Strings;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class GroupAnagrams {
    public static List<List<String>> groupAnagrams(String[] strs){
        HashMap<String,List<String>> map=new HashMap<>();
        for(String str:strs){
            String cur=encode(str);
            map.putIfAbsent(cur,new LinkedList<>());
            map.get(cur).add(str);
        }
        List<List<String>> res= new LinkedList<>();
        for(List<String> group:map.values()){
            res.add(group);
        }
        return res;
    }
    private static String encode(String str){
        char[] count=new char[26];
        for(char s:str.toCharArray()){
            int x=s-'a';
            count[x]++;
        }
        return new String(count);
    }
}
