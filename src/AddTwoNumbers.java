
/**
 * Created by Yu Yujie on 09/03/2018.
 *
 * Problem 2. Add Two Numbers
 *
 * Description:
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse
 * order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 * Example
 *
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 *
 */
public class AddTwoNumbers {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static void main(String[] args)
    {
        ListNode ln1 = new ListNode(2);
        ln1.next = new ListNode(4);
        ln1.next.next = new ListNode(3);
        ListNode ln2 = new ListNode(5);
        ln2.next = new ListNode(6);
        ln2.next.next = new ListNode(4);

        ListNode ln3 = new AddTwoNumbers().addTwoNumbers(ln1, ln2);
        while(ln3 != null)
        {
            System.out.println(ln3.val);
            ln3 = ln3.next;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int temp = 0;
        boolean flag = true;
        ListNode l3 = new ListNode(0);
        ListNode p = l3;

        while(flag)
        {
            if(l1 != null)
            {
                temp += l1.val;
                l1 = l1.next;
            }

            if(l2 != null)
            {
                temp += l2.val;
                l2 = l2.next;
            }

            p.val = temp % 10;
            temp = (temp / 10);

            if(l1 == null && l2 == null)
            {
                flag = false;
                if( temp != 0)
                {
                    p.next = new ListNode(0);
                    p = p.next;
                    p.val = temp;
                }
            }
            else
            {
                p.next = new ListNode(0);
                p = p.next;
            }
        }

        return l3;
    }
}
