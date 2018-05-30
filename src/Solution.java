import java.util.*;

public class Solution {

    public static void main(String[] args) {

        int[] nums1 = {1, 4, 5};
        int[] nums2 = {1, 3, 4};
        int[] nums3 = {2, 6};
        ListNode[] lists = new ListNode[3];
        lists[0] = ListNode.generateList(nums1);
        lists[1] = ListNode.generateList(nums2);
        lists[2] = ListNode.generateList(nums3);

        ListNode.showListNode(new Solution().mergeKLists(lists));
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;

        PriorityQueue<ListNode> myQueue = new PriorityQueue<>(lists.length, new Comparator<ListNode>(){
            @Override
            public int compare(ListNode o1, ListNode o2) {
                if (o1.val < o2.val)
                    return -1;
                else if (o1.val == o2.val)
                    return 0;
                else
                    return 1;
            }
        });

        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) {
                myQueue.add(lists[i]);
            }
        }

        ListNode result = new ListNode(-1);
        ListNode tail = result;
        while (myQueue.size() > 0) {
            tail.next = myQueue.poll();
            tail = tail.next;

            if (tail.next != null) {
                myQueue.add(tail.next);
            }
        }

        return result.next;
    }
}
