class Solution {
    public int reverse(int x) {
        int ori=x;
        long rev=0;
        while(ori!=0){
            int digit=ori%10;
            rev=rev*10+digit;
            ori=ori/10;
        } if(rev>Integer.MAX_VALUE || rev<Integer.MIN_VALUE) return 0;
        return (int)rev;
    }
}