package algorithm算法.力扣100题;

import algorithm算法.刷完的题目.ReverseList;

/**
 * @author VeigarBaron
 * @date 2021/1/28 14:57
 * @Description *
 */
public class MergeTwoLists {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode listNode = new ListNode();
        if (l1 == null && l2!= null)
            listNode.next = l2;
        if (l2 == null && l1!= null)
            listNode.next = l1;

        if (l1!=null || l2!=null){
            if (l1.val < l2.val){
                listNode = new ListNode(l1.val, l1.next);
                l1 = l1.next;
            }else {
                listNode = new ListNode(l2.val, l2.next);
                l2 = l2.next;
            }
            listNode = mergeTwoLists(l1, l2);
        }
        return listNode;
    }
}
