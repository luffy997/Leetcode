package dfs;

/**
 * easy
 * 剑指 Offer 68 - I. 二叉搜索树的最近公共祖先
 *
 * 要求：
 * 所有节点的值都是唯一的。
 * p、q 为不同节点且均存在于给定的二叉搜索树中。
 * @author 路飞
 * @create 2021/3/19 15:21
 */
public class LowestCommonAncestor1 {
    public static void main(String[] args) {

    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //三种情况 要充分利用二叉搜索树的特点和节点唯一且都在树中
        //1.分布在根节点的两侧 直接返回root
        while (root != null) {
            //2.分布在右子树 这里的思路非常好，一旦root进行向下迭代出现null 就说明这个是爹 直接跳出循环
            if (root.val < p.val && root.val < q.val) root = root.right;
                //3.分布在左子树
            else if (root.val > p.val && root.val > q.val) root = root.left;
            else break;
        }
        return root;
    }
}
