package dfs;

/**
 * medium
 * 剑指 Offer 36. 二叉搜索树与双向链表
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的循环双向链表。要求不能创建任何新的节点，只能调整树中节点指针的指向。
 * @author 路飞
 * @create 2021/3/19 8:51
 */
public class TreeToDoublyList {
    public static void main(String[] args) {

    }

    private static TreeNode pre;
    private static TreeNode head;
    public static TreeNode TreeToDoublyList(TreeNode root){
       if(root == null) return null;
       dfs(root);
       head.left=pre;
       pre.right=head;
       return head;
    }

    /**
     * 二叉搜索树中 中序遍历是递增的
     * @param curNode
     */
    private static void dfs(TreeNode curNode){
        if (curNode == null) return;
        dfs(curNode.left);
        if (pre != null) pre.right = curNode;
        else head = curNode;
        curNode.left = pre;
        pre=curNode;
        dfs(curNode.right);
    }
}
