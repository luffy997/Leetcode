package review;

/**
 * 541. 反转字符串 II
 * @author 路飞
 * @create 2021/4/6 14:25
 */
public class ReverseStr {
    public static void main(String[] args) {
        String s ="abcdefg" ;
        System.out.println(s.length());
        int k = 3;
        System.out.println(reverseStr(s, k));
    }

    public static String reverseStr(String s,int k){
        int length = s.length();
        if (length == 1 || k == 1) return s;
        StringBuilder sb = null;
        StringBuilder res = new StringBuilder();
        int i = 0;
        for (i = 0; i +2*k < length; i +=2*k) {
            sb = new StringBuilder(s.substring(i, i+k));
            res.append(sb.reverse());
            res.append(s.substring(i+k,i+2*k));
            sb.delete(0,sb.length());
        }
        //1.判断剩下的是否小于k，小于k就全部反转
        //2，不小于k 就反转k，其他不变
        System.out.println(i);
        if (length - i < k){
            sb = new StringBuilder(s.substring(i,length));
            res.append(sb.reverse());
        }else {
            sb = new StringBuilder(s.substring(i,i+k));
            res.append(sb.reverse()).append(s.substring(i+k,length));
        }
        return res.toString();
    }
}
