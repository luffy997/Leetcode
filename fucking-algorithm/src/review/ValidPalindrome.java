package review;

/**
 * 680. 验证回文字符串 Ⅱ
 * 给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。
 * @author 路飞
 * @create 2021/4/6 15:53
 */
public class ValidPalindrome {
    public static void main(String[] args) {
        System.out.println(validPalindrome("abc"));
    }

    public static boolean validPalindrome(String s){
        int length = s.length();
        if (length <=1) return true;
        int left = 0;
        int right = length - 1;
        while (left < right){
            if (s.charAt(left) != s.charAt(right)){
                return isPanLindrome(s.substring(left,right)) || isPanLindrome(s.substring(left+1,right+1));
            }
            left++;
            right--;
        }
        return true;
    }

    public static boolean isPanLindrome(String s){
        int length = s.length();
        int left = 0;
        int right = length -1;
        while(left < right){
            if (s.charAt(left) != s.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }
}
