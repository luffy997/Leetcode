package review;

import java.util.Arrays;

/**
 * 手写快排
 * @author 路飞
 * @create 2021/4/13 14:40
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {3,2,1,4,5,0,7};
        quickSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort(int[] arr,int start,int end){
        if (start >= end)return;
        int sign = (start+end)/2;
        //sign 与 end交换
        int temp = arr[sign];
        arr[sign] = arr[end];
        arr[end] = temp;
        int j = start;
        for(int i = start; i< end;i++){
            if(arr[i] < arr[end]){
                temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
                j++;
            }
        }
        temp = arr[j];
        arr[j]=arr[end];
        arr[end]=temp;
        quickSort(arr,start,j);
        quickSort(arr,j+1,end);
    }
}
