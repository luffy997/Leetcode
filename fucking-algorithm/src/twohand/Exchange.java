package twohand;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * 剑指 Offer 21. 调整数组顺序使奇数位于偶数前面
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，
 * 所有偶数位于数组的后半部分。
 * @author 路飞
 * @create 2021/3/9 9:17
 */
public class Exchange {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        //System.out.println(Arrays.toString(exchange(nums)));
        m2(nums);
    }

    /**
     * LinkedList
     * @param nums
     * @return
     */
    public static int[] exchange(int[] nums){
        int length = nums.length;
        if (length <= 1) return nums;
        LinkedList<Integer> list = new LinkedList<>();
        for (int i : nums){
            if (i % 2 ==1){ //奇数
                list.addFirst(i);
            }else {
                list.addLast(i);
            }
        }


        Iterator<Integer> iterator = list.iterator();
        int index = 0;
        while (iterator.hasNext()){
            Integer next = iterator.next();
            nums[index] = next;
            index ++;
        }
        return nums;
    }

    /**
     * 双指针
     * @param nums
     * @return
     */
    public static void m2(int[] nums){
        int length = nums.length;
        //if (length <= 1) return nums;
        int left = 0;
        int right = length - 1;
        int temp = 0;
        while (left< right){
            while (left < right && nums[left] % 2 != 0){ //直到找到偶数
                ++left;
            }
            while (left < right && nums[right] % 2 == 0){ //直到找到奇数
                -- right;
            }
            temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
        }

        System.out.println(Arrays.toString(nums));

    }
}
