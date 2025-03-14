class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        int[][] data = new int[(firstList.length+secondList.length)*2][2];

        int j=0;
        for(int i=0; i<firstList.length; i++){
            data[j][0] = firstList[i][0];
            data[j][1] = 1;
            data[j+1][0] = firstList[i][1];
            data[j+1][1] = -1;
            j+=2;
        }

        for(int i=0; i<secondList.length; i++){
            data[j][0] = secondList[i][0];
            data[j][1] = 1;
            data[j+1][0] = secondList[i][1];
            data[j+1][1] = -1;
            j+=2;
        }

        Arrays.sort(data, new Comparator<int[]>(){
            public int compare(int[] a, int[] b){
                if(a[0]==b[0]){
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
                if(count == 2){
                    start = d[0];
                }
            }else{
                count--;
                if(count == 1){
                    end = d[0];
                    res.add(new int[]{start, end});
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