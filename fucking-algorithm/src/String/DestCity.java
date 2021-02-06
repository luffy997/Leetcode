package String;

import java.util.*;

/**
 * 1436. 旅行终点站
 * 给你一份旅游线路图，该线路图中的旅行线路用数组 paths 表示，其中 paths[i] = [cityAi, cityBi] 表示该线路将会从 cityAi 直接前往 cityBi 。请你找出这次旅行的终点站，即没有任何可以通往其他城市的线路的城市。
 *
 * 题目数据保证线路图会形成一条不存在循环的线路，因此只会有一个旅行终点站。
 *
 * @author 路飞
 * @create 2021/2/5 19:31
 */
public class DestCity {
    public static void main(String[] args) {
        List<String> inlist1 = new ArrayList<>();
        List<String> inlist2 = new ArrayList<>();
        List<String> inlist3 = new ArrayList<>();
        List<List<String>> outlist = new ArrayList<>();
        inlist1.add("B");
        inlist1.add("C");
        inlist2.add("D");
        inlist2.add("B");
        inlist3.add("C");
        inlist3.add("A");
        outlist.add(inlist1);
        outlist.add(inlist2);
        outlist.add(inlist3);
        System.out.println(outlist);
        System.out.println(function(outlist));
    }

    public static String destCity(List<List<String>> paths){
        Map<String, Integer> countMap = new HashMap<>();
        Map<String, Integer> indexMap = new HashMap<>();

        for (List<String> list : paths){
            for (String str : list){
                Integer count = countMap.get(str);
                count = count == null? 1 : ++count;
                countMap.put(str,count);
                if (list.indexOf(str) == 1) indexMap.put(str,1);
            }
        }
        //遍历countMap 找到次数为1的
        System.out.println(countMap);
        System.out.println(indexMap);
        String[] strings = new String[2];
        Set<Map.Entry<String, Integer>> entrySet = countMap.entrySet();
        Iterator<Map.Entry<String, Integer>> iter = entrySet.iterator();
        int i = 0;
        while (iter.hasNext())
        {
            Map.Entry<String, Integer> entry = iter.next();
            if (entry.getValue() == 1){
                strings[i] = entry.getKey();
                ++i;
            }
        }
        System.out.println(Arrays.toString(strings));

        for (int j = 0; j < indexMap.size(); j++) {
            if (indexMap.get(strings[0]) != null){
                return strings[0];
            }
        }
        return strings[1];
    }

    /**
     * 一位大佬用了一个hashmap，效率超双95%+
     * 利用HashMap存储每个cityA与cityB，cityA当作键，cityB当作值，然后判断hashmap中是否含有key，如果含有
     * 则把key中的value取出来，当作新的key，继续遍历是否含有这个key，如果不含有则代表是终点。
     *
     */

    public static String function(List<List<String>> paths){
        Map<String,String> hashMap = new HashMap<>();
        for (List<String> path : paths) {
            hashMap.put(path.get(0),path.get(1));
        }
        String key = paths.get(0).get(0);
        while(hashMap.containsKey(key)) {
            String value = hashMap.get(key);
            key = value;
        }
        return key;
    }
}
