class Solution {
    class Pair{
        int val;
        int freq;
        public Pair(int val, int freq){
            this.val = val;
            this.freq = freq;
        }
    }
    public int[] topKFrequent(int[] nums, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((p1, p2) -> p2.freq - p1.freq);

        Map<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        for(Integer key: map.keySet()){
            pq.offer(new Pair(key, map.get(key)));
        }

        int[] ans = new int[k];

        for(int i=0; i<k; i++){
            Pair p = pq.poll();
            ans[i] = p.val;
        }

        return ans;
    }
}

//using buckets
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        List<List<Integer>> buckets = new ArrayList<>();
        buckets.add(new ArrayList<>()); //for frequency 0, placeholder

        Map<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            buckets.add(new ArrayList<>());
        }

        for(Integer key: map.keySet()){
            int freq = map.get(key);
            buckets.get(freq).add(key);
        }

        int[] ans = new int[k];

        for(int i=buckets.size()-1; i>=0; i--){
            if(k<=0) break;
            if(buckets.get(i).size() == 0) continue;
            for(Integer item: buckets.get(i)){
                ans[--k] = item;
            }
        }

        return ans;
    }
}