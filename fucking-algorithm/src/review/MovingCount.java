package review;

/**
 * 剑指 Offer 13. 机器人的运动范围
 * @author 路飞
 * @create 2021/4/10 11:01
 */
public class MovingCount {
    public static void main(String[] args) {
        System.out.println(movingCount(3, 1, 0));
    }

    public static int movingCount(int m,int n,int k){
        boolean[][] isVisited = new boolean[m][n];
        return dfs(m,n,0,0,k,isVisited);
    }

    private static int dfs(int m,int n,int i,int j,int k,boolean[][] isVisited){
        if (bitSum(i) + bitSum(j) > k || isVisited[i][j]) return 0;
        isVisited[i][j] = true;
        return 1+dfs(m,n,i,j+1,k,isVisited) + dfs(m,n,i+1,j,k,isVisited);
    }

    private static int bitSum(int n){
        int sum = 0;
        while (n > 0){
            sum += n%10;
            n/=10;
        }
        return sum;
    }
}
