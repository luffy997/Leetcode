package dfs;

import java.util.HashMap;
import java.util.Map;

/**
 * medium
 * 构建二叉树 方法2
 * @author 路飞
 * @create 2021/3/24 10:35
 */
public class BuildTree2 {
    public static void main(String[] args) {

    }

    private static Map<Integer,Integer> map = new HashMap<>();
    private static int[] preoredr;
    public  TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preoredr = preorder;
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i],i);
        }
        return recur(0,0,preorder.length - 1);

    }

    private static TreeNode recur(int root,int left,int right){
        if (left > right) return null;
        TreeNode node = new TreeNode(preoredr[root]);
        int index = map.get(preoredr[root]);
        //左子树递归
        node.left = recur(index+1,left,index -1);
        //右子树的开始的索引要搞清楚 右子树开始索引 = 根节点 + 左子树 + 1
        node.right = recur(index+(left - root) +1,index+1,right);
        return node;
    }
}
