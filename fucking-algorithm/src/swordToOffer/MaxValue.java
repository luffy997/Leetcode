package swordToOffer;

/**
 * @author 路飞
 * @create 2021/4/8 16:47
 */
public class MaxValue {
    public static void main(String[] args) {
        int[][] gird = {{1,3,1},{1,5,1},{4,2,1}};
        System.out.println(maxValue(gird));
    }

    public static int maxValue(int[][] grid){
        int m = grid.length;
        int n = grid[0].length;
        //把第一行进行累加赋值
        for (int i = 1; i < n; i++) {
            grid[0][i] += grid[0][i-1];
        }

        //第一列
        for (int i = 1; i < m; i++) {
            grid[i][0] = grid[i-1][0];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                grid[i][j] += Math.max(grid[i-1][j],grid[i][j-1]);
            }
        }
        return grid[m-1][n-1];
    }
}
