package dfs;

/**
 * medium
 * 105. 从前序与中序遍历序列构造二叉树
 *
 * @author 路飞
 * @create 2021/3/23 11:50
 */
public class BuildTree1 {
    public static void main(String[] args) {

    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return help(preorder,0,preorder.length - 1,inorder,0,inorder.length - 1);
    }

    private TreeNode help(int[] preorder,int l1,int r1,int[] inorder,int l2,int r2){
        if (l1 > r1 || l2 > r2) return null;
        int i = l2;
        while (inorder[i] != preorder[i]){ //在中序数组中去寻找根节点
            i++;
        }
        TreeNode root = new TreeNode(preorder[l1]);
        root.left = help(preorder,l1+1,l1+i-l2,inorder,l2,i-1);
        root.right = help(preorder,l1+i-l2+1,r1,inorder,i+1,r2);
        return root;
    }
}
