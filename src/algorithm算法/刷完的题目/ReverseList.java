package algorithm算法.刷完的题目;

/**
 * @author VeigarBaron
 * @date 2021/1/28 11:02
 * @Description *
 */
public class ReverseList {
    // Definition for singly-linked list.
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    //code 题解= 思路同 reverseList()
    public ListNode reverseList2(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    //code
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        while (head != null){
            if (prev == null) {
                prev = new ListNode(head.val, null);
                head = head.next;
                continue;
            }
            prev = new ListNode(head.val, prev);
            head = head.next;
        }
        return prev;
    }

    public static void main(String[] args) {
        ListNode listNode5 = new ListNode(5, null);
        ListNode listNode4 = new ListNode(4, listNode5);
        ListNode listNode3 = new ListNode(3, listNode4);
        ListNode listNode2 = new ListNode(2, listNode3);
        ListNode listNode1 = new ListNode(1, listNode2);

        ReverseList re = new ReverseList();
        re.reverseList(listNode1);
    }
}