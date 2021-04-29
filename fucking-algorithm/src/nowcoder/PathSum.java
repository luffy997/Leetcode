package nowcoder;


import java.util.ArrayList;
import java.util.Arrays;

/**
 * 二叉树路径之和
 *
 * @author 路飞
 * @create 2021/4/26 11:02
 */
public class PathSum {

    public static void main(String[] args) {

    }

    private static ArrayList<ArrayList<Integer>> res = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
         dfs(root,sum,new ArrayList<Integer>());
        return res;
    }
    public static void dfs(TreeNode root, int sum, ArrayList<Integer> list){
        if (root == null)return;
        ArrayList<Integer> temp = new ArrayList<>(list);
        temp.add(new Integer(root.val));
        if (sum == root.val && root.left == null && root.right ==null){
            res.add(temp);
            return;
        }
        dfs(root.left,sum-root.val,temp);
        dfs(root.right,sum-root.val,temp);
    }
}

