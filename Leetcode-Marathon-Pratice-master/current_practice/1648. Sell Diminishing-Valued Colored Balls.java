class Solution {
    public int maxProfit(int[] inventory, int orders) {
        //get the number of balls for each type to maximize the total value
        //reverse the order of inventory
        Arrays.sort(inventory);

        int m = inventory.length;

        int[] reverseInv = new int[m];

        for(int i=0; i<m; i++){
            reverseInv[i] = inventory[m-i-1];
        }

        long left = 1, right = reverseInv[0];

        long M = 1000000000 + 7;

        while(left < right){
            long mid = left + (right - left)/2;
            if(count(mid, reverseInv)<=orders){
                right = mid;
            }else{
                left = mid + 1;
            }
        }

        long k = left;

        long res = 0;

        for(int i=0; i<reverseInv.length; i++){
            if(reverseInv[i] < k) break;
            res += ((long)reverseInv[i] + k)*((long)reverseInv[i]-k+1)/2;
            res %= M;
        }

        res += (k-1) * (orders-count(k, reverseInv))%M;
        res %= M;

        return (int)res;
    }

    private long count(long mid, int[] reverseInv){
        long orderNums = 0;

        for(int i=0; i<reverseInv.length; i++){
            if(reverseInv[i] < mid) break;
            orderNums += reverseInv[i] - mid + 1;
        }

        return orderNums;
    }

}