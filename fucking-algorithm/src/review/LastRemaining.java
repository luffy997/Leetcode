package review;

/**
 * 约瑟夫环
 * @author 路飞
 * @create 2021/4/9 17:38
 */
public class LastRemaining {
    public static void main(String[] args) {
        System.out.println(lastRemaing(5, 3));
    }

    public static int lastRemaing(int m,int n){
        int pos = 0;
        for(int i = 2;i<=m;i++){
            pos = (pos+n)%i;
        }
        return pos;
    }
}
