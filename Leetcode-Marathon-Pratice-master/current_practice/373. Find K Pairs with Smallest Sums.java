class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> res1 = new ArrayList<>();
        List<List<Integer>> res2 = new ArrayList<>();
        //find the kth - smallest sum
        long left = Integer.MIN_VALUE, right = Integer.MAX_VALUE;
        while(left < right){
            long mid = left + (right-left)/2;
            if(countSmallerOrEqual(mid, nums1, nums2) >= k){
                right = mid;
            }else{
                left = mid + 1;
            }
        }
        int m = (int)left;

        for(int i=0; i<nums1.length; i++){
            for(int j=0; j<nums2.length && nums1[i] + nums2[j]<=m && res1.size() < k; j++){
                if(nums1[i] + nums2[j] < m){
                    res1.add(Arrays.asList(nums1[i], nums2[j]));
                }else{
                    res2.add(Arrays.asList(nums1[i], nums2[j]));
                }
            }
        }

        int rem = Math.min(k-res1.size(), res2.size());

        for(int i=0; i<rem; i++){
            res1.add(res2.get(i));
        }

        return res1;

    }

    private int countSmallerOrEqual(long mid, int[] nums1, int[] nums2){
        int j = nums2.length-1;
        int count = 0;
        for(int i=0; i<nums1.length; i++){
            while(j>=0 && (long)(nums1[i] + nums2[j]) > mid){
                j--;
            }
            count += j + 1;
        }
        return count;
    }
}