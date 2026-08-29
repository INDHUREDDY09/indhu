class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {

        int n = nums.length;
        int[] result = new int[n - k + 1];

        Deque<Integer> deque = new ArrayDeque<>();

        int resultIndex = 0;

        for (int i = 0; i < n; i++) {

            // Remove elements that are outside the window
            if (!deque.isEmpty() && deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }

            // Remove smaller elements
            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) {
                deque.pollLast();
            }

            // Add current index
            deque.offerLast(i);

            // Store maximum
            if (i >= k - 1) {
                result[resultIndex] = nums[deque.peekFirst()];
                resultIndex++;
            }
        }

        return result;
    }
}

