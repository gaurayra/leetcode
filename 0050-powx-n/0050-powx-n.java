class Solution {
    public double myPow(double x, int n) {
        long power = n;
        if (power < 0) power = -power;
        double po = 1;
        while (power > 0) {
            if (power % 2 == 1) po *= x;
             x *= x;
            power /= 2;
        }  if (n < 0) return 1 / po;
        return po;
    }
}