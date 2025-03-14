class Solution {
    public int findSpecialInteger(int[] arr) {
        int length = arr.length;
        int freq = (int)(length * 0.25);

        Map<Integer, Integer> map = new HashMap<>();

        for(int i: arr){
            map.put(i, map.getOrDefault(i, 0)+1);
        }

        int res = 0;

        for(Integer key: map.keySet()){
            if(map.get(key) > freq){
                res = key;
            }
        }

        return res;
    }
}