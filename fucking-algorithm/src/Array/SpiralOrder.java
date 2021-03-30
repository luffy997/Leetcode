package Array;

import java.util.ArrayList;
import java.util.List;

/**
 * medium
 * 54. 螺旋矩阵
 * 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
 * @author 路飞
 * @create 2021/3/22 19:20
 */
public class SpiralOrder {
    public static void main(String[] args) {
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        System.out.println(sporalOrder(matrix));
    }

    public static List<Integer> sporalOrder(int[][] matrix){
        List<Integer> list = new ArrayList<>();
        if(matrix.length == 0) return list;
        int left = 0;
        int right = matrix[0].length - 1;
        int top = 0;
        int bottom = matrix.length - 1;
        while(true){
            for(int i = left;i <= right;i++) list.add(matrix[top][i]);
            if(++top > bottom ) break;
            for(int i = top;i <= bottom;i++) list.add(matrix[i][right]);
            if(left > --right) break;
            for(int i = right;i>=left;i--) list.add(matrix[bottom][i]);
            if(top > --bottom) break;
            for(int i = bottom;i>=top;i--) list.add(matrix[i][left]);
            if(++left > right) break;
        }
        return list;

    }
}
