package list;


import twohand.ListNode;

/**
 * medium
 * 19. 删除链表的倒数第 N 个结点
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 * 进阶：你能尝试使用一趟扫描实现吗？
 * @author 路飞
 * @create 2021/3/25 17:47
 */
public class RemoveNthFromEnd {
    public static void main(String[] args) {
        System.out.println();
    }
    public static Node removeNthFromEnd(Node head,int n){
        if(head == null ||(head.next == null && n == 1)) return null;
        //第一次遍历获取长度
        int size = 0;
        Node dummy = new Node(0);
        dummy.next = head;
        Node cur = head;
        Node pre = dummy;
        while(head!=null){
            size ++;
            head = head.next;
        }

        //假如删除的是head
        if(n == size){
            dummy.next = cur.next;
            return dummy.next;
        }
        int i = 1;
        while(cur != null){
            if(i == size-n+1){
                pre.next = cur.next;
            }else{
                pre = pre.next;
                cur = cur.next;
            }
            i++;
        }
        return dummy.next;
    }
}
