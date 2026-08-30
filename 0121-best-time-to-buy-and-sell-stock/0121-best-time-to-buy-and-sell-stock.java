class Solution {
    public int maxProfit(int[] prices) {
       int maxprofit=0;
       int minprice=prices[0];
       for(int i=1; i<prices.length; i++){
        if(minprice>prices[i]) minprice=prices[i];
        int profit= prices[i]-minprice;
        if(maxprofit<profit) maxprofit=profit;
       } return maxprofit;
    }
}