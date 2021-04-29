package singleton;

/**
 * 饿汉式单例
 * @author 路飞
 * @create 2021/4/20 9:24
 */
public class Hungry {

    private Hungry(){

    }
    private static Hungry hungry = new Hungry();

    public static Hungry getInstance() {
        return hungry;
    }
}
