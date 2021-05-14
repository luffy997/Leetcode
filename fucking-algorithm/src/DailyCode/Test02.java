package DailyCode;

/**
 * 静态域：用staitc声明，jvm加载类时执行，仅执行一次
 * 构造代码块：类中直接用{}定义，每一次创建对象时执行。
 * 执行顺序优先级：静态域,main(),构造代码块,构造方法。
 * 1 静态域 ：首先执行，第一个静态域是一个静态变量 public static Test t1 = new Test(); 创建了Test 对象，
 * 会执行构造块代码，所以输出blockA。然后执行第二个静态域（即静态代码块）输出blockB。
 * 2 main():Test t2 = new Test()执行，创建Test类对象，只会执行构造代码块（创建对象时执行），输出blockA。
 * 3 构造代码块只会在创建对象时执行，没创建任何对象了，所以没输出
 * 4 构造函数：使用默认构造函数，没任何输出
 * @author 路飞
 * @create 2021/5/11 9:26
 */
public class Test02 {
    private static Test02 t1 = new Test02();
    {
        System.out.println("blockA");
    }
    static {
        System.out.println("blockB");
    }

    /**
     * (1) 父类静态对象和静态代码块
     * (2) 子类静态对象和静态代码块
     * (3) 父类非静态对象和非静态代码块
     * (4) 父类构造函数
     * (5) 子类 非静态对象和非静态代码块
     * (6) 子类构造函数
     * @param args
     */
    public static void main(String[] args) {
        Test02 t2 = new Test02();
    }
}
