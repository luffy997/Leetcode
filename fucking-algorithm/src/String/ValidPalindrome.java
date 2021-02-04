package String;

/**
 * 680. 验证回文字符串 Ⅱ
 * 给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。
 * 注意：字符串只包含从 a-z 的小写字母。字符串的最大长度是50000。
 *
 * @author 路飞
 * @create 2021/1/30 18:27
 */
public class ValidPalindrome {
    public static void main(String[] args) {
        String s = "deeee";
//        String s = "abc";
        System.out.println(function(s));
    }

    /**
     * 双指针 超出时间限制
     *
     * @param s
     * @return
     */
    public static boolean validPalindrome(String s) {
        int length = s.length();

        int left = 0;
        int right = length - 1;
        boolean hasDeleteLeft = false;
        boolean hasDeleteRight = false;
        int lastDeleteLeft = 0;
        int lastDeleteRight = 0;

        while (left < right) {
            //从首尾开始比较
            if (s.charAt(left) == s.charAt(right)) {
                left++;
                right--;

            } else {
                if (hasDeleteLeft && hasDeleteRight) return false;
                else if (hasDeleteLeft || hasDeleteRight) {
                    left = lastDeleteLeft;
                    right = lastDeleteRight;
                }
                if (!hasDeleteLeft && s.charAt(left + 1) == s.charAt(right)) {
                    hasDeleteLeft = true;
                    lastDeleteLeft = left;
                    lastDeleteRight = right;
                    left++;
                } else if (!hasDeleteRight && s.charAt(left) == s.charAt(right - 1)) {
                    hasDeleteLeft = true;
                    lastDeleteLeft = left;
                    lastDeleteRight = right;
                    right--;
                } else {
                    return false;
                }


            }


        }
        return true;

    }

    /**
     * 以"abdda"这个串为例，此时i指向'b'，j指向'd'，发现不对了。
     * 但是有一次删除的机会，我们自己写几个case其实就能发现，
     * 此时子串范围为(i+1, j)或(i, j-1)的俩子串只要有任意一个是回文串，
     * 则结果就是回文串，否则就不是。
     * @param s
     * @return
     */
    public static boolean function(String s){

        int i = 0, j = s.length() - 1;
        while(i < j){
            if(s.charAt(i) != s.charAt(j)){
                return isValid(s, i + 1, j) || isValid(s, i, j - 1);
            }
            i++;
            j--;
        }
        return true;
    }

    public static boolean isValid(String s, int i, int j){
        while(i < j){
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
