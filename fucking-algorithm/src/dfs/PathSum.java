package dfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * medium
 * 剑指 Offer 34. 二叉树中和为某一值的路径
 * 输入一棵二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径。从树的根节点开始往下一直到叶节点所经过的节点形成一条路径。
 * @author 路飞
 * @create 2021/3/16 9:27
 */
public class PathSum {
    public static void main(String[] args) {

    }

    private static LinkedList<Integer> queue = new LinkedList<>();
    private static LinkedList<List<Integer>> res = new LinkedList<>();

    public static List<List<Integer>> pathSum(TreeNode root, int target) {
        recur(root,target);
        return res;
    }

    private static void recur(TreeNode root,int target){
        if(root == null) return;
        target -= root.val;
        if (target == 0 && root.left == null && root.right == null){
            res.add(queue);
        }
        //递归
        recur(root.left,target);
        recur(root.right,target);
        //回溯
        queue.removeLast();
    }
}
