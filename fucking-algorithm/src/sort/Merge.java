package sort;

import java.util.Arrays;

/**
 * medium
 * 56. 合并区间
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，
 * 并返回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。
 *
 * @author 路飞
 * @create 2021/4/2 9:40
 */
public class Merge {
    public static void main(String[] args) {
        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
        merge(intervals);
        System.out.println("结果");
        CanAttendMeetings.show(intervals);
    }

    /**
     * 和上一题一样，首先对区间按照起始端点进行升序排序，然后逐个
     * 判断当前区间是否与前一个区间重叠，如果不重叠的话将当前区间
     * 直接加入结果集，反之如果重叠的话，就将当前区间与前一个区间进行合并。
     * @param intervals
     */
    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(v1,v2)-> v1[0]-v2[0]);

        int  index = -1;
        int[][] res = new int[intervals.length][2];

        for (int[] tempArray : intervals){
            //没有重合的情况
            //前一个区间的第二个数 小于 后一个区间的第一个数
            //无重叠
            if (index == -1 || res[index][1] < tempArray[0]){
                res[++index] = tempArray;
            }else { //在前一个区间的第二个数和后一个区间的第二个数中找一个较大的
                //来做新区见的第二个数（并集）
                res[index][1] = Math.max(res[index][1],tempArray[1]);
            }
        }
        return Arrays.copyOf(res,index+1);

    }

}
