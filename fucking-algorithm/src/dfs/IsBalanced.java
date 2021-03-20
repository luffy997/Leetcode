package dfs;

/**
 * easy
 * 剑指 Offer 55 - II. 平衡二叉树
 *
 * 输入一棵二叉树的根节点，判断该树是不是平衡二叉树。如果某二叉树中任意节点的左右子树的深度相差不超过1，那么它就是一棵平衡二叉树。
 * @author 路飞
 * @create 2021/3/19 14:34
 */
public class IsBalanced {
    public static void main(String[] args) {

    }

    public static boolean isBalanced(TreeNode root){
        if (root == null) return true;
        int res = dfs(root);
        return res <=1;
    }
    public static int dfs(TreeNode root){
        if (root == null) return 0;
        isBalanced(root.left);
        isBalanced(root.right);
        return Math.abs(dfs(root.left) - dfs(root.right));
    }
}
