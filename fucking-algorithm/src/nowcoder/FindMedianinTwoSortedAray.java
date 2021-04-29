package nowcoder;

/**
 * 给定两个有序数组arr1和arr2，已知两个数组的长度都为N，求两个数组中所有数的上中位数。
 * 上中位数：假设递增序列长度为n，若n为奇数，则上中位数为第n/2+1个数；否则为第n/2个数
 * [要求]
 * 时间复杂度为O(logN)，额外空间复杂度为O(1)
 * @author 路飞
 * @create 2021/4/26 15:00
 */
public class FindMedianinTwoSortedAray {
    public static void main(String[] args) {
        int[] arr1 = {1,2,3,4};
        int[] arr2 = {3,4,5,6};
        System.out.println(findMedianinTwoSortedAray(arr1, arr2));
    }
    public static int findMedianinTwoSortedAray (int[] arr1, int[] arr2) {
        if (arr1.length < 1) return 0;

        int count = 0;
        int i = 0,j = 0;
        int index = 1;
        while (index <= arr1.length){
            if (arr1[i] < arr2[j]){
                count = arr1[i];
                i++;
            }else {
                count = arr2[j];
                j++;
            }
            index++;
        }
        return count;
    }

}
