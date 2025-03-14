class Solution {
    public List<Integer> minSubsequence(int[] nums) {
        List<Integer> ans = new ArrayList<>();

        Arrays.sort(nums);

        int[] numsCopy = new int[nums.length];

        int j=0;

        for(int i=nums.length-1; i>=0; i--){
            numsCopy[j] = nums[i];
            j+=1;
        }

        ans.add(numsCopy[0]);

        boolean isGreater = false;

        int index = 1;

        while(true){
            int currSum=0;

            for(int i=0; i<ans.size(); i++){
                currSum += ans.get(i);
            }

            if(currSum <= calculateSum(numsCopy, index)){
                ans.add(numsCopy[index]);
                index += 1;
            }else{
               break;
            }
        }

        return ans;

    }

    private int calculateSum(int[] arr, int index){
        int sum=0;

        for(int i=index; i<arr.length; i++){
            sum += arr[i];
        }

        return sum;
    }
}