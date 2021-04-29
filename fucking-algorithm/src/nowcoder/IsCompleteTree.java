package nowcoder;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 判断是否是完全二叉树
 * @author 路飞
 * @create 2021/4/26 16:15
 */
public class IsCompleteTree {
    public static void main(String[] args) {

    }

    /**
     * 完全二叉树是由满二叉树而引出来的。对于深度为K的，有n个结点的二叉树，当且仅当其每一个结点都与深度为K的满二叉树中编号从1至n的结点一一对应时称之为完全二叉树。
     * 若设二叉树的深度为h，除第 h 层外，其它各层 (1～h-1) 的结点数都达到最大个数，第h 层所有的结点都连续集中在最左边，这就是完全二叉树。
     * （大家好好理解一下上面两个定义，是等价的~~）
     * 满二叉树一定是完全二叉树，完全二叉树不一定是满二叉树。
     * @param root
     * @return
     */
    public static boolean isCompleteTree(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (queue.peek() != null){
            TreeNode node = queue.poll();
            queue.offer(node.left);
            queue.offer(node.right);
        }

        while (!queue.isEmpty() && queue.peek() == null){
            queue.poll();
        }
        return queue.isEmpty();
    }
}
