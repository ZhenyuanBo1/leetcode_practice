class Solution {
    public int[] sortedSquares(int[] nums) {
        List<Integer> pos = new ArrayList<>();
        List<Integer> neg = new ArrayList<>();

        for(int i=0; i<nums.length; i++){
            if(nums[i] < 0){
                neg.add(nums[i] * nums[i]);
            }else{
                pos.add(nums[i] * nums[i]);
            }
        }

        int[] ans = new int[nums.length];

        //merge pos part and neg part; for neg part we traverse in reverse direction

        int j=0, k=neg.size()-1;
        int index = 0;

        while(j<pos.size() && k>=0){
            if(pos.get(j) <= neg.get(k)){
                ans[index++] = pos.get(j);
                j++;
            }else{
                ans[index++] = neg.get(k);
                k--;
            }
        }

        if(j<pos.size() && k < 0){
            while(j<pos.size()){
                ans[index++] = pos.get(j++);
            }
        }else if(j>=pos.size() && k>=0){
            while(k>=0){
                ans[index++] = neg.get(k--);
            }
        }

        return ans;

    }
}