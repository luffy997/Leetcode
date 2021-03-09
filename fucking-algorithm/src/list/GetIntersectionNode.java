package list;

import java.util.HashMap;
import java.util.Map;

/**
 * easy
 *160. 相交链表
 * 编写一个程序，找到两个单链表相交的起始节点。
 * @author 路飞
 * @create 2021/2/19 19:59
 */
public class GetIntersectionNode {
    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5 );
        Node node6 = new Node(6 );
        Node node7 = new Node(7 );
        Node node8 = new Node(8 );
        Node node9 = new Node(9 );
        Node node10 = new Node(10);
        Node node11 = new Node(11);
        Node node12 = new Node(12);
        SingleList singleList02 = new SingleList();
        singleList02.add(node8);
        singleList02.add(node11);
        singleList02.add(node12);
        singleList02.add(node10);
        singleList02.add(node9);
        singleList02.add(node2);
        singleList02.add(node3);
        singleList02.add(node4);
        singleList02.print();


        SingleList singleList01 = new SingleList();
        singleList01.add(node6);
        singleList01.add(node7);
        singleList01.add(node1);
        singleList01.add(node2);
        singleList01.add(node3);
        singleList01.add(node4);
        singleList01.print();


        //getIntersectionNode(singleList01.head,singleList02.head);

    }

    /**
     * hash
     * @param headA
     * @param headB
     * @return
     */
    public static void getIntersectionNode(Node headA,Node headB){
        if (headA == null || headB == null) return ;
        //遍历headA
        int index = 1;
        Node cur = headA.next;
        Map<Integer, Integer> map = new HashMap<>();
        while (true){
            if (cur == null){
                break;
            }
            map.put(cur.val,index);
            ++index;
            cur = cur.next;
        }

        System.out.println(map);
    }
}
