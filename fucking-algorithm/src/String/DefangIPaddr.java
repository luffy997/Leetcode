package String;

/**
 * 1108. IP 地址无效化
 * 给你一个有效的 IPv4 地址 address，返回这个 IP 地址的无效化版本。
 *
 * 所谓无效化 IP 地址，其实就是用 "[.]" 代替了每个 "."。
 *
 * @author 路飞
 * @create 2021/2/4 21:12
 */
public class DefangIPaddr {
    public static void main(String[] args) {
        String address = "1.1.1.1";
        System.out.println(defangIPaddr(address));
    }

    /**
     * 送分题
     * @param address
     * @return
     */
    public static String defangIPaddr(String address){
       return address.replace(".","[.]");
    }
}
