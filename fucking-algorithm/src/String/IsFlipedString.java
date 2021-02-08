package String;

/**
 * 面试题 01.09. 字符串轮转
 *
 * 字符串轮转。给定两个字符串s1和s2，请编写代码检查s2是否为s1旋转而成（比如，waterbottle是erbottlewat旋转后的字符串）。
 * 字符串长度在[0, 100000]范围内。
 * 说明:
 *
 * 你能只调用一次检查子串的方法吗？
 *
 * @author 路飞
 * @create 2021/2/8 21:47
 */
public class IsFlipedString {
    public static void main(String[] args) {
        String s1 = "waterbottle";
        String s2 = "erbottlewat";
        System.out.println(isFiledString(s1, s2));
    }

    //效率很低
    public static boolean isFiledString(String s1, String s2){
        if (s1.equals(s2)) return true;
        if (s1.length() != s2.length()) return false;

        StringBuilder sb = new StringBuilder(s1);
        StringBuilder temp = new StringBuilder();
        for (int i = 1; i < s1.length(); i++) {
            temp.append(sb.substring(i,sb.length())).append(sb.substring(0,i));
            if (temp.toString().equals(s2)){
            return true;
            }
            temp.delete(0,temp.length());
        }
        return false;
    }

    //改写
    public static boolean function(String s1,String s2){
        if (s1.length()!=s2.length()) return false;
        String ss = s2+s2;
        return ss.contains(s1);
    }
}
