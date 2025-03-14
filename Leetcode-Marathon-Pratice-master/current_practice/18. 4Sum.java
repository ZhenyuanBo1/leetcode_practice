class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);

        List<List<Integer>> res = new ArrayList<>();

        for(int i=0; i<nums.length; i++){
            int val = target - nums[i];
            threeSum(nums, i, val, res);
        }
        return res;
    }
    private void threeSum(int[] nums, int currIndex, int target, List<List<Integer>> ans){
        for(int i = currIndex + 1; i<nums.length; i++){
            if(i == currIndex + 1 || nums[i-1] != nums[i]){
                List<List<Integer>> threeSumList = threeSumHelper(nums, i, target);
                for(List<Integer> subList : threeSumList){
                    List<Integer> newList = new ArrayList<>();
                    newList.add(nums[currIndex]);
                    newList.addAll(subList);
                    if(!ans.contains(newList)) ans.add(newList);
                }
            }
        }
    }
    private List<List<Integer>> threeSumHelper(int[] nums, int currIndex, int target){
        int low = currIndex + 1;
        int high = nums.length-1;
        List<List<Integer>> ans = new ArrayList<>();

        while(low < high){
            int sum = nums[low] + nums[high] + nums[currIndex];
            if(sum == target){
                ans.add(Arrays.asList(nums[currIndex], nums[low++], nums[high--]));
                while(low < high && nums[low-1] == nums[low]) low++;
            }else if(sum < target){
                low++;
            }else if(sum > target){
                high--;
            }
        }

        return ans;
    }
}