package review;

/**
 * 125. 验证回文串
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 *
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 *
 * @author 路飞
 * @create 2021/4/6 16:10
 */
public class IsPalindrome {
    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        System.out.println(isPalindrome(s));
    }

    public static boolean isPalindrome(String s){
        //去掉空格和其他非字母和数字字符
        String trim = s.trim();
        //转小写
        String s1 = trim.toLowerCase();
        int length = s1.length();
        if (length <= 1) return true;
        System.out.println(s1);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s1.length(); i++) {
            //只要字母和数字
            char c = s1.charAt(i);
            if (isRangeDefined((int) c,97,122) || isRangeDefined((int) c,48,57)){
                sb.append(c);
            }
        }
        int left = 0;
        int right = sb.length() - 1;
        while (left < right){
            if (sb.charAt(left) != sb.charAt(right)){
                return false;
            }
            left++;
            right--;
        }

        return true;
    }

    private static boolean isRangeDefined(int cur,int min,int max){
        return Math.max(cur,min) == Math.min(cur,max);
    }

}
