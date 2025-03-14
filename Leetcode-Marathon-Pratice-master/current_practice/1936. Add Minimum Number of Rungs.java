class Solution {
    public int addRungs(int[] rungs, int dist) {
        int left = 0, right = Integer.MAX_VALUE;

        while(left < right){
            int mid = left + (right-left)/2;
            if(isOK(mid, rungs, dist)){
                right = mid;
            }else{
                left = mid+1;
            }
        }

        return left;
    }

    private boolean isOK(int mid, int[] rungs, int dist){
        int s = 0;
        int count = 0;
        for(int i=0; i<rungs.length; i++){
            if(rungs[i] - s > dist){
                count += (rungs[i]-s-1)/dist;
            }
            s = rungs[i];
        }

        if(count<=mid) return true;

        return false;
    }
}