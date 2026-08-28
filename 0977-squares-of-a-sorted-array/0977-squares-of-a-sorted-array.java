class Solution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        int left = 0, right = n - 1, pos = n - 1;

        while (left <= right) {
            int l = nums[left] * nums[left];
            int r = nums[right] * nums[right];

            if (l > r) {
                result[pos--] = l;
                left++;
            } else {
                result[pos--] = r;
                right--;
            }
        }
        return result;
    }
}
