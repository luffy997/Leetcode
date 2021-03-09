package Array;

/**
 * medium
 * 礼物的最大价值
 *
 *在一个 m*n 的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于 0）。
 *你可以从棋盘的左上角开始拿格子里的礼物，并每次向右或者向下移动一格、直到到达
 *棋盘的右下角。给定一个棋盘及其上面的礼物的价值，请计算你最多能拿到多少价值的
 *礼物？
 * @create 2021/3/8 11:07
 */
public class MaxValue {
    public static void main(String[] args) {
        int[][] gird = {{1,2,5},{3,2,1}};
        System.out.println(maxValue(gird));
    }

    //dp
    //拆解子问题
    //只能向左和向下
    public static int maxValue(int[][] grid){

        //记录结果
        //左上角开始
        int m = grid.length;
        int n = grid[0].length;

        //一排 一竖
        if (m == 1 ||  n == 1){
            int res = 0;
            for (int[] temp : grid){
                for (int i : temp){
                    res +=i;
                }
            }
            return res;
        }

        //2*2
        if (m == 2 && n == 2){
            int res = grid[0][0] + grid[m-1][n-1];
            int tempRight = grid[0][1];
            int tempDown = grid[1][0];

            if (tempRight >= tempDown){
                res = tempRight + res;

            }else {
                res = tempDown + res;

            }
            return res;

        }

        int res = grid[0][0] + grid[m-1][n-1];
        int right = 1;
        int down = 1;

        int i = 0;
        int j = 0;
        while (i <n  && j < m){
            int tempRight = grid[i][right];
            int tempDown = grid[down][j];

            if (tempRight >= tempDown){
                res = tempRight + res;
                ++i;
            }else {
                res = tempDown + res;
                ++j;
            }

            if (m != n){
                while ( i == n-1 && j != m -1 ){
                    res = grid[m +1] [i];
                    ++j;
                }
                while ( j == m-1 && i != n -1 ){
                    res = grid[i] [j+1];
                    ++i;
                }
            }

        }
        return res;

    }
}
