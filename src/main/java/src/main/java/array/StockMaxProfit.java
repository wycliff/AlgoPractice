package src.main.java.array;

public class StockMaxProfit {
    //2ptr
    public static int calculateMaxProfit(int[] prices) {
        // buy low sell high
        int l = 0; //buying
        int r = 1; //sell
        int maxProfit = 0;

        while (r < prices.length){
            if(prices[l]<prices[r]){
                int profit = prices[r] - prices[l];
                maxProfit = Math.max(maxProfit, profit);
            }else{
                l=r;
            }

            r+=1;
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        int[] prices =  {7,1,5,3,6,4};
        System.out.println(calculateMaxProfit(prices));
    }
}
