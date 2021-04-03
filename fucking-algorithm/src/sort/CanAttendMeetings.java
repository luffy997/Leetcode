package sort;

import java.util.Arrays;

/**
 * easy
 * 252. 会议室
 * 给定一个会议时间安排的数组 intervals ，每个会议时间都会包括开始和结束的时间
 * intervals[i] = [starti, endi] ，请你判断一个人是否能够参加这里面的全部会议。
 * @author 路飞
 * @create 2021/4/2 14:28
 */
public class CanAttendMeetings {
    public static void main(String[] args) {
        int[][] intervals = {{0,30},{5,10},{15,20}};
        show(intervals);
        System.out.println();
        show(intervals);
    }

    public static boolean canAttendMeeting(int[][] intervals){
        int length = intervals.length;
        Arrays.sort(intervals,(v1,v2)->v1[0] - v2[0]);
        for (int i = 1; i < length; i++) {
            //前一个会议的结束时间 晚于后一个会议的开始时间 那就冲突了
            if (intervals[i-1][1] > intervals[i][0]) return false;
        }
        return true;
    }

    public static void show(int[][] intervals){
        for (int i = 0; i < intervals.length; i++) {
            for (int j = 0; j < intervals[0].length; j++) {
                System.out.print(intervals[i][j]+" ");
            }
            System.out.println();
        }
    }
}
