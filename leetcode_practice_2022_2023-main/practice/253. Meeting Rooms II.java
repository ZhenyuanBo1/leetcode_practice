class Solution {
    public int minMeetingRooms(int[][] intervals) {
        //using scanning method
        int[][] data = new int[intervals.length*2][2];

        int j = 0;
        for(int i=0; i<intervals.length; i++){
            data[j][0] = intervals[i][0];
            data[j][1] = 1;
            data[j+1][0] = intervals[i][1];
            data[j+1][1] = -1;
            j += 2;
        }

        Arrays.sort(data, new Comparator<int[]>(){
            public int compare(int[] a, int[] b){
                if(a[0] == b[0]){
                    return Integer.compare(a[1], b[1]);
                }else{
                    return Integer.compare(a[0], b[0]);
                }
            }
        });

        int res = 0;
        int count = 0, start = -1, end = -1;

        for(int[] d: data){
            if(d[1] == 1){
                count++;
                res = Math.max(count, res);
            }else if(d[1] == -1){
                count--;
            }
        }

        return res;
    }
}
