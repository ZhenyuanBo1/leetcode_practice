class Solution {
    public int totalFruit(int[] fruits) {
        Map<Integer, Integer> map = new HashMap<>();
        int left=0;
        int right=0;
        int maxCount=0;

        while(right<fruits.length){
            int count = map.getOrDefault(fruits[right], 0)+1;
            map.put(fruits[right++], count);

            if(map.size() <= 2){
                maxCount = Math.max(maxCount, right-left);
            }else if(map.size() > 2){
                int updatedVal = map.get(fruits[left])-1;
                if(updatedVal == 0){
                    map.remove(fruits[left++]);
                }else{
                    map.put(fruits[left++], updatedVal);
                }
            }
        }

        return maxCount;
    }
}