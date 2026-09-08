class Solution {
    public int countCommas(int n) {
     long ans = 0;
        long start = 1000;
        long commas = 1;
        while (start <= n) {
            long end = start * 1000 - 1;
            if (end > n) end = n;
            long count = end - start + 1;
            ans += count * commas;
            start *= 1000;
            commas++;
        } return (int)ans;   
    }
}