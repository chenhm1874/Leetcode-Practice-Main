package Tree;

import java.util.HashMap;
import java.util.Map;

public class ConstructBTFromPreorderPostorder {
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){
            this.val=val;
            this.left=this.right=null;
        }
    }
    Map<Integer,Integer> position=new HashMap<>();
    public TreeNode constructFromPrePost(int[] preorder,int[] postorder){
        for(int i=0;i<postorder.length;i++){
            position.put(postorder[i],i);
        }
        return build(preorder,0,preorder.length-1,
                     postorder,0,postorder.length-1);
    }
    private TreeNode build(int[] preorder,int preStart,int preEnd,int[] postorder,int postStart,int postEnd){
        if(preStart>preEnd){
            return null;
        }
        if(preStart==preEnd){
            return new TreeNode(preorder[preStart]);
        }
        TreeNode root=new TreeNode(preorder[preStart]);
        int leftRootVal= preorder[preStart+1];
        int index=position.get(leftRootVal);
        int leftSize=index-postStart;
        root.left=build(preorder,preStart+1,preStart+leftSize,postorder,postStart,index);
        root.right=build(preorder,preStart+leftSize+1,preEnd,postorder,index+1,postEnd-1);
        return root;
    }
}
