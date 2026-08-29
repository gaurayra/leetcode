class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] combine= new int[nums1.length+nums2.length];
        for(int i=0; i<nums1.length; i++){
            combine[i]=nums1[i];
        }
        for(int i=0; i<nums2.length; i++){
            combine[nums1.length+i]=nums2[i];
        }
        Arrays.sort(combine);
        int n= combine.length;
        if(n%2!=0){ return combine[n/2];}
        else{ return (combine[n/2-1]+combine[n/2])/2.0 ;}
    }
}