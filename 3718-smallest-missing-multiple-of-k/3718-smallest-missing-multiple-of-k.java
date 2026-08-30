class Solution {
    public int missingMultiple(int[] nums, int k) {
        int x = k;

        while (true) {

            boolean found = false;

            for (int num : nums) {
                if (num == x) {
                    found = true;
                    break;
                }
            }

            if (!found) {
                return x;
            }

            x += k;
        }
    }
}