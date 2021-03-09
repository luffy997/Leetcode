package sort;



/**
 * 插入排序
 * @author 路飞
 * @create 2021/2/18 11:43
 */
public class InsertSort {
    public static void main(String[] args) {
        int[] array = new int[80000];
        for (int i = 0; i < 80000; i++) {
            array[i] =(int) (Math.random()*80000);
        }
        long start = System.currentTimeMillis();
        insertSort(array);
        long end = System.currentTimeMillis();
        System.out.println((end - start) / 1000);
    }
    public static int[] insertSort(int[] array){

        //待插入的数
        int insertVal = array[1];
        int insertIndex = 1 -1; //即arr[1] 的前面这个数的下标

        for (int i = 1; i < array.length ; i++) {
            insertVal = array[i];
            insertIndex = i -1; //即arr[1] 的前面这个数的下标

            //insertIndex >=0 不越界
            //insertVal < array[insertIndex] 说明insertVal比有序数组中的任意数都要小（因为array[insertIndex]就是最大的）
            //现在需要找到insertVal合适的位置即可
            //若不满足，拿insertVal比有序数组最大的都大  直接放在有序数组的最后面
            while (insertIndex >=0 && insertVal < array[insertIndex]){ //插入到有序数组中
                array[insertIndex + 1] = array[insertIndex];
                insertIndex -- ; //找到待插入数合适的位置
            }
            array[insertIndex + 1] = insertVal;
          //  System.out.println("第"+i+"轮："+ Arrays.toString(array));
        }
        return array;

    }
}
