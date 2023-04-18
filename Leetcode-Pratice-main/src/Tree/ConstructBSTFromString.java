package Tree;

public class ConstructBSTFromString {
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){
            this.val=val;
            this.left=null;
            this.right=null;
        }
    }
    int idx=0;
    public TreeNode str2tree(String s){
        int len=s.length();
        if(len==0||idx>=len){
            return null;
        }
        int sig=1;
        int val=0;
        if(s.charAt(idx)=='-'){
            sig=-1;
            ++idx;
        }
        while(idx<len && s.charAt(idx) >='0' && s.charAt(idx)<='9'){
            val=val*10+s.charAt(idx)-'0';
            ++idx;
        }
        TreeNode root=new TreeNode(val*sig);
        if(idx>=len || s.charAt(idx)==')'){
            ++idx;
            return root;
        }
        ++idx;
        root.left=str2tree(s);
        if(idx>=len || s.charAt(idx)==')'){
            ++idx;
            return root;
        }
        ++idx;
        root.right=str2tree(s);
        if(idx>=len || s.charAt(idx)==')'){
            ++idx;
            return root;
        }
        return root;
    }
}
