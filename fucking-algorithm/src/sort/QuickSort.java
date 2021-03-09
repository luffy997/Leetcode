package sort;

import java.util.Arrays;

/**
 * 快速排序
 * @author 路飞
 * @create 2021/2/18 17:18
 */
public class QuickSort {
    public static void main(String[] args) {
//        int[] array = {-9,78,0,23,-567,70};
//        quickSort(array,0,array.length - 1);
        int[] array = new int[800000];
        for (int i = 0; i < 800000; i++) {
            array[i] =(int) (Math.random()*80000);
        }
        long start = System.currentTimeMillis();

//        shellSort(array); //6220
        quickSort(array,0,array.length -1); //22ms 158ms

        long end = System.currentTimeMillis();
        System.out.println(end - start); //22ms 141ms
    }

    public static void quickSort(int[] array,int left,int right){
        int l = left;
        int r = right;
        int temp = 0;
        //pivot 中轴
        int pivot = array[(left + right) / 2];

        while (l < r){
            while (array[l] < pivot){
                ++l;
            }
            while (array[r] > pivot){
                --r;
            }
            if (l >= r){
                break;
            }

            temp = array[l];
            array[l] = array[r];
            array[r] = temp;

            if (array[1] == pivot){
                --r;
            }
            if (array[r] == pivot){
                ++l;
            }
        }

        //防止l = r
        if (l == r){
            ++l;
            --r;
        }
        //向左递归
        if (left < r){
            quickSort(array,left,r);
        }
        //向右递归
        if (right > l){
            quickSort(array,l,right);
        }
        //System.out.println(Arrays.toString(array));
    }

}
