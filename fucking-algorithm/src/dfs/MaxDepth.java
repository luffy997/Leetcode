package dfs;

/**
 * 剑指 Offer 55 - I. 二叉树的深度
 * 输入一棵二叉树的根节点，求该树的深度。从根节点到叶节点
 * 依次经过的节点（含根、叶节点）形成树的一条路径，最长路径的长度为树的深度。
 * @author 路飞
 * @create 2021/3/19 12:29
 */
public class MaxDepth {
    public static void main(String[] args) {

    }

    public static int maxDepth(TreeNode root){
        if (root == null) return 0;
        return Math.max(maxDepth(root.left),maxDepth(root.right)) + 1;
    }
}
