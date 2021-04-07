package review;

/**
 * 521. 最长特殊序列 Ⅰ
 * @author 路飞
 * @create 2021/4/6 11:33
 */
public class FindLUSlength1 {
    public static void main(String[] args) {
        String a = "aba";
        String b = "bdc";
        System.out.println(findLUSLength(a, b));
    }
    public static int findLUSLength(String a,String b){
        if (a.equals(b)) return -1;
        return Math.max(a.length(),b.length());
    }
}
