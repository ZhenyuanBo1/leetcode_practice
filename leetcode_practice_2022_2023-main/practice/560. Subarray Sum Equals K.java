class Solution {
    public int subarraySum(int[] nums, int k) {
        //frequency: 7
        //using cumulative sum
        //for subarray sum, we use cumulative sum
        int[] sum = new int[nums.length+1];
        sum[0] = 0;

        int count = 0;

        for(int i=1; i<nums.length; i++){
            sum[i] = sum[i-1] + nums[i-1];
        }

        for(int i=0; i<nums.length; i++){
            for(int j = i+1; j<=nums.length; j++){
                int sum = sum[j] - sum[i];
                if(sum == k) count++;
            }
        }

        return count;
    }
}

class Solution {
    public int subarraySum(int[] nums, int k) {
        //frequency: 7
        //using hashmap
        //for subarray sum, we use cumulative sum, similar to Two Sum
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1); //key is 0, value is number of occurences for this sum;

        int sum = 0;
        int count = 0;
        for(int i=0; i<nums.length; i++){
            sum += nums[i];

            if(map.containsKey(sum - k)){
                count += map.get(sum-k);
            }

            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return count;
    }
}