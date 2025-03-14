class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = 0, p2 = 0;

        int[] res = new int[m+n];

        int i = 0;

        while(p1 < m && p2 < n){
            if(nums1[p1] <= nums2[p2]){
                res[i++] = nums1[p1];
                p1++;
            }else if(nums1[p1] > nums2[p2]){
                res[i++] = nums2[p2];
                p2++;
            }
        }

        if(p1 < m && p2 >=n){
            while(p1 < m){
                res[i++] = nums1[p1++];
            }
        }else if(p1 >= m && p2 < n){
            while(p2 < n){
                res[i++] = nums2[p2];
                p2++;
            }
        }

        i = 0;

        while(i<res.length){
            nums1[i] = res[i];
            i++;
        }
    }
}