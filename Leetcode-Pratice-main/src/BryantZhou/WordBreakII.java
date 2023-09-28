package BryantZhou;

import java.util.LinkedList;
import java.util.List;

public class WordBreakII {
    List<String> res=new LinkedList<>();
    LinkedList<String> track=new LinkedList<>();
    public List<String> wordBreak(String s,List<String> wordDict){
        backtrack(s,0,wordDict);
        return res;
    }
    private void backtrack(String s, int start,List<String> wordDict){
        if(start==s.length()){
            res.add(String.join(" ", track));
        }
        if (start>s.length()){
            return;
        }
        for(String word:wordDict){
            int len=word.length();
            if(start+len>s.length()){
                continue;
            }
            String substr=s.substring(start,start+len);
            if(!substr.equals(word)){
                continue;
            }
            track.addLast(word);
            backtrack(s,start+len,track);
            track.removeLast();
        }
    }
}
