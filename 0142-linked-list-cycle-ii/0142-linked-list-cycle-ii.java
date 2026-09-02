class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        // Step 1: Detect whether a cycle exists
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            // Cycle detected
            if (slow == fast) {
                // Step 2: Find the starting node of the cycle
                ListNode pointer = head;

                while (pointer != slow) {
                    pointer = pointer.next;
                    slow = slow.next;
                }

                return pointer;
            }
        }

        // No cycle
        return null;
    }
}
