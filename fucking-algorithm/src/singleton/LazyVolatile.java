package singleton;

/**
 * volatile+sync+双重检测
 * @author 路飞
 * @create 2021/4/20 9:29
 */
public class LazyVolatile {

    public LazyVolatile() {
    }

    private static volatile LazyVolatile lazy;

    public static LazyVolatile getInstance() {
        if (lazy == null) {
            synchronized (LazyVolatile.class) {
                if (lazy == null) {
                    return new LazyVolatile();
                }
            }
        }
        return lazy;
    }
}
