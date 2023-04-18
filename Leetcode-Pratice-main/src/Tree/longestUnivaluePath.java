package Tree;
//给定一颗二叉树，找到路径中每个节点具有相同值的最长路径的长度。 此路径可能会也可能不会通过根节点。
//
//1.两个节点之间的路径长度由它们之间的边数表示。
//2.给定的二叉树不超过10000个节点。 树的高度不超过1000。
//
//样例
//样例 1:
//
//输入:
//
//              5
//             / \
//            4   5
//           / \   \
//          1   1   5
//输出:
//2
public class longestUnivaluePath {
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){
            this.val=val;
            this.left=this.right=null;
        }
    }
    int ans=0;
    public int longestUnivaluePath(TreeNode root){
        helper(root);
        return ans;
    }
    //表示从该节点延伸的最大长度
    private int helper(TreeNode node){
        if(node==null){
            return 0;
        }
        int left=helper(node.left);
        int right=helper(node.right);
        int arrowleft=0;
        int arrowright=0;
        if(node.left!=null&&node.left.val==node.val){
            arrowleft+=1+left;
        }
        if(node.right!=null&&node.right.val==node.val){
            arrowright+=1+left;
        }
        ans=Math.max(ans,arrowleft+arrowright);
        return Math.max(arrowleft,arrowright);
    }
}
