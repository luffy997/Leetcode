package String;

/**
 * 面试题 01.03. URL化
 * URL化。编写一种方法，将字符串中的空格全部替换为%20。假定该字符串尾部有足够的空间存放新增字符，并且知道字符串的“真实”长度。（注：用Java实现的话，请使用字符数组实现，以便直接在数组上操作。）
 *
 * 字符串长度在 [0, 500000] 范围内。
 *
 * @author 路飞
 * @create 2021/2/8 20:14
 */
public class ReplaceSpaces {
    public static void main(String[] args) {
        String S = "     ";
        System.out.println(replaceSpaces(S, 5));
    }

    public static String replaceSpaces(String S, int length){

        StringBuilder result = new StringBuilder();
        //防止全是空格
        if (S.trim().length() == 0){
            for (int i = 0; i < length; i++) {
                 result.append("%20").toString();
            }
            return result.toString();
        }
//        boolean flag = true; //默认是否加空格
//        if (trim.length() == length){
//            flag = false;
//        }

        for (int i = 0; i < length;) {
            if (S.charAt(i) != ' '){
                result.append(S.charAt(i));
                i++;
            }else {
                result.append("%20");
                i++;
            }
        }
        System.out.println(result.toString());
        return result.toString();
    }
}
