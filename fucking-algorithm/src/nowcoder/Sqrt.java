package nowcoder;

/**
 * 平方根
 * @author 路飞
 * @create 2021/4/23 16:40
 */
public class Sqrt {
    public static void main(String[] args) {
        System.out.println(sqrt(16));
    }

    public static int sqrt(int x){
        int i = 1;
        int res = 0;
        while (x >=0){
            x -= i;
            res++;
            i +=2;
        }
        return res - 1;
    }
}
