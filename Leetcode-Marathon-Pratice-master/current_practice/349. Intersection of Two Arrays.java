class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums2);


        List<Integer> res = new ArrayList<>();

        for(int i=0; i<nums1.length; i++){
            int target = nums1[i];
            if(!res.contains(target)){
                if(searchValue(target, nums2)){
                    res.add(target);
                }
            }
        }

        int[] ans = new int[res.size()];

        for(int i=0; i<res.size(); i++){
            ans[i] = res.get(i);
        }

        return ans;


    }

    private boolean searchValue(int target, int[] nums2){
        int left = 0, right = nums2.length-1;

        while(left < right){
            int mid = left + (right - left)/2;
            if(nums2[mid] > target){
                right = mid -1;
            }else if(nums2[mid] < target){
                left = mid + 1;
            }else{
                return true;
            }
        }

        if(left == right && nums2[left] == target) return true;

        return false;
    }
}