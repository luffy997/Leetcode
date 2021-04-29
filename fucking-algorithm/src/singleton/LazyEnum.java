package singleton;

/**
 * 引入枚举
 * @author 路飞
 * @create 2021/4/20 9:31
 */
public class LazyEnum {

    private LazyEnum(){
    }

    public static LazyEnum getInstance(){
        return Lazy.INSTANCE.getInstance();
    }

    private enum Lazy{
        INSTANCE;
        private LazyEnum lazy;

        //JVM保证这个方法只会被调用一次
        Lazy(){ //钩爪方法私有
            lazy = new LazyEnum();
        }

        public LazyEnum getInstance(){
            return lazy;
        }
    }
}
