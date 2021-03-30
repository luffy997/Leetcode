package Array;

import java.util.Arrays;

/**
 * medium
 * 59. 螺旋矩阵 II
 * 给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。
 * @author 路飞
 * @create 2021/3/23 8:31
 */
public class GenerateMatrix {
    public static void main(String[] args) {
        int[][] ints = generateMatrix(3);
        for(int[] array : ints ){
            for(int num : array){
                System.out.print(num+" ");
            }
            System.out.println();
        }
    }

    public static int[][] generateMatrix(int n){
        if(n == 1) return new int[][]{{1}};
        int[][] res =  new int[n][n];
        int left = 0 ;
        int right = n - 1;
        int top = 0;
        int bottom = n - 1;
        int num = 1;
        int over = n*n;
        while(num <= over){
            for(int i = left;i <= right;i++) res[top][i] = num++;
            top++;
            for(int i = top;i <= bottom;i++) res[i][right]=num++;
            right--;
            for(int i = right;i>=left;i--) res[bottom][i]=num++;
            bottom--;
            for(int i = bottom;i>=top;i--) res[i][left] = num++;
            left++;
        }
        return res;

    }
}
