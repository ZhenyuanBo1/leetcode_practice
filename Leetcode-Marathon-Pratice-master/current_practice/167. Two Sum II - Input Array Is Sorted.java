class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] res = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<numbers.length; i++){
            int val = target - numbers[i];
            if(map.containsKey(val)){
                res[0] = map.get(val);
                res[1] = i+1;
                break;
            }else{
                map.put(numbers[i], i+1);
            }
        }
        return res;
    }
}