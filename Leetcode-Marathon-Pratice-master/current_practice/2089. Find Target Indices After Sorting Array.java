class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        Arrays.sort(nums);

        List<Integer> list = new ArrayList<>();

        int left = 0, right = nums.length-1;

        while(left < right){
            int mid = left + (right-left)/2;
            if(nums[mid] < target){
                left = mid+1;
            }else{
                right = mid;
            }
        }

        if(left == right && nums[left] == target){
            list.add(left);
        }

        int left2 = 0;
        right = nums.length-1;

        //upper bound
        while(left2 < right){
            int mid = right - (right-left2)/2;
            if(nums[mid] > target){
                right = mid-1;
            }else{
                left2 = mid;
            }
        }

        if(left2 == right && nums[left2] == target){
            for(int i=left+1; i<=left2; i++){
                list.add(i);
            }
        }

        return list;

    }
}