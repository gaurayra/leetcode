class Solution {
    public long[] resultArray(int[] nums, int k) {
        long[] ans = new long[k];
        long[] dp = new long[k];
        for (int num : nums) {
            long[] next = new long[k];
            int rem = num % k;
            next[rem]++;
            for (int r = 0; r < k; r++) {
                int newRem = (r * rem) % k;
                next[newRem] += dp[r];
            }
            for (int r = 0; r < k; r++) {
                ans[r] += next[r];
            } dp = next;
        } return ans;
    }
}