package sort;

import java.util.Arrays;

/**
 * @author 路飞
 * @create 2021/2/18 20:48
 */
public class Test {
    public static void main(String[] args) {
        int[] array = new int[100000];
        for (int i = 0; i < 100000; i++) {
            array[i] = (int) (Math.random()*100000);
        }
//        int[] array = {2,5,3,6,9,4,500,200,40};
        long start = System.currentTimeMillis();

//        bubble(array);  //所花费时间17411ms
//        select(array); //所花费时间3229ms
//        insert(array); //所花费时间1003ms
//        shell(array);  //所花费时间18ms
        quick(array);  //所花费时间22ms

        long end = System.currentTimeMillis();
        System.out.println("所花费时间"+(end - start) +"ms");



    }

    public static void bubble(int[] array){
        BubbleSort.bubbleSort(array);
    }
    public static void select(int[] array){
        SelectSort.selectSort(array);
    }
    public static void insert(int[] array){
        InsertSort.insertSort(array);
    }
    public static void shell(int[] array){
        ShellSort.shellSort2(array);
    }
    public static void quick(int[] array){
        QuickSort.quickSort(array,0,array.length -1);
    }

}
