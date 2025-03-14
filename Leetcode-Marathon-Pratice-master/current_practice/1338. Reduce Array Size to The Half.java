class Solution {
    public int minSetSize(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<arr.length; i++){
            map.put(arr[i], map.getOrDefault(arr[i], 0)+1);
        }

        PriorityQueue<Integer> heap = new PriorityQueue<>(Comparator.reverseOrder());

        for(Integer val: map.values()){
            heap.add(val);
        }

        int countDeletedVal = 0, ans = 0;

        while(countDeletedVal < arr.length/2){
            int freq = heap.remove();
            countDeletedVal += freq;
            ans++;
        }

        return ans;
    }
}