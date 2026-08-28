class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode current = head;
        int count = 0;

        while (current != null && count < k) {
            current = current.next;
            count++;
        }

        if (count < k)
            return head;

        ListNode previous = null;
        current = head;

        for (int i = 0; i < k; i++) {
            ListNode next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }

        head.next = reverseKGroup(current, k);
        return previous;
    }
}
