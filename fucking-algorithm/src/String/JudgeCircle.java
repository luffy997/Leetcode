package String;

import java.util.HashMap;
import java.util.Map;

/**
 * 657. 机器人能否返回原点
 * 在二维平面上，有一个机器人从原点 (0, 0) 开始。给出它的移动顺序，判断这个机器人在完成移动后是否在 (0, 0) 处结束。
 *
 * 移动顺序由字符串表示。字符 move[i] 表示其第 i 次移动。机器人的有效动作有 R（右），L（左），U（上）和 D（下）。
 * 如果机器人在完成所有动作后返回原点，则返回 true。否则，返回 false。
 *
 * 注意：机器人“面朝”的方向无关紧要。 “R” 将始终使机器人向右移动一次，“L” 将始终向左移动等。此外，假设每次移动机器人的移动幅度相同。
 *
 * @author 路飞
 * @create 2021/1/30 17:34
 */
public class JudgeCircle {
    public static void main(String[] args) {
        String s = "RLUURDDDLU";
        System.out.println(function(s));
    }

    /**
     *自己写的  有点问题
     * @param moves
     * @return
     */
    public static boolean judgeCircle(String moves) {

        Map<Character, Integer> map = new HashMap<>();
        char[] chars = moves.toCharArray();
        int length = chars.length;

        //map统计
        for (char c : chars){
            Integer count = map.get(c);
            count = count== null ? 1 : ++count;
            map.put(c,count);
        }

        System.out.println(map);
        //方向的个数是成双成对的
//对于 Integer var = ? 在-128 至 127 之间的赋值，Integer 对象是在 IntegerCache.cache 产生，
//会复用已有对象，这个区间内的 Integer 值可以直接使用==进行判断，但是这个区间之外的所有数据，都
//会在堆上产生，并不会复用已有对象，这是一个大坑，推荐使用 equals 方法进行判断。
        if (!map.get('U').equals(map.get('D'))){
            return false;
        }
        if (!map.get('R').equals(map.get('L'))){
            return false;
        }
        return true;
    }

    /**
     * 本质就是看UDLF是不是成对的  这里与顺序无关
     * @param s
     * @return
     */
    public static boolean function(String s){
        char[] chars = s.toCharArray();
        int x = 0;
        int y = 0;
        for (char c : chars){
            switch (c){
                case 'U': x++; break;
                case 'D': x--; break;
                case 'L': y++; break;
                case 'R': y--; break;
            }
        }
        return x ==0 && y==0;
    }

}
