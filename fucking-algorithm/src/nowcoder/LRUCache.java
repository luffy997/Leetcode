package nowcoder;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * LRU缓存设计
 * @author 路飞
 * @create 2021/4/21 16:41
 */
public class LRUCache {
    private Map<Integer,Integer> store;
    private LinkedList<Integer> keys;
    private int capcity;

    public LRUCache(int capcity) {
        this.capcity = capcity;
        this.store = new HashMap<>();
        keys = new LinkedList<>();
    }

    public void set(int key,int value){
        if (keys.size() == capcity){
            store.remove(keys.getFirst());
            keys.removeFirst();
        }
        keys.add(key);
        store.put(key,value);
    }

    public int get(int key){
        if (store.containsKey(key)){
            keys.remove(new Integer(key));
            keys.add(key);
            return store.get(key);
        }else {
            return -1;
        }
    }

    public int[] LRU(int[][] operators,int k){
        LRUCache cache = new LRUCache(k);
        int[] rets =  new int[operators.length];
        int index = 0;
        for(int[] o : operators){
            int opt = o[0];
            if(opt == 1){
                cache.set(o[1],o[2]);
            }else {
                rets[index] = cache.get(o[1]);
                index++;
            }
        }
        return Arrays.copyOfRange(rets,0,index);
    }

    public static void main(String[] args) {
        int k = 3;
        int[][] operators = {{1,1,1},{1,2,2},{1,3,2},{2,1},{1,4,4},{2,2}};
        LRUCache cache = new LRUCache(k);
        System.out.println(Arrays.toString(cache.LRU(operators, k)));
    }
}
