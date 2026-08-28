class Solution {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        long total = 0;
        long prefix = 0;

        for (int x : nums)
            total += x;

        for (int i = 0; i < n; i++) {
            long left = (long) nums[i] * i - prefix;
            long right = (total - prefix - nums[i])
                       - (long) nums[i] * (n - i - 1);

            result[i] = (int)(left + right);
            prefix += nums[i];
        }
        return result;
    }
}
