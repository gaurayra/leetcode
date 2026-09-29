class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] c= new int[nums1.length + nums2.length];
        for(int i=0; i<nums1.length; i++){
            c[i]=nums1[i];
        }
        for(int i=0; i<nums2.length; i++){
            c[nums1.length+i]=nums2[i];
        }
        Arrays.sort(c);
        int l= c.length;
        if(l%2!=0) return c[l/2];
        else return (c[l/2-1]+c[l/2])/2.0;
    }
}