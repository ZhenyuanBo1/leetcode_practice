class Solution {
    public int triangleNumber(int[] nums) {
        int count = 0;
        Arrays.sort(nums);
        for(int i=0; i<nums.length-2; i++){
            int k = i+2;
            for(int j=i+1; j<nums.length-1; j++){
                k = binarySearch(nums, j+1, nums.length-1, nums[i] + nums[j]);
                count += k-j-1;
            }
        }
        return count;
    }
    private int binarySearch(int[] nums, int l, int r, int target){
        while(l<=r){
            int mid = l + (r-l)/2;
            if(nums[mid]>=target){
                r = mid-1;
            }else if(nums[mid]<target){
                l = mid + 1;
            }
        }

        return l;
    }
}

public class Solution {
    public int triangleNumber(int[] nums) {
        int count = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if(nums[i] == 0) continue;
            int k = i + 2;
            for (int j = i + 1; j < nums.length - 1 && nums[j] != 0; j++) {
                //iterate through entire array to look for k such that nums[i] + nums[j] > nums[k]
                while (k < nums.length && nums[i] + nums[j] > nums[k])
                    k++;
                count += k - j - 1;
            }
        }
        return count;
    }
}