package review;

/**
 * 38. 外观数列
 * 给定一个正整数 n ，输出外观数列的第 n 项。
 *
 * 「外观数列」是一个整数序列，从数字 1 开始，序列中的每一项都是对前一项的描述。
 *
 * 你可以将其视作是由递归公式定义的数字字符串序列：
 *
 * countAndSay(1) = "1"
 * countAndSay(n) 是对 countAndSay(n-1) 的描述，然后转换成另一个数字字符串。
 * 前五项如下：
 * @author 路飞
 * @create 2021/4/6 9:44
 */
public class CountAndSay {
    public static void main(String[] args) {
        System.out.println(countAndSay(4));

    }

    public static String countAndSay(int n){
        if (n == 1) return "1";
        String str = countAndSay(n-1);
        StringBuilder ans = new StringBuilder();
        int cnt = 1;
        for (int i = 0; i < str.length(); i++) {
            if (i < str.length()-1 && str.charAt(i) == str.charAt(i+1)){
                cnt++;
            }else {
                ans.append(cnt).append(str.charAt(i));
                cnt=1;
            }
        }
        return ans.toString();



    }
}
