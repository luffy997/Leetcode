package dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * medium
 * 144. 二叉树的前序遍历
 给你二叉树的根节点 root ，返回它节点值的 前序 遍历。
 * @author 路飞
 * @create 2021/3/15 16:19
 */
public class PreorderTraversal {
    public static void main(String[] args) {

    }

    public List<Integer> reorderTraversal(TreeNode root){
        List<Integer> res = new ArrayList<>();
        preorder(root,res);
        return res;
    }

    public static void preorder(TreeNode root,List<Integer> res){
        if (root == null){
            return;
        }
        res.add(root.val);
        preorder(root.left,res);
        preorder(root.right,res);
    }
}
