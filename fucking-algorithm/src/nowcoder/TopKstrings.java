package nowcoder;

import java.util.*;

/**
 * 出现次数的Topkit
 * @author 路飞
 * @create 2021/4/26 9:43
 */
public class TopKstrings {

    public static void main(String[] args) {
        String[] strings = {"1","10","10","2","12"};
        topKstrings(strings,1);
    }
    public static String[][]  topKstrings (String[] strings, int k) {
        if (k  <= 0) return new String[][]{};
        Map<String, Integer> treeMap = new HashMap<>();
        for (String str : strings){
            Integer count = treeMap.get(str);
            count = count == null ? 1 : ++count;
            treeMap.put(str,count);
        }
        //先比较值是否相等，相同按键升序比较，不等按值降序排列
        ArrayList<Map.Entry<String, Integer>> list = new ArrayList<>(treeMap.entrySet());
        Collections.sort(list,((o1, o2) -> (o1.getValue().compareTo(o2.getValue()) == 0 ? o1.getKey().compareTo(o2.getKey()) : o2.getValue().compareTo(o1.getValue()))
                ));
        String[][] res= new String[k][2];
        for (int i = 0; i < k;i++){
            res[i][0] = list.get(i).getKey();
            res[i][1] = list.get(i).getValue().toString();
        }
        return res;
    }
}
