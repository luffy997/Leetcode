package String;


import java.util.*;

/**
 * @author 路飞
 * @create 2021/1/27
 */
public class Test {
    public static void main(String[] args) {
//        Stack<Integer> stack = new Stack<>();
//        stack.push(1);
//        stack.push(2);
//        System.out.println(stack);
//        char c = ')';
//        System.out.println(Integer.valueOf(c));
//        StringBuilder sb = new StringBuilder();
//        sb.append('1');
//        sb.append('2');
//        sb.append('3');
//        sb.append('4');
//        sb.delete(0,1);
//        System.out.println(sb.toString());
//        String s = "  d 3 d    ";
//        System.out.println(s.trim().length());
//        System.out.println((char) 97);
//        String s = "abcadf";
//        int[] bucket = new int[26];
//        char[] charArray = s.toCharArray();
//        //把s中的字符分别放到对应的桶中
//        for (char c : charArray) {
//            System.out.println(c-'a');
//            bucket[c - 'a']++;
//            System.out.println(Arrays.toString(bucket));
//        }

//        Random random = new Random();
//        for (int i = 0; i < 100; i++) {
//
//            System.out.println(random.nextInt(122 - 97)+97);
//        }

//        System.out.println(1 % 2);

        String s = "hellohello";
        System.out.println(s.substring(0, 3));
//        StringBuilder sbOne = new StringBuilder("abcabc");
//        StringBuilder sbTwo = new StringBuilder("abc");
//        System.out.println(sbOne.indexOf(sbTwo.toString()));
//        System.out.println(sbOne.substring(3, 6).toString());
//        String s = "aaabaaaabaaabaaaabaaaabaaaabaaaaba";
//        System.out.println(s.length());
//        System.out.println(Integer.valueOf('3'));
//        System.out.println(Integer.valueOf('4'));
//        List<Character> list = new ArrayList<>();
//        list.add('a');
//        list.add('a');
//        list.add('b');
//        Iterator<Character> iterator = list.iterator();
//        while (iterator.hasNext()) {
//            char c = iterator.next();
//            if (c == 'a') {
//                iterator.remove();
//                break;
//            }
//        }
//        System.out.println(list);

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append('a');
        stringBuilder.append('b');
        stringBuilder.append('a');
        System.out.println(stringBuilder.equals(stringBuilder.reverse().toString()));

    }
}
