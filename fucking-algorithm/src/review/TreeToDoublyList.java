package review;


import java.util.ArrayList;
import java.util.List;

/**
 * medium
 * 剑指 Offer 36. 二叉搜索树与双向链表
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的循环双向链表。
 * 要求不能创建任何新的节点，只能调整树中节点指针的指向。
 * @author 路飞
 * @create 2021/4/12 16:42
 */
public class TreeToDoublyList {
    public static void main(String[] args) {

    }

    /**
     * 特别地，我们希望可以就地完成转换操作。当转化完成以后，
     * 树中节点的左指针需要指向前驱，树中节点的右指针需要指
     * 向后继。还需要返回链表中的第一个节点的指针
     */
    private static List<Node> list = new ArrayList<>();
    public Node treeToDoublyList(Node root) {
        if (root == null) return root;
        dfs(root);
        Node pre = list.get(0);
        Node head= pre;
        for (int i = 1; i < list.size(); i++) {
            Node q = list.get(i);
            q.left = pre;
            pre.right = q;
            pre = q;
        }
        pre.right = head;
        head.left = pre;
        return head;
    }

    //中序遍历 即可得到排序
    private static void dfs(Node root){
        if (root == null) return;
        if (root.left != null) list.add(root.left);
        list.add(root);
        if (root.right != null) list.add(root.right);
    }
}
