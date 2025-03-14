class Solution {
    public int numberOfBoomerangs(int[][] points) {
        //to calculate the number of boomerangs, we can use n * (n-1)
        int sum = 0;
        for(int i=0; i<points.length; i++){
            Map<Integer, Integer> map = new HashMap<>();
            for(int j=0; j<points.length; j++){
                if(j != i){
                    int xdist = (points[j][0] - points[i][0]) * (points[j][0] - points[i][0]);
                    int ydist = (points[j][1] - points[i][1]) * (points[j][1] - points[i][1]);
                    int dist = xdist + ydist;
                    //number of points to this point
                    map.put(dist, map.getOrDefault(dist, 0) + 1);
                }
            }

            for(Integer key : map.keySet()){
                sum += map.get(key) * (map.get(key)-1);
            }
        }

        return sum;
    }
}