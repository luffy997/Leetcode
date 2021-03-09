package sort;

import java.util.Arrays;
import java.util.Random;


/**
 * 冒泡排序
 * @author 路飞
 * @create 2021/2/18 10:20
 */
public class BubbleSort {
    public static void main(String[] args) {
        //int[] array = {4,6,9,1,8,10,2};
        for (int j = 0; j < 100; j++) {
            int[] array = generateArray(100);
            int[] temp = new int[100];
            for (int i = 0; i < array.length; i++) {
                temp[i] = array[i];
            }



            Arrays.sort(array);
            Arrays.equals(array,bubbleSort(temp));


           if (!Arrays.equals(array, temp)){
               System.out.println(Arrays.toString(array));
               System.out.println(Arrays.toString(temp));
               System.out.println("错误");
               System.out.println();
           }
        }

    }

    public static int[] bubbleSort(int[] array){
        int temp = 0;
        boolean flag = false;
        for (int i = 0; i < array.length - 1 ; i++) {
            for (int j = 0; j < array.length -1 -i  ; j++) {
                if (array[j] > array[j+1]){
                     temp = array[j];
                     array[j] = array[j+1];
                     array[j+1] = temp;
                    flag = true;
                }
            }
            if (!flag) {
                break;
            }else {
                flag = false;
            }
        }
        return array;
    }

    //随机生成n个数
    public static int[] generateArray(int n){
        int[] array = new int[n];
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            array[i] = (int)(Math.random()*100);
        }
        return array;
    }
}
