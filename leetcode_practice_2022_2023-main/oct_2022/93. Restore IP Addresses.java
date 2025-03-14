class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        List<String> segments = new ArrayList<>();
        helper(s, segments, res, -1, 3);
        return res;
    }
    private void helper(String s, List<String> segments, List<String> res, int prev, int dots){
        //base case
        if(dots == 0){
            String segment = s.substring(prev+1, s.length());
            if(isValid(segment)){
                segments.add(segment);
                res.add(String.join(".", segments));
                segments.remove(segments.size()-1);
            }
        }

        int endPos = Math.min(s.length()-1, prev+4);
        for(int i=prev+1; i<endPos; i++){
            String segment = s.substring(prev+1, i+1);
            if(isValid(segment)){
                segments.add(segment);
                helper(s, segments, res, i, dots-1);
                segments.remove(segments.size()-1);
            }
        }
    }
    private boolean isValid(String segment){
        if(segment.length() > 3) return false;
        if(segment.charAt(0) == '0') return segment.length() == 1;
        return Integer.valueOf(segment) <= 255;
    }
}