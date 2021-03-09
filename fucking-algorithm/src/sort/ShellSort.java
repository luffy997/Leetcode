package sort;

import java.util.Arrays;

/**
 * 希尔排序
 * @author 路飞
 * @create 2021/2/18 15:38
 */
public class ShellSort {
    public static void main(String[] args) {
//        int[] array = {8,9,1,7,2,3,5,4,6,0};
        int[] array = new int[800000];
        for (int i = 0; i < 800000; i++) {
           array[i] =(int) (Math.random()*80000);
        }
        long start = System.currentTimeMillis();

//        shellSort(array); //6220
        shellSort2(array); //22ms 158ms

        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }

    /**
     * 交换法
     * @param array
     */
    public static void shellSort(int[] array){
        int length = array.length;
        int temp = 0;
        for (int n = length / 2; n >=1; n/=2) {
            for (int i = n; i < length; i++) {
                for (int j = i -n; j >= 0; j-=n){
                        if (array[j] > array[j+n]){
                            temp = array[j+n];
                            array[j+n] = array[j];
                            array[j] = temp;
                        }
                }
            }
        }
       // System.out.println(Arrays.toString(array));


      /*  for (int i = 2; i < array.length; i++) {
            for (int j = i -2; j >= 0; j-=2){
                if (array[j] > array[j+2]){
                    temp = array[j+2];
                    array[j+2] = array[j];
                    array[j] = temp;
                }
            }
        }
        System.out.println("第二次排序："+Arrays.toString(array));

        for (int i = 1; i < array.length; i++) {
            for (int j = i -1; j >= 0; j-=1){
                if (array[j] > array[j+1]){
                    temp = array[j+1];
                    array[j+1] = array[j];
                    array[j] = temp;
                }
            }
        }
        System.out.println("第三次排序："+Arrays.toString(array));*/
    }

    /**
     * 移位法
     * @param array
     */
    public static void shellSort2(int[] array){
        for (int gap = array.length / 2 ; gap >=1 ; gap /= 2){
            for (int i = gap; i < array.length; i++) {
                int j =i;
                int temp = array[j];
                if (array[j] < array[j - gap]){
                    while (j - gap >=0 && temp < array[j - gap]){
                        array[j] = array[j -gap];
                        j -= gap;
                    }
                    array[j] = temp;
                }
            }
        }
       // System.out.println(Arrays.toString(array));
    }
}
