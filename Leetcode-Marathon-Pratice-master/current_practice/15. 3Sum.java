class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for(int i=0; i<nums.length; i++){
            if(i==0 || nums[i]!=nums[i-1]){
                int twoSum = 0 - nums[i];
                int l = i+1, r = nums.length-1;
                while(l < r){
                    if(nums[l] + nums[r] > twoSum){
                        r--;
                    }else if(nums[l] + nums[r] < twoSum){
                        l++;
                    }else{
                        List<Integer> newList = Arrays.asList(nums[i], nums[l], nums[r]);
                        res.add(newList);
                        l++;
                        while(l<r && nums[l] == nums[l-1]){
                            l++;
                        }
                    }
                }
            }
        }
        return res;
    }
}