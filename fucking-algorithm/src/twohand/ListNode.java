package twohand;

/**
 * medium
 * 剑指 Offer 18. 删除链表的节点
 * @author 路飞
 * @create 2021/3/8 23:13
 */
  public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    public static ListNode deleteNode(ListNode head, int val) {
        if (head == null) {
            return head;
        }
        ListNode preNode = head;
        ListNode curNode = head.next;
        while (curNode != null) {
            //头节点
            if (preNode.val == val) {
                head = head.next;
                break;
            }

            if (curNode.val == val) {
                preNode.next = curNode.next;
                break;
            }
            preNode = curNode;
            curNode = curNode.next;
        }
        return head;
    }
}