package search;



import java.util.ArrayList;
import java.util.List;

/**
 * medium
 * 113. 路径总和 II
 * 给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。
 *
 * 叶子节点 是指没有子节点的节点。
 * @author 路飞
 * @create 2021/4/12 15:24
 */
public class PathSum {
    public static void main(String[] args) {

    }

    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        dfs(root,targetSum,new ArrayList<Integer>());
        return res;
    }
    private void dfs(TreeNode root, int targetSum, List<Integer> list){
        if (root == null)return;

        if(targetSum == 0 && root.left == null && root.right == null){ //条件：和+叶子节点
            res.add(list);
            return;
        }
        if(targetSum < 0) return;
        List<Integer> temp = new ArrayList<>(list);
        temp.add(new Integer(root.val));
        dfs(root.left,targetSum-=root.val,temp);
        dfs(root.right,targetSum-=root.val,temp);
    }
}
