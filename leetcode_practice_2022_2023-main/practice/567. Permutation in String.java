class Solution {
    //using sliding window
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()) return false;
        
        int p1 = 0, p2 = 0;
        
        while(p2 < s2.length() && p2 - p1 + 1 < s1.length()){
            p2++;
        }
        
        while(p2 < s2.length()){
            String s = s2.substring(p1, p2+1);
            char[] a = s1.toCharArray();
            char[] b = s.toCharArray();
            Arrays.sort(a);
            Arrays.sort(b);
            
            boolean found = true;
            for(int i=0; i<a.length; i++){
                if(a[i] != b[i]){
                    found = false;
                    break;
                }
            }
            
            if(found) return true;
            
            p1++;
            p2++;
        }
        
        return false;
    }
}
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()) return false;
        
        int[] s1map = new int[26];
        int[] s2map = new int[26];

        for(int i=0; i<s1.length(); i++){
            s1map[s1.charAt(i)-'a']++;
            s2map[s2.charAt(i)-'a']++;
        }

        for(int i=0; i<s2.length()-s1.length(); i++){
            if(isMatch(s1map, s2map)) return true;
            s2map[s2.charAt(i+s1.length()) - 'a']++;
            s2map[s2.charAt(i)-'a']--;
        }
        
        return isMatch(s1map, s2map);
    }

    private boolean isMatch(int[] map1, int[] map2){
        for(int i=0; i<26; i++){
            if(map1[i] != map2[i]) return false;
        }

        return true;
    }
}
