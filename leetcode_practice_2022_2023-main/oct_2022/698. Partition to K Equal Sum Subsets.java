class Solution {
    private int totalSet;
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for(int i=0; i<nums.length; i++){
            sum += nums[i];
        }

        if(sum % k != 0) return false;

        int setSum = sum / k;

        boolean[] visited = new boolean[nums.length];
        
        Arrays.sort(nums);
        reverse(nums);

        return helper(0, 0, k, setSum, nums, visited, 0);

    }
    
    //reverse the array so we can more quickly create a subset
    void reverse(int[] arr) {
        for (int i = 0, j = arr.length - 1; i < j; i++, j--) { 
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }

    private boolean helper(int curr, int count, int k, int target, int[] nums, boolean[] visited, int index){

        if(count == k-1){
            return true;
        }

        if(curr > target){
            return false;
        }

        if(curr == target){
            return helper(0, count + 1, k, target, nums, visited, 0);
        }

        for(int i=index; i<nums.length; i++){
            if(visited[i]) continue;
            visited[i] = true;
            int val = nums[i];
            if(helper(curr + nums[i], count, k, target, nums, visited, i+1)){
                return true;
            }
            visited[i] = false;
        }

        return false;
    }
}