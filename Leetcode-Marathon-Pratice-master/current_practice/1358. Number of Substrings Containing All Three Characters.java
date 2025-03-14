class Solution {
    public int numberOfSubstrings(String s) {
        int left=0;
        int right=0;
        int count=0;
        int[] map = new int[3];

        while(left<s.length()){
            while(right<s.length() && !(map[0] > 0 && map[1]>0 && map[2]>0)){
                map[s.charAt(right++) - 'a']++;
            }
            if(map[0]>0 && map[1]>0 && map[2]>0){
                count += s.length() - right + 1;
            }
            map[s.charAt(left++)-'a']--;
        }

        return count;
    }
}