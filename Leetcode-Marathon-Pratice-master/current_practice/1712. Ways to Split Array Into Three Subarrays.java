class Solution {
    public int waysToSplit(int[] nums) {
        //we need to fix the leftmost boundary first

        //---this is the template for presum
        int n = nums.length;
        long[] presum = new long[n];
        presum[0] = nums[0];

        for(int i=1; i<nums.length; i++){
            presum[i] = nums[i] + presum[i-1];
        }


        int j=0, k=0;
        long res = 0;
        long M = 1000000000 + 7;

        for(int i=0; i<n; i++){
            while(j<=i || (j<n && presum[j] - presum[i] < presum[i])){
                j++;
            }

            if(j==n) break;

            //we need to look for k, where k is between j and n
            int l = j, r = n-1;
            while(l<r){
                int mid = r-(r-l)/2;
                if(presum[mid]<=0.5*(presum[i]+presum[n-1])){
                    l = mid;
                }else if(presum[mid]>0.5*(presum[i]+presum[n-1])){
                    r = mid-1;
                }
            }

            if(l==nums.length-1) l--;
            if(l<j) continue;

            if(presum[l]<=0.5*(presum[i]+presum[n-1]))
                res = (res + (l-j+1))%M;

        }

        return (int)res;
    }
}