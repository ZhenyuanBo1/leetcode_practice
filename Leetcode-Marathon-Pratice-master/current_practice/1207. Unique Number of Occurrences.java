class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<arr.length; i++){
            int count = map.getOrDefault(arr[i], 0)+1;
            map.put(arr[i], count);
        }

        Set<Integer> set = new HashSet<>();

        for(Integer key: map.keySet()){
            if(!set.add(map.get(key))) return false;
        }

        return true;
    }
}