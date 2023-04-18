package Tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//按照以下规则在 m*n 二维字符串数组中打印二叉树：
//
//行号m应该等于给定二叉树的高度。
//列号n始终为奇数。
//根节点的值（以字符串格式）应该放在它可以放入的第一行的正中间。根节点所属的列和行将剩余空间分成两部分（左下部分和右下部分）。您应该在左下部分打印左子树，并在右下部分打印右子树。左下部和右下部应具有相同的大小。即使一个子树为空，而另一个子树不为空，你也不需要打印空子树，但仍然需要留出与另外一个子树一样大的空间。但是，如果两个子树都为空，那么您不需要为它们留出空间。
//每个未使用的空格应包含一个空字符串""。
//按照相同的规则打印所有子树。
//二叉树的高度在[1, 10]范围内。
//
//样例
//样例1:
//
//输入:{1,2}
//    1
//   /
//  2
//输出:
// [["", "1", ""],
//  ["2", "", ""]]
public class PrintBinaryTree {
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){
            this.val=val;
            this.left=this.right=null;
        }
    }
    public List<List<String>> printTree(TreeNode root){
        int height=getHeight(root);
        String[][] res=new String[height][(1<<height)-1];
        for(String[] res1:res){
            Arrays.fill(res1,"");
        }
        List<List<String>> ans=new ArrayList<>();
        fill(res,root,0,0,res[0].length);
        for(String[] arr:res){
            ans.add(Arrays.asList(arr));
        }
        return ans;
    }
    private int getHeight(TreeNode root){
        if (root==null){
            return -1;
        }
        return 1+Math.max(getHeight(root.left),getHeight(root.right));
    }
    private void fill(String[][] res,TreeNode root,int height,int l,int r){
        if(root==null){
            return;
        }
        res[height][(l+r)/2]=""+root.val;
        fill(res,root.left,height+1,l,(l+r)/2);
        fill(res,root.right,height+1,(l+r)/2+1,r);
    }
}
