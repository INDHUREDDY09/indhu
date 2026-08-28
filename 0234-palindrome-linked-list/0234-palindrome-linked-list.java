class Solution {
    public boolean isPalindrome(ListNode head) {
        java.util.ArrayList<Integer> values = new java.util.ArrayList<>();

        while (head != null) {
            values.add(head.val);
            head = head.next;
        }

        int left = 0, right = values.size() - 1;

        while (left < right) {
            if (!values.get(left).equals(values.get(right)))
                return false;
            left++;
            right--;
        }

        return true;
    }
}
