package bitoperation;

/**
 * 2.交换两数
 * @author 路飞
 * @create 2021/3/15 14:50
 */
public class Demo_2 {
    public static void main(String[] args) {
        int a = 100;
        int b = 1;

        a = a^b;

//        a ^= b;
//        b ^= a;
//        a ^= b;
        System.out.println(a);
        System.out.println(b);

    }
}
