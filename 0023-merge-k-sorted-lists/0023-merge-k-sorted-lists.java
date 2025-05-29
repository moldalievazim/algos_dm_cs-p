/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        return mergeAllLists(lists, 0, lists.length - 1);
    }

    public ListNode mergeAllLists(ListNode[] lists, int left, int right) {
        if (left > right) return null;
        if (left == right) return lists[left];

        int mid = (left + right) / 2;

        ListNode mergedLeftHalf = mergeAllLists(lists, left, mid);
        ListNode mergedRightHalf = mergeAllLists(lists, mid + 1, right);

        return mergeTwoSortedLists(mergedLeftHalf, mergedRightHalf);
    }

    public ListNode mergeTwoSortedLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        if (l1.val < l2.val) {
            l1.next = mergeTwoSortedLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoSortedLists(l1, l2.next);
            return l2;
        }
    }
}