package String;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 925. 长按键入
 * 你的朋友正在使用键盘输入他的名字 name。偶尔，在键入字符 c 时，按键可能会被长按，而字符可能被输入 1 次或多次。
 * <p>
 * 你将会检查键盘输入的字符 typed。如果它对应的可能是你的朋友的名字（其中一些字符可能被长按），那么就返回 True。
 * name.length <= 1000
 * typed.length <= 1000
 * name 和 typed 的字符都是小写字母。
 *
 * @author 路飞
 * @create 2021/2/4 11:52
 */
public class IsLongPressedName {
    public static void main(String[] args) {
        String name = "alex";
        String typed = "aaleexa";
        System.out.println(isLongPressedName(name, typed));
        System.out.println(function(name, typed));
    }

    /**
     * 双指针 --第一感觉
     *
     * @param name
     * @param typed
     */
    public static boolean isLongPressedName(String name, String typed) {

        int i = 0;
        int j = 0;
        while (i < typed.length() ) {
            if (i < name.length() && name.charAt(i) == typed.charAt(j)){
                //两个字符串存在一对匹配的字符，此时将 i,ji,j 都加 11。
                i++;
                j++;
            }else if (j > 0 && typed.charAt(j) == typed.charAt(j -1)){
               // 存在一次长按键入
                j++;
            }else {
                return false;
            }
        }
        //如果i = name.length,说明name的值都被匹配到了
        return i == name.length();
    }

    //手写
    public static boolean function(String name, String typed){
        int i = 0;
        int j = 0;
        while (j < typed.length()){
            if (i < name.length() && name.charAt(i) == typed.charAt(j)){
                i++;
                j++;
            }else if (j>0 && typed.charAt(j) == typed.charAt(j-1)){
                j++;
            }else {
                return false;
            }
        }
        return i == name.length();
    }
}
