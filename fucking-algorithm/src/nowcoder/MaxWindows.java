package nowcoder;

import java.util.*;

/**
 * @author 路飞
 * @create 2021/4/28 20:42
 */
public class MaxWindows {
    public static void main(String[] args) {
        int[] num = {2,3,4,2,6,2,5,1};
        System.out.println(maxInWindows(num, 3));
    }
    public static ArrayList<Integer> maxInWindows(int [] num, int size) {
        //整个dp吧
        //窗口的个数为num.length -size+1;
        if(num.length < size || size == 0)return new ArrayList<Integer>();
        ArrayList<Integer> res = new ArrayList<>();
        //在前size中找到最大数
        Queue<Integer> queue = new PriorityQueue<>((x,y)->y-x);
        for (int i = 0; i < size; i++) {
            queue.add(num[i]);
        }
        res.add(queue.peek());
        int slow = 0;
        int fast = size;
        for (slow = 0,fast = size; fast< num.length; slow++,fast++) {
            queue.remove(num[slow]);
            queue.add(num[fast]);
            res.add(queue.peek());
        }
        return res;
    }
}
