class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        LinkedList<int[]> merged = new LinkedList<>();

        for(int[] interval: intervals){
            if(merged.isEmpty() || merged.getLast()[1] < interval[0]){
                merged.add(interval);
            }else{
                merged.getLast()[1] = Math.max(merged.getLast()[1], interval[1]);
            }
        }

        return merged.toArray(new int[merged.size()][2]);
    }
}

//using ArrayList:
class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        // LinkedList<int[]> merged = new LinkedList<>();
        List<int[]> merged = new ArrayList<>();

        for(int[] interval: intervals){
            if(merged.isEmpty() || merged.get(merged.size()-1)[1] < interval[0]){
                merged.add(interval);
            }else{
                merged.get(merged.size()-1)[1] = Math.max(merged.get(merged.size()-1)[1], interval[1]);
            }
        }

        return merged.toArray(new int[merged.size()][2]);
    }
}



//扫描数组
/*
create pair: (start, 1), (end, -1)
*/
class Solution {
    public int[][] merge(int[][] intervals) {
        int[][] data = new int[intervals.length * 2][2];

        int j = 0;
        //label start as 1 and end as -1
        for(int i=0; i<intervals.length; i++){
            data[j][0] = intervals[i][0];
            data[j][1] = 1;
            data[j+1][0] = intervals[i][1];
            data[j+1][1] = -1;
            j+=2;

        }

        //sort the data array
        Arrays.sort(data, new Comparator<int[]>(){
            public int compare(int[] a, int[] b){
                if(a[0] == b[0]){
                    return Integer.compare(b[1], a[1]);
                }else{
                    return Integer.compare(a[0], b[0]);
                }
            }
        });

        int count = 0, start = -1, end = -1;
        List<int[]> res = new ArrayList<>();

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
                    int[] mergedInterval = new int[2];
                    mergedInterval[0] = start;
                    mergedInterval[1] = end;
                    res.add(mergedInterval);
                }
            }
        }

        int[][] ans = new int[res.size()][2];

        for(int i=0; i<ans.length; i++){
            int[] merged = res.get(i);
            ans[i][0] = merged[0];
            ans[i][1] = merged[1];
        }

        return ans;
    }
}