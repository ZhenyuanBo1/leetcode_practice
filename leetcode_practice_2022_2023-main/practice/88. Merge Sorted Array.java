class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] sorted = new int[m+n];
        int p1 = 0, p2 = 0;

        int i = 0;

        while(p1<m && p2 <n){
            if(nums1[p1] <= nums2[p2]){
                sorted[i++] = nums1[p1++];
            }else if(nums1[p1] > nums2[p2]){
                sorted[i++] = nums2[p2++];
            }
        }

        if(p1>=m && p2<n){
            while(p2<n){
                sorted[i++] = nums2[p2++];
            }
        }else if(p2>=n && p1<m){
            while(p1<m){
                sorted[i++] = nums1[p1++];
            }
        }

        for(int j=0; j<sorted.length; j++){
            nums1[j] = sorted[j];
        }

    }
}