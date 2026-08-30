class Solution {
    public int searchInsert(int[] nums, int target) {
        int r=nums.length;;
        for(int i=0; i<nums.length; i++){
            if(nums[i]>=target){
                r=i;
            break;} 
            else{r=i+1;}
        } return r;
    }
}