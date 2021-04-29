package writeExam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author 路飞
 * @create 2021/4/27 17:42
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String[] str1 = s.split(" ");
        int[]weight = new int[str1.length];
        for (int i = 0; i < str1.length; i++) {
            weight[i] = Integer.parseInt(str1[i]);
        }
        int maxLoad = Integer.parseInt(br.readLine());
        int count = countLeastBoat(weight, maxLoad);
        System.out.println(count);
    }
    //一行一行读取数组
    public static void readArray() {
        Scanner sc = new Scanner(System.in);
        int[] arr = null;
        while (sc.hasNextLine()) {
            String[] s = sc.nextLine().split(" ");
            int len = s.length;
            arr = new int[len];
            for (int i = 0; i < len; i++) {
                arr[i] = Integer.parseInt(s[i]);
            }
            System.out.println(Arrays.toString(arr));
        }
    }

    //一行一行读取数字
    public static void readNumber(){
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int i = sc.nextInt();
            System.out.println(i);
        }
    }

    public static int countLeastBoat(int[] weights,int maxLoad){
        if(weights == null || weights.length == 0)return  0;
        Arrays.sort(weights);
        int n = weights.length;
        int need = 0;
        int left = 0;
        int right = n-1;
        while (left < right){
            if (weights[left] + weights[right] <= maxLoad){
                need++;
                left ++;
                right --;
            }else {
                need++;
                right--;
            }
        }
        if (weights[right+1] + weights[left] > maxLoad) return ++need;
        return need;
    }

}
