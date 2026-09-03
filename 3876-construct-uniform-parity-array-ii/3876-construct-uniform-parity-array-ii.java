class Solution {
    public boolean uniformArray(int[] nums1) {
       boolean hasOdd = false;
        int minVal = nums1[0];
        for (int x : nums1) {
            if (x % 2 != 0)  hasOdd = true;
            if (x < minVal)  minVal = x;
        }
        return !hasOdd || (minVal % 2 != 0); 
    }
}