package BryantZhou;

import java.util.LinkedList;
import java.util.List;

public class RestoreIPAddress {
    LinkedList<String> res= new LinkedList<>();
    LinkedList<String> track=new LinkedList<>();
    public List<String> restoreIpAddress(String s){
        backtrack(s,0);
        return res;
    }
    private void backtrack(String s,int start){
        if(start==s.length() && track.size()==4){
           res.add(String.join(".",track));
        }
        for(int i=start;i<s.length();i++){
            if(!isValid(s,start,i)){
                continue;
            }
            if(track.size()>4){
                break;
            }
            track.addLast(s.substring(start,i+1));
            backtrack(s,i+1);
            track.removeLast();
        }
    }
    private boolean isValid(String s,int start,int end){
        int len=end-start+1;
        if(len==0 || len>3){
            return false;
        }
        if(len == 1){
            return true;
        }
        if(s.charAt(start)==0){
            return false;
        }
        if(len<=2){
            return true;
        }
        if(Integer.parseInt(s.substring(start,start+len))>255){
            return false;
        }else {
            return true;
        }
    }
}
