package nowcoder;

import java.util.ArrayList;

/**
 * 二叉树中是否存在节点和为指定值的路径
 * @author 路飞
 * @create 2021/4/29 17:48
 */
public class HasPathSum {
    public static void main(String[] args) {

    }
    private static boolean flag = false;
    public static boolean hashPathSum(TreeNode root, int sum){
        if (root == null)return false;
        dfs(root,sum);
        return flag;
    }
    public static void dfs(TreeNode root,int sum){
        if (root == null)return;
        if (root.left == null && root.right ==null && sum == root.val) {
            flag = true;
            return;
        }
        dfs(root.left,sum-root.val);
        dfs(root.right,sum-root.val);
    }
}
