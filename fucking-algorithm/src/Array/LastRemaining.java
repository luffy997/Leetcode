package Array;

import java.util.ArrayList;
import java.util.List;

/**
 * esay
 * 剑指 Offer 62. 圆圈中最后剩下的数字
 * 0,1,···,n-1这n个数字排成一个圆圈，从数字0开始，每次从这个圆圈里删除第m个数字（删除后从下一个数字开始计数）。求出这个圆圈里剩下的最后一个数字。
 * 例如，0、1、2、3、4这5个数字组成一个圆圈，从数字0开始每次删除第3个数字，则删除的前4个数字依次是2、0、4、1，因此最后剩下的数字是3。
 * 约瑟夫环问题
 * @author 路飞
 * @create 2021/3/21 9:17
 */
public class LastRemaining {
    public static void main(String[] args) {
        lastRemain(5,3);
    }

    /**
     *
     * @param n 从0-n-1 排成一个圆圈
     * @param m 从数字0开始，每次从这个圆圈中删除第m个数字，（删除后从下一个数字开始计数）
     * @return 出这个圆圈里剩下的最后一个数字
     */
    public static int lastRemain(int n,int m){
        int pos = 0;
        for (int i = 2; i <= n; i++) {
            pos = (pos+m) % i;
        }
        return pos;
    }
}
