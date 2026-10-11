class Solution {
    public int jump(int[] nums) {
      int jumps=0, farthestpoint=0, currentindex=0;
      for(int i=0; i<nums.length-1; i++){
        if(i+nums[i]>farthestpoint) farthestpoint=i+nums[i];
        if(currentindex==i){
            jumps++;
            currentindex=farthestpoint;
        } 
      }  return jumps;
    }
}