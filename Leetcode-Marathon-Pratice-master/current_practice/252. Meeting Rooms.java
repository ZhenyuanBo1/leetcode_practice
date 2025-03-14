class Solution {
    public boolean canAttendMeetings(int[][] intervals) {

        if(intervals.length == 0) return true;

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        int currEndTime = intervals[0][1];

        for(int i=1; i<intervals.length; i++){
            if(intervals[i][0] < currEndTime) return false;
            else{
                currEndTime = intervals[i][1];
            }
        }

        return true;
    }
}


//扫描一遍duration array
class Solution {
    public boolean canAttendMeetings(int[][] intervals) {
        TreeMap<Integer, Integer> tmap = new TreeMap<>();

        for(int[] interval: intervals){
            tmap.put(interval[0], tmap.getOrDefault(interval[0], 0)+1);
            tmap.put(interval[1], tmap.getOrDefault(interval[1], 0)-1);
        }

        int count = 0;

        for(Integer key: tmap.keySet()){
            count += tmap.get(key);
            if(count > 1) return false;
        }

        return true;
    }
}