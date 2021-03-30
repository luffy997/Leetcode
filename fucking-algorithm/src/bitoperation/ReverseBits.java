package bitoperation;

/**easy
 * 190. 颠倒二进制位
 * @author 路飞
 * @create 2021/3/29 14:38
 */
public class ReverseBits {
    public static void main(String[] args) {
        System.out.println(resverseBit(10));
    }
    public static int resverseBit(int n){
        int res = 0;
        int count = 32;
        while(count != 0 ){
            res = res << 1;
            res = res+(n&1);
            n = n >>> 1;
            count--;
        }
        return res;
    }
}
