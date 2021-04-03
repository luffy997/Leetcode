package Array;

/**
 * medium
 * 48. 旋转图像
 * 给定一个 n × n 的二维矩阵 matrix 表示一个图像。请你将图像顺时针旋转 90 度。
 * 你必须在 原地 旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要 使用另一个矩阵来旋转图像。
 * matrix.length == n
 * matrix[i].length == n
 * 1 <= n <= 20
 * -1000 <= matrix[i][j] <= 1000
 *
 * @author 路飞
 * @create 2021/3/31 10:21
 */
public class Rotate {
    public static void main(String[] args) {
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        rotate(matrix);
    }

    /**
     * 先对角线翻折
     * 再水平翻折
     * @param matrix
     */
    public static void rotate(int[][] matrix){
        int length = matrix.length;
        if (length == 0) return ;
        
        //对角线翻折
        for (int i = 0; i < length-1; i++) {
            for (int j = i+1; j < length; j++) {
                matrix[i][j] ^= matrix[j][i];
                matrix[j][i] ^=matrix[i][j];
                matrix[i][j] ^=matrix[j][i];
            }
        }

        //左右对折 行不变，列变
        int mid = length >> 1;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < mid; j++) {
                matrix[i][j] ^=matrix[i][length-1-j];
                matrix[i][length-1-j] ^=matrix[i][j];
                matrix[i][j] ^=matrix[i][length-1-j];
            }
        }
    }
}
