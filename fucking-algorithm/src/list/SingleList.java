package list;

/**
 * 单链表
 * @author 路飞
 * @create 2021/2/19 11:40
 */
public class SingleList {
    //初始化头节点
    public Node head = new Node(0);

    //添加元素
    public  void add(Node node){
        Node temp = head;
        while (true){
            if (temp.next == null){
                break;
            }
            temp = temp.next;
        }
        temp.next = node;
    }

    //打印
    public void print(){
        if (head.next == null){
            System.out.println("链表为空");
            return;
        }
        Node temp = head.next;
        while (true){
            if (temp == null){
                break;
            }
            System.out.println(temp);
            temp = temp.next;
        }
    }
}
