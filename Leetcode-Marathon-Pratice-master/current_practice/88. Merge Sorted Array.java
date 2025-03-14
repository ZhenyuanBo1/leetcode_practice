class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if(nums2.length == 0) return;

        int[] nums1Copy = new int[m];

        for(int i=0; i<m; i++){
            nums1Copy[i] = nums1[i];
        }

        int p1 = 0, p2=0;

        for(int p=0; p<nums1.length; p++){
            if(p2>=n || p1<m && nums1Copy[p1] < nums2[p2]){
                nums1[p] = nums1Copy[p1++];
            }else{
                nums1[p] = nums2[p2++];
            }
        }
    }
}


