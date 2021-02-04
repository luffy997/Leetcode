package String;

/**
 * 459. 重复的子字符串
 * 给定一个非空的字符串，判断它是否可以由它的<P>一个子串重复多次构成</P>。
 * 定的字符串只含有小写英文字母，并且长度不超过10000。
 * @author 路飞
 * @create 2021/1/29 20:51
 */
public class RepeatedSubstringPattern {
    public static void main(String[] args) {

        String s = "abac";
        System.out.println(repeatedSubstringPattern(s));
    }

    /**
     * 双指针 m没成功
     * 假设字符串有n个子串构成,则拼接后的子串为2n个,掐头去尾后为2n-2个,
     * 如果此时的字符串至少包含一个原字符串,则说明至少包含n个子串,则2n-2>=n,n>=2.
     * 则说明该字符串是周期性结构,最少由两个子串构成.如果一个都不包含,即不包含n个子串,
     * 则说明2n-2<n,n<2,即n为1,也就是不符合周期性结构.
     * @param s
     */
    public static boolean repeatedSubstringPattern(String s) {

//        int start = 0;
//        int end = 0;
//
//        for (int i = 0; i < s.length(); i++) {
//            if (s.charAt(end) != s.charAt(start) || i ==0){
//                end ++;
//
//            }else {
//                start ++;
//                end ++;
//            }
//
//            if (end == s.length()-1 && (s.length() - (start+1)) != end ){
//                return true ;
//            }
//        }
//        return false;
//
//    }
        String str = s + s;
        return str.substring(1, str.length() - 1).contains(s);
    }

}
