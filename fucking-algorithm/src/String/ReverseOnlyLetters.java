package String;

import java.util.*;

/**
 * @author 路飞
 * @create 2021/2/4 11:11
 */
public class ReverseOnlyLetters {
    public static void main(String[] args) {
        //65-90
        //97-122
        String S = "ab-cd";
        reverseOnlyLetters(S);
    }

    public static String reverseOnlyLetters(String S){
        //取出所有字母
        StringBuilder sb = new StringBuilder();
        Map<Integer, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < S.length(); i++) {
            //判断是不是字母
            char c = S.charAt(i);
            if (rangeInDefined(c,65,90) || rangeInDefined(c,97,122)){
                sb.append(c);
            }else {
            //利用map 记录非字母的索引
                map.put(i,i);
            }
        }
        //反转sb
        sb.reverse();
        //map最快的遍历方式
        Set<Map.Entry<Integer, Integer>> entrySet = map.entrySet();
        Iterator<Map.Entry<Integer, Integer>> iter = entrySet.iterator();
        int tempKey = 0;
        int tempValue = 0;
        while (iter.hasNext())
        {
            Map.Entry<Integer, Integer> entry = iter.next();
          tempKey =  entry.getKey();
         tempValue = entry.getValue();
         sb.insert(tempKey,S.charAt(tempValue));

        }
            return sb.toString();

    }


    //判断在不在范围
    public static boolean rangeInDefined(int current, int min, int max) {
        return Math.max(min, current) == Math.min(current, max);
    }
}
