package bitoperation;

/**
 * 1.判断奇偶
 *
 * @author 路飞
 * @create 2021/3/15 14:45
 */
public class Demo_1 {
    public static void main(String[] args) {

        for (int i = 0; i < 100; i++) {
            if ((i & 1) == 0){
                System.out.println(i);
            }
        }
    }
}
