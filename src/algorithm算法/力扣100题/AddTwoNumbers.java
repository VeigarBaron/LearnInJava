package algorithm算法.力扣100题;

/**
 * @author VeigarBaron
 * @date 2021/1/27 16:55
 * @Description *
 */
public class AddTwoNumbers {
    // Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        if (l1.next == null){
            return l2;
        }if (l2.next == null){
            return l1;
        }


        return null;
    }
}
