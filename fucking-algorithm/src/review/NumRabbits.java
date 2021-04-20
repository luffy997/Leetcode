package review;

import java.util.*;

/**
 * 781. 森林中的兔子
 * 森林中，每个兔子都有颜色。其中一些兔子（可能是全部）告诉你还有多少
 * 其他的兔子和自己有相同的颜色。我们将这些回答放在 answers 数组里。
 * 返回森林中兔子的最少数量。
 * @author 路飞
 * @create 2021/4/9 19:30
 */
public class NumRabbits {
    public static void main(String[] args) {
        int[] answers = {1,1,2};
        System.out.println(numRabbits(answers));
    }

    public static int numRabbits(int[] answers){
        int length = answers.length;
        if (length == 0) return 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : answers){
            Integer count = map.get(num);
            count = count == null ? 1 : ++count;
            map.put(num,count);
        }
        int count = 0;
        Set<Integer> keySet = map.keySet();
        for (int key : keySet){
            int val = map.get(key);
            int chu = val/(key+1);
            int yu = val%(key+1);
            if (yu != 0){
                count += chu*(key+1) + key+1;
            }else {
                count += chu*(key+1);
            }
        }
        return count;
    }
}
