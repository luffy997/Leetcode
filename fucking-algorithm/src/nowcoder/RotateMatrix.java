package nowcoder;

/**
 * 顺时针旋转矩阵
 * @author 路飞
 * @create 2021/4/27 15:45
 */
public class RotateMatrix {
    public static void main(String[] args) {

    }
    public static int[][] rotateMatrix(int[][] mat,int n){
        if (n < 2) return mat;
        //中线对折
        for (int i = 0; i < n - 1; i++) {
            for (int j = i+1; j < n; j++) {
                mat[i][j] ^=mat[j][j];
                mat[j][i] ^=mat[i][j];
                mat[i][j] ^=mat[j][j];
            }
        }

        //先左右对折
        int left = 0;
        int right = n -1;
        for (int i = 0; i < n/2; i++){
            while(left < right){
                mat[i][left]^=mat[0][right];
                mat[0][right]^=mat[0][left];
                mat[0][left]^=mat[0][right];
                left++;
                right--;
            }
        }
       return  mat;
    }
}
