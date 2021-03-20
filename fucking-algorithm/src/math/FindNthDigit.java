package math;

/**
 * medium
 * 剑指 Offer 44. 数字序列中某一位的数字
 * 数字以0123456789101112131415…的格式序列化到一个字符序列中。在这个序列中，第5位（从下标0开始计数）是5，第13位是1，第19位是4，等等。
 * 请写一个函数，求任意第n位对应的数字。
 *
 * @author 路飞
 * @create 2021/3/20 16:56
 */
public class FindNthDigit {
    public static void main(String[] args) {
        findNthDight(12);
    }

    public static void findNthDight(int n){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <=Integer.MAX_VALUE;i++){
            sb.append(i);
        }
        System.out.println(sb.charAt(n));
    }
}
