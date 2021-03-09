package list;

/**
 * 合并两个有序的单链表
 * @author 路飞
 * @create 2021/2/19 16:38
 */
public class MergeList {
    public static void main(String[] args) {

    }

    public static Node mergeList(Node list1,Node list2){
        if (list1 == null) return list2;
        if (list2 == null) return list1;
        Node resNode;
        if (list1.val < list2.val){
            resNode = list1;
            list1 = list1.next;
        }else {
            resNode = list2;
            list2 = list2.next;
        }
        //递归得到next
        resNode.next = mergeList(list1,list2);
        return resNode;

    }
}
