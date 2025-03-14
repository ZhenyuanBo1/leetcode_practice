class Solution {
    public int minMeetingRooms(int[][] intervals) {
        if(intervals.length == 0) return 0;

        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(intervals.length, new Comparator<Integer>() {
          public int compare(Integer a, Integer b) {
            return a - b;
          }});

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        pq.add(intervals[0][1]);


        for(int i=1; i<intervals.length; i++){
            if(intervals[i][0] >= pq.peek()){
                pq.poll();
            }
            pq.add(intervals[i][1]);
        }


        return pq.size();
    }
}

class Solution {
    public int minMeetingRooms(int[][] intervals) {
        //basically, this calculates the number of overlapping intervals
        TreeMap<Integer, Integer> tmap = new TreeMap<>();

        for(int[] interval: intervals){
            tmap.put(interval[0], tmap.getOrDefault(interval[0], 0)+1);
            tmap.put(interval[1], tmap.getOrDefault(interval[1], 0)-1);
        }

        // System.out.println(tmap);
        int count = 0, max=0;

        for(Integer key: tmap.keySet()){
            count += tmap.get(key);
            max = Math.max(max, count);
        }

        return max;
    }
}