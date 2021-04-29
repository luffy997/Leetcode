package nowcoder;

/**
 * 字符串转整数
 * @author 路飞
 * @create 2021/4/27 10:38
 */
public class StrToNum {
    public static void main(String[] args) {
        String str = "-19232";
        System.out.println(strToNum(str));
    }

    public static int strToNum(String str){
        //if (str == null || str.length() == 0) return 0;
        String s = str.trim();
        char[] arr = s.toCharArray();
        int sigin = 1;
        int index = 0;//有效索引开始位置
        if (arr[0] == '-'){
            sigin = -1;
            index ++;
        }
        if (arr[0] == '+'){
            index ++;
        }

        int res = 0;
        for (int i = index; i < arr.length; i++) {
            if (arr[i] >= '0' && arr[i] <= '9'){
                if (res > Integer.MAX_VALUE/10 || res < Integer.MIN_VALUE/10 && arr[i] >= '7'){
                    if (sigin >0){
                        return Integer.MAX_VALUE;
                    }else {
                        return Integer.MIN_VALUE;
                    }
                }
                res = res*10 + arr[i]-'0';
            }else {
                //数字直接跳出即可
                break;
            }
        }
        return res*sigin;
    }
}
