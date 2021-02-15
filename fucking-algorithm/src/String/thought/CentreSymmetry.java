package String.thought;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * medium
 * 247.中心对称
 * 中⼼对称数是指⼀个数字在旋转了 180 度之后看起来依旧相同的数字（或者上下颠倒地看）
 * 找到所有⻓度为 n 的中⼼对称数。
 * @author 路飞
 * @create 2021/2/14 21:04
 */
public class CentreSymmetry {
    public static void main(String[] args) {
        System.out.println(centerSymmetry(3, 3));
    }

    /**
     *递归实现
     * @param n
     * @return
     */
    public static List<String> centerSymmetry(int n,int m){

        //1.合法性校验
        if (n < 0 || m < 0 || n > m){
            throw new IllegalArgumentException("非法输入");
        }

        //2.退出递归条件
        if (n == 0) return new ArrayList<String>(Arrays.asList(""));
        if (n == 1) return new ArrayList<String>(Arrays.asList("0","1","8"));

        //3.缩小问题规模
        List<String> list = centerSymmetry(n - 2, m);

        //4.整合结果
        List<String> res = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            String s = list.get(i);
            if( n != m ) res.add("0" + s + "0");
            res.add("1" + s + "1");
            res.add("6" + s + "9");
            res.add("8" + s + "8");
            res.add("9" + s + "6");
        }
        return res;
    }
}
