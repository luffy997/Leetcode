package dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * easy
 * 257. 二叉树的所有路径
 * 给定一个二叉树，返回所有从根节点到叶子节点的路径。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 * @author 路飞
 * @create 2021/4/12 16:11
 */
public class BinaryTreePaths {
    public static void main(String[] args) {

    }
    static List<String> res = new ArrayList<>();
    public static List<String> binaryTreePaths(TreeNode root) {
        dfs(root,"");
        return res;
    }
    static void dfs(TreeNode root,String cur){
        if(root.left == null && root.right == null){
            res.add(cur);
            return;
        }
        dfs(root.left,cur+root.val+"->");
        dfs(root.right,cur+root.val+"->");
    }
}
