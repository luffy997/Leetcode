package sort;

import java.util.Arrays;

/**
 * 选择排序
 * @author 路飞
 * @create 2021/2/18 11:12
 */
public class SelectSort {
    public static void main(String[] args) {
        int[] array = {34,2,1,101,99};
        selectSort(array);
    }

    public static void selectSort(int[] array){
        //假定第一个是最小
        int minIndex = 0;
        int min = array[0];
        for (int j = 0; j < array.length - 1; j++) { //交换次数 n- 1  与冒泡一样 时间复杂度O(n^2)
            //假定最小的值，其索引为0，遍历数组，找到真正最小的值，交换，然后将0索引后移一位，找到第二小的
             minIndex = j;
             min = array[j];
            for (int i = minIndex +1; i < array.length; i++) {
                if (array[i] < min){
                    minIndex = i;
                    min = array[i];
                }
            }
            //将找到的最小值与假定的最小值进行交换-- 交换排序的核心
            array[minIndex] = array[j];
            array[j] = min;
          //  System.out.println(Arrays.toString(array));
        }
     //   System.out.println("最终-"+Arrays.toString(array));

    }
}
