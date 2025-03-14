class Solution {
    public List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        List<Integer> ans = new ArrayList<>();

        for(int i=0; i<nums1.length; i++){
            list1.add(nums1[i]);
        }

        for(int j=0; j<nums2.length; j++){
            if(list1.contains(nums2[j])){
                if(!ans.contains(nums2[j])){
                    ans.add(nums2[j]);
                }
            }else{
                list2.add(nums2[j]);
            }
        }

        for(int k=0; k<nums3.length; k++){
            if(!ans.contains(nums3[k])){
                if(list1.contains(nums3[k]) || list2.contains(nums3[k])){
                    if(!ans.contains(nums3[k])) ans.add(nums3[k]);
                }
            }
        }

        return ans;
    }
}