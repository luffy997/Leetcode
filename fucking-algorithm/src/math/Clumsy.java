package math;

import java.util.*;

/**
 * medium
 * 1006. 笨阶乘
 * 通常，正整数 n 的阶乘是所有小于或等于 n 的正整数的乘积。例如，factorial(10) = 10 * 9 * 8 * 7 * 6 * 5 * 4 * 3 * 2 * 1。
 * 相反，我们设计了一个笨阶乘 clumsy：在整数的递减序列中，我们以一个固定顺序的操作符序列来依次替换原有的乘法操作符：乘法(*)，除法(/)，加法(+)和减法(-)。
 * 例如，clumsy(10) = 10 * 9 / 8 + 7 - 6 * 5 / 4 + 3 - 2 * 1。然而，这些运算仍然使用通常的算术运算顺序：我们在任何加、减步骤之前执行所有的乘法和除法步骤，并且按从左到右处理乘法和除法步骤。
 * 另外，我们使用的除法是地板除法（floor division），所以 10 * 9 / 8 等于 11。这保证结果是一个整数。
 * 实现上面定义的笨函数：给定一个整数 N，它返回 N 的笨阶乘。
 *
 * 提升：
 * 1 <= N <= 10000
 * -2^31 <= answer <= 2^31 - 1  （答案保证符合 32 位整数。）
 *
 * @author 路飞
 * @create 2021/4/1 16:40
 */
public class Clumsy {
    public static void main(String[] args) {
        System.out.println(m2(10));
    }


    //这个解法没有处理优先级的问题
//    public static void clumsy(int N){
//        Stack<Integer> stack = new Stack<>();
//        //先把数字全部放入栈 4 3 2 1
//        int temp = N;
//        for (int i = 1; i < N; i++) {
//            stack.push(i);
//        }
//        System.out.println(stack);
//        int index = 0;
//        int res = N;
//        while (!stack.isEmpty()){
//            if (index % 4 == 0){
//                res *=stack.pop();
//                index ++;
//            } else if (index % 4 == 1){
//                res /=stack.pop();
//                index ++;
//            }else if (index % 4 == 2){
//                res +=stack.pop();
//                index++;
//            }else {
//                res -=stack.pop();
//                index++;
//            }
//        }
//        System.out.println(res);
//    }



    public static int m2(int N){
        Stack<Integer> stack = new Stack<>();
        stack.push(N);
        N--;
        int count = 0;
        while (N > 0){
            if (count % 4 == 0) stack.push(stack.pop()*N); //乘法优先级高 可以直接计算
            else if (count % 4 ==1) stack.push(stack.pop()/N); //除法优先级高，可以直接计算
            else if (count % 4 ==2) stack.push(N); //加减法优先级都不高，需要放入栈里，任人宰割
            else stack.push(-N); //减法直接取反，存入栈里，这样做最后的类加操作就只需要加就行了
            count++;
            N--;
        }

        int res = 0;
        //此时任人宰割的加减法
        while (!stack.isEmpty()) res += stack.pop();

        return res;
    }
}
