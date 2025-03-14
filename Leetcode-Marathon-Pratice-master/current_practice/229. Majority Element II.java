class Solution {
    public List<Integer> majorityElement(int[] nums) {
        Arrays.sort(nums);

        List<Integer> res = new ArrayList<>();

        int i=0, j=0;

        while(i<nums.length){
            while(j+1<nums.length && nums[j] == nums[j+1]){
                j++;
            }
            if(j-i+1 > nums.length/3){
                res.add(nums[j]);
            }

            j++;
            i=j;
        }

        return res;
    }
}