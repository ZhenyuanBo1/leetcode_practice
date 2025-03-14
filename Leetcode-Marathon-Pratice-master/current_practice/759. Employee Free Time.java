/*
// Definition for an Interval.
class Interval {
    public int start;
    public int end;

    public Interval() {}

    public Interval(int _start, int _end) {
        start = _start;
        end = _end;
    }
};
*/

class Solution {
    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        int len = 0;
        for(List<Interval> intervalList: schedule){
            len += intervalList.size();
        }
        int[][] data = new int[len*2][2];

        int j=0;
        for(List<Interval> intervalList: schedule){
            for(Interval dur: intervalList){
                data[j][0] = dur.start;
                data[j][1] = 1;
                data[j+1][0] = dur.end;
                data[j+1][1] = -1;
                j+=2;
            }
        }

        Arrays.sort(data, new Comparator<int[]>(){
            public int compare(int[] a, int[] b){
                if(a[0] == b[0]){
                    return Integer.compare(b[1], a[1]);
                }else{
                    return Integer.compare(a[0], b[0]);
                }
            }
        });

        int start = -1, end = -1;

        List<Interval> res =  new ArrayList<>();

        int count = 0;

        for(int[] d: data){
            if(d[1] == 1){
                count++;
                if(count == 1){
                    start = d[0];
                }
            }else{
                count--;
                if(count == 0){
                    end = d[0];
                    res.add(new Interval(start, end));
                }
            }
        }


        List<Interval> ans = new ArrayList<>();

        for(int i=0; i+1<res.size(); i++){
            ans.add(new Interval(res.get(i).end, res.get(i+1).start));
        }

        return ans;
    }
}