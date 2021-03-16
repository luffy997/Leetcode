package dfs;

/**
 * medium
 * 剑指 Offer 13. 机器人的运动范围
 * 地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？
 *
 * @author 路飞
 * @create 2021/3/15 15:01
 */
public class MovingCount {
    public static void main(String[] args) {
        int m = 2;
        int n = 3;
        int k = 1;
        System.out.println(movingCount(2, 3, 1));
    }

    public static int movingCount (int m,int n,int k){
        boolean[][] visisted = new boolean[m][n];
        return dfs(visisted,m,n,k,0,0);
    }


    private static int dfs(boolean[][] visited,int m,int n ,int k,int i,int j ){
        if (i >= m || j >=n || visited[i][j] || bitSum(i) + bitSum(j) > k ) return 0;
        visited[i][j] = true;
        return 1+dfs(visited,m,n,k,i+1,j) +dfs(visited,m,n,k,i,j+1);
    }

    private static int bitSum(int n ){
        int sum = 0;
        while ( n > 0){
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }
}
