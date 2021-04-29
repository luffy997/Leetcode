package writeExam;

import java.util.Scanner;

/**
 * @author 路飞
 * @create 2021/4/27 19:57
 */
public class M2 {
    public static void main(String[] args) {
        int[][] weight = new int[6][];
        String[] pointsStr = { "V1", "V2", "V3", "V4", "V5"};
        Scanner input = new Scanner(System.in);
        for (int i = 0; i < pointsStr.length; i++) {
            String[]valuesStr = input.nextLine().split(" ");
            int[] values = new int[valuesStr.length];
            for (int j = 0; j < valuesStr.length; j++) {
                values[j] = Integer.parseInt(valuesStr[j]);
            }
            weight[i] = values;
        }
        input.close();
        method(weight, pointsStr);
    }

    public static void method(int[][] weightArray,String[] strArry){
        
    }
}
