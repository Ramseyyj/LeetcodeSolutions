
/**
 * Created by Yu Yujie on 29/05/2018.
 *
 * Problem 25: Reverse Nodes in k-Group
 *
 * Description:
 * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
 * k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is
 * not a multiple of k then left-out nodes in the end should remain as it is.
 *
 * Example:
 *
 * Given this linked list: 1->2->3->4->5
 *
 * For k = 2, you should return: 2->1->4->3->5
 *
 * For k = 3, you should return: 3->2->1->4->5
 *
 * Note:
 *
 *  1. Only constant extra memory is allowed.
 *  2. You may not alter the values in the list's nodes, only nodes itself may be changed.
 *
 * 自己的思路：每次取k个数出来进行reverse，然后拼接到新的链表后面。
 */
public class ReverseNodesInKGroup {

    public static void main(String[] args) {

        int[] nums = {1, 2, 3, 4, 5};

        ListNode.showListNode(new ReverseNodesInKGroup().reverseKGroup(ListNode.generateList(nums), 2));
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        int len = 0;
        ListNode p, q;
        for (p = head; p != null; p = p.next) len++;

        ListNode newHeader = new ListNode(-1);
        p = newHeader;
        for (int i = 0; i < len / k; i++) {
            ListNode tempHeader = new ListNode(-1);
            for (int j = 0; j < k; j++) {
                q = head;
                head = head.next;
                q.next = tempHeader.next;
                tempHeader.next = q;
            }

            p.next = tempHeader.next;
            while (p.next != null) p = p.next;
        }

        p.next = head;

        return newHeader.next;
    }
}
