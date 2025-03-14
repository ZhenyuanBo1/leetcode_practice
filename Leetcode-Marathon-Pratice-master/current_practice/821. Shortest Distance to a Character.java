class Solution {
    public int[] shortestToChar(String s, char c) {
        int[] res = new int[s.length()];

        for(int i=0; i<s.length(); i++){
            int minDist = Integer.MAX_VALUE;
            for(int j=0; j<s.length(); j++){
                if(s.charAt(j)==c){
                    minDist = Math.min(minDist, Math.abs(i-j));
                }
            }
            res[i] = minDist;
        }

        return res;
    }
}