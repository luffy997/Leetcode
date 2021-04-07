package review;

/**
 * 709. 转换成小写字母
 * 实现函数 ToLowerCase()，该函数接收一个字符串参数 str，并将该字符串中的大写字母转换成小写字母，之后返回新的字符串。
 * @author 路飞
 * @create 2021/4/6 17:54
 */
public class ToLowerCase {
    public static void main(String[] args) {
        String str = "Hello";
        System.out.println(toLowerCase(str));
    }

    public static String toLowerCase(String str){
        int length = str.length();
        if (length == 0) return "";
        StringBuilder res = new StringBuilder();
        for (char c : str.toCharArray()){
            if (isRange(c-0,97,122)){
                res.append(c);
            }else if (isRange(c-0,65,90)){
                res.append((char)(c+32));
            }else {
                res.append(c);
            }
        }
        return res.toString();

    }

    private static boolean isRange(int cur,int min,int max){
        return Math.max(min,cur) == Math.min(cur,max);
    }
}
