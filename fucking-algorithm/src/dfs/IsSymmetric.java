package dfs;

/**
 * 剑指 Offer 28. 对称的二叉树
 * @author 路飞
 * @create 2021/3/15 16:47
 */
public class IsSymmetric {
    public static void main(String[] args) {

    }
    public static boolean isSymmetric(TreeNode root){
        return root == null || recur(root.left,root.right);
    }

    private static boolean recur(TreeNode L,TreeNode R){
        if(L == null && R == null) return true;
        if(L == null || R ==  null || L.val != R.val) return false;
        return recur(L.left,R.right) && recur(L.right,R.left);
    }
}
