package Array;

import java.util.Arrays;

/**
 * medium
 *  把数字翻译成字符串
 * @author 路飞
 * @create 2021/3/7 17:27
 */
public class TranslateNum {
    public static void main(String[] args) {
        System.out.println(Integer.valueOf('a')); //97
        System.out.println(Integer.valueOf('z')); //122
        String s = "122524";
        System.out.println(s.substring(3, 5));
        translateNum(203);

    }

    public static void translateNum(int num){

        String str = String.valueOf(num);
        int length = str.length();
        int[] array = new int[length+1];
        //初始化
        array[0] = 1;
        array[1] = 1;
        for (int i = 2; i <= length;i++ ) {
            if ( str.charAt(i-2)!='0' && rangeInDefined(Integer.parseInt(str.substring(i-2,i)),0,25)){
                array[i] = array[i - 1] + array[i-2];
            }else {
                array[i] = array[i-1];
            }
        }

        System.out.println(Arrays.toString(array));
    }

    //判断在不在范围
    public static boolean rangeInDefined(int current, int min, int max) {
        return Math.max(min, current) == Math.min(current, max);
    }
}
