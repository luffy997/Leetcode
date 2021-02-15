package String.thought;

/**
 * Recursion
 * 递归问题的实践 ---- Hano
 * 递归写法结构总结：
 * function fn(n){
 *  //第一步：判断输入或者状态是否非法？
 *  if（input/state is invalid）{
 *      return;
 *  }
 *  //第二步：判断递归是否应当结束？
 *  if（match condition）{
 *      return some value;
 *  }
 *
 *  //第三步:缩小问题规模
 *  result1 =fn(n1);
 *  result2 =fn(n2);
 * ......
 *
 * //第四步：整合结果
 * return combine(result1,result2)
 * }
 *
 * @author 路飞
 * @create 2021/2/14 20:40
 */
public class Hano {
    public static void main(String[] args) {
        hano('A','B','C',3);
    }

    public static void hano(char A , char B , char C , int n){
        if (n > 0){
            hano(A , C, B,n -1);
            System.out.println(A + "->" + C);
            hano(B, A, C , n - 1);
        }
    }
}
