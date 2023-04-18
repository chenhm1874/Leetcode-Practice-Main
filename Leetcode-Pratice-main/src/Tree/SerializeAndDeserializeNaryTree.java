package Tree;

import java.util.ArrayList;

public class SerializeAndDeserializeNaryTree {
    public class DirectedGraphNode{
        int label;
        ArrayList<DirectedGraphNode> neighbors;
        DirectedGraphNode(int val){
            this.label=val;
            this.neighbors=new ArrayList<>();
        }
    }
    int pos=1;
    public String dfs(DirectedGraphNode root){
        String ans="";
        if(root==null){
            return ans;
        }
        ans+="[";
        ans+=String.valueOf(root.label);
        for(int i=0;i<root.neighbors.size();i++){
            ans+=dfs(root.neighbors.get(i));
        }
        ans+="]";
        return ans;
    }
    public DirectedGraphNode solve(String data){
        int num=0;
        while (data.charAt(pos)>='0' && data.charAt(pos)<='9'){
            num*=10;
            num+=data.charAt(pos)-'0';
            pos++;
        }
        DirectedGraphNode root=new DirectedGraphNode(num);
        while (pos<data.length()){
            if(data.charAt(pos)=='['){
                ++pos;
                root.neighbors.add(solve(data));
            }
            else if (data.charAt(pos)==']'){
                pos++;
                return root;
            }
        }
        return null;
    }
    public String serialize(ArrayList<DirectedGraphNode> nodes){
        String ans="";
        if(nodes.size()==0){
            return ans;
        }
        return dfs(nodes.get(0));
    }
    public DirectedGraphNode deserialize(String data){
        if(data.length()==0){
            return null;
        }
        return solve(data);
    }
}
