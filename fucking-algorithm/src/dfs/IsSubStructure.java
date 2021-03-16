package dfs;

/**
 * medium
 * 剑指 Offer 26. 树的子结构
 * 输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)
 *
 * B是A的子结构， 即 A中有出现和B相同的结构和节点值。
 * @author 路飞
 * @create 2021/3/15 15:58
 */
public class IsSubStructure {
    public static void main(String[] args) {

    }

    public static boolean isSubStructure(TreeNode A,TreeNode B){
        return (A != null && B != null) && (recur(A,B) || isSubStructure(A.left,B) || isSubStructure(A.right,B));
    }

    private static boolean recur(TreeNode A,TreeNode B){
        if (B == null) return true;
        if (A == null || A.val != B.val) return false;
        return recur(A.left,B.left) && recur(A.right,B.right);
    }
}
