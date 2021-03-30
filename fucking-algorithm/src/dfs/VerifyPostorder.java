package dfs;

import java.util.Stack;

/**
 * meduim
 * 剑指 Offer 33. 二叉搜索树的后序遍历序列
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。如果是则返回 true，否则返回 false。假设输入的数组的任意两个数字都互不相同。
 * @author 路飞
 * @create 2021/3/24 16:14
 */
public class VerifyPostorder {
    public static void main(String[] args) {
        int[] postorder = {1,6,3,2,5};
        System.out.println(verifyPostorder(postorder));
    }


    public static boolean verifyPostorder(int[] postorder){
        if (postorder.length == 0 ) return false;
        Stack<Integer> stack = new Stack<>();
        int root = Integer.MAX_VALUE;
        for (int i = postorder.length - 1; i >= 0; i --) {
            if (postorder[i] > root) return false;
            while (!stack.isEmpty() && stack.peek() > postorder[i]){
                stack.pop();
            }
            stack.add(postorder[i]);
        }
        return true;
    }
}
