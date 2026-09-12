class Solution {
    public int leastInterval(char[] tasks, int n) {

        // Count frequency of each task
        int[] freq = new int[26];

        for (char task : tasks) {
            freq[task - 'A']++;
        }

        // Find the maximum frequency
        int maxFreq = 0;

        for (int count : freq) {
            maxFreq = Math.max(maxFreq, count);
        }

        // Count how many tasks have the maximum frequency
        int maxCount = 0;

        for (int count : freq) {
            if (count == maxFreq) {
                maxCount++;
            }
        }

        // Minimum intervals needed based on the most frequent task(s)
        int required = (maxFreq - 1) * (n + 1) + maxCount;

        // If other tasks can fill all idle positions,
        // we simply need tasks.length intervals.
        return Math.max(tasks.length, required);
    }
}
