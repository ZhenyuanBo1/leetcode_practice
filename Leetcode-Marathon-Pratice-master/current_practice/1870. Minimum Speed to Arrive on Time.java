class Solution {
    public int minSpeedOnTime(int[] dist, double hour) {
        //check if it is impossible
        if(hour <= dist.length-1) return -1;

        int left = 1, right = Integer.MAX_VALUE;
        while(left < right){
            int mid = left + (right-left)/2;
            if(isOK(mid, dist, hour)){
                right = mid;
            }else{
                left = mid+1;
            }
        }

        return left;

    }

    private boolean isOK(int mid, int[] dist, double hour){
        double actualHour = 0;
        for(int i=0; i<dist.length; i++){
            if(dist[i] % mid > 0 && i!=dist.length-1){
                actualHour += Math.round(dist[i]/mid + 1);
            }else if(dist[i] % mid > 0 && i==dist.length-1){
                actualHour += dist[i]*1.0 / mid;
            }else if(dist[i] % mid == 0){
                actualHour += dist[i] / mid;
            }
        }

        // System.out.println("mid: " + mid + )
        if(actualHour <= hour) return true;

        return false;
    }
}