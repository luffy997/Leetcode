package review;

/**
 * 1011. 在 D 天内送达包裹的能力
 * @author 路飞
 * @create 2021/4/27 17:17
 */
public class ShipWithinDays {
    public static void main(String[] args) {

    }
    public int shipWithinDays(int[] weights, int D) {
        int n = weights.length-1;
        int left = 0;
        int right = 0;
        for (int num : weights){
            left = Math.max(left,num);
            right+=num;
        }
        while (left < right){
            int need = 1;
            int cut = 0;
            int mid = left +(right-left)/2;
            for (int i = 0; i <= n; i++) {
                if (cut+weights[i] <= mid){
                    cut+=weights[i];
                }else {
                    need++;
                    cut = weights[i];
                }
            }
            if (need <= D){ //算出来的天数比要求的少，那就说明每天装多了，不到D天就装完l，所以要缩小右边界
                right =mid;
            }else {
                left = mid+1;
            }
        }
        return left;

    }
}
