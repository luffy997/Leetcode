package greedy;

import java.util.Arrays;

/**
 * easy
 * 1725. 可以形成最大正方形的矩形数目
 * 1 <= rectangles.length <= 1000
 * rectangles[i].length == 2
 * 1 <= li, wi <= 109
 * li != wi
 *
 * @author 路飞
 * @create 2021/3/31 15:33
 */
public class CountGoodRectangles {
    public static void main(String[] args) {
        int[][] rectangles = {{2,3},{3,7},{4,3},{3,7}};
        countGoodRectangles(rectangles);
    }

    public static int countGoodRectangles(int[][] rectangles){
        int length = rectangles.length;
        if (length == 1) return 1;


        int[] minArray = new int[length];

        int i = 0;
        for(int[] temp : rectangles){
            minArray[i] = Math.min(temp[0],temp[1]);
            i++;
        }

        Arrays.sort(minArray);
        //取最大的
        int max = minArray[length-1];
        int count = 0;
        for(int num : minArray){
            if (max <= num) {
                count++;
            }
        }
        return count;


    }
}
