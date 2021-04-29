package nowcoder;

/**
 * 丢棋子
 * @author 路飞
 * @create 2021/4/29 15:25
 */
public class ThrowPiece {
    public static void main(String[] args) {
        System.out.println(throwPiece(105, 2));
    }
    public static int throwPiece(int n,int k){
        if (n < 1 || k < 1){
            return 0;
        }
        if ( k == 1) return n;
        int[][] dp =new int[n+1][k+1];
        for (int i = 1; i < dp.length; i++) {
            dp[i][1] = i;
        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = 2; j <= k; j++) {
                int min = Integer.MAX_VALUE;
                for (int K = 1; K < i+1; ++K) {
                    min = Math.min(min,Math.max(dp[K-1][j-1],dp[i-K][j]));
                }
                dp[i][j] = min + 1;
            }
        }
        return dp[n][k];
    }

    //优化后的dp
    //** Solution Three **
    public int solutionThree(int n, int k){
        if ( n<1 || k<1 )
            return 0;
        if ( k == 1 ) return n;
        int[] preArr = new int[n+1];
        int[] curArr = new int[n+1];
        for(int i=1; i<curArr.length; ++i) {
            curArr[i] = i;
        }
        for(int i=1; i<k; ++i) {
            int[] tmp = preArr;
            preArr = curArr;
            curArr = tmp;
            for(int j=1; j<curArr.length; ++j){
                int min = Integer.MAX_VALUE;
                for(int K=1; K<j+1; ++K) {
                    min = Math.min(min,  Math.max(preArr[K-1], curArr[j-K]));
                }
                curArr[j] = min + 1;
            }
        }
        return curArr[curArr.length-1];
    }

}
