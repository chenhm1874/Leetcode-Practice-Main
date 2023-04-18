package Tree;

//给定二叉树的根，然后是值v和深度d，您需要在给定深度d处添加一行值为v的节点。 根节点位于深度1。
//
//添加规则是：给定正整数深度d，对于深度为d-1的每一个非空树节点 N，产生两个值为v的树节点，分别作为 N 的左子树根和右子树根。并且 N 的原始左子树应该是新左子树根的左子树，其原始右子树应该是新右子树根的右子树。 如果深度d为1表示根本没有深度d-1，则创建一个值为v的树节点作为整个原始树的新根，并且原始树是新根的左子树。
//
//给定的d在范围[1，给定树的最大深度+ 1]。
//给定的二叉树至少有一个树节点。
//
//样例
//样例1
//
//输入:
//一棵如下所示的二叉树:
//       4
//     /   \
//    2     6
//   / \   /
//  3   1 5
//v = 1
//d = 2
//输出:
//       4
//      / \
//     1   1
//    /     \
//   2       6
//  / \     /
// 3   1   5
public class AddOneRowToTree {
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){
            this.val=val;
            this.left=this.right=null;
        }
    }
    public TreeNode addOneRow(TreeNode root,int val,int depth){
        if(depth==1){
            TreeNode newRoot=new TreeNode(val);
            newRoot.left=root;
            return newRoot;
        }
        dfs(root,val,depth);
        return root;
    }
    private void dfs(TreeNode root,int val,int depth){
        if(depth-1==1){
            TreeNode left=new TreeNode(val);
            TreeNode right=new TreeNode(val);
            left.left=root.left;
            right.right=root.right;
            root.left=left;
            root.right=right;
            if(root.left!=null){
                dfs(root.left,val,depth-1);
            }
            if(root.right!=null){
                dfs(root.right,val,depth-1);
            }
        }
    }
}
