package list;

/**
 * easy
 * 83. 删除排序链表中的重复元素
 * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 * @author 路飞
 * @create 2021/3/25 17:24
 */
public class DeleteDuplicates1 {
    public static void main(String[] args) {

    }

    public static Node deleteDuplicates1(Node head){
        if (head == null && head.next == null) return head;
        Node cur = null;
        while(cur != null && cur.next != null){
            if(cur.val == cur.next.val){
                cur.next = cur.next.next;
            }else {
                cur = cur.next;
            }
        }
        return head;
    }
}
