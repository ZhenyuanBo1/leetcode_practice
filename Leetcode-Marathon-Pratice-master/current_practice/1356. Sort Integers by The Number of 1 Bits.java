class Solution {
    public int[] sortByBits(int[] arr) {
        Map<Integer, PriorityQueue<Integer>> map = new TreeMap<>();

        for(int item: arr){
            String str = Integer.toBinaryString(item);
            int count = 0;

            for(char ch: str.toCharArray()){
                if(ch == '1'){
                    count+=1;
                }
            }

            if(map.containsKey(count)){
                map.get(count).offer(item);
            }else{
                PriorityQueue<Integer> pq = new PriorityQueue<>();
                pq.offer(item);
                map.put(count, pq);
            }
        }

        int[] res = new int[arr.length];
        int index=0;

        for(Integer key: map.keySet()){
            while(!map.get(key).isEmpty()){
                int val = map.get(key).poll();
                res[index++] = val;
            }
        }

        return res;
    }
}