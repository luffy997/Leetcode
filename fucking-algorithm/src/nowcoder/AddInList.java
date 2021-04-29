package nowcoder;

import java.util.ArrayList;

/**
 * 两个链表生成相加链表
 * @author 路飞
 * @create 2021/4/22 16:44
 */
public class AddInList {
    public static void main(String[] args) {
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        System.out.println(spiralOrder(matrix));
    }

    public static ArrayList<Integer> spiralOrder(int[][] matrix) {
        int left = 0;
        int right = matrix[0].length-1;
        int top = 0;
        int buttom = matrix.length-1;

        ArrayList<Integer> res = new ArrayList<>();
        while(true){
            for(int i = left;i <= right;i++) res.add(matrix[top][i]);
            if(++top > buttom)break;
            for(int i = top;i <=buttom;i++) res.add(matrix[i][right]);
            if(--right < left)break;
            for(int i = right;i >=left;i--) res.add(matrix[buttom][i]);
            if(--buttom <top)break;
            for(int i = buttom;i>=top;i--) res.add(matrix[i][left]);
            if(++left>right)break;
        }
        return res;
    }
}
