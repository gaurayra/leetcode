class Solution {
    public int minimumDeletions(int[] nums) {
        int n= nums.length;
        int maxIndex=0;
        int minIndex=0;
        for(int i=0; i<nums.length; i++){
            if(nums[i]>nums[maxIndex]){
                maxIndex=i;
            }
            if(nums[i]<nums[minIndex]){
                minIndex=i;
            }
        }
        int left= Math.min(maxIndex,minIndex);
        int right= Math.max(maxIndex,minIndex);
        int op1=right+1;
        int op2=n-left;
        int op3=(left+1)+(n-right);
        return Math.min(op1, Math.min(op2,op3));
    }
}