class Solution {
    public int largestAltitude(int[] gain) {
        int[] altitudes = new int[gain.length+1];

        altitudes[0] = 0;

        int j=0;

        for(int i=1; i<=gain.length; i++){
            altitudes[i] = altitudes[i-1] + gain[j];
            j++;
        }

        int highest = Integer.MIN_VALUE;

        for(int i=0; i<altitudes.length; i++){
            if(highest<altitudes[i]){
                highest = altitudes[i];
            }
        }

        return highest;
    }
}