package String;

import java.util.HashSet;
import java.util.Set;

/**
 * 1496. 判断路径是否相交
 * 给你一个字符串 path，其中 path[i] 的值可以是 'N'、'S'、'E' 或者 'W'，分别表示向北、向南、向东、向西移动一个单位。
 *
 * 机器人从二维平面上的原点 (0, 0) 处开始出发，按 path 所指示的路径行走。
 *
 * 如果路径在任何位置上出现相交的情况，也就是走到之前已经走过的位置，请返回 True ；否则，返回 False 。
 *
 * @author 路飞
 * @create 2021/2/6 11:40
 */
public class IsPathCrossing {
    public static void main(String[] args) {
    String path = "NESWW";
    System.out.println(isPathCrossing(path));
    }

    public static boolean isPathCrossing(String path){
        char[] chars = path.toCharArray();
        Set<String> set = new HashSet<>();


        //如果为null 或者为空 直接返回false
        if (path.length() ==0 || path.equals(" ")) return false;

        //初始值
        int vertical = 0;
        int level = 0;
        //把原点加入set
        set.add("0,0");

        for (char c : chars){
            switch (c){
                case 'N':
                    vertical++;
                    break;
                case 'S':
                    vertical--;
                    break;
                case 'E':
                    level++;
                    break;
                case 'W':
                    level-- ;
                    break;
            }
        //如果添加失败(已经走过的坐标),则返回true;
            if (!set.add(level + "," +vertical)) {
                return true;
            }
        }
        return false;
    }
}
