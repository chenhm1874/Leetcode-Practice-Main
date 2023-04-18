package Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ClosestBSTValueII {
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(){}
        TreeNode(int val){
            this.val=val;
        }
        TreeNode(int val,TreeNode left,TreeNode right){
            this.val=val;
            this.left=left;
            this.right=right;
        }
    }
    public List<Integer> closestValues(TreeNode root,int k,double target){
        List<Integer> res=new ArrayList<>();
        Stack<TreeNode> upperbound=new Stack<>();
        Stack<TreeNode> lowerbound=new Stack<>();
        TreeNode p=root;
        while(p!=null){
            if(p.val<=target){
                lowerbound.push(p);
                p=p.right;
            }
            else{
                upperbound.push(p);
                p=p.left;
            }
        }
        while(!lowerbound.isEmpty()|| !upperbound.isEmpty()&& k>0){
            TreeNode low=null;
            TreeNode up=null;
            if(!lowerbound.isEmpty()){
                low=lowerbound.peek();
            }
            if(!upperbound.isEmpty()){
                up=upperbound.peek();
            }
            if(up==null&&low!=null||up!=null&&low!=null&&Math.abs(low.val-target)<Math.abs(up.val-target)){
                res.add(lowerbound.pop().val);
                k--;
                //找到满足条件的节点后，应在该节点左子树的右支上继续寻找满足条件的节点，故将右支上的所有节点压入栈中
                low=low.left;
                while(low!=null){
                    lowerbound.push(low);
                    low=low.right;
                }
            }
            else if(low==null&& up!=null|| low!=null&& up!=null&& Math.abs(low.val-target)>=Math.abs(up.val-target)){
                res.add(upperbound.pop().val);
                k--;
                up=up.left;
                while(up!=null){
                    upperbound.push(up);
                    up=up.left;
                }
            }
        }
        return res;
    }
}
