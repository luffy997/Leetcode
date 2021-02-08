package String;

import java.util.Arrays;

/**
 * 1694. 重新格式化电话号码
 *
 给你一个字符串形式的电话号码 number 。number 由数字、空格 ' '、和破折号 '-' 组成。

 请你按下述方式重新格式化电话号码。

 首先，删除 所有的空格和破折号。
 其次，将数组从左到右 每 3 个一组 分块，直到 剩下 4 个或更少数字。剩下的数字将按下述规定再分块：
 2 个数字：单个含 2 个数字的块。
 3 个数字：单个含 3 个数字的块。
 4 个数字：两个分别含 2 个数字的块。
 最后用破折号将这些块连接起来。注意，重新格式化过程中 不应该 生成仅含 1 个数字的块，并且 最多 生成两个含 2 个数字的块。

 返回格式化后的电话号码。
 *
 * 2 <= number.length <= 100
 * number 由数字和字符 '-' 及 ' ' 组成。
 * number 中至少含 2 个数字。
 * @author 路飞
 * @create 2021/2/7 17:19
 */
public class ReformatNumber {
    public static void main(String[] args) {
        String number = "9964-";
        System.out.println(reformatNumber(number));
    }

    public static String reformatNumber(String number){
       //去掉所有的空格和破折号
        String replace = number.replace(" ", "").replace("-", "");
        int length = replace.length();
        if (length <= 3) return number;
        StringBuilder sb = new StringBuilder(replace);
        StringBuilder result = new StringBuilder();
        if (length == 4){
            return result.append(sb.substring(0,2)).append('-').append(sb.substring(2,4)).toString();
        }
        System.out.println("格式化："+replace);

        int index = 0;
        int count =0;
        //把前面的一部分拼接 剩下的放入sb进行下一步规则的处理
        while (true){
            //先把前三个数字拼接到sb

            if (index ==0){
                result.append(replace.substring(index,index+3)).append('-');
                sb.delete(index,index+3);
                ++count ;
            }
            index +=3;
            if (length -index >4){
                result.append(replace.substring(index,index+3)).append('-');
                sb.delete(0,3);
                ++ count;
            }else {
                break;
            }
        }

        System.out.println(result.toString());
        System.out.println(sb.toString());

        //根据sb的长度，进行拼接
        //2 个数字：单个含 2 个数字的块。
        //3 个数字：单个含 3 个数字的块。
        //4 个数字：两个分别含 2 个数字的块。
        if (sb.length() <=3){
            result.append(sb);
        }else {
            result.append(sb.substring(0,2)).append('-').append(sb.substring(2,4));
        }

       return result.toString();
    }
}
