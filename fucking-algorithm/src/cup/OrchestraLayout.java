package cup;

/**
 * @author 路飞
 * @create 2021/4/5 15:34
 */
public class OrchestraLayout {
    public static void main(String[] args) {
        System.out.println(orchestraLayout(100, 29, 34));
    }
    public static int orchestraLayout(int num, int xPos, int yPos) {
        if(num == 1) return 0;
        int[][] ints = generateMatrix(num);

        return ints[xPos][yPos] == 0 ? 9 : ints[xPos][yPos];

    }

    public static  int[][] generateMatrix(int n){
        int[][] res =  new int[n][n];
        int left = 0 ;
        int right = n - 1;
        int top = 0;
        int bottom = n - 1;
        int num = 1;
        int over = n*n;
        while(num <= over){
            for(int i = left;i <= right;i++) res[top][i] = num++%9;
            top++;
            for(int i = top;i <= bottom;i++) res[i][right]=num++%9;
            right--;
            for(int i = right;i>=left;i--) res[bottom][i]=num++%9;
            bottom--;
            for(int i = bottom;i>=top;i--) res[i][left] = num++%9;
            left++;
        }
        return res;

    }
}
