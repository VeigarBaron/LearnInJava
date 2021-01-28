package algorithm算法.刷完的题目;

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

    // code
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode head = null, tail = null;
        int carry = 0;

        while (l1 != null || l2 != null){
            // 处理为相同长度链表
            if (l1 != null && l2 == null)
                l2.val = 0;
            if (l1 == null)
                l1.val = 0;

            int sum = l1.val + l2.val + carry;
            carry = sum / 10;
            if (head == null){
                head = tail = new ListNode(sum % 10, null);
            } else {
                tail.next = new ListNode(sum % 10, null);
                tail = tail.next;
            }
            l1 = l1.next;
            l2 = l2.next;
        }

        if (carry > 0){
            tail.next = new ListNode(carry,null);
        }
        return head;
    }
}
