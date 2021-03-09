package list;

import java.util.Stack;

/**
 * 逆序打印单链表
 * @author 路飞
 * @create 2021/2/19 16:30
 */
public class ReversePrint {
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
        reversePrint(singleList.head);
        System.out.println("链表逆序打印");
    }

    public static void reversePrint(Node head){
        if (head.next == null){
            System.out.println("链表为空");
            return;
        }
        Stack<Integer> stack = new Stack<>();
        Node cur = head.next;
        while (true){
            if (cur == null){
                break;
            }
            stack.push(cur.val);
            cur = cur.next;
        }

        while (stack.size() >0){
            System.out.println(stack.pop());
        }
    }
}
