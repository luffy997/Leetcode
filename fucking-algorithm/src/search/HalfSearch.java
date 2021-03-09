package search;

import java.util.Arrays;

/**
 * 二分查找
 * 在有序表中进行
 * @author 路飞
 * @create 2021/2/19 9:45
 */
public class HalfSearch {
    public static void main(String[] args) {

            int[] a = new int[10000000];
            for (int i = 0; i < 10000000; i++) {
                a[i] = (int)(Math.random()*100000);
            }
            Arrays.sort(a);
            int temp = a[536];
            if (halfSearchRecursion(a,0,a.length -1,temp) != halfSearchNoRecursion(a,temp)){
                System.out.println("错误");
            }
        }


    /**
     * 递归实现
     * @param a
     * @param left
     * @param right
     * @param target
     * @return
     */
    public static int halfSearchRecursion(int[] a ,int left,int right,int target){
        int mid = left + (right - left) / 2; //防止整型溢出
        int midValue = a[mid];
        if (left <= right){
            if (midValue > target){
                return halfSearchRecursion(a,left,mid-1,target);
            }else if (midValue < target){
                return halfSearchRecursion(a,mid+1,right,target);
            }else {
                return mid;
            }
        }
        return -1;
    }

    /**
     * 非递归实现
     * @param a
     * @param target
     */
    public static int halfSearchNoRecursion(int[] a,int target){
        int i = 0;
        int j = a.length - 1;
        while (i <= j){
            int mid = i + (j - i) / 2;
            int midValue = a[mid];
            if (midValue > target){
                j = mid -1;
            }else if (midValue < target){
                i = mid + 1;
            }else {
                return mid;
            }
        }
        return -1;
    }


    public static int binarySearch(int[] a,int left,int right,int target){
        int mid = left + (right -left) /2;
        int midValue = a[mid];
        while (left <= right){
            if (midValue < target){
                binarySearch(a,mid + 1,right,target);
            }else if (midValue > target){
                binarySearch(a,left,mid -1,target);
            }else {
                return mid;
            }
        }
        return -1;
    }


}
