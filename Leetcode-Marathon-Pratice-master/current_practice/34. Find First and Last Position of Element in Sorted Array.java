class Solution {
    public int[] searchRange(int[] nums, int target) {
        int left = 0, right = nums.length-1;
        List<Integer> list = new ArrayList<>();

        //define the lower bound
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
        }else{
            list.add(-1);
        }

        left = 0;
        right = nums.length-1;

        //define upper bound
        while(left < right){
            int mid = right - (right-left)/2;
            if(nums[mid] > target){
                right = mid-1;
            }else{
                left = mid;
            }
        }

        if(left == right && nums[left] == target){
            list.add(left);
        }else{
            list.add(-1);
        }

        int[] res = new int[list.size()];

        for(int i=0; i<list.size(); i++){
            res[i] = list.get(i);
        }


        return res;
    }
}