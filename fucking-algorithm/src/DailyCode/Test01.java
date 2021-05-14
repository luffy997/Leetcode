package DailyCode;

/**
 *
 * 变量的访问权限辨析
 * @author 路飞
 * @create 2021/5/11 9:21
 */
public class Test01 {
    private float f = 1.0f;
    int m = 12;
    static int n = 1;

    public static void main(String[] args) {
        Test01 t = new Test01();
        t.f = 1.0f;
        t.m = 1;
        Test01.n = 1000;
    }


}