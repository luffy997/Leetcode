package String;

import java.util.Arrays;

/**
 * 1507. 转变日期格式
 * <p>
 * 给你一个字符串 date ，它的格式为 Day Month Year ，其中：
 * <p>
 * Day 是集合 {"1st", "2nd", "3rd", "4th", ..., "30th", "31st"} 中的一个元素。
 * Month 是集合 {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"} 中的一个元素。
 * Year 的范围在 ​[1900, 2100] 之间。
 * 请你将字符串转变为 YYYY-MM-DD 的格式，其中：
 * <p>
 * YYYY 表示 4 位的年份。
 * MM 表示 2 位的月份。
 * DD 表示 2 位的天数。
 *
 * @author 路飞
 * @create 2021/2/6 15:43
 */
public class ReformatDate {
    public static void main(String[] args) {
        String date = "22nd Apr 2023";
        System.out.println(reformateDate(date));
    }

    public static String reformateDate(String date) {
        //进行字符串拆分
        String[] split = date.split("\\s+");
        StringBuilder result = new StringBuilder();
        StringBuilder sb = new StringBuilder();
        char[] chars;
        int index = 0;
        String[] monthArray = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        //第一个是号数
        while (true){
            chars = split[0].toCharArray();
            if (rangeInDefined(Integer.valueOf(chars[index]),48,57)) {
                sb.append(chars[index]);
                ++index;
            }else {
                break;
            }
        }
       if (sb.length() ==1) sb.append('0').reverse();

        result.append(sb.reverse()).append('-');
        //sb置空
        sb.delete(0,sb.length());

        //第二个是月份

        for (int j = 0; j < monthArray.length; j++) {
            if (monthArray[j].equals(split[1])){
                ++j;
               sb.append(j);
                if (sb.length() ==1) sb.append('0').reverse();
                result.append(sb.reverse()).append('-');
            }
        }
        sb.delete(0,sb.length());
        sb.append(split[2]).reverse();
       return result.append(sb).reverse().toString();


    }
    //判断在不在范围
    public static boolean rangeInDefined(int current, int min, int max) {
        return Math.max(min, current) == Math.min(current, max);
    }
}
