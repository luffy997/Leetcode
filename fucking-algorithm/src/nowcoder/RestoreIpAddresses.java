package nowcoder;

import java.util.ArrayList;

/**
 * IP地址转换
 * @author 路飞
 * @create 2021/4/27 16:16
 */
public class RestoreIpAddresses {
    public static void main(String[] args) {
        String s = "012301";
        System.out.println(restoreIpAddresses(s));
    }

    private static ArrayList<String> res = new ArrayList<>();
    public static ArrayList<String> restoreIpAddresses(String s) {
        if (s.length() == 0)return res;
        dfs(s,0,3);
        return res;
    }
    private static void dfs(String s, int start, int cnt){
        if (cnt == 0){
            String[] split = s.split("\\.");
            if (split.length < 4) return;
            for(String str : split){
                if (str.length()>1 && str.charAt(0) == '0') return;
                if (str.length() >3 ||Integer.parseInt(str) > 255) return;
            }
            res.add(s);
            return;
        }
        int len = s.length();
        if (start >= len)return;
        //一个一个划分
        dfs(s.substring(0,start+1)+"."+s.substring(start+1,len),start+2,cnt-1);
        if (start < len-2)
        dfs(s.substring(0,start+2)+"."+s.substring(start+2,len),start+3,cnt-1);
        if (start < len-3)
        dfs(s.substring(0,start+3)+'.'+s.substring(start+3,len),start+4,cnt-1);
    }
}