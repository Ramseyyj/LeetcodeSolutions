import java.util.List;

public class ListNode {

    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    public static ListNode generateList(int[] nums) {
        ListNode head = null;
        if (nums.length == 0) {
            return head;
        } else {
            head = new ListNode(nums[0]);
            ListNode p = head;
            for (int i = 1; i < nums.length; i++) {
                ListNode temp = new ListNode(nums[i]);
                p.next = temp;
                p = p.next;
            }
        }
        return head;
    }

    public static void showListNode(ListNode head) {
        ListNode p = head;
        while (p!= null) {
            System.out.println(p.val);
            p = p.next;
        }
    }
}
