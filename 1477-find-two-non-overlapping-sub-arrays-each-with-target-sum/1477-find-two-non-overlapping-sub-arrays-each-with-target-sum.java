class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        int n = arr.length;
        int[] best = new int[n];
        int sum = 0;
        int left = 0;
        int ans = Integer.MAX_VALUE;
        int minLen = Integer.MAX_VALUE;
        for (int right = 0; right < n; right++) {
            sum += arr[right];
            while (sum > target) {
                sum -= arr[left];
                left++;
            }
            if (sum == target) {
                int len = right - left + 1;
                if (left > 0 && best[left - 1] != 0) {
                    ans = Math.min(ans, len + best[left - 1]);
                } minLen = Math.min(minLen, len);
            } best[right] = (minLen == Integer.MAX_VALUE) ? 0 : minLen;
        } return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}