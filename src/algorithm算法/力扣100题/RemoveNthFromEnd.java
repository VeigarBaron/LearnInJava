package algorithm算法.力扣100题;

/**
 * @author VeigarBaron
 * @date 2021/3/18 14:19
 * @Description *
 */
public class RemoveNthFromEnd {
    // Definition for singly-linked list.
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {

        if (head.next == null)
            return null;

        int num = 1;
        ListNode pnext = head;
        ListNode listNext = head;
        while (pnext.next != null) {
            pnext = pnext.next;
            ++num;
        }

        int target = num - n + 1;
        int i = 0;
        while (listNext.next != null) {
            i++;
            listNext = listNext.next;
            if (i == target) {
                listNext.next = listNext.next.next;
            }

        }
        return listNext;
    }

    public static void main(String[] args) {
        RemoveNthFromEnd removeNthFromEnd = new RemoveNthFromEnd();
        ListNode listNode = new ListNode(7,null);
        ListNode listNode0 = new ListNode(5,listNode);
        ListNode listNode1 = new ListNode(1,listNode0);
        ListNode listNode2 = new ListNode(4,listNode1);
        ListNode listNode3 = new ListNode(9,listNode2);
        ListNode listNode4 = new ListNode(2,listNode3);
        removeNthFromEnd.removeNthFromEnd(listNode4,3);
    }
}
