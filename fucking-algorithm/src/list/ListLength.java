package list;

/**
 * 获取链表的长度
 * @author 路飞
 * @create 2021/2/19 16:25
 */
public class ListLength {
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
        System.out.println("链表长度");
        System.out.println(getLength(singleList.head));
    }

    public static int getLength(Node head){
        //头节点不算
        if (head.next == null ){
            return 0;
        }

        int length = 1;
        Node cur = head.next;
        while (true){
            if (cur.next == null){
                break;
            }
            cur = cur.next;
            length++;
        }
        return length;
    }
}
