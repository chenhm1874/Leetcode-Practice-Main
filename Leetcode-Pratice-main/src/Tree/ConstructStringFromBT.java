package Tree;

//你需要通过一棵二叉树的先序遍历，构建一个包含括号和整数的字符串。
//
//空结点需要用空括号对"()"来表示。同时你需要忽略掉所有的不影响字符串和原始二叉树一对一映射关系的空括号对。
//
//样例
//样例 1:
//
//输入: Binary tree: [1,2,3,4]
//       1
//     /   \
//    2     3
//   /
//  4
//
//输出: "1(2(4))(3)"
//
//解释: 一开始应该是 "1(2(4)())(3()())"，
//但是你需要忽略掉所有的不必要的空括号对.
//然后就变成了 "1(2(4))(3)".
public class ConstructStringFromBT {
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){
            this.val=val;
            this.left=this.right=null;
        }
    }
    public String tree2str(TreeNode t){
        String s=String.valueOf(t.val);
        boolean hasLeft=false;
        if(t.left!=null){
            hasLeft=true;
            s+='('+tree2str(t.left)+')';
        }
        if(t.right!=null){
            if(!hasLeft){
                s+="()";
            }
            s+='('+tree2str(t.right)+')';
        }
        return s;
    }
}
