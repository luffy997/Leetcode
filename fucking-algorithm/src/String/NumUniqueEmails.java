package String;

import java.util.HashSet;
import java.util.Set;

/**
 * 929. 独特的电子邮件地址
 * 每封电子邮件都由一个本地名称和一个域名组成，以 @ 符号分隔。
 * <p>
 * 例如，在 alice@leetcode.com中， alice 是本地名称，而 leetcode.com 是域名。
 * <p>
 * 除了小写字母，这些电子邮件还可能包含 '.' 或 '+'。
 * <p>
 * 如果在电子邮件地址的本地名称部分中的某些字符之间添加句点（'.'），则发往那里的邮件将会转发到本地名称中没有点的同一地址。例如，"alice.z@leetcode.com” 和 “alicez@leetcode.com” 会转发到同一电子邮件地址。 （请注意，此规则不适用于域名。）
 * <p>
 * 如果在本地名称中添加加号（'+'），则会忽略第一个加号后面的所有内容。这允许过滤某些电子邮件，例如 m.y+name@email.com 将转发到 my@email.com。 （同样，此规则不适用于域名。）
 * <p>
 * 可以同时使用这两个规则。
 *
 * <P>每封 emails[i] 都包含有且仅有一个 '@' 字符。</P>
 * <p>
 * 给定电子邮件列表 emails，我们会向列表中的每个地址发送一封电子邮件。实际收到邮件的不同地址有多少？
 *
 * @author 路飞
 * @create 2021/2/4 14:54
 */
public class NumUniqueEmails {
    public static void main(String[] args) {
        String[] emails = {"test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"};
        System.out.println(numUniqueEmails(emails));
    }

    public static int numUniqueEmails(String[] emails) {
        //利用hashset存储不同邮箱地址
        Set<String> set = new HashSet<>();
        StringBuilder sbLeft = new StringBuilder();
        StringBuilder sbRight = new StringBuilder();
        StringBuilder temp_one= new StringBuilder();
        StringBuilder temp_two = new StringBuilder();
        StringBuilder result = new StringBuilder();

        char[] charsTemp;
        for (int i = 0; i < emails.length; i++) {
            temp_one.append(emails[i]);
            temp_two.append(emails[i]);
            charsTemp = emails[i].toCharArray();
            //找到@ 进行分割
            int j = 0; //内层指针
            boolean flag = true;
            while (j < charsTemp.length && charsTemp[j] != '@') {
                //直接去掉 .
                if (charsTemp[j] != '.' && charsTemp[j] != '+' && flag){
                    sbLeft.append(charsTemp[j]);
                    ++j;
                }else if (charsTemp[j] == '+'){
                  flag = false;
                    ++j;
                }else {
                    j++;
                }

            }

            sbRight.append(temp_one.delete(0, j ));
            //两种情况 -- 只需要管sbLeft

            set.add(result.append(sbLeft).append(sbRight).toString());

            System.out.println("第"+i+"left："+sbLeft.toString());
            System.out.println("第"+i+"right:"+sbRight.toString());
            //置空
            temp_one.delete(0,temp_one.length());
            temp_two.delete(0,temp_two.length());
            sbRight.delete(0,sbRight.length());
            sbLeft.delete(0,sbLeft.length());
            result.delete(0,result.length());

        }
        return set.size();
    }
}
