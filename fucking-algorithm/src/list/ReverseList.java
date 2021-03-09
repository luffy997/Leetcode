package list;

import javax.print.attribute.standard.PresentationDirection;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Stack;

/**
 * 链表反转
 *
 * @author 路飞
 * @create 2021/2/19 10:33
 */
public class ReverseList {
    public static void main(String[] args) {

        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        SingleList singleList = new SingleList();
        singleList.add(node1);
        singleList.add(node2);
        singleList.add(node3);
        singleList.add(node4);
        singleList.print();
        Node node = reverseList(singleList.head);

        System.out.println("链表反转----------------");



    }

    public static void reverseNode(Node head) {
        //如果链表为空或只有一个元素，无需反转，之间返回
        if (head.next == null || head.next.next == null) {
            return ;
        }
        //定义一个辅助的指针，帮助我们遍历原来的链表
        Node cur = head.next;
        Node next = null;
        //新建一个node
        Node reverserHead = new Node(0);
        while (cur != null){
               next = cur.next;  //先暂时保存当前节点的下一个节点，后面需要使用
               cur.next = reverserHead.next; // //将cur 的下一个节点指向新的链表的最前端
               reverserHead.next = cur; //将cur 连接到新的链表上
               cur = next; //cur 后移
        }
        head.next = reverserHead.next;
    }

    /**
     * 递归实现
     * @param head
     * @return
     */
    public static Node reverseList(Node head) {
        LinkedList<Integer> integers = new LinkedList<>();
        Stack<Node> stack = new Stack<>();

        int[] ints = new int[0];

        if (head == null || head.next == null) {
            return head;
        }
        Node newHead = reverseList(head.next);
        head.next.next = head;
        //  的下一个节点必须指向 ∅。如果忽略了这一点，链表中可能会产生环。
        head.next = null;
        return newHead;
    }
}

