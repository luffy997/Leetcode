package review;

/**
 * hard
 * 1～n 整数中 1 出现的次数
 * 输入一个整数 n ，求1～n这n个整数的十进制表示中1出现的次数。
 * 例如，输入12，1～12这些整数中包含1 的数字有1、10、11和12，1一共出现了5次。
 * @author 路飞
 * @create 2021/4/13 16:50
 */
public class CountDigitOne {
    public static void main(String[] args) {
        System.out.println(countDigitOne(20));
    }

    public static int countDigitOne(int n){
        int count = 0;
        long i = 1;
        while (n / i !=0){
            long high = n/(10*i);
            long cur = (n/i)%10;
            long low = n - (n/i)*i;
            if (cur == 0){
                count +=high*i;
            }else if (cur == 1){
                count +=high*i+(low+1);
            }else {
                count +=(high+1) * i;
            }
            i *=10;
        }
        return count;
    }
}
