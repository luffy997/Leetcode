package String;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 1417. 重新格式化字符串
 * 给你一个混合了数字和字母的字符串 s，其中的字母均为小写英文字母。
 *
 * 请你将该字符串重新格式化，使得任意两个相邻字符的类型都不同。也就是说，字母后面应该跟着数字，而数字后面应该跟着字母。
 *
 * 请你返回 重新格式化后 的字符串；如果无法按要求重新格式化，则返回一个 空字符串 。
 *
 * 1 <= s.length <= 500
 * s 仅由小写英文字母和/或数字组成。
 * @author 路飞
 * @create 2021/2/5 17:11
 */
public class Reformat {
    public static void main(String[] args) {
        //大写 65-90
        //小写 97-122
        String s = "x17";
        System.out.println(reformat(s));
    }

    /**
     * 效率很低
     * @param s
     * @return
     */
    public static String reformat(String s){
        LinkedList<Character> letter = new LinkedList<>();
        LinkedList<Character> number = new LinkedList<>();
        StringBuilder result = new StringBuilder();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            //字母
            if (rangeInDefined(Integer.valueOf(chars[i]),65,90) || rangeInDefined(Integer.valueOf(chars[i]),97,122)){
                letter.add(chars[i]);
            }else {
                number.add(chars[i]);
            }
        }
        //写两行 方便阅读
        int letterSize = letter.size();
        int numberSize = number.size();
        if ((letterSize == 1 && number.size() ==0) || (numberSize ==1 && letter.size() ==0)) return s;
        if (letterSize==0 || numberSize==0) return "";
        if (Math.abs(letterSize - numberSize) >=2) return "";
        //字母的个数大于或者等于数字 要先字母开头 然后再数字

        if (letterSize >= numberSize){
            for (int i = 0; i < letterSize + numberSize; i++) {
                if (i % 2 == 0){
                    result.append(letter.pollFirst());
                }else {
                    result.append(number.pollFirst());
                }
            }
        }else {
            //字母的个数小于数字 要先数字开头 然后再字母
            for (int i = 0; i < letterSize + numberSize; i++) {
                if (i % 2 == 0){
                    result.append(number.pollFirst());
                }else {
                    result.append(letter.pollFirst());
                }
            }
        }
        return result.toString();
    }

    //判断在不在范围
    public static boolean rangeInDefined(int current, int min, int max) {
        return Math.max(min, current) == Math.min(current, max);
    }

    /**
     * 一个大佬写的牛逼的代码
     */
    public static String function(String s){
        int num1=0,num2=0;
        char[] chars = s.toCharArray();
        for(char c:chars){
            if(c >= '0'&&c <= '9'){num1++;}
            else{num2++;}
        }//看数字字符比较多还是字母字符比较多
        if( num1-num2<-1 || num1-num2>1){return "";}
        if(num1>num2){
            num1 = 0;num2 = 1;
        }else{
            num1 = 1;num2 = 0;
        }
        for(char c:s.toCharArray()){
            if(c >= '0'&&c <= '9'){chars[num1] = c; num1 += 2;}
            else{chars[num2] = c; num2 += 2;}
        }
        return new String(chars);
    }
    }
