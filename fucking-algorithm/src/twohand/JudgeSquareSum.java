package twohand;

/**
 * 633. 平方数之和
 * @author 路飞
 * @create 2021/4/28 8:46
 */
public class JudgeSquareSum {
    public static void main(String[] args) {
        System.out.println(judgeSquareSum(4));
    }

    public static boolean judgeSquareSum(int c){
        if (c < 3) return true;
        int right =(int)Math.sqrt(c)+1;
        int left = 0;
        //双指针
        while (left <= right){
            if (right*right+left*left > c){
                right --;
            }else if (right*right+left*left < c){
                left++;
            }else return true;
        }
        return false;
    }
}
