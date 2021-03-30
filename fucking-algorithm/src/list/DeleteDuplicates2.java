package list;

import twohand.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * medium
 * 82. 删除排序链表中的重复元素 II
 *存在一个按升序排列的链表，给你这个链表的头节点 head ，请你删除链表中所有存在数字重复情况的节点，只保留原始链表中 没有重复出现 的数字。
 * 返回同样按升序排列的结果链表。
 *
 * @author 路飞
 * @create 2021/3/25 11:11
 */
public class DeleteDuplicates2 {
    public static void main(String[] args) {

    }

    public static Node deleteDuplicates(Node head){
      if(head == null || head.next == null) return head;

      //该节点和下一个节点不相同 那就递归 参数就是下一个节点 因为不知道下一个节点是否和下下个节点相同 所以
      //返回的只能是head
      if (head.next.val != head.val){
          head.next = deleteDuplicates(head.next);
          return head;
      }else {
          //出现节点相同的情况
          //思路就是一种next 找到和head不相同的情况 再返回
          //这时还是不知道 该节点是否和它的下一个节点相同 所以不能直接返回该节点
          Node temp = head.next.next;
          while (temp != null && temp.val == head.val){
              temp = temp.next;
          }
          return deleteDuplicates(temp);
      }
    }
}
