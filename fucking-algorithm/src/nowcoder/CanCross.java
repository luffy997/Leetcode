package nowcoder;

/**
 * 403. 青蛙过河
 * 一只青蛙想要过河。 假定河流被等分为若干个单元格，并且在每一个单元格内都有可能放有一块石子（也有可能没有）。 青蛙可以跳上石子，但是不可以跳入水中。
 * 给你石子的位置列表 stones（用单元格序号 升序 表示）， 请判定青蛙能否成功过河（即能否在最后一步跳至最后一块石子上）。
 * 开始时， 青蛙默认已站在第一块石子上，并可以假定它第一步只能跳跃一个单位（即只能从单元格 1 跳至单元格 2 ）。
 * 如果青蛙上一步跳跃了 k 个单位，那么它接下来的跳跃距离只能选择为 k - 1、k 或 k + 1 个单位。 另请注意，青蛙只能向前方（终点的方向）跳跃。
 * @author 路飞
 * @create 2021/4/29 14:54
 */
public class CanCross {
    public static void main(String[] args) {

    }

    public static boolean canCross(int[] stones) {
        int n = stones.length;
        if (stones[1] != 1) return false;
        boolean[][] dp = new boolean[n][n];
        dp[1][1] = true;
        for (int i = 2; i < n; i++) {
            for (int j = 1; j < i; j++) {
                int k = stones[i] - stones[j];
                if (k <= j+1){
                    dp[i][k] = dp[j][k-1] || dp[j][k] || dp[j][k+1];
                }
            }
        }
        for (int i = 1; i < n; i++) {
            if (dp[n-1][i]) return true;
        }
        return false;
    }
}
