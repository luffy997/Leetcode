package sort;

import java.util.Arrays;

/**
 * easy
 * 剑指 Offer 40. 最小的k个数
 * 输入整数数组 arr ，找出其中最小的 k 个数。例如，
 * 输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
 *
 * @author 路飞
 * @create 2021/3/23 9:51
 */
public class GetLeastNumbers {
    public static void main(String[] args) {
        int[] arr = {0,0,1,2,4,2,2,3,1,4};
        System.out.println(Arrays.toString(getLeastNumbers(arr, 8)));
    }

    /**
     * 快排
     * @param arr
     * @param k
     * @return
     */
    public static int[] getLeastNumbers(int[] arr,int k){
        if (arr.length == 0 || k == 0) return new int[0];
        quickSort(arr,0,arr.length - 1);
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    private static void quickSort(int[] array,int start,int end){
        if (end <= start){
            return;
        }else {
            int sigin = (start + end) / 2;
            int temp = array[end];
            array[end] = array[sigin];
            array[sigin] = temp;
            int j = start;
            for (int i = start; i <= end - 1; i++) {
                if (array[i] < array[end]){
                    temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                    j = j+1;
                }
            }
            temp = array[j];
            array[j] = array[end];
            array[end]=temp;
            quickSort(array,start,j);
            quickSort(array,j+1,end);
        }
    }
}
