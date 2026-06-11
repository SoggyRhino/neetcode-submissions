class Solution {
    public int maxProfit(int[] prices) {
        //start a 0 and 1 
        int l =0, r = 1;
        //max is >= 0 
        int max =0;


        while (r < prices.length){

            //if left < right there is potential for profit so we check
            if (prices[l] < prices[r]){
                max = Math.max(max , prices[r] -prices[l]);
            } else { // else we have checked all l to r and have the max now do it again starting at r
                l =r;
            }
            r++;

        }
        return max;

    }
}
