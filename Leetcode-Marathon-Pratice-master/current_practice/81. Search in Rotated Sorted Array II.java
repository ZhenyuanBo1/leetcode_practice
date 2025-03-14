class Solution {
    public boolean search(int[] nums, int target) {
        //using binary search
        //remove the numbers from the end of nums that is equal to nums[0]
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

        int[] newArr = new int[list.size()];

        for(int i=0; i<list.size(); i++){
            newArr[i] = list.get(i);
        }

        int left = 0, right = newArr.length-1;

        while(left < right){
            int mid = left + (right-left)/2;
            if(newArr[mid] == target) return true;

            if(newArr[mid]>=newArr[0] == target>=newArr[0]){
                //in the same group
                if(newArr[mid]<target){
                    left = mid + 1;
                }else if(newArr[mid] > target){
                    right = mid-1;
                }
            }else if(target>=newArr[0]){
                right = mid-1;
            }else{
                left = mid+1;
            }
        }

        if(left == right && newArr[left] == target) return true;

        return false;

    }
}