package Tree;

public class LongestConsecutiveSequenceII {
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){
            this.val=val;
            this.left=this.right=null;
        }
    }
    public class ReturnType{
        int incr, decr,longestLength;
        ReturnType(int incr,int decr,int longestLength){
            //最长递增子序列的长度
            this.incr=incr;
            //最长递减子序列的长度
            this.decr=decr;
            this.longestLength=longestLength;
        }
    }
    public int longestConsecutiveII(TreeNode root){
        ReturnType res=traverse(root);
        return res.longestLength;
    }
    private ReturnType traverse(TreeNode root){
        if(root==null){
            return new ReturnType(0,0,0);
        }
        ReturnType leftInfo=traverse(root.left);
        ReturnType rightInfo=traverse(root.right);
        int leftInc=leftInfo.incr;
        int leftDec=leftInfo.decr;
        int rightInc= rightInfo.incr;
        int rightDec=rightInfo.decr;
        int curDec=0;
        int curInc=0;
        if(root.left!=null){
            if(root.val==root.left.val-1){
                curInc=Math.max(curInc,leftInc+1);
            }
            if(root.val==root.left.val+1){
                curDec=Math.max(curDec,leftDec+1);
            }
        }
        if(root.right!=null){
            if(root.val==root.right.val-1){
                curInc=Math.max(curInc,rightInc+1);
            }
            if(root.val==root.right.val+1){
                curDec=Math.max(curDec,rightDec+1);
            }
        }
        int longestLength=Math.max(Math.max(leftInfo.longestLength,rightInfo.longestLength),curDec+curInc+1);
        return new ReturnType(curInc,curDec,longestLength);
    }
}
