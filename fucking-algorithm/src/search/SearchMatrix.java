package search;

import java.util.Arrays;

/**
 * medium
 * 74. 搜索二维矩阵
 * 编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
 *
 * 每行中的整数从左到右按升序排列。
 * 每行的第一个整数大于前一行的最后一个整数。
 *
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 100
 * -104 <= matrix[i][j], target <= 104
 *
 * @author 路飞
 * @create 2021/3/30 15:06
 */
public class SearchMatrix {
    public static void main(String[] args) {
        int[][] nums = {{1},{3}};
        System.out.println(searchMatrix(nums, 3));
    }

    public static boolean searchMatrix(int[][] matrix, int target) {



        //特判
        int m = matrix.length;
        int n = matrix[0].length;
        if (m == 1){
            int temp =  binarySearch(matrix[0],target,0,n-1);
            return temp != -1;
        }
        //m很小
        //这里偷下懒，直接遍历
        //当m很大，那就需要二分查找，定区间
        int i = 1;
        for (i = 1; i < m; i++) {
            if (matrix[i-1][0] == target) return true;
            if (matrix[i][0] > target && matrix[i-1][0] < target) break;
        }


        int res = binarySearch(matrix[i-1], target, 0, n - 1);
        return res != -1;

    }

    private static int binarySearch(int[] num, int target, int left, int right) {
        if (left > right) {
            return -1;
        }
        int mid = (left + right) / 2;
        int midVal = num[mid];
        if (target < midVal) {
            return binarySearch(num, target, left, mid - 1); //向左递归
        } else if (target > midVal) { //向右递归
            return binarySearch(num, target, mid + 1, right);
        } else {
            return mid;
        }
    }
}
