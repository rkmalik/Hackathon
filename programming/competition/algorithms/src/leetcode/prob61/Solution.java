package leetcode.prob61;

public class Solution {

    public ListNode rotateRight(
            ListNode head,
            int k) {

        // Find the kth node

        if (head == null || head.next == null)
            return head;

        ListNode node = head;
        ListNode tail = node;
        int size = 1;
        ListNode mid = null;

        while (node != null && node.next != null) {
            tail = node;
            node = node.next.next;
            if (node == null) {
                tail = tail.next;
                size++;
            } else {
                tail = node;
                size += 2;
            }
        }

        if (k > size)
            k = k % size;

        if (k == 0 || k == size)
            return head;

        int count = 1;
        int steps = size - k;
        
        node = head;
        ListNode prev = null;

        while (count <= steps) {
            prev = node;
            node = node.next;
            count++;
        }

        if (node != null) {
            node = prev.next;
            prev.next = null;
            tail.next = head;
            head = node;
        }
        return head;
    }
}