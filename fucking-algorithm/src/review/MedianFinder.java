package review;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * hard
 * 剑指 Offer 41. 数据流中的中位数
 * 如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
 * 例如，
 * [2,3,4] 的中位数是 3
 * [2,3] 的中位数是 (2 + 3) / 2 = 2.5
 * 设计一个支持以下两种操作的数据结构：
 * @author 路飞
 * @create 2021/4/13 15:17
 */
public class MedianFinder {
    public static void main(String[] args) {
        Median median = new Median();
        median.addNum(5);
        median.addNum(2);
        median.addNum(4);
        median.addNum(3);
        median.addNum(7);
        median.addNum(6);
        System.out.println(median.A);
        System.out.println(median.B);
        System.out.println(median.findMedian());


    }
}
class Median{
    Queue<Integer> A,B;
    public Median() {
        A = new PriorityQueue<>(); //小顶堆 存储较大的一部分
        B = new PriorityQueue<>((x,y)->(y-x)); //大顶堆 存储较小的一半
    }

    public void addNum(int num){
        if (A.size() != B.size()){
            A.add(num);
            B.add(A.poll());
        }else {
            B.add(num);
            A.add(B.poll());
        }
    }
    public double findMedian(){
        return A.size() != B.size() ? A.peek() : (A.peek() + B.peek()) / 2.0;
    }
}
