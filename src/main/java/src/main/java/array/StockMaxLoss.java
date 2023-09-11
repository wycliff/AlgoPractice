package src.main.java.array;

public class StockMaxLoss {

    public static int calculateBigLoss(int[] prices){
        // buy high, sell low
        // maxLoss
        // [7,1,5,3,6,4]
        int l = 0;
        int r = 1;
        int maxLoss = 0;

        while(r<prices.length){
            if(prices[r]<prices[l]){
                int loss = prices[l] - prices[r];
                maxLoss = Math.max(maxLoss, loss);
            }else{
                l = r;
            }
            r+=1;
        }

        return maxLoss;
    }

    public static void main(String[] args) {
        int[] prices = {7,1,5,3,12,4};
        System.out.println(calculateBigLoss(prices));
    }
}
