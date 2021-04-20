package review;

/**
 * 240. 搜索二维矩阵 II
 * 编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target 。该矩阵具有以下特性：
 *
 * 每行的元素从左到右升序排列。
 * 每列的元素从上到下升序排列。
 * @author 路飞
 * @create 2021/4/9 20:18
 */
public class SearchMatrix {

    public static void main(String[] args) {
        int[] nums = {1,2,3,10,18};
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
            if (matrix == null || matrix.length == 0) return false;
            int m = 0; //控制上下的
            int n = matrix[0].length-1; //控制左右
            while (m <matrix.length && n >=0){
                if (matrix[m][n] == target){
                    return true;
                }else if (matrix[m][n] > target){
                    n--;
                }else {
                    m++;
                }
            }
            return false;
        }
}
