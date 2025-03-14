class Solution {
    public boolean isReflected(int[][] points) {
        Set<String> set = new HashSet<>();
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for(int i=0; i<points.length; i++){
            int[] point = points[i];
            max = Math.max(max, point[0]);
            min = Math.min(min, point[0]);
            String s = point[0] + "x" + point[1];
            set.add(s);
        }

        int sum = min + max;

        for(int[] point: points){
            String str = (sum - point[0]) + "x" + point[1];
            if(!set.contains(str)) return false;
        }

        return true;
    }
}