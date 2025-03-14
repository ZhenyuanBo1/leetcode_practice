class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        //using scanning method to look for the position of starting and endpoint point
        int[][] data = new int[(intervals.length+1)*2][2];

        int j=0;
        for(int i=0; i<intervals.length; i++){
            data[j][0] = intervals[i][0];
            data[j][1] = 1;
            data[j+1][0] = intervals[i][1];
            data[j][1] = -1;
            j+=2;
        }

        data[j][0] = newInterval[0];
        data[j][1] = 1;
        data[j+1][0] = newInterval[1];
        data[j+1][1] = -1;

        //sort data
        Arrays.sort(data, new Comparator<int[]>(){
            public int compare(int[] a, int[] b){
                if(a[0] == b[0]){
                    Integer.compare(b[1], a[1]);
                }else{
                    Integer.compare(a[0], b[0]);
                }
            }
        });

        int count = 0, start = -1, end = -1;
        List<int[]> res = new ArrayList<>();

        //scanning and look for start and end
        for(int[] d : data){
            if(d[1] == 1){
                count++;
                if(count == 1){
                    start = d[0];
                }
            }else if(d[1] == -1){
                count--;
                if(count == 0){
                    end = d[0];
                    int[] merged = new int[2];
                    merged[0] = start;
                    merged[1] = end;
                    res.add(merged);
                }
            }
        }

        int[][] ans = new int[res.size()][2];

        for(int i=0; i<ans.length; i++){
            ans[i][0] = res.get(i)[0];
            ans[i][1] = res.get(i)[1];
        }

        return ans;
    }
}