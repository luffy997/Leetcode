package nowcoder;

/**
 * 反转数字
 * @author 路飞
 * @create 2021/4/27 8:56
 */
public class Reverse {
    public static void main(String[] args) {
        System.out.println(reverse(0));
    }
    public static int reverse(int x){
        //位运算获取长度
        int len = 0;
        int y = x;
        while (x != 0){
            len ++;
            x/=10;
        }
        int res = 0;
        while (len != 0){
            int temp = 1;
            for (int i = 0; i < len-1; i++) {
                temp*=10;
            }
            len--;
            res+=temp*(y%10);
            y/=10;
        }
        return res > Integer.MAX_VALUE || res < Integer.MIN_VALUE ? 0 : res;
    }

}
