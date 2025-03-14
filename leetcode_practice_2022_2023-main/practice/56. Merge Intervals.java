class Solution {
    public int[][] merge(int[][] intervals) {
        int[][]data = new int[intervals.length*2][2];

        int j=0;
        for(int i=0; i<intervals.length; i++){
            data[j][0] = intervals[i][0];
            data[j][1] = 1;
            data[j+1][0] = intervals[i][1];
            data[j+1][1] = -1;
            j+=2;
        }

        Arrays.sort(data, new Comparator<int[]>(){
            public int compare(int[] a, int [] b){
                if(a[0] == b[0]){
                    return Integer.compare(b[1], a[1]);
                }else{
                    return Integer.compare(a[0], b[0]);
                }
            }
        });

        List<int[]> res = new ArrayList<>();

        int count = 0, start = -1, end = -1;

        for(int[] d: data){
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

        for(int i=0; i<res.size(); i++){
            ans[i][0] = res.get(i)[0];
            ans[i][1] = res.get(i)[1];
        }

        return ans;
    }
}