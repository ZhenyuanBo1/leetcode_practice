class Solution {
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int left = 0, right = position[position.length-1] - position[0];

        while(left < right){
            int mid = right - (right-left)/2;
            if(isOK(mid, position, m)){
                left = mid;
            }else{
                right = mid-1;
            }
        }

        return left;
    }

    private boolean isOK(int mid, int[] pos, int m){
        int j=0, i=0;
        while(m>1){
            while(j<pos.length && Math.abs(pos[j] - pos[i]) < mid){
                j++;
            }
            if(j<pos.length){
                m--;
                i = j;
            }else{
                return false;
            }
        }
        // System.out.println("mid: " + mid + " status: " + true);
        return true;
    }
}