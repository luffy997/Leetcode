package String;

/**
 * 606. 根据二叉树创建字符串
 * 你需要采用前序遍历的方式，将一个二叉树转换成一个由括号和整数组成的字符串。
 * <p>
 * 空节点则用一对空括号 "()" 表示。而且你需要省略所有不影响字符串与原始二叉树之间的一对一映射关系的空括号对。
 * 题目的描述是生怕让你看懂，有位老哥在评论区写清楚了
 * <p>
 * 子节点需要用()来包裹。举例来说，二叉树[root,left,right]，
 * 则转换为root(left)(right)。如果只有left为空节点，则输出root()(right)；
 * 如果只有right为空节点则可以忽略右节点的()，输出为root(left)。
 *
 * @author 路飞
 * @create 2021/1/30 17:07
 */
public class Tree2str {
    public static void main(String[] args) {
        TreeNode tree = new TreeNode(1);
        tree.left.val = 2;
        tree.right.val = 3;
        tree.left.val = 4;
        System.out.println(tree2str(tree));
    }

    /**
     * 前序遍历 递归
     * 1.左子树和右子树都没有
     * 2.只有左子树，右子树为空
     * 3.左子树为空，只有右子树
     * 4.左右子树都有。 其中 3和4一类处理。2比较特殊。
     *
     * @param t
     * @return
     */
    public static String tree2str(TreeNode t) {
        //递归第一步 ： 递归终止条件
        if (t == null) {
            return "";
        }
        //1.只有根节点
        if (t.left == null && t.right == null) {
            return t.val + "";
        }
        //2.只有左子树，右子树为空
        if (t.right == null) {
            return t.val + "(" + tree2str(t.left) + ")";
        }

        return t.val + "(" + tree2str(t.left) + ")(" + tree2str(t.right) + ")";

    }
}
