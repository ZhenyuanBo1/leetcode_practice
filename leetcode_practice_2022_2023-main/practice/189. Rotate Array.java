class Solution {
    public void rotate(int[] nums, int k) {
        int[] res = new int[nums.length];

        int shift = k % nums.length;

        int index = nums.length-shift;

        int m=0;
        for(int i=index; i<nums.length; i++){
            res[m++] = nums[i];
        }

        for(int j=0; j<index; j++){
           res[m++] = nums[j]; 
        }

        for(int l=0; l<nums.length; l++){
            nums[l] = res[l];
        }

    }
}

//no extra space
class Solution {
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        //reverse whole array
        reverse(nums, 0, nums.length-1);
        reverse(nums, 0, k-1);
        reverse(nums, k, nums.length-1);
    }
    
    private void reverse(int[] nums, int s, int e){
        while(s<e){
            int temp = nums[e];
            nums[e] = nums[s];
            nums[s] = temp;
            s++;
            e--;
        }
    }
}