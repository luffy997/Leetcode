package String;

/**
 * 415. 字符串相加
 * num1 和num2 的长度都小于 5100
 * num1 和num2 都只包含数字 0-9
 * num1 和num2 都不包含任何前导零
 * 你不能使用任何內建 BigInteger 库， 也不能直接将输入的字符串转换为整数形式
 *
 * 这个很重要，模拟进位操作，若位数不一样，就用0补全
 * 还可以延申到二进制相加！！！
 *
 * @author 路飞
 * @create 2021/1/29
 */
public class AddStrings {
    public static void main(String[] args) {
        String num1 = "15511";
        String num2 = "2";
        String string = function(num1, num2);
        System.out.println(string);
        char a = '2';
        char b = '0';
        System.out.println(a);
    }

    public static String addString(String num1, String num2) {
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int add = 0;
        StringBuffer ans = new StringBuffer();
        while (i >= 0 || j >= 0 || add != 0) {
            int x = i >= 0 ? num1.charAt(i) - '0' : 0;
            int y = j >= 0 ? num2.charAt(j) - '0' : 0;
            int result = x + y + add;
            ans.append(result % 10);
            add = result / 10; //迭代
            i--;
            j--;
        }
        // 计算完以后的答案需要翻转过来
        return ans.reverse().toString();
    }

    /**
     * 自己写
     * @param num1
     * @param num2
     * @return
     */
    public static String function(String num1, String num2){
       int i = num1.length() -1 ;
       int j = num2.length() -1 ;
       int add = 0;
        StringBuilder sb = new StringBuilder();
        while (i>=0 || j>=0 || add!=0){
           int x = i>=0 ? num1.charAt(i) - '0' : 0;
           int y = j>=0 ? num2.charAt(j) - '0' : 0;
           int result = x+y+add;
           sb.append(result % 10);
           add = result / 10;
           i--;
           j--;

       }
        return sb.reverse().toString();
    }
}
