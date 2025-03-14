class Solution {
    public long kthSmallestProduct(int[] nums1, int[] nums2, long k) {
        long left = (long)-1e11, right = (long)1e11;
        while(left < right){
            long mid = left+(right-left)/2;
            if(countSmallerOrEqual(mid, nums1, nums2)>=k){
                right = mid;
            }else{
                left = mid+1;
            }
        }
        return left;
    }
    private long countSmallerOrEqual(long mid, int[] nums1, int[] nums2){
        long count = 0;
        //nums1[i] * nums2[j] <= mid
        if(mid>=0){
            int j0 = nums2.length-1;
            int j1 = nums2.length-1;
            for(int i=0; i<nums1.length; i++){
                if(nums1[i]>0){
                    while(j0>=0 && (long)nums1[i]*(long)nums2[j0]>mid){
                        j0--;
                    }
                    count += j0+1;
                }else if(nums1[i] == 0){
                    count += nums2.length;
                }else if(nums1[i] < 0){
                    while(j1>=0 && (long)nums1[i]*(long)nums2[j1]<=mid){
                        j1--;
                    }
                    count += nums2.length-1-j1;
                }
            }
        }else{
            int j0 = 0;
            int j1 = 0;
            for(int i=0; i<nums1.length; i++){
                if(nums1[i]>0){
                    while(j0<nums2.length && (long)nums1[i]*(long)nums2[j0]<=mid){
                        j0++;
                    }
                    count += j0;
                }else if(nums1[i]==0){
                    count += 0;
                }else{
                    while(j1<nums2.length && (long)nums1[i]*(long)nums2[j1]>mid){
                        j1++;
                    }
                    count += nums2.length-j1;
                }
            }
        }
        return count;
    }
}