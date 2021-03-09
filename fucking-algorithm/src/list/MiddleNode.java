package list;

/**
 * 找出链表的中间结点
 *
 * @author 路飞
 * @create 2021/2/19 17:31
 */
public class MiddleNode {
    public static void main(String[] args) {

    }

    /**
     * 快慢指针
     *
     * @param head
     * @return
     */
    public static Node middleNode(Node head) {
        Node fast = head;
        Node slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
