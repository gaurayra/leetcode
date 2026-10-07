class Solution {
    public int searchInsert(int[] nums, int target) {
        int ans=nums.length;
        for(int i=0; i<nums.length; i++){
            if(nums[i]>=target){
                ans=i;
                break;
            }else ans=i+1;
        } 
        return ans;
    }
}