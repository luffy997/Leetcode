package alibaba;

import java.util.Scanner;

/**
 * @author 路飞
 * @create 2021/4/19 11:21
 */
public class Main{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
    }

    public static void m1(int n,int k){
        if (n >= k) System.out.println(n-k+1);
        else {
            int a = k % n;
            System.out.println(n-a+1);
        }
    }
}
