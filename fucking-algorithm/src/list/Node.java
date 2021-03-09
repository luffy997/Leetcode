package list;

/**
 * 链表常见算法题：
 * •	单链表反转
 * •	合并有序单链表
 * •	找出单链表的中间节点
 * •	判断单链表相交或者有环
 * •	找出进入环的第一个节点
 * •	求单链表相交的第一个节点
 *
 * 节点
 * @author 路飞
 * @create 2021/2/19 10:30
 */
public class Node {
    int val; //数据域
    Node next; //后继
    public Node(int val){ //有参构造
        this.val = val;
    }

    @Override
    public String toString() {
        return "Node{" +
                "val=" + val +"}";
    }

    public void list(Node head){
        if (head.next == null){
            System.out.println("链表为空");
            return;
        }
        Node temp = head.next;
        while (true){
            if (temp == next){
                break;
            }
            System.out.println(temp);
            temp = temp.next;
        }
    }
}
