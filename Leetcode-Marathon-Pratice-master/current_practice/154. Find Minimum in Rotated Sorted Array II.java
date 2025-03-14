class Solution {
    public int findMin(int[] nums) {

        List<Integer> list = new ArrayList<>();
        for(int i=0; i<nums.length; i++){
            list.add(nums[i]);
        }

        for(int i=nums.length-1; i>1; i--){
            if(list.get(i) == nums[0]){
                list.remove(i);
            }else{
                break;
            }
        }

        int[] newNums = new int[list.size()];

        for(int i=0; i<list.size(); i++){
            newNums[i] = list.get(i);
        }


        int left = 0, right = newNums.length-1;

        while(left < right){
            int mid = left + (right-left)/2;

            //check which section we should perform binary search
            if(newNums[mid]>=newNums[0] && newNums[newNums.length-1]<=newNums[0]){
                //the minimum should be in the right branch
                left = mid + 1;
            }else if(newNums[mid]>=newNums[0] && newNums[newNums.length-1]>=newNums[0]){
                return newNums[0];
            }else{
                right = mid;
            }
        }

        return newNums[left];
    }
}