package review;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author 路飞
 * @create 2021/4/15 16:59
 */
public class MaxQueue {
    public static void main(String[] args) {
        MaxQueue maxQueue = new MaxQueue();
        System.out.println(maxQueue.max_value());
        System.out.println(maxQueue.pop_front());
        maxQueue.push_back(1);
        maxQueue.push_back(2);
        maxQueue.push_back(5);
        System.out.println(maxQueue.pop_front());
        System.out.println(maxQueue.max_value());

    }


    private LinkedList<Integer> queue; //存数据
    private LinkedList<Integer> help; //始终存最大的
    public MaxQueue() {
        queue = new LinkedList<>();
        help = new LinkedList<>();
    }

    public int max_value() {
        return queue.isEmpty()? -1 : help.poll();
    }

    public void push_back(int value) {
        queue.add(value);
        while (!help.isEmpty() && value > help.peekLast()){
            help.pollLast(); //更新help里最大的值
        }
        help.add(value);
    }

    public int pop_front() {
        if (queue.isEmpty()){
            return -1;
        }
        int val = queue.peek();
        if (help.peek() == val){
            help.pop();
        }
        return val;
    }
}


