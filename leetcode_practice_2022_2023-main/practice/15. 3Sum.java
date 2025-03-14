class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        //if currrent value is greater than 0, break from the loop
        for(int i=0; i<nums.length && nums[i]<=0; i++){
            if(i == 0 || nums[i-1] != nums[i]){
                twoSum(nums, i, res);
            }
        }
        return res;
    }
    
    private void twoSum(int[] nums, int index, List<List<Integer>> res){
        int lo = index+1, h = nums.length-1;
        
        while(lo < h){
            int currSum = nums[index] + nums[lo] + nums[h];
            if(currSum > 0){
                h--;
            }else if(currSum < 0){
                lo++;
            }else{
                res.add(new ArrayList<>(Arrays.asList(nums[index], nums[lo++], nums[h--])));
                while(lo<h && nums[lo] == nums[lo-1]) lo++;
            }
        }
    }
}