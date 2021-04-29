package nowcoder;

/**
 * 进制转换
 * @author 路飞
 * @create 2021/4/26 10:29
 */
public class ToNum {
    public static void main(String[] args) {

    }
    public static String slove(int M,int N){
        String t = "0123456789ABCDEF";
        if (M == 0) return "0";
        StringBuilder sb = new StringBuilder();
        boolean fu = false;
        if (M < 0){ //负数就要先变成整数，最后加个-即可
            fu = true;
            M = -M;
        }
        while (M!=0){
            sb.append(t.charAt(M%N));
            M/=N;
        }
        if (fu) {
            sb.append("-");
        }
        return sb.reverse().toString();
    }
}
