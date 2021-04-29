package nowcoder;

/**
 * 岛屿的个数
 * @author 路飞
 * @create 2021/4/24 17:39
 */
public class Solve {
    public static void main(String[] args) {
        char[][] gird = {{'1','1','0','0','0'},{'0','1','0','1','1'},{'0','0','0','1','1'},{'0','0','0','0','0'},{'0','0','1','1','1'}};
        System.out.println(solve(gird));
    }

    public static int solve(char[][] grid){
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1'){
                    //如果当前格子是1，岛屿的数量加1
                    res++;
                    //然后通过dfs把当前格子的上下左右4
                    //个位置为1的都要置为0，因为他们是连着
                    //一起的算一个岛屿，
                    dfs(grid,i,j);
                }
            }
        }
        return res;
    }
    //把四周的方格都变成‘1’
    public static void dfs(char[][] grid,int i,int j){
        //边界条件判断，不能越界
        if (i <0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == '0')return;
        //把当前格子置为0，然后再从他的上下左右4个方向继续遍历
        grid[i][j] = '0';
        dfs(grid,i-1,j);
        dfs(grid,i+1,j);
        dfs(grid,i,j+1);
        dfs(grid,i,j-1);
    }
}
