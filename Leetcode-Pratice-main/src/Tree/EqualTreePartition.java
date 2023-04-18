package Tree;

import java.util.HashMap;
import java.util.Map;

//给定一个有 n个节点的二叉树，请问可否在去掉恰好一条边的情况下，将原有的树分成两个节点值总和相等的两个树。
//
//树的节点的值在[-100000, 100000]范围内。
//1 <= n <= 10000
//保证树不为 null
//二叉树的表示
//
//样例
//样例 1:
//
//输入: {5,10,10,#,#,2,3}
//输出: true
//解释:
//  原始的树:
//     5
//    / \
//   10 10
//     /  \
//    2    3
//  两棵子树:
//     5       10
//    /       /  \
//   10      2    3
//样例 2:
//
//输入: {1,2,10,#,#,2,20}
//输出: false
//解释:
//  原始的树:
//     1
//    / \
//   2  10
//     /  \
//    2    20
public class EqualTreePartition {
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){
            this.val=val;
            this.left= this.right=null;
        }
    }
    Map<Integer,Integer> map=new HashMap<>();
    public boolean checkEqualTree(TreeNode root){
        int sum=helper(root);
        if(sum==0){
            return map.get(0)>1;
        }
        return sum%2==0 && map.containsKey(sum/2);
    }
    private int helper(TreeNode root){
        if(root==null){
            return 0;
        }
        int tmp=1;
        int sum=helper(root.left)+helper(root.right)+root.val;
        if(map.containsKey(sum)){
            tmp=map.get(sum)+1;
        }
        map.put(sum,tmp);
        return sum;
    }
}
