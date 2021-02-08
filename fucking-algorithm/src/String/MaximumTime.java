package String;

/**
 * 1736. 替换隐藏数字得到的最晚时间
 * 给你一个字符串 time ，格式为 hh:mm（小时：分钟），其中某几位数字被隐藏（用 ? 表示）。
 *
 * 有效的时间为 00:00 到 23:59 之间的所有时间，包括 00:00 和 23:59 。
 *
 * 替换 time 中隐藏的数字，返回你可以得到的最晚有效时间。
 *
 * time 的格式为 hh:mm
 * 题目数据保证你可以由输入的字符串生成有效的时间
 *
 * @author 路飞
 * @create 2021/2/8 17:51
 */
public class MaximumTime {
    public static void main(String[] args) {
        String time = "00:01";
        System.out.println(maximumTime(time));
    }

    public static String maximumTime(String time){
        StringBuilder sb = new StringBuilder(time);
        StringBuilder result = new StringBuilder();

        //首先拼接hh
        //1.？h   -> h<=3 ?=2 h>4 ?=1
        //2.h？  -> h=1 ?=9  h=2 ?=3
        //3.？？23

        //两个问号 直接变成23
        if (sb.substring(0,2).toString().equals("??")) {
            result.append("23:");
        }else {
            if (sb.charAt(0) == '?'){
                if (sb.charAt(1) <= 51){
                    result.append('2').append(sb.charAt(1)).append(':');
                }else {
                    result.append('1').append(sb.charAt(1)).append(':');
                }
            }else if (sb.charAt(1) == '?'){
                if (sb.charAt(0) == '2'){
                    result.append('2').append('3').append(':');
                }else if (sb.charAt(0) == '1'){
                    result.append('1').append('9').append(':');
                }else {  //第一个h为0
                    result.append('0').append('9').append(':');
                }
            }else {
                result.append(sb.substring(0,2)).append(':');
            }
        }


        if (sb.substring(3,5).toString().equals("??")) return result.append("59").toString();

        if (sb.charAt(3) == '?'){
             result.append('5').append(sb.charAt(4)).toString();
        }else if (sb.charAt(4) == '?'){
             result.append(sb.charAt(3)).append('9').toString();
        }else {
            result.append(sb.substring(3,5));
        }

        return result.toString();
    }
}
