package list;

/**
 * easy
 * 剑指 Offer 18. 删除链表的节点
 * 给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。
 * 返回删除后的链表的头节点。
 *
 * @author 路飞
 * @create 2021/3/25 11:54
 */
public class DeleteNode {
    public static void main(String[] args) {

    }

    public static Node deleteNode(Node head,int val){
        if (head == null || head.next == null) return head;
        //加入虚节点，方便操作
        Node dummy = new Node(0);
        dummy.next = head;
        Node cur = head;
        Node pre = dummy;
        while (cur != null){
            if(cur.val == val){
                pre.next = cur.next;
                break;
            }
            cur = cur.next;
            pre = pre.next;
        }
        return dummy.next;

    }
}
