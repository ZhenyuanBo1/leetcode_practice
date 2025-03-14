class Solution {
    public int[] twoSum(int[] nums, int target) {
        List<Integer> list = new ArrayList<>();

        for(int i=0; i<nums.length; i++){
            for(int j=i+1; j<nums.length; j++){
                if(nums[i] + nums[j] == target){
                    list.add(i);
                    list.add(j);
                    break;
                }
            }
        }

        int[] res = new int[2];

        res[0] = list.get(0);
        res[1] = list.get(1);

        return res;
    }
}

//time: O(n)
class Solution {
    public int[] twoSum(int[] nums, int target) {
        //use map to store all numbers that have been visited
        Map<Integer, Integer> visited = new HashMap<>();
        int[] res = new int[2];

        for(int i=0; i<nums.length; i++){
            int val = target - nums[i];
            if(visited.containsKey(val)){
                res[0] = visited.get(val);
                res[1] = i;
                break;
            }else{
                visited.put(nums[i], i);
            }
        }

        return res;
    }
}