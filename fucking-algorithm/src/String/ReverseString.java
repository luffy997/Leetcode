package String;

import java.util.Stack;

/**
 * 344. 反转字符串
 * 原地修改输入数组、使用 O(1) 的额外空间解决
 * @author 路飞
 * @create 2021/1/29
 */
public class ReverseString {
    public static void main(String[] args) {
        char[] s = {'h','e','l','l','o','2'};
        change(s);
    }

    public static void reverseString(char[] s) {

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length; i++) {
            stack.push(s [i]);
        }

        for (int i = 0; i < s.length; i++) {
            s[i] = stack.pop();
        }
    }

    /**
     * 双指针
     * 分别从首和尾开始交换
     * @param s
     */
    public static void change(char[] s){
        int left = 0;
        int right =s.length -1;
        for (left =0,right =s.length -1;left <=right;left++,right--){
            char temp = s[left];
             s[left] = s[right];
             s[right] = temp;
        }
    }
}
