package dfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * esay
 * 剑指 Offer 54. 二叉搜索树的第k大节点
 * 给定一棵二叉搜索树，请找出其中第k大的节点。
 *
 * 二叉搜索树的中序遍历就是递增序列！！！！！！！！
 * @author 路飞
 * @create 2021/3/19 12:02
 */
public class kthLargest {
    public static void main(String[] args) {

    }

    List<Integer> list = new LinkedList<Integer>();
    public int kthLargest(TreeNode root, int k) {
        if(root == null) return -1;
        dfs(root);
        return list.get(list.size()-k);
    }

    void dfs(TreeNode root){
        if(root == null) return;
        dfs(root.left);
        list.add(root.val);
        dfs(root.right);
        return;
    }
}
