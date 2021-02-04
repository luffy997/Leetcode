package String;

/**
 * 541. 反转字符串 II
 * 给定一个字符串 s 和一个整数 k，你需要对从字符串开头算起的每隔 2k 个字符的前 k 个字符进行反转。
 * <p>
 * 如果剩余字符少于 k 个，则将剩余字符全部反转。
 * 如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。
 *
 * @author 路飞
 * @create 2021/1/30 11:16
 */
public class ReverseStr {
    public static void main(String[] args) {
        String s = "123456";
        int k = 2;
        System.out.println(function(s, k));
    }

    /**
     * 双指针
     * 每2k为一组，前k个元素反转，后k个元素保持不变。
     * 前k个元素的标为（i, i + k - 1）,此处需判断是否超出数组范围，反转之后 i = i +2k,
     * 进行下一组的反转。
     *
     * @param s
     * @param k
     * @return
     */
    public static String reverseStr(String s, int k) {
        char[] chars = s.toCharArray();
        int n = chars.length;
        // 每2k个元素为一组进行反转
        for (int i = 0; i < n; i += 2 * k) {
            int left = i;
            int right = (i + k - 1 < n) ? i + k - 1 : n - 1; //判断下标是否越界
            while (left <= right) {
                char temp = chars[left];
                chars[left] = chars[right];
                chars[right] = temp;
                left++;
                right--;
            }
        }
        String str = new String(chars);
        return str;

    }

    public static String function(String s, int k) {
        char[] chars = s.toCharArray();
        int length = s.length();

        for (int i = 0; i < length; i += 2 * k) {
            int left = i;
            int right = (i + k - 1 < length) ? i + k - 1 : length - 1;
            while (left < right) {
                char temp = chars[left];
                chars[left] = chars[right];
                chars[right] = temp;
                left ++;
                right --;  //不然会死循环
            }
        }
        return new String(chars);
    }

}

