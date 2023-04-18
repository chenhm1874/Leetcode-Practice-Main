package Tree;
//给一棵二叉搜索树以及一个整数 n, 在树中找到和为 n 的两个数字。无法找到解时返回 null。
//

//样例
//样例1
//
//输入：
//{4,2,5,1,3}
//3
//输出： [1,2] (or [2,1])
//解释：
//二叉搜索树如下：
//    4
//   / \
//  2   5
// / \
//1   3
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class TwoSumIVBST {
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){
            this.val=val;
            this.left=this.right=null;
        }
    }
    public int[] twoSum(TreeNode root,int n){
        if(root==null){
            return null;
        }
        Queue<TreeNode> queue=new LinkedList<>();
        Set<Integer> set=new HashSet<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            TreeNode cur=queue.poll();
            if(set.contains(n-cur.val)){
                return new int[]{cur.val,n-cur.val};
            }
            set.add(cur.val);
            if(cur.left!=null){
                queue.offer(cur.left);
            }
            if(cur.right!=null){
                queue.offer(cur.right);
            }
        }
        return null;
    }
}
