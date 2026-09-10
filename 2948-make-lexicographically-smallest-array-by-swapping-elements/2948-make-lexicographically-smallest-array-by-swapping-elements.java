class Solution {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int n = nums.length;
        Integer[] idx = new Integer[n];
        for (int i = 0; i < n; i++) {
            idx[i] = i;
        }
        java.util.Arrays.sort(idx, (a, b) -> nums[a] - nums[b]);
        int[] result = new int[n];
        int i = 0;
        while (i < n) {
            int j = i;
            while (j + 1 < n && nums[idx[j + 1]] - nums[idx[j]] <= limit) {
                j++;
            }
            java.util.List<Integer> positions = new java.util.ArrayList<>();
            for (int k = i; k <= j; k++) {
                positions.add(idx[k]);
            }
            java.util.Collections.sort(positions);
            for (int k = 0; k <= j - i; k++) {
                result[positions.get(k)] = nums[idx[i + k]];
            } i = j + 1;
        } return result;
    }
}