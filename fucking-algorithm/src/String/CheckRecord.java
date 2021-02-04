package String;

import java.util.HashMap;
import java.util.Map;

/**
 * 551. 学生出勤记录 I
 * 给定一个字符串来代表一个学生的出勤记录，这个记录仅包含以下三个字符：
 * <p>
 * 'A' : Absent，缺勤
 * 'L' : Late，迟到
 * 'P' : Present，到场
 * 如果一个学生的出勤记录中不超过一个'A'(缺勤)并且不超过两个连续的'L'(迟到),那么这个学生会被奖赏。
 * <p>
 * 你需要根据这个学生的出勤记录判断他是否会被奖赏。
 *
 * @author 路飞
 * @create 2021/1/30 12:14
 */
public class CheckRecord {
    public static void main(String[] args) {
        String s = "PPALLL";
        System.out.println(checkRecord(s));
        System.out.println(Integer.valueOf('L'));
    }

    public static boolean checkRecord(String s) {
        //利用map存放 A的次数
        Map<Character, Integer> map = new HashMap<>();
        char[] chars = s.toCharArray();
        int length = chars.length;
        for (char c : chars) {
            Integer count = map.get(c);
            count = count == null ? 1 : ++count;
            map.put(c, count);
        }


        //如果A  >1  直接false
        if (map.get('A') != null &&  map.get('A') > 1) {
            return false;
        } else {
            //L 不能连续3次及以上出现
            int i = 0;
            while (i < length -2) {
                if (chars[i] == 'L' && chars[i+1] == 'L' && chars[i+2] == 'L'){
                    return false;
                }
                i++;
            }
        }
        return true;
    }
}

