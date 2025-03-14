class Solution {
    public int removeElement(int[] nums, int val) {
        int left = 0, right = nums.length-1;

        while(left<right){
            if(nums[left] == val){
                int temp = nums[right];
                nums[right--] = nums[left];
                nums[left] = temp;
            }else{
                left++;
            }
        }

        int count = 0;

        for(int i=0; i<nums.length; i++){
            if(nums[i] == val) count += 1;
        }

        return nums.length - count;
    }
}

public int removeElement(int[] nums, int val) {
    int i = 0;
    for (int j = 0; j < nums.length; j++) {
        if (nums[j] != val) {
            nums[i] = nums[j];
            i++;
        }
    }
    return i;
}