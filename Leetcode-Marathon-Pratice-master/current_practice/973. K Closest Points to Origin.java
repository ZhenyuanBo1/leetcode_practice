class Solution {
    public int[][] kClosest(int[][] points, int k) {
        TreeMap<Integer, List<int[]>> tmap = new TreeMap<>();

        for(int i=0; i<points.length; i++){
            int dis = Math.abs(0-points[i][0]) * Math.abs(0-points[i][0]) + Math.abs(0-points[i][1]) * Math.abs(0-points[i][1]);
            if(tmap.containsKey(dis)){
                tmap.get(dis).add(new int[]{points[i][0], points[i][1]});
            }else{
                List<int[]> list = new ArrayList<>();
                list.add(new int[]{points[i][0], points[i][1]});
                tmap.put(dis, list);
            }
        }

        List<int[]> res = new ArrayList<>();

        for(Integer key: tmap.keySet()){
            boolean flag = false;
            List<int[]> candidates = tmap.get(key);
            for(int[] candidate: candidates){
                if(res.size()>=k){
                    flag = true;
                    break;
                }
                res.add(candidate);
            }
            if(flag) break;
        }

        int[][] ans = new int[res.size()][2];

        for(int i=0; i<res.size(); i++){
            int[] point = res.get(i);
            ans[i][0] = point[0];
            ans[i][1] = point[1];
        }

        return ans;


    }
}