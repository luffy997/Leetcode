package bfs;



import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 剑指 Offer 32 - I. 从上到下打印二叉树
 * 广度优先遍历
 * @author 路飞
 * @create 2021/3/15 17:19
 */
public class LevelOrder {
    public static void main(String[] args) {

    }

    public static int[] leveOrder(TreeNode root){
        if (root == null) return new int[0];
        List<Integer> list = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        if (queue.size() != 0){
            TreeNode temp = queue.pollFirst();
            list.add(temp.val);
            if (temp.left != null) queue.addLast(temp.left);
            if (temp.right != null) queue.addLast(temp.right);
        }

        //把list放入数组
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}
