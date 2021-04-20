package review;

/**
 * 剑指 Offer 46. 把数字翻译成字符串
 *
 * @author 路飞
 * @create 2021/4/14 17:46
 */
public class TranslateNum {
    public static void main(String[] args) {
        System.out.println(translateNum(252));
    }

    private static int COUNT = 0;

    public static int translateNum(int num) {
        String s = String.valueOf(num);
        return dfs(s,0);

    }

    private static int dfs(String str, int index) {
        if (index >= str.length() - 1){
            return 1;
        }
        int res = dfs(str,index+1);
        String temp = str.substring(index, index + 2);
        if (temp.compareTo("10") >= 0 && temp.compareTo("25") <=0){
            res += dfs(str,index+1);
        }
        return res;
    }
}
