class Solution {
    public boolean uniformArray(int[] nums1) {
        boolean odd = false, even = false;
        for (int x : nums1) {
            if (x % 2 == 0) even = true;
            else odd = true;
        }
        if (!odd || !even) return true;
        return nums1.length > 1;
    }
}