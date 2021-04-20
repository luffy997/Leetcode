package review;

/**
 * 551. 学生出勤记录 I
 * @author 路飞
 * @create 2021/4/7 18:00
 */
public class CheckRecord {
    public static void main(String[] args) {
        String s = "PPALLL";
        System.out.println(checkRecord(s));
    }

    public static boolean checkRecord(String s){
        char[] chars = s.toCharArray();
        int countA = 0;
        int countL = 0;
        char c = ' ';
        for (int i = 0; i < chars.length; i++) {
            c = s.charAt(i);
            if (c == 'A'){
                countA ++;
            }else if (i+2 <=chars.length-1 && c == 'L'){
                if (chars[i+1] == 'L' && chars[i+2] == 'L') return false;
            }
            if (countA ==2) return false;
        }
        return true;
    }
}
