package String;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 937. 重新排列日志文件
 *对于每条日志，其第一个字为字母与数字混合的 标识符 ，除标识符之外的所有字为这一条日志的 内容 。
 *
 * 除标识符之外，所有字均由小写字母组成的，称为 字母日志
 * 除标识符之外，所有字均由数字组成的，称为 数字日志
 * 题目所用数据保证每个日志在其标识符后面至少有一个字。
 *
 * 请按下述规则将日志重新排序：
 *
 * 所有 字母日志 都排在 数字日志 之前。
 * 字母日志 在内容不同时，忽略标识符后，按内容字母顺序排序；在内容相同时，按标识符排序；
 * 数字日志 应该按原来的顺序排列。
 * 返回日志的最终顺序。
 *
 * @author 路飞
 * @create 2021/2/4 16:11
 */
public class ReorderLogFiles {
    public static void main(String[] args) {

    }

    /**
     * 将字母日志和数字日志分开，分别放入两个list中
     * 使用自定义排序对字母日志按要求排序，数字日志顺序不变
     * 将二者合并并返回
     * @param logs
     * @return
     */
    public static String[] reorderLogFiles(String[] logs){

        List<String> letterLogs = new ArrayList<>();
        List<String> numLogs = new ArrayList<>();
        // 将字母日志和数字日志分开，分别放入两个list
        for (String log : logs) {
            int i = log.indexOf(" ") + 1;
            if (log.charAt(i) >= '0' && log.charAt(i) <= '9')
                numLogs.add(log);
            else
                letterLogs.add(log);
        }
        Collections.sort(letterLogs, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                // 取字母a日志的标识符及内容
                int ai = a.indexOf(" ");
                String ida = a.substring(0, ai);
                String loga = a.substring(ai + 1);

                // 取字母b日志的标识符及内容
                int bi = b.indexOf(" ");
                String idb = b.substring(0, bi);
                String logb = b.substring(bi + 1);

                // 对比二者内容，如果相同则对比标识符
                int cmp = loga.compareTo(logb);
                if (cmp == 0)
                    return ida.compareTo(idb);
                return cmp;
            }
        });
        letterLogs.addAll(numLogs);
        return letterLogs.toArray(new String[letterLogs.size()]);
    }
}
