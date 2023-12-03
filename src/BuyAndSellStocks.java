public class BuyAndSellStocks {

    public static int buyOrSell(int[] arr) {
        // not correct for some cases
        int n = arr.length;
        int minValue = arr[0];
        int buyIndex = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] < minValue) {
                minValue = arr[i];
                buyIndex = i;
            }
        }

        int profitValue = 0;
        for (int i = buyIndex ; i < n; i++){
            if(arr[i]-minValue>profitValue){
                profitValue = arr[i]-minValue;

            }
        }
        return profitValue;
    }


    // Correct Optimal Approach
    public static int buyOrSellStocks(int[] arr){
        int maxProfit = 0;
        int minPrice = Integer.MAX_VALUE;
        for(int num : arr){
            minPrice = Math.min(minPrice, num);
            maxProfit = Math.max(maxProfit, num - minPrice);
        }
        return maxProfit;
    }


    public static void main(String[] args) {
        int[] arr = new int[]{7,6,4,3,1};
        System.out.println(buyOrSell(arr));
    }
}
