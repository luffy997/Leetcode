package sort;

import java.util.Arrays;

/**
 * medium
 * 57. 插入区间
 * 给你一个 无重叠的 ，按照区间起始端点排序的区间列表。
 * 在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。
 * @author 路飞
 * @create 2021/4/2 15:13
 */
public class Insert {
    public static void main(String[] args) {
        int[][] intervals = {{1,3},{6,9}};
        int[] newInterval = {2,5};
        insert(intervals,newInterval);
    }

    public static int[][] insert(int[][] intervals, int[] newInterval){
        //因为给定的列表已经有序 所以就不需要排序了

        int[][] res = new int [intervals.length+1][2];
        int index = 0;
        int i = 0;
        while (i < intervals.length && intervals[i][1] < newInterval[0]){
            res[index ++] = intervals[i++];
        }
        //发现待插入区间的第二个结束位置大于或等于新区见的开始数，就退出循环，i就应插入的区间开始位置
        CanAttendMeetings.show(res);
        //有可能存在重叠区间，重叠区间就合并
        while (i < intervals.length && intervals[i][0] <= newInterval[1]){
            newInterval[0] = Math.min(intervals[i][0],newInterval[0]);
            newInterval[1] = Math.max(intervals[i][1],newInterval[1]);
            i++;
        }
        res[index++] = newInterval;
        //剩余的区间加入结果集
        while (i < intervals.length){
            res[index++] = intervals[i++];
        }
        return Arrays.copyOf(res,index);
    }
}
