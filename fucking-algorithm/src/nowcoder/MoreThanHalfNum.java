package nowcoder;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author 路飞
 * @create 2021/4/26 9:13 */
public class MoreThanHalfNum {


    public static int MoreThanHalfNum_Solution(int [] array) {

        //map
        int n = array.length;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int num : array){
            Integer count = map.get(num);
            count = count == null ? 1 : ++count;
            map.put(num,count);
        }
        Set<Map.Entry<Integer,Integer>> entrySet =map.entrySet();
        for (Map.Entry<Integer, Integer> entry : entrySet) {
            if (entry.getValue() > n / 2) {
                return entry.getKey();
            }
        }
        return 0;
    }
}
