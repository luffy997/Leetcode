package sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * medium
 * 剑指 Offer 45. 把数组排成最小的数
 * 输入一个非负整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * 0 < nums.length <= 100
 *
 * @author 路飞
 * @create 2021/3/23 10:14
 */
public class MinNumber {
    public static void main(String[] args) {
        int[] nums = {3, 30, 34, 5, 9};
        System.out.println(minNumber(nums));
    }

/*    public static String minNumber(int[] nums){
        if (nums.length == 0) return " ";
        StringBuilder sb = new StringBuilder();
        List<Integer> list = new ArrayList<>();
        for(int num : nums){
            int temp = 1;
            while (num != 0){
                temp = num % 10;
                list.add(temp);
                num /=10;
            }
        }
        int[] resArray = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            resArray[i] = list.get(i);
        }


        //1.先排序
        //2.有0就依次放到第二高位上
        quickSort(resArray,0,resArray.length -1);
        int countZero = 0;
        for(int num : resArray){
            if (num != 0){
                break;
            }
            countZero ++;
        }

        //最高位 加入最小的非零数字
        //再加出现的所有0
        //最后再依次加入排序的数字
        sb.append(resArray[countZero]);
        for (int i = 0; i < countZero; i++) {
            sb.append(0);
        }
        for (int i = countZero+1;i < resArray.length;i++){
              sb.append(resArray[i]);
        }
        return sb.toString();
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
    }*/

    public static String minNumber(int[] nums) {
        if (nums == null || nums.length == 0) return null;

        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strs[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(strs,(str1,str2)->{
            if (str1.charAt(0) == str2.charAt(0)){
                return (str1+str2).compareTo(str2+str1);
            }else {
                return str1.charAt(0) - str2.charAt(0);
            }
        });

        StringBuilder sb = new StringBuilder();
        for(String str : strs){
            sb.append(str);
        }
        return sb.toString();
    }
}
